package com.ykh.tang.agent.message;

/**
 * 63 服务上线消息， 0x00008001
 *
 * @author xianchao.ji
 */
public class ServiceOnlineMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int userID;// 用户ID
    int servType; // 服务类型
    int groupID; // 服务类型实例编号
    int channelType;

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }

    public int getServType() {
        return servType;
    }

    public void setServType(int servType) {
        this.servType = servType;
    }
}
