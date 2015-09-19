package com.ykh.tang.agent.message;

import com.ykh.tang.agent.vo.BMSUserInfo;

import java.util.List;

/**
 * 42.查询用户列表成功消息，0x000100f2
 *
 * @author xianchao.ji
 */
public class QueryUserListResult extends BaseConfMsgResult implements IMessageHandler {
    List<BMSUserInfo> userInfoArr; // user对象列表

    public List<BMSUserInfo> getUserInfoArr() {
        return userInfoArr;
    }

    public void setUserInfoArr(List<BMSUserInfo> userInfoArr) {
        this.userInfoArr = userInfoArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
