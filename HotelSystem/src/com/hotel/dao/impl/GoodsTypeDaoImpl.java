package com.hotel.dao.impl;

import com.hotel.dao.GoodsTypeDao;
import com.hotel.entity.GoodsType;
import com.hotel.util.DBUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> selectList() {
        String sql="select id,typename from goodstype";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanListHandler<>(GoodsType.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(GoodsType goodsType) {
        String sql="insert into goodstype values(default,?)";
        try {
            int i=DBUtil.getQueryRunner().update(sql,goodsType.getTypename());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql="delete from goodstype where id=?";
        try {
            int i=DBUtil.getQueryRunner().update(sql,id);
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(GoodsType goodsType) {
        String sql="update goodstype set typename=? where id=?";
        try {
            int i=DBUtil.getQueryRunner().update(sql,goodsType.getTypename(),goodsType.getId());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GoodsType selectById(Integer id) {
        String sql="select id,typename from goodstype where id=?";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanHandler<>(GoodsType.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        String sql="delete from goodstype where id=?";
        return DBUtil.deleteBatch(sql,ids);
    }
}
