package com.ykh.tang.agent.message;

import java.util.ArrayList;
import java.util.List;

/**
 * 40.改变用户角色成功消息，0x000100d2
 *
 * @author xianchao.ji
 */
public class ChangeUserRoleMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int userID; // 操作者ID
    int type;// 操作类型（1增加，2删除，3替换）
    List<String> userArr = new ArrayList<String>(); // 操作成功userid 列表
    List<String> roleArr = new ArrayList<String>(); // 操作成功roleid 列表

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getUserArr() {
        return userArr;
    }

    public void setUserArr(List<String> userArr) {
        this.userArr = userArr;
    }

    public List<String> getRoleArr() {
        return roleArr;
    }

    public void setRoleArr(List<String> roleArr) {
        this.roleArr = roleArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
