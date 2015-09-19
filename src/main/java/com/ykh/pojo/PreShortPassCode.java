package com.ykh.pojo;

import java.util.Date;

/**
 * PreShortPassCode entity. @author MyEclipse Persistence Tools
 */

public class PreShortPassCode implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String passCode;
    private Integer length;
    private Boolean useFlag;
    private String useResv;
    private Date cycleTime;
    private Long version;

    // Constructors

    /**
     * default constructor
     */
    public PreShortPassCode() {
    }

    /**
     * minimal constructor
     */
    public PreShortPassCode(Date cycleTime) {
        this.cycleTime = cycleTime;
    }

    /**
     * full constructor
     */
    public PreShortPassCode(String passCode, Integer length, Boolean useFlag,
                            String useResv, Date cycleTime, Long version) {
        this.passCode = passCode;
        this.length = length;
        this.useFlag = useFlag;
        this.useResv = useResv;
        this.cycleTime = cycleTime;
        this.version = version;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassCode() {
        return this.passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getUseFlag() {
        return this.useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public String getUseResv() {
        return this.useResv;
    }

    public void setUseResv(String useResv) {
        this.useResv = useResv;
    }

    public Date getCycleTime() {
        return this.cycleTime;
    }

    public void setCycleTime(Date cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
