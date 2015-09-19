package com.ykh.tang.agent.message;

/**
 * 32 //用户退出会议成功消息，0x00010082
 *
 * @author xianchao.ji
 */
public class UserExitConfMsgResult extends BaseConfMsgResult {
    int userID;  //用户ID

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
