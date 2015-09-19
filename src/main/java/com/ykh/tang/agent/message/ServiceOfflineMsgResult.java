package com.ykh.tang.agent.message;

/**
 * 64 服务下线消息, 0x00008002
 *
 * @author xianchao.ji
 */
public class ServiceOfflineMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int userID;// 用户ID
    int servType; // 服务类型
    int groupID; // 服务类型实例编号
    int channelType;

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

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

}
