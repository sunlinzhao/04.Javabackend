package com.hotel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : SunLZ
 * @project : Javabackend
 * @date : 2024/8/14
 */
@WebServlet(name = "S3", value = "/S3")
public class S3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("这里是S3的 servlet");
        req.setAttribute("K1", "K1");
        // 以前的写法
//        resp.setStatus(302);
//        resp.setHeader("location", "S4");
        // 现在的写法
        resp.sendRedirect("S4");
//        resp.sendRedirect("http://www.baidu.com");
    }
}
