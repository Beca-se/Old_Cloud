package com.zh.learn.gateway.predicate;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ZhouHu
 * @Class Name LoginPredicateFactory
 * @Desc TODO
 * @create: 2020-03-31 14:25
 **/
@Configuration
public class LoginPredicateFactory extends AbstractRoutePredicateFactory<LoginPredicateFactory.Config> {


    @Autowired
    private RedisTemplate<String, String> redisTtemplate;


    public LoginPredicateFactory() {
        this(LoginPredicateFactory.Config.class);
    }

    public LoginPredicateFactory(Class<Config> configClass) {
        super(configClass);
    }

    @Autowired
    private LoginPredicateFactory.Config config;

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                List<HttpCookie> cookies = serverWebExchange.getRequest().getCookies()
                        .get(config.cookieName);
                if (cookies == null || cookies.isEmpty()) {
                    return false;
                }
                for (HttpCookie cookie : cookies) {
                    // Check the cookie value is valid or not
                    boolean cookieValid = StringUtils.isNotBlank(cookie.getValue()) && cookie.getValue().startsWith(config.cookiePrefix);
                    if (cookieValid) {
                        // Start to redis check the token

                    }
                }
                return false;
            }
        };
    }

    @Override
    public Config newConfig() {
        return config;
    }

    @Component
    @Validated
    public static class Config {

        @NotEmpty
        @Value("${cookie.prefix}")
        private String cookiePrefix;

        @NotEmpty
        @Value("${cookie.name}")
        private String cookieName;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Config{");
            sb.append("cookiePrefix='").append(cookiePrefix).append('\'');
            sb.append(", cookieName='").append(cookieName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
