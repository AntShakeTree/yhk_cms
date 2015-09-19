package com.ykh.tang.agent.message;

/**
 * 59.电话用户下线通知，0x000101b2
 *
 * @author xianchao.ji
 */
public class PhoneUserOfflineMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int userID;// 电话用户ID
    int phone;// 电话号码

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
