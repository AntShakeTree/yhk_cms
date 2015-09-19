package com.ykh.tang.agent.vo;

/**
 * @author xianchao.ji
 *         <p/>
 *         （会议中用户信息结构体）
 */
public class BMSUserInfoNotify extends BMSUserInfo {
    public Integer userNo;// 用户入会序号

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }
}
