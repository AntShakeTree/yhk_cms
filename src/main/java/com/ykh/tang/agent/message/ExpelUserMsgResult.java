package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 38.驱逐用户出会成功消息，0x000100c2
 *
 * @author xianchao.ji
 */
public class ExpelUserMsgResult extends BaseConfMsgResult implements IMessageHandler {
    List<String> userArr; //操作成功userid 列表

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
