package com.ykh.tang.agent.message;

/**
 * 58.用户下线通知，0x00011110
 *
 * @author xianchao.ji
 */
public class UserOfflineMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int userID;// 用户ID

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
