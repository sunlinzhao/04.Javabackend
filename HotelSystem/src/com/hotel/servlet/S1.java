package com.hotel.servlet;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "S1", value = "/S1")
public class S1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        PrintWriter writer = resp.getWriter();
        writer.println("这里是S1的 servlet");
        // 在请求范围内，放一个名值对
        req.setAttribute("k", "v");
        // 封装转发对象
        RequestDispatcher rd = req.getRequestDispatcher("S2");
        // 调用转发
        rd.forward(req, resp);
//        rd.include(req, resp);
    }
}
