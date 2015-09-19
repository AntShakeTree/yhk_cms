package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 3 from chao.li
 *
 * @author xianchao.ji
 */
public class UserInfo {
    int userID;
    String userName;
    int clientType;
    int domain;
    int status;
    Ip ip;
    List<String> roleArr;

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

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }

    public List<String> getRoleArr() {
        return roleArr;
    }

    public void setRoleArr(List<String> roleArr) {
        this.roleArr = roleArr;
    }
}
