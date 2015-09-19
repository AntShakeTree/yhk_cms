package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 28.用户加入子会议成功消息，0x00010072
 *
 * @author xianchao.ji
 */
public class UserJoinSubConfMsgResult extends BaseConfMsgResult implements IMessageHandler {
    List<ConfMsgRec> confMsgRecArr;

    public List<ConfMsgRec> getConfMsgRecArr() {
        return confMsgRecArr;
    }

    public void setConfMsgRecArr(List<ConfMsgRec> confMsgRecArr) {
        this.confMsgRecArr = confMsgRecArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
