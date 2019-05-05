package cloud.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Zhou Hu
 * @Description: Spring Security 默认开启了跨域保护(CSRF),我们需要关闭以方便Eureka Client注册到我们的Eureka Server上面
 * @Date: 10:25 2019-05-05
 **/


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭 CSRF
        http.csrf().disable();
        // 开启安全认证
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

}