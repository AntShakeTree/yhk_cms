package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 19.创建子会议失败消息
 *
 * @author xianchao.ji
 */
public class CreateSubConfMsgFault extends BaseConfMsgFault implements IMessageHandler {
    public List<UserError> userErrorArr; // 操作失败用户错误列表

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
