package com.ykh.tang.agent.message;

/**
 * 60.用户自定义消息失败，0x00010164
 *
 * @author xianchao.ji
 */
public class UserDefineMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
