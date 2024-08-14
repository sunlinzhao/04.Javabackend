package com.hotel.util;

import com.hotel.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/*",initParams = {
        @WebInitParam(name="path",value = "login_ajax.jsp"),
        @WebInitParam(name="allow",value = "login,assets,index.jsp")
})
public class PermissionFilter implements Filter {
    private String path;
    private String allow;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        path=filterConfig.getInitParameter("path");
        allow=filterConfig.getInitParameter("allow");
    }
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session=request.getSession();
        //获取用户访问的url地址
        String requestURI = request.getRequestURI();
        String queryString=request.getQueryString();
        requestURI=queryString==null?requestURI:requestURI+"?"+queryString;
        String[] allows=allow.split(",");
        for (String allowed:allows){
            if (requestURI.contains(allowed)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        //StringBuffer requestURL = request.getRequestURL();
       /* System.out.println(requestURI);
        System.out.println(queryString);*/
        //System.out.println(requestURL);
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin==null){
            //用户没有经过登录
            response.sendRedirect(path);
        }else{
            //用户经过登录
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
