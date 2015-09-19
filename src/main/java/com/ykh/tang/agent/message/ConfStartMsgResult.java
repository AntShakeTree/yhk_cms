package com.ykh.tang.agent.message;

/**
 * 62.下发会议开始消息， 0x00010132
 *
 * @author xianchao.ji
 */
public class ConfStartMsgResult extends BaseConfMsgResult implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
