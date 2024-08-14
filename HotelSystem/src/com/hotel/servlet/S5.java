package com.hotel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/S5")
public class S5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("k1","v1");
        req.getSession().setAttribute("k2","v2");
       // req.getRequestDispatcher("/S6").forward(req,resp);
        resp.sendRedirect("S6");
    }
}
