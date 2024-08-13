package com.javabackend.config;

import java.util.ResourceBundle;

/**
 * @author : SunLZ
 * @project : Javabackend
 * @date : 2024/8/13
 */
public class DbConfig {
    public static final String user;
    public static final String password;
    public static final String driver;
    public static final String url;

    /**
     * 加载数据库配置
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        user = bundle.getString("mysql.user");
        password = bundle.getString("mysql.password");
        driver = bundle.getString("mysql.driver");
        url = bundle.getString("mysql.url");
    }
}
