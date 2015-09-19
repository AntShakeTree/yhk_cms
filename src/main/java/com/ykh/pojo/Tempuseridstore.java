package com.ykh.pojo;

/**
 * Tempuseridstore entity. @author MyEclipse Persistence Tools
 */

public class Tempuseridstore implements java.io.Serializable {

    // Fields

    private Integer recordId;
    private Integer tempuserid;

    // Constructors

    /**
     * default constructor
     */
    public Tempuseridstore() {
    }

    /**
     * full constructor
     */
    public Tempuseridstore(Integer tempuserid) {
        this.tempuserid = tempuserid;
    }

    // Property accessors

    public Integer getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getTempuserid() {
        return this.tempuserid;
    }

    public void setTempuserid(Integer tempuserid) {
        this.tempuserid = tempuserid;
    }

}