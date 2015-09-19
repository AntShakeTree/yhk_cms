package com.ykh.tang.agent.message;

/**
 * 50s.更新会议描述成功消息，0x00010192
 *
 * @author xianchao.ji
 */
public class UpdateConfDesMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int operationID; // 操作者ID
    String des; // 会议描述

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
