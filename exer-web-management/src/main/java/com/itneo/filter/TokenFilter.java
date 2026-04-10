package com.itneo.filter;

import com.itneo.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1.获取请求路径
        String path = req.getRequestURI(); // /employee/login

        // 2.判断请求路径是否是登录请求，如果路径中包含 /login，则放行
        if(path.contains("login")){
            log.info("登录请求，放行");
            chain.doFilter(req, resp);
            return;
        }

        // 3.获取请求头中的token
        String token = req.getHeader("token");

        // 4.判断token是否存在，如果不存在，说明用户没有登录，返回错误信息(响应码401)
        if(token == null || token.isEmpty()){
            log.info("令牌为空，响应401");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 5.如果token存在，校验token，如果校验失败，返回错误信息(响应码401)
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 6.如果token存在，校验成功，放行
        log.info("令牌合法，放行");
        chain.doFilter(req, resp);

    }
}
