package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 41.改变用户角色失败消息，0x000100d4
 *
 * @author xianchao.ji
 */
public class ChangeUserRoleMsgFault extends BaseConfMsgFault implements IMessageHandler {
    int actionType;// 操作类型（1增加，2删除，3替换）
    List<UserError> userArr; // 操作失败用户错误列表

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public List<UserError> getUserArr() {
        return userArr;
    }

    public void setUserArr(List<UserError> userArr) {
        this.userArr = userArr;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
