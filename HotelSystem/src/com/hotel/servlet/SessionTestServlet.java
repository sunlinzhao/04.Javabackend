package com.hotel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        HttpSession session=req.getSession();//req.getSession(false);
        //获取Sessionid
        out.println(session.getId()+"<br>");
        //判断session是否是新的
        out.println(session.isNew()?"新的":"旧的");
        //Session失效
        //1.关闭浏览器
        //2.将工程从服务器退出
        //3.超过最大不活动时间 默认最大不活动时间 1800秒(30分钟)
        //4.调用方法，让当前session失效

        //设置session最大不活动时间，以秒钟为单位
        //session.setMaxInactiveInterval(5);
        out.println(session.getMaxInactiveInterval()+"<br>");
        out.println("<a href='session'>刷新</a><br>");
        out.println("<a href='session?flag=in'>失效</a><br>");
        String flag=req.getParameter("flag");
        if (flag!=null){
            //让当前session失效
            session.invalidate();
        }
    }
}
