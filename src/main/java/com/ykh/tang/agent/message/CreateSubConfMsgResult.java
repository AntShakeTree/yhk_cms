package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 18.创建子会议成功消息
 *
 * @author xianchao.ji
 */
public class CreateSubConfMsgResult extends BaseConfMsgResult implements IMessageHandler {
    public List<ConfMsgRec> confMsgRecArr;

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
