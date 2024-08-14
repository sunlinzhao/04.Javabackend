package com.hotel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/S6")
public class S6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String k1 = (String) req.getAttribute("k1");
        String k2=(String)req.getSession().getAttribute("k2");
        out.println(k1+"<br>"+k2+"<br>");
        req.getSession().removeAttribute("k2");
        String k3=(String)req.getSession().getAttribute("k2");
        out.println("after remove:"+k1+"<br>"+k3);
    }
}
