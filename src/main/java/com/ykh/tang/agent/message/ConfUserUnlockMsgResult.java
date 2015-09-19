package com.ykh.tang.agent.message;

/**
 * 26.会议用户解锁成功消息，0x00010062
 *
 * @author xianchao.ji
 */
public class ConfUserUnlockMsgResult extends BaseConfMsgResult implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
