package com.hotel.dao.impl;

import com.hotel.dao.RoomTypeDao;
import com.hotel.entity.RoomType;
import com.hotel.util.DBUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RoomTypeDaoImpl implements RoomTypeDao {
    @Override
    public List<RoomType> selectList() {

        String sql="select * from roomtype order by price";
        try {
            return getQueryRunner().query(sql, new BeanListHandler<RoomType>(RoomType.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(RoomType roomType) {
        String sql="insert into roomtype values(default,?,?,?,?,?)";
        try {
            int i = getQueryRunner().update(sql, roomType.getType(), roomType.getPrice(), roomType.getDeposit(), roomType.getBedNum(), roomType.getRemark());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql="delete from roomtype where id=?";
        try {
            int i = getQueryRunner().update(sql, id);
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(RoomType roomType) {
        String sql="update roomtype set type=?,price=?," +
                "deposit=?,bedNum=?,remark=? where id=?";
        try {
            int i=getQueryRunner().update(sql,roomType.getType(),roomType.getPrice(),
                    roomType.getDeposit(),roomType.getBedNum(),roomType.getRemark(),
                    roomType.getId());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public RoomType selectById(Integer id) {
        String sql="select * from roomtype where id=?";
        try {
            return getQueryRunner().query(sql,new BeanHandler<>(RoomType.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        String sql=new String("delete from roomtype where id=?");
        return DBUtil.deleteBatch(sql,ids);
    }
}
