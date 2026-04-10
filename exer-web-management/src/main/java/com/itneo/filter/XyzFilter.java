package com.itneo.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*") // 拦截所有请求
@Slf4j
public class XyzFilter implements Filter {

    /**
     * 初始化方法，web启动时执行，只执行一次
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法 ....");
    }

    /**
     * 拦截方法，每次请求时执行
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("放行前，拦截到了请求....");

        // 放行
        chain.doFilter(request, response);

        log.info("放行后，请求处理完毕....");
    }

    /**
     * 销毁方法，web关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
       log.info("destroy 销毁方法 ....");
    }
}
