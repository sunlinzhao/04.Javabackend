package com.hotel.service;

import com.hotel.entity.RoomInfo;

import java.util.List;

public interface RoomInfoService {
    List<RoomInfo> list();
    boolean insert(RoomInfo roomInfo);
    boolean remove(Integer id);
    boolean update(RoomInfo roomInfo);
    RoomInfo getById(Integer id);
    boolean removeChecked(String[] ids);
}
