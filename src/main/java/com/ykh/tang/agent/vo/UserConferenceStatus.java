package com.ykh.tang.agent.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * （用户会议状态）
 *
 * @author xianchao.ji
 */
@XmlRootElement
public class UserConferenceStatus {
    public int confID;// 会议ID
    public int userID;// 用户ID
    public int isOnline;// 是否在线
    public int isBlack;// 是否被黑

    public int getConfID() {
        return confID;
    }

    public void setConfID(int confID) {
        this.confID = confID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public int getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(int isBlack) {
        this.isBlack = isBlack;
    }

}
