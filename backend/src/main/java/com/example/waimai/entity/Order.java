package com.example.waimai.entity;

import java.sql.Time;

public class Order {

    private Integer id;
    private String takeoutinfo;

    private String time1;

    private String time2;

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    private String liquid;

    private String name;

    private String phone;

    private String address;


    private String placefrom;

    private String openid;

    private String status;

    private String receiver_openid;

    public String getReceiver_openid() {
        return receiver_openid;
    }

    public void setReceiver_openid(String receiver_openid) {
        this.receiver_openid = receiver_openid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlacefrom() {
        return placefrom;
    }

    public void setPlacefrom(String placefrom) {
        this.placefrom = placefrom;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiquid() {
        return liquid;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    public String getTakeoutinfo() {
        return takeoutinfo;
    }

    public void setTakeoutinfo(String takeoutinfo) {
        this.takeoutinfo = takeoutinfo;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }
}


