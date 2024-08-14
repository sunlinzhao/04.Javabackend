package com.hotel.entity;

public class GoodsType {
    private Integer id;
    private String typename;

    public GoodsType() {
        System.out.println("调用了无参构造方法");
    }

    public GoodsType(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public Integer getId() {
        System.out.println("执行了getId");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("执行了setId");
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
