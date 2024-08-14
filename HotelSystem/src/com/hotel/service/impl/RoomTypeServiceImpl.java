package com.hotel.service.impl;

import com.hotel.dao.RoomTypeDao;
import com.hotel.dao.impl.RoomTypeDaoImpl;
import com.hotel.entity.RoomType;
import com.hotel.service.RoomTypeService;

import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService {
    private RoomTypeDao dao;
    public RoomTypeServiceImpl(){
        this.dao=new RoomTypeDaoImpl();
    }
    @Override
    public List<RoomType> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(RoomType roomType) {
        return dao.save(roomType);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(RoomType roomType) {
        return dao.update(roomType);
    }

    @Override
    public RoomType getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public boolean removeChecked(String[] ids) {
        return dao.deleteChecked(ids);
    }
}
