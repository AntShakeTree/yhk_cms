package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 46 查询会议用户通道成功应答信息，0x00010172
 *
 * @author xianchao.ji
 */
public class QueryConfChannelMsgResult extends BaseConfMsgResult implements IMessageHandler {
    List<ChannelInfo> channelInfoArr;

    public List<ChannelInfo> getChannelInfoArr() {
        return channelInfoArr;
    }

    public void setChannelInfoArr(List<ChannelInfo> channelInfoArr) {
        this.channelInfoArr = channelInfoArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
