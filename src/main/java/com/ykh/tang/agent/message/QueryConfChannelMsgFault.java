package com.ykh.tang.agent.message;

/**
 * 47.查询会议用户通道失败应答信息，0x00010173
 *
 * @author xianchao.ji
 */
public class QueryConfChannelMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
