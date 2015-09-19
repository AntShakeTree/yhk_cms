package com.ykh.tang.agent.message;

/**
 * 22.会议系统锁定通知，0x00010030
 *
 * @author xianchao.ji
 */
public class ConfSysLockMsgResult extends BaseConfMsgResult implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
