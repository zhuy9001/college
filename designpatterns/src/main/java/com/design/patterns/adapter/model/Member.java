package com.design.patterns.adapter.model;

import java.io.Serializable;

public class Member implements Serializable {


    private static final long serialVersionUID = -8367950583503778406L;

    private String  userName;
    private String password;
    private  String openId;
    private String  type;

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mid='" + openId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
