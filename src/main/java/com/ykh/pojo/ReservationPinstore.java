package com.ykh.pojo;

/**
 * ReservationPinstore entity. @author MyEclipse Persistence Tools
 */

public class ReservationPinstore implements java.io.Serializable {

    // Fields

    private Long recordId;
    private Integer pin;

    // Constructors

    /**
     * default constructor
     */
    public ReservationPinstore() {
    }

    /**
     * full constructor
     */
    public ReservationPinstore(Integer pin) {
        this.pin = pin;
    }

    // Property accessors

    public Long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getPin() {
        return this.pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

}