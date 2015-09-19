package com.ykh.tang.agent.message;

/**
 * 13.会议成功消息
 *
 * @author xianchao.ji
 */
public class BaseConfMsgResult extends MsgHeader {
    public int confID; // 会议ID

    public int getConfID() {
        return confID;
    }

    public void setConfID(int confID) {
        this.confID = confID;
    }

}
