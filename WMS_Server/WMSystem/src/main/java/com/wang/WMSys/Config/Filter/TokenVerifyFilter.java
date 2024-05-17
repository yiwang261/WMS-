package com.wang.WMSys.Config.Filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.wang.WMSys.Pojo.Entity.User;
import com.wang.WMSys.Service.Impl.RedisService;
import com.wang.WMSys.Utils.*;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class TokenVerifyFilter extends OncePerRequestFilter {

    @Resource
    private RedisService<String,String> redisService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 放行登录接口
        if(request.getRequestURI().contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 获取token
        String token = request.getHeader("Authorization");

        if (token == null) {
            Result result = Result.error("未登录");
            ResponseUtil.write(response,JSONUtil.toJSONString(result));
            // 解析token
            return;
        }

        // 获取用户信息
        User user;
        try {
             user = JWTUtil.parseToken(token, "user", User.class);
        } catch (JWTDecodeException e) {
//            e.printStackTrace();
            Result result = Result.error("身份信息错误,请重新登录");
            ResponseUtil.write(response,JSONUtil.toJSONString(result));
            return;
        }

        String userTokenFromRedis = redisService.get(Const.REDIS_KEY + user.getPkId());

        if( userTokenFromRedis==null  ){
            System.out.println(111);
            Result result = Result.error("身份信息过期,请重新登录");
            ResponseUtil.write(response,JSONUtil.toJSONString(result));
            return;
        }

        // 放行
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        doFilter(request, response, filterChain);

    }
}
