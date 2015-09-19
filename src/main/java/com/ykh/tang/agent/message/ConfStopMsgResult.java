package com.ykh.tang.agent.message;

/**
 * 20.会议停止成功消息，0x00010022
 *
 * @author xianchao.ji
 */
public class ConfStopMsgResult extends BaseConfMsgResult implements IMessageHandler {
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
