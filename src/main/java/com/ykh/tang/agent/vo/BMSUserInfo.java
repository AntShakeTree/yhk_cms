package com.ykh.tang.agent.vo;

import java.util.List;

public class BMSUserInfo {
    public int userID; // 用户ID
    public String userName; // 用户名
    public int clientType; // 客户端类型，由应用设值
    public int pinCode; // PIN码
    public int domain; // 用户所在的域
    public int status; // 用户状态
    public List<String> ipArr; //IP列表
    public List<String> roletypeArr; // 用户的角色列表

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getDomain() {
        return domain;
    }

    public void setDomain(int domain) {
        this.domain = domain;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getIPArr() {
        return ipArr;
    }

    public void setIPArr(List<String> ipArr) {
        this.ipArr = ipArr;
    }

    public List<String> getRoleTypeArr() {
        return roletypeArr;
    }

    public void setRoleTypeArr(List<String> roletypeArr) {
        this.roletypeArr = roletypeArr;
    }
}
