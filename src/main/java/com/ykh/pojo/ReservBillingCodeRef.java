package com.ykh.pojo;

/**
 * ReservBillingCodeRef entity. @author MyEclipse Persistence Tools
 */

public class ReservBillingCodeRef implements java.io.Serializable {

    // Fields

    private Long recordId;
    private String billingCode;
    private String subbillingCode;
    private String applicationId;
    private String userId;
    private Integer status;    //0 , 1  正在预约boss，2  预约完成。

    // Constructors

    /**
     * default constructor
     */
    public ReservBillingCodeRef() {
    }

    /**
     * full constructor
     */
    public ReservBillingCodeRef(String billingCode, String subbillingCode,
                                String applicationId) {
        this.billingCode = billingCode;
        this.subbillingCode = subbillingCode;
        this.applicationId = applicationId;
    }

    // Property accessors

    public Long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getBillingCode() {
        return this.billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getSubbillingCode() {
        return this.subbillingCode;
    }

    public void setSubbillingCode(String subbillingCode) {
        this.subbillingCode = subbillingCode;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}