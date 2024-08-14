package com.hotel.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
@WebFilter(value = "/*",
        initParams = {@WebInitParam(name = "encode",value = "utf-8")})
public class EncodingFilter implements Filter {
    private String encode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encode);
        servletResponse.setCharacterEncoding(encode);
        //表示当前过滤节点结束，向下一个节点跳转
        filterChain.doFilter(servletRequest,servletResponse);
        //System.out.println("run encoding filter");
    }
}
