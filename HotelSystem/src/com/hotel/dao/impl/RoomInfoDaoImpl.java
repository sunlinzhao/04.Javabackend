package com.hotel.dao.impl;

import com.hotel.dao.RoomInfoDao;
import com.hotel.entity.RoomInfo;
import com.hotel.util.DBUtil;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RoomInfoDaoImpl implements RoomInfoDao {
    @Override
    public List<RoomInfo> selectList() {
        String sql="select t.type,i.* from roomtype t join roominfo i where t.id=i.tid";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanListHandler<>(RoomInfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(RoomInfo roomInfo) {
        String sql="insert into roominfo values(default,?,?,?,?,?,?,?,?,?)";
        try {
            int i=DBUtil.getQueryRunner().update(sql,roomInfo.getLevel(),roomInfo.getTid(),
                    roomInfo.getRoomnum(),roomInfo.getPrice(),roomInfo.getDeposit(),
                    roomInfo.getTel(),roomInfo.getStatus(),roomInfo.getRemark(),
                    roomInfo.getPic());
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(RoomInfo roomInfo) {
        return false;
    }

    @Override
    public RoomInfo selectById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        return false;
    }
}
