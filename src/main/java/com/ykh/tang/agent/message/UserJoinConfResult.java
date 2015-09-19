package com.ykh.tang.agent.message;

/**
 * 30.用户入会通知，0x00010152
 *
 * @author xianchao.ji
 */
public class UserJoinConfResult extends BaseConfMsgResult implements IMessageHandler {

    private JoinUserInfo userInfo; // 扩展用户信息结构体（BMSUserInfo），增加入会议序号

    public Object getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = (JoinUserInfo) userInfo;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
