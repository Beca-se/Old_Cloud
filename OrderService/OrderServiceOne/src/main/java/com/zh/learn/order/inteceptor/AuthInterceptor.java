package com.zh.learn.order.inteceptor;

import com.zh.learn.common.domain.ResultBean;
import com.zh.learn.common.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhouHu
 * @Class Name AuthInterceptor
 * @Desc
 * @create: 2020-03-19 16:13
 **/
@Component
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final String AUTH_TOKEN = "AUTH_TOKEN";
    private static final String ORDER_PRE_FIX = "ORDER_SERVICE";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // If the require pass is empty or is error
        String authToken = request.getHeader(AUTH_TOKEN);
        log.info("The {} value is {}. Start to check !", AUTH_TOKEN, authToken);
        if (StringUtils.isBlank(authToken) || !authToken.equals(redisTemplate.opsForHash().get(AUTH_TOKEN, ORDER_PRE_FIX))) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            ResultBean resultBean = ResultBean.isPermissionDenied();
            resultBean.setMessage("Authentication failure!");
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/json");
            outputStream.write(GsonUtils.getInstance().toJson(resultBean).getBytes());
            outputStream.flush();
            return false;
        }
        return true;
    }
}
