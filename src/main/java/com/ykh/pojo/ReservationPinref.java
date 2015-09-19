package com.ykh.pojo;

/**
 * ReservationPinref entity. @author MyEclipse Persistence Tools
 */

public class ReservationPinref implements java.io.Serializable {

    // Fields

    private Long recordId;
    private String billingCode;
    private Integer pin;

    // Constructors

    /**
     * default constructor
     */
    public ReservationPinref() {
    }

    /**
     * full constructor
     */
    public ReservationPinref(String billingCode, Integer pin) {
        this.billingCode = billingCode;
        this.pin = pin;
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

    public Integer getPin() {
        return this.pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

}