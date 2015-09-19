package com.ykh.tang.agent.message;

import com.ykh.tang.agent.vo.BMSUserInfo;
import com.ykh.tang.agent.vo.UserChannel;


/**
 * 15
 *
 * @author xianchao.ji
 */
public class ConfMsgRec {
    public BMSUserInfo userInfo; //用户信息结构体
    public UserChannel userChannel; //用户通道结构体

    public BMSUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(BMSUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserChannel getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(UserChannel userChannel) {
        this.userChannel = userChannel;
    }
}
