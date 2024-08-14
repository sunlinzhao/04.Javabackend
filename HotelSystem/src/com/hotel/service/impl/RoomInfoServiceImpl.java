package com.hotel.service.impl;

import com.hotel.dao.RoomInfoDao;
import com.hotel.dao.impl.RoomInfoDaoImpl;
import com.hotel.entity.RoomInfo;
import com.hotel.service.RoomInfoService;

import java.util.List;

public class RoomInfoServiceImpl implements RoomInfoService {
    private final RoomInfoDao dao;
    public RoomInfoServiceImpl(){
        dao=new RoomInfoDaoImpl();
    }
    @Override
    public List<RoomInfo> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(RoomInfo roomInfo) {
        return dao.save(roomInfo);
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public boolean update(RoomInfo roomInfo) {
        return false;
    }

    @Override
    public RoomInfo getById(Integer id) {
        return null;
    }

    @Override
    public boolean removeChecked(String[] ids) {
        return false;
    }
}
