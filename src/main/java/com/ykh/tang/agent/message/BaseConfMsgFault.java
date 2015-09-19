package com.ykh.tang.agent.message;

/**
 * 14.会议失败消息
 *
 * @author xianchao.ji
 */
public class BaseConfMsgFault extends MsgHeader {
    public int confID;// 会议ID
    public int errID; // 错误代码

    public int getConfID() {
        return confID;
    }

    public void setConfID(int confID) {
        this.confID = confID;
    }

    public int getErrID() {
        return errID;
    }

    public void setErrID(int errID) {
        this.errID = errID;
    }


}
