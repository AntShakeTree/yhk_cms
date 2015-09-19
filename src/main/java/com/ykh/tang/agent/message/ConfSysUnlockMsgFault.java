package com.ykh.tang.agent.message;

/**
 * 23.会议系统解锁通知，0x00010040
 *
 * @author xianchao.ji
 */
public class ConfSysUnlockMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
