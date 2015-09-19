package com.ykh.tang.agent.message;

/**
 * 51.更新会议描述失败消息，0x00010194
 *
 * @author xianchao.ji
 */
public class UpdateConfDesMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
