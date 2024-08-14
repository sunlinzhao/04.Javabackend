package com.hotel.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends BaseServlet{
    public void save(HttpServletRequest request, HttpServletResponse response){
        System.out.println("run save method");
    }
    public void delete(HttpServletRequest request, HttpServletResponse response){
        System.out.println("run delete method");
    }
    public String view(HttpServletRequest request,HttpServletResponse response){
        System.out.println("run view method");
        return "forward:index.jsp";
    }
    public String select(HttpServletRequest request,HttpServletResponse response){
        System.out.println("run select method");
        return "redirect:index.jsp";
    }
    public String list(HttpServletRequest request, HttpServletResponse response){
        System.out.println("run list method");
        //重定向，前缀redirect    请求转发   前缀 forward
        //如果不加前缀，默认请求转发
        //return "forward:index.jsp";
        return "index.jsp";
        //请求转发或重定向
        //request.getRequestDispatcher("").forward(request,response);
        //response.sendRedirect("");
    }
}
