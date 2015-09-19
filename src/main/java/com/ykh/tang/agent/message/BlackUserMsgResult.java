package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 34.用户加入黑名单成功消息，0x000100a2
 *
 * @author xianchao.ji
 */
public class BlackUserMsgResult extends BaseConfMsgResult implements IMessageHandler {
    List<String> userArr; //操作成功userid 列表

    public List<String> getUserArr() {
        return userArr;
    }

    public void setUserArr(List<String> users) {
        this.userArr = users;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
