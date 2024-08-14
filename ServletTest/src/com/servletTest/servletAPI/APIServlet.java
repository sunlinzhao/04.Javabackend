package com.servletTest.servletAPI;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : SunLZ
 * @project : Javabackend
 * @date : 2024/8/13
 */


@WebServlet(name = "APIServlet", value = "/APIServlet")
public class APIServlet extends HttpServlet {
    public APIServlet() {
        System.out.println("servlet 构造方法");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet 初始化方法");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet 处理用户请求");
    }

    @Override
    public void destroy() {
        System.out.println("servlet 销毁处理方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
