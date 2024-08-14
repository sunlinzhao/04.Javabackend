package com.hotel.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/Context")
public class ContextTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("r","request");
        HttpSession session=req.getSession();
        session.setAttribute("s","session");
        //要在ServletContext作用域范围内设置一个名值对
        //获取ServletContext方式
        ServletContext context;
        context=req.getServletContext();
        context=session.getServletContext();
        context=this.getServletConfig().getServletContext();
        context=this.getServletContext();
        context.setAttribute("c","context");
        context.setAttribute("c","qqqq");
        context.removeAttribute("c");
    }
}
