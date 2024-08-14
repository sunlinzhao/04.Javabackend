package com.hotel.dao.impl;

import com.hotel.dao.MemberLevelDao;
import com.hotel.entity.MemberLevel;
import com.hotel.util.DBUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MemberLevelDaoImpl implements MemberLevelDao {
    @Override
    public List<MemberLevel> selectList() {
        String sql="select * from memberlevel order by low";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanListHandler<>(MemberLevel.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(MemberLevel memberLevel) {
        String sql="insert into memberlevel values(default,?,?,?,?)";
        try {
            int i=DBUtil.getQueryRunner().update(sql,memberLevel.getLevel(),
                    memberLevel.getLow(),memberLevel.getHigh(),memberLevel.getDiscount());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql="delete from memberlevel where id=?";
        try {
            int i=DBUtil.getQueryRunner().update(sql,id);
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(MemberLevel memberLevel) {
        String sql="update memberlevel set level=?,low=?,high=?,discount=? where id=?";
        try {
            int i=DBUtil.getQueryRunner().update(sql,memberLevel.getLevel(),
                    memberLevel.getLow(),memberLevel.getHigh(),
                    memberLevel.getDiscount(),memberLevel.getId());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public MemberLevel selectById(Integer id) {
        String sql="select * from memberlevel where id=?";
        try {
           return DBUtil.getQueryRunner().query(sql,new BeanHandler<>(MemberLevel.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        String sql="delete from memberlevel where id=? ";
        return DBUtil.deleteBatch(sql,ids);
    }
}
