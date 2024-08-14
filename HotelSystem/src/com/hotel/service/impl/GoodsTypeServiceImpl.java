package com.hotel.service.impl;

import com.hotel.dao.GoodsTypeDao;
import com.hotel.dao.impl.GoodsTypeDaoImpl;
import com.hotel.entity.GoodsType;
import com.hotel.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    private GoodsTypeDao dao;

    public GoodsTypeServiceImpl() {
        dao=new GoodsTypeDaoImpl();
    }

    @Override
    public List<GoodsType> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(GoodsType goodsType) {
        return dao.save(goodsType);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(GoodsType goodsType) {
        return dao.update(goodsType);
    }

    @Override
    public GoodsType getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public boolean removeChecked(String[] ids) {
        return dao.deleteChecked(ids);
    }
}
