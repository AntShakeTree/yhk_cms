package com.ykh.tang.agent.message;

import java.util.List;

/**
 * 10 from chao.li
 *
 * @author xianchao.ji
 */
public class ConferenceInfo {
    int confID;
    Time0 planStartTime;
    Time0 planStopTime;
    int confScale;
    List<String> roleInfoArr;
    List<String> configArr;
    SubConfInfo subConfInfo;

    public int getConfID() {
        return confID;
    }

    public void setConfID(int confID) {
        this.confID = confID;
    }

    public Object getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Object planStartTime) {
        this.planStartTime = (Time0) planStartTime;
    }

    public Object getPlanStopTime() {
        return planStopTime;
    }

    public void setPlanStopTime(Object planStopTime) {
        this.planStopTime = (Time0) planStopTime;
    }

    public int getConfScale() {
        return confScale;
    }

    public void setConfScale(int confScale) {
        this.confScale = confScale;
    }

    public List<String> getRoleInfoArr() {
        return roleInfoArr;
    }

    public void setRoleInfoArr(List<String> roleInfoArr) {
        this.roleInfoArr = roleInfoArr;
    }

    public List<String> getConfigArr() {
        return configArr;
    }

    public void setConfigArr(List<String> configArr) {
        this.configArr = configArr;
    }

    public Object getSubConfInfo() {
        return subConfInfo;
    }

    public void setSubConfInfo(Object subConfInfo) {
        this.subConfInfo = (SubConfInfo) subConfInfo;
    }
}
