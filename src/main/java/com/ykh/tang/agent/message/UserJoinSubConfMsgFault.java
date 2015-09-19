package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 29.用户加入子会议失败消息，0x00010074
 *
 * @author xianchao.ji
 */
public class UserJoinSubConfMsgFault extends BaseConfMsgFault implements IMessageHandler {
    List<UserError> userErrorArr; // 操作失败用户错误列表

    public List<UserError> getUserErrorArr() {
        return userErrorArr;
    }

    public void setUserErrorArr(List<UserError> userErrorArr) {
        this.userErrorArr = userErrorArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
