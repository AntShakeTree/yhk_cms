package com.ykh.tang.agent.message;

/**
 * 21.会议停止失败应答消息，0x00010024
 *
 * @author xianchao.ji
 */
public class ConfStopMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
