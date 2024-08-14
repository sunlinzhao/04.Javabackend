package com.hotel.service.impl;

import com.hotel.dao.AdminDao;
import com.hotel.dao.impl.AdminDaoImpl;
import com.hotel.entity.Admin;
import com.hotel.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private final AdminDao dao;
    public AdminServiceImpl(){
        dao=new AdminDaoImpl();
    }
    @Override
    public List<Admin> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(Admin admin) {
        return dao.save(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return dao.login(admin);
    }

    @Override
    public boolean updateLogin(Admin admin) {
        return dao.updateLastLoginTime(admin);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(Admin admin) {
        return dao.update(admin);
    }

    @Override
    public Admin getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public boolean removeChecked(String[] ids) {
        return dao.deleteChecked(ids);
    }
}
