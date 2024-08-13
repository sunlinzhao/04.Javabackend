package com.javabackend.servlet;

import com.alibaba.druid.pool.DruidDataSource;
import com.javabackend.config.DbConfig;
import com.javabackend.entity.Message;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : Javabackend
 * @date : 2024/8/13
 */
@WebServlet(name = "ViewMessageBoardServlet", value = "/view")
public class ViewMessageBoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        // Druid获取连接池数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(DbConfig.driver);
        dataSource.setUrl(DbConfig.url);
        dataSource.setUsername(DbConfig.user);
        dataSource.setPassword(DbConfig.password);
        // DbUtils 操作数据库
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select id,nickname,content,ip,mtime from message order by mtime desc";
        BeanListHandler<Message> beanListHandler = new BeanListHandler<>(Message.class);
        try {
            List<Message> query = runner.query(sql, beanListHandler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
