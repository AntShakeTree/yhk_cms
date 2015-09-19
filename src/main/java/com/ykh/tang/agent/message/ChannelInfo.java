package com.ykh.tang.agent.message;

/**
 * 4 from chao.li
 *
 * @author xianchao.ji
 */
public class ChannelInfo {
    int serviceType;
    Ip ip;
    BackIp backIp;
    int groupID;
    int channelID;
    int privilege;

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }

    public BackIp getBackIp() {
        return backIp;
    }

    public void setBackIp(BackIp backIp) {
        this.backIp = backIp;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }
}
