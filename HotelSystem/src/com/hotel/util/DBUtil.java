package com.hotel.util;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DBUtil {
    private static final String DRIVER_CLASS;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static QueryRunner runner;
    static {
        ResourceBundle bundle=ResourceBundle.getBundle("/db");
        DRIVER_CLASS=bundle.getString("mysql.driver");
        URL=bundle.getString("mysql.url");
        USERNAME=bundle.getString("mysql.user");
        PASSWORD=bundle.getString("mysql.password");
    }
    public static DruidDataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
    public static QueryRunner getQueryRunner(){
        if (runner==null)
            runner=new QueryRunner(getDataSource());
        return runner;
    }
    public static boolean deleteBatch(String sql,String[] ids){
        List<Object[]> list=new ArrayList<>();
        for (String id : ids) {
            list.add(new Object[]{id});
        }
        try {
            getQueryRunner().batch(sql, list.toArray(new Object[list.size()][]));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
