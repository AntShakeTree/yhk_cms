package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 39.驱逐用户出会失败消息，0x000100c4
 *
 * @author xianchao.ji
 */
public class ExpelUserMsgFault extends BaseConfMsgFault implements IMessageHandler {
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
