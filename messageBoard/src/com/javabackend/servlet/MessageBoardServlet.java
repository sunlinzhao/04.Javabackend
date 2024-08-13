package com.javabackend.servlet;
/**
 * @author : SunLZ
 * @project : Javabackend
 * @date : 2024/8/13
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.javabackend.config.DbConfig;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(name = "MessageBoardServlet", value = "/MessageBoardServlet")
public class MessageBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码
        request.setCharacterEncoding("utf-8");

        String nickName = request.getParameter("nickName");
        String content = request.getParameter("content");
        String ip = request.getRemoteAddr(); // 获取 IP 地址
        // 存放数据
        // TODO
        // 设置响应内容类型是网页
        response.setContentType("text/html");
        // 设置响应编码
        response.setCharacterEncoding("utf-8");
        // 获取打印流
        PrintWriter out = response.getWriter();
//        out.println("您的昵称是：" + nickName + "<br>"); // br实现换行
//        out.println("您的留言是：" + content);
        // 将昵称和留言内容存入到数据库中
        // apache DbUtils 工具类
        // 需要 DbUtils、mysql驱动、数据库连接池的jar包
        // Druid 连接池获取数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(DbConfig.driver);
        dataSource.setUrl(DbConfig.url);
        dataSource.setUsername(DbConfig.user);
        dataSource.setPassword(DbConfig.password);
        // DbUtils 操作数据库
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "insert into message(nickname,content,ip, mtime) values(?,?,?,?)";
        try {
            int x = runner.update(sql, nickName, content, ip, LocalDateTime.now());
            out.println(x > 0 ? "留言成功" : "留言失败");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
