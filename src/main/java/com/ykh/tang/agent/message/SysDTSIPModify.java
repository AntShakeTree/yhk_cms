package com.ykh.tang.agent.message;

/**
 * 61.传输服务器地址改变通知，0x00010142
 *
 * @author xianchao.ji
 */
public class SysDTSIPModify extends BaseConfMsgResult implements IMessageHandler {
    String newIP;// 新IP地址UINT32[4],32bits[16bytes]
    String oldIP; // 原IP地址UINT32[4],32bits[16bytes]

    public String getNewIP() {
        return newIP;
    }

    public void setNewIP(String newIP) {
        this.newIP = newIP;
    }

    public String getOldIP() {
        return oldIP;
    }

    public void setOldIP(String oldIP) {
        this.oldIP = oldIP;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
