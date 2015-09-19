package com.ykh.tang.agent.message;

/**
 * 24.用户锁定会议成功消息，0x00010052
 *
 * @author xianchao.ji
 */
public class ConfUserLockMsgResult extends BaseConfMsgResult implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
