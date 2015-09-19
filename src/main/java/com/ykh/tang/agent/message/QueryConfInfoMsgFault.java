package com.ykh.tang.agent.message;

/**
 * 45 查询会议信息失败消息，0x00010104
 *
 * @author xianchao.ji
 */
public class QueryConfInfoMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
