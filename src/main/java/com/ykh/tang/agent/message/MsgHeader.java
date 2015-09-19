package com.ykh.tang.agent.message;

/**
 * 12.消息号
 *
 * @author xianchao.ji
 */
public class MsgHeader implements IMessage {

    private int contentLength;
    private int messageType;
    private int serviceType;
    private int channelID;
    private int timestamp;
    private int version;

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int getMsgID() {
        // TODO Auto-generated method stub
        return this.messageType;
    }

}
