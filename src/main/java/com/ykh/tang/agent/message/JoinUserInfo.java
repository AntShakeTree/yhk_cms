package com.ykh.tang.agent.message;

import java.util.ArrayList;
import java.util.List;

/**
 * 6 from chao.li
 *
 * @author xianchao.ji
 */
public class JoinUserInfo {
    int index;
    int userID;
    String userName;
    int clientType;
    int domain;
    int status;
    Ip IP;
    List<String> roleArr = new ArrayList<String>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

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

    public List<String> getRoleArr() {
        return roleArr;
    }

    public void setRoleArr(List<String> roleArr) {
        this.roleArr = roleArr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getIP() {
        return IP;
    }

    public void setIP(Object ip) {
        this.IP = (Ip) ip;
    }

}
