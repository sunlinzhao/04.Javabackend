package com.hotel.servlet;

import com.hotel.entity.MemberLevel;
import com.hotel.service.MemberLevelService;
import com.hotel.service.impl.MemberLevelServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/MemberLevelServlet")
public class MemberLevelServlet extends BaseServlet{
    private  final MemberLevelService service;
    public MemberLevelServlet() {
        service=new MemberLevelServiceImpl();
    }
    public String deleteCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");
        service.removeChecked(ids);
        return selectList(request,response);
    }

    public String update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        MemberLevel level=new MemberLevel();
        try {
            BeanUtils.populate(level,request.getParameterMap());
        } catch (IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
        service.update(level);
        return selectList(request,response);
    }
    public String preUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("id");
        MemberLevel level = service.getById(Integer.valueOf(id));
        request.setAttribute("level",level);
        return "member_level_update.jsp";
    }

    public String delete(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("id");
        service.remove(Integer.valueOf(id));
        return selectList(request,response);
    }
    public String save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MemberLevel level=new MemberLevel();
        try {
            BeanUtils.populate(level,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        service.insert(level);
        return selectList(request,response);
    }

    public String selectList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MemberLevel> list = service.list();
        request.setAttribute("list",list);
        return"member_level_list.jsp";
    }
}
