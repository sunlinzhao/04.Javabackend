package com.hotel.servlet;

import com.hotel.entity.RoomInfo;
import com.hotel.entity.RoomType;
import com.hotel.service.RoomInfoService;
import com.hotel.service.RoomTypeService;
import com.hotel.service.impl.RoomInfoServiceImpl;
import com.hotel.service.impl.RoomTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "RoomInfoServlet",value = "/RoomInfoServlet", initParams = {
        @WebInitParam(name = "status", value = "1:空,2:有客,3:空脏"),
        @WebInitParam(name="email",value = "126.com")})
@MultipartConfig
public class RoomInfoServlet extends BaseServlet {
    private final RoomInfoService service;
    private final RoomTypeService typeService;

    public RoomInfoServlet() {
        service = new RoomInfoServiceImpl();
        typeService = new RoomTypeServiceImpl();
    }
    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path=request.getParameter("path");
        String fileName=path.substring(path.lastIndexOf("/")+1);
        String realPath=this.getServletContext().getRealPath("/");
        String file=realPath+path;
        //设置一下响应相关的类型
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
        //通过IO流，实现文件下载
        FileInputStream fis=new FileInputStream(file);
        OutputStream os= response.getOutputStream();
        byte[] buffer=new byte[1024];
        int b=-1;
        while ((b=fis.read(buffer))!=-1){
            os.write(buffer,0,b);
        }
        fis.close();
        os.close();
    }
    public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomInfo info = new RoomInfo();
        try {
            BeanUtils.populate(info, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //获取当前工程真实路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/");
        String path = realPath + "upload";
        File dir = new File(path);
        dir.mkdirs();//创建目录
        //完成上传处理
        Part part = request.getPart("pic");
        String fileName = part.getSubmittedFileName();
        String extName = fileName.substring(fileName.lastIndexOf("."));
        String prefix = String.valueOf(System.currentTimeMillis());
        fileName = prefix + extName;
        File file = new File(dir, fileName);
        //上传处理
        part.write(file.getAbsolutePath());
        //UUID.randomUUID().toString().replace("-","");
        info.setPic("/upload/" + fileName);
        service.insert(info);
        return selectList(request, response);
    }

    public String selectList(HttpServletRequest request, HttpServletResponse response) {
        List<RoomInfo> list = service.list();
        request.setAttribute("list", list);
        return "room_info_list.jsp";
    }

    public String preSave(HttpServletRequest request, HttpServletResponse response) {

        ServletConfig config = this.getServletConfig();
        //1:空,2:有客,3:空脏,4:备用
        //获取初始化参数
        String status = config.getInitParameter("status");
        //获取Servlet名字
        String servletName = config.getServletName();
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //对枚举类型进行循环
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }

        String[] statuses = status.split(",");
        Map<String, String> map = new TreeMap<>();
        for (String s : statuses) {//1:空
            map.put(s.split(":")[0], s.split(":")[1]);
        }
        //先查询所有房间类型
        List<RoomType> list = typeService.list();
        request.setAttribute("list", list);
        request.setAttribute("map", map);
        return "room_info_save.jsp";
    }
}
