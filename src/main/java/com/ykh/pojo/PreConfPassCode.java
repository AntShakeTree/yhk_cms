package com.ykh.pojo;

import java.util.Date;

public class PreConfPassCode implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String PassCode;
    private Integer length;
    private Boolean useFlag;
    private String useResv;
    private Date cycleTime;
    private Long version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassCode() {
        return PassCode;
    }

    public void setPassCode(String passCode) {
        PassCode = passCode;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public String getUseResv() {
        return useResv;
    }

    public void setUseResv(String useResv) {
        this.useResv = useResv;
    }

    public Date getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(Date cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


}
