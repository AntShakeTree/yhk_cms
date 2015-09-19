package com.ykh.tang.agent.message;

/**
 * 44 查询会议信息成功消息，0x00010102
 *
 * @author xianchao.ji
 */
public class QueryConfInfoMsgResult extends BaseConfMsgResult implements IMessageHandler {
    ConferenceInfo confInfo;// 会议信息结构体
    int status; // 会议状态，,低1位表示会议是否开启0/1
    // 会议状态，,会议系统是否锁定
    // 会议状态，会议用户是否锁定0/1
    String desc;// 会议描述
    String configData;// 会议配置数据
    int holdTime;// 会议剩下时间

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }

    public ConferenceInfo getConfInfo() {
        return confInfo;
    }

    public void setConfInfo(Object confInfo) {
        this.confInfo = (ConferenceInfo) confInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(int holdTime) {
        this.holdTime = holdTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }
}
