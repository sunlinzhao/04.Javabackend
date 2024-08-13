package com.javabackend.entity;

import java.time.LocalDateTime;

/**
 * @author : SunLZ
 * @project : Javabackend
 * @date : 2024/8/13
 */
public class Message {
    private Integer id;
    private String nickName;
    private String content;
    private String ip;
    private LocalDateTime mtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getMtime() {
        return mtime;
    }

    public void setMtime(LocalDateTime mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", ip='" + ip + '\'' +
                ", mtime=" + mtime +
                '}';
    }
}
