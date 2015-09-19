package com.ykh.tang.agent.message;

/**
 * 56.用户上线通知，0x00011111
 *
 * @author xianchao.ji
 */
public class UserOnlineMsgResult extends BaseConfMsgResult implements IMessageHandler {
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
