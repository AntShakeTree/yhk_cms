package com.ykh.tang.agent.message;

/**
 * 48.更新会议配置数据成功消息，0x00010182
 *
 * @author xianchao.ji
 */
public class UpdateConfConfigMsgResult extends BaseConfMsgResult implements IMessageHandler {
    private String configData;

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }
}
