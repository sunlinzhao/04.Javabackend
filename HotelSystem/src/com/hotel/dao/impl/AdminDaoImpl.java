package com.hotel.dao.impl;

import com.hotel.dao.AdminDao;
import com.hotel.entity.Admin;
import com.hotel.util.DBUtil;
import com.hotel.util.Md5Util;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public List<Admin> selectList() {
        String sql="select id,name,pwd,lasttime from admin order by lasttime desc";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanListHandler<>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Admin admin) {
        String sql="insert into admin(name,pwd) values(?,?)";
        try {
            int i=DBUtil.getQueryRunner().update(sql,admin.getName(),
                    Md5Util.getMd5String(admin.getPwd()));
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Admin login(Admin admin) {
        String sql="select id,name,pwd,lasttime from admin where name=? and pwd=?";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanHandler<>(Admin.class),
                    admin.getName(),Md5Util.getMd5String(admin.getPwd()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateLastLoginTime(Admin admin) {
        String sql="update admin set lasttime=? where id=?";
        try {
            int i=DBUtil.getQueryRunner().update(sql,admin.getLasttime(),admin.getId());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        String sql="update admin set name=? where id=? and name!='admin'";
        try {
            int i=DBUtil.getQueryRunner().update(sql,admin.getName(),admin.getId());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql="delete from admin where id=? and name!='admin'";
        try {
            int i=DBUtil.getQueryRunner().update(sql,id);
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        String sql="delete from admin where id=? and name!='admin'";
       return DBUtil.deleteBatch(sql,ids);
    }

    @Override
    public Admin selectById(Integer id) {
        String sql="select id,name,pwd,lasttime from admin where id=?";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanHandler<>(Admin.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
