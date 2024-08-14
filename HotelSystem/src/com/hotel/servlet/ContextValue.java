package com.hotel.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContextValue")
public class ContextValue extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* System.out.println(req.getAttribute("r"));
        System.out.println(req.getSession().getAttribute("s"));
        System.out.println(getServletContext().getAttribute("c"));
        String email = getServletContext().getInitParameter("email");
        System.out.println(email);*/
        ServletContext context=getServletContext();

        String contextPath = context.getContextPath();

        System.out.println(contextPath);
        /* context.getInitParameter("");
        Enumeration<String> initParameterNames = context.getInitParameterNames();
        context.getRealPath("/");
        String serverInfo = context.getServerInfo();
        System.out.println("服务器:"+serverInfo);
        int majorVersion = context.getMajorVersion();
        int minorVersion = context.getMinorVersion();
        System.out.println("minorVersion = " + minorVersion);
        System.out.println("majorVersion = " + majorVersion);*/


    }
}
