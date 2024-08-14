package com.hotel.servlet;

import com.hotel.entity.RoomType;
import com.hotel.service.RoomTypeService;
import com.hotel.service.impl.RoomTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "RoomTypeServlet", value = "/RoomTypeServlet")
public class RoomTypeServlet extends BaseServlet {
    private final RoomTypeService service;
    public RoomTypeServlet() {
        this.service = new RoomTypeServiceImpl();
    }
    public void selectByTid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String tid=request.getParameter("tid");
        RoomType roomType = service.getById(Integer.valueOf(tid));
        PrintWriter out=response.getWriter();
        out.println("{\"price\":"+roomType.getPrice()+",\"deposit\":"+roomType.getDeposit()+"}");
    }
    public String  deleteCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");
        service.removeChecked(ids);
        return selectList(request,response);//"redirect:RoomTypeServlet?flag=selectList";
    }
    public String update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        RoomType roomType=new RoomType();
        try {
            BeanUtils.populate(roomType,request.getParameterMap());
        } catch (IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
        service.update(roomType);
        return selectList(request,response);
    }
    public String preUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("id");
        RoomType roomType = service.getById(Integer.valueOf(id));
        request.setAttribute("roomType",roomType);
        return "room_type_update.jsp";
    }
    public String delete(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("id");
        service.remove(Integer.valueOf(id));
        return selectList(request,response);
    }

    public String save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RoomType roomType=new RoomType();
        try {
            BeanUtils.populate(roomType,request.getParameterMap());
        } catch (IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
        service.insert(roomType);
        return selectList(request,response);
    }

    public String selectList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        List<RoomType> list = service.list();
        request.setAttribute("list",list);
        return"room_type_list.jsp";
    }
}
