package com.ykh.tang.agent.message;

/**
 * 16
 *
 * @author xianchao.ji
 */
public class UserError {
    int userID; //用户ID
    int errorID;//错误值

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getErrorID() {
        return errorID;
    }

    public void setErrorID(int errorID) {
        this.errorID = errorID;
    }
}
