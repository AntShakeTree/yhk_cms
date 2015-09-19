package com.ykh.tang.agent.vo;

public class BMSConferenceInfo {
    // 0：未开始；1：已创建未开始；2：已经开始；3：已经结束
    public int confStatus;

    public int getConfStatus() {
        return confStatus;
    }

    public void setConfStatus(int confStatus) {
        this.confStatus = confStatus;
    }
}
