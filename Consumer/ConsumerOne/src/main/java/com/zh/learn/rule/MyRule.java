package com.zh.learn.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhouHu
 * @Class Name MyRule
 * @Desc TODO
 * @create: 2020-03-31 10:15
 **/
@Slf4j
@Configuration
public class MyRule extends AbstractLoadBalancerRule {
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    public Server choose(Object key) {
        System.out.println(this);
        System.out.println(atomicInteger);
        ILoadBalancer loadBalancer = getLoadBalancer();
        if (loadBalancer == null) {
            log.warn("no load balancer");
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = loadBalancer.getReachableServers();
            List<Server> allServers = loadBalancer.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + loadBalancer);
                return null;
            }
            server = reachableServers.get(0);
            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {
            log.warn("No available alive servers after 10 tries from load balancer: "
                    + loadBalancer);
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
