package com.ykh.tang.agent.message;

/**
 * 43.查询用户列表失败消息，0x000100f4
 *
 * @author xianchao.ji
 */
public class QueryUserListFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
