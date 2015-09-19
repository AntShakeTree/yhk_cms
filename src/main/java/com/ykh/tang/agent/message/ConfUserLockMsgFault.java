package com.ykh.tang.agent.message;

/**
 * 25.用户锁定会议失败消息，0x00010054
 *
 * @author xianchao.ji
 */
public class ConfUserLockMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
