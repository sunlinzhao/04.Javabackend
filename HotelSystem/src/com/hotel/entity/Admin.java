package com.hotel.entity;

import java.time.LocalDateTime;

public class Admin {
    private Integer id;
    private String name;
    private String pwd;
    private LocalDateTime lasttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LocalDateTime getLasttime() {
        return lasttime;
    }

    public void setLasttime(LocalDateTime lasttime) {
        this.lasttime = lasttime;
    }
}
