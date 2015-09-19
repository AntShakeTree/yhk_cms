package com.ykh.tang.agent.vo;

import java.util.List;

public class ConferenceInfoBMS {
    private int confID = 0;
    private String name = "";
    private String billingCode = "";
    private String password = "";
    private int planStartTime0 = 0;
    private int planStartTime1 = 0;
    private int planStopTime0 = 0;
    private int planStopTime1 = 0;
    private int confScale = 0;
    private SubConferenceInfo subConference = null;
    private List<RoleInfo> roleInfo = null;
    private List<String> serviceConfigs = null;
    private AutoStopParams stopParams = null;
    private int status; //1：创建 2：开始 3：结束

    public int getConfID() {
        return confID;
    }

    public void setConfID(int confID) {
        this.confID = confID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConfScale() {
        return confScale;
    }

    public void setConfScale(int confScale) {
        this.confScale = confScale;
    }

    public List<RoleInfo> getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(List<RoleInfo> roleInfo) {
        this.roleInfo = roleInfo;
    }

    public List<String> getServiceConfigs() {
        return serviceConfigs;
    }

    public void setServiceConfigs(List<String> serviceConfigs) {
        this.serviceConfigs = serviceConfigs;
    }

    public Object getSubConference() {
        return subConference;
    }

    public void setSubConference(Object subConference) {
        this.subConference = (SubConferenceInfo) subConference;
    }

    public int getPlanStartTime0() {
        return planStartTime0;
    }

    public void setPlanStartTime0(int planStartTime0) {
        this.planStartTime0 = planStartTime0;
    }

    public int getPlanStartTime1() {
        return planStartTime1;
    }

    public void setPlanStartTime1(int planStartTime1) {
        this.planStartTime1 = planStartTime1;
    }

    public int getPlanStopTime0() {
        return planStopTime0;
    }

    public void setPlanStopTime0(int planStopTime0) {
        this.planStopTime0 = planStopTime0;
    }

    public int getPlanStopTime1() {
        return planStopTime1;
    }

    public void setPlanStopTime1(int planStopTime1) {
        this.planStopTime1 = planStopTime1;
    }

    public void setStopParams(AutoStopParams stopParams) {
        this.stopParams = stopParams;
    }

    public Object getStopParams() {
        return this.stopParams;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public void setSubConference(SubConferenceInfo subConference) {
        this.subConference = subConference;
    }
}
