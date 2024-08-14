package com.hotel.dao;

import com.hotel.util.DBUtil;
import com.hotel.entity.RoomType;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface RoomTypeDao {
    default QueryRunner getQueryRunner(){
        return DBUtil.getQueryRunner();
    }
    List<RoomType> selectList();
    boolean save(RoomType roomType);
    boolean delete(Integer id);
    boolean update(RoomType roomType);
    RoomType selectById(Integer id);
    boolean deleteChecked(String[] ids);
}
