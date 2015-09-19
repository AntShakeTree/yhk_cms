package com.ykh.tang.agent.vo;

import java.util.ArrayList;
import java.util.List;

public class UserChannel {
    public int userID;// 用户ID
    public List<UserServiceAddr> ctsAddr;// 接入服务器地址列表
    public List<UserServiceAddr> dtsAddr;// 传输服务器地址列表
    public int tempConferenceID;          //cmsagent不使用该变量

    public int getUserID() {
        return userID;
    }

    public void setUserID(int ID) {
        userID = ID;
    }

    public List<UserServiceAddr> getCtsAddr() {
        return ctsAddr;
    }

    public void setCtsAddr(List<UserServiceAddr> Addr) {
        ctsAddr = Addr;
    }

    public List<UserServiceAddr> getDtsAddr() {
        return dtsAddr;
    }

    public void setDtsAddr(List<UserServiceAddr> Addr) {
        dtsAddr = Addr;
    }

    public Object getArrayInstance() {
        return new ArrayList<UserServiceAddr>();
    }

    public int getTempConferenceID() {
        return tempConferenceID;
    }

    public void setTempConferenceID(int tempConferenceId) {
        this.tempConferenceID = tempConferenceId;
    }

}
