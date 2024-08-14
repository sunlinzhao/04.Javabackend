package com.hotel.entity;

public class RoomInfo {
    private Integer id;
    private Integer level;
    private Integer tid;
    private String type;
    private String roomnum;
    private Integer price;
    private Integer deposit;
    private String tel;
    private String status;
    private String remark;
    private String pic;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "id=" + id +
                ", level=" + level +
                ", tid=" + tid +
                ", type='" + type + '\'' +
                ", roomnum='" + roomnum + '\'' +
                ", price=" + price +
                ", deposit=" + deposit +
                ", tel='" + tel + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
