package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 32.用户退出子会议失败消息，0x00010094
 *
 * @author xianchao.ji
 */
public class UserExitSubConfMsgFault extends BaseConfMsgFault {
    List<UserError> userErrors; //操作失败用户错误列表

    public List<UserError> getUserErrors() {
        return userErrors;
    }

    public void setUserErrors(List<UserError> userErrors) {
        this.userErrors = userErrors;
    }
}
