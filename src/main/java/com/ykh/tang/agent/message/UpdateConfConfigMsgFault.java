package com.ykh.tang.agent.message;

/**
 * 49.更新会议配置数据失败消息，0x00010184
 *
 * @author xianchao.ji
 */
public class UpdateConfConfigMsgFault extends BaseConfMsgFault implements IMessageHandler {
    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
