package com.ykh.tang.agent.message;

/**
 * 27.会议用户解锁失败消息，0x00010064
 *
 * @author xianchao.ji
 */
public class ConfUserUnlockMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
