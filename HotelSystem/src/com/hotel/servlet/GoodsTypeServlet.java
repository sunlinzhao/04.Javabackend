package com.hotel.servlet;

import com.hotel.entity.GoodsType;
import com.hotel.service.GoodsTypeService;
import com.hotel.service.impl.GoodsTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends BaseServlet {
    private final GoodsTypeService service;

    public GoodsTypeServlet() {
        service = new GoodsTypeServiceImpl();
    }

    public String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsType goodsType = new GoodsType();
        try {
            BeanUtils.populate(goodsType, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        service.update(goodsType);
        return selectList(req, resp);
    }

    public String preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        GoodsType goodsType = service.getById(Integer.valueOf(id));
        req.setAttribute("goodsType", goodsType);
        return"goods_type_update.jsp";
    }

    public String deleteCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("ids");
        service.removeChecked(ids);
        return selectList(req, resp);
    }

    public String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsType goodsType = new GoodsType();
        try {
            BeanUtils.populate(goodsType, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        service.insert(goodsType);
        return selectList(req, resp);
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.remove(Integer.valueOf(id));
        return selectList(req, resp);
    }

    public String selectList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GoodsType> list = service.list();
        req.setAttribute("list", list);
        return "goods_type_list.jsp";
    }
}
