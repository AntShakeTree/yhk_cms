package com.ykh.tang.agent.message;

/**
 * 31.用户退会失败消息，0x00010084
 *
 * @author xianchao.ji
 */
public class UserExitConfMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
