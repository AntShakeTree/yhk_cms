package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 35.用户退出黑名单成功消息，0x000100b2
 *
 * @author xianchao.ji
 */
public class UnblackUserMsgResult extends BaseConfMsgResult implements IMessageHandler {
    List<String> userArr; // 操作成功userid 列表

    public List<String> getUserArr() {
        return userArr;
    }

    public void setUserArr(List<String> userArr) {
        this.userArr = userArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
