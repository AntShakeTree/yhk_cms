package com.ykh.tang.agent.message;

/**
 * 5 from chao.li
 *
 * @author xianchao.ji
 */
public class ChannelAndUserInfo {
    UserInfo userInfo;
    ChannelInfo channelInfo;

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = (UserInfo) userInfo;
    }

    public Object getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(Object channelInfo) {
        this.channelInfo = (ChannelInfo) channelInfo;
    }
}
