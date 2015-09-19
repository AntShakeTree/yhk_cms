package com.ykh.tang.agent.vo;

public class UserServiceAddr {
    public int serviceType; // 服务类型，业务管理需要，由会议管理转换
    public int serverIP0; // 服务器地址Ip
    public int serverIP1;
    public int serverIP2;
    public int serverIP3;
    public int hotServerIP0;// 备份服务器IP
    public int hotServerIP1;
    public int hotServerIP2;
    public int hotServerIP3;
    public int groupID; // 组ID
    public int channel; // 通道ID
    public int priv; // 权限

    public int getServiceType() {
        return serviceType;
    }

    public int getServerIP0() {
        return serverIP0;
    }

    public void setServerIP0(int serverIP0) {
        this.serverIP0 = serverIP0;
    }

    public int getServerIP1() {
        return serverIP1;
    }

    public void setServerIP1(int serverIP1) {
        this.serverIP1 = serverIP1;
    }

    public int getServerIP2() {
        return serverIP2;
    }

    public void setServerIP2(int serverIP2) {
        this.serverIP2 = serverIP2;
    }

    public int getServerIP3() {
        return serverIP3;
    }

    public void setServerIP3(int serverIP3) {
        this.serverIP3 = serverIP3;
    }

    public int getHotServerIP0() {
        return hotServerIP0;
    }

    public void setHotServerIP0(int hotServerIP0) {
        this.hotServerIP0 = hotServerIP0;
    }

    public int getHotServerIP1() {
        return hotServerIP1;
    }

    public void setHotServerIP1(int hotServerIP1) {
        this.hotServerIP1 = hotServerIP1;
    }

    public int getHotServerIP2() {
        return hotServerIP2;
    }

    public void setHotServerIP2(int hotServerIP2) {
        this.hotServerIP2 = hotServerIP2;
    }

    public int getHotServerIP3() {
        return hotServerIP3;
    }

    public void setHotServerIP3(int hotServerIP3) {
        this.hotServerIP3 = hotServerIP3;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getPriv() {
        return priv;
    }

    public void setPriv(int priv) {
        this.priv = priv;
    }
}
