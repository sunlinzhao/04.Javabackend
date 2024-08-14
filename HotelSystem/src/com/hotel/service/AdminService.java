package com.hotel.service;

import com.hotel.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> list();
    boolean insert(Admin admin);
    Admin login(Admin admin);
    boolean updateLogin(Admin admin);
    boolean remove(Integer id);
    boolean update(Admin admin);
    Admin getById(Integer id);
    boolean removeChecked(String[] ids);
}
