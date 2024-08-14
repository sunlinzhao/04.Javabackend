package com.hotel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testUrl")
public class UrlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println(session.getId());
        out.println("<br><a href='testUrl'>reload</a>");
        String path=resp.encodeURL("testUrl");
        out.println("<br><a href='"+path+"'>reload</a>");
    }
}
