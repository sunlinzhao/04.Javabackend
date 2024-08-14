package com.hotel.dao;

import com.hotel.entity.MemberLevel;

import java.util.List;

public interface MemberLevelDao {
    List<MemberLevel> selectList();
    boolean save(MemberLevel memberLevel);
    boolean delete(Integer id);
    boolean update(MemberLevel memberLevel);
    MemberLevel selectById(Integer id);
    boolean deleteChecked(String[] ids);
}
