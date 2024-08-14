package com.hotel.servlet;

import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RoomTypeServlet?flag=save   flag=delete
        String flag=req.getParameter("flag");
        if (StringUtils.isNullOrEmpty(flag)){
            throw  new RuntimeException("请正确传递参数");
        }
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method=aClass.getDeclaredMethod
                    (flag,HttpServletRequest.class,HttpServletResponse.class);
            //result=index.jsp
            String result=(String)method.invoke(this,req,resp);
            if (StringUtils.isNullOrEmpty(result))
                return;
            int i = result.indexOf(":");
            if (i!=-1){
                //result=redirect:index.jsp
                String prefix=result.substring(0,i);
                String path=result.substring(i+1);
                if (prefix.equalsIgnoreCase("forward"))
                    req.getRequestDispatcher(path).forward(req,resp);
                else if (prefix.equalsIgnoreCase("redirect"))
                    resp.sendRedirect(path);
                else
                    throw new RuntimeException("当前操作前缀不支持");
            }else{
                req.getRequestDispatcher(result).forward(req,resp);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
