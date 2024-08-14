package com.hotel.dao;



import com.hotel.entity.Admin;

import java.util.List;

public interface AdminDao {
    List<Admin> selectList();
    boolean save(Admin admin);
    Admin login(Admin admin);
    boolean updateLastLoginTime(Admin admin);
    boolean update(Admin admin);
    boolean delete(Integer id);
    boolean deleteChecked(String[] ids);
    Admin selectById(Integer id);
}
