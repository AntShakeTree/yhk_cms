package com.ykh.services.conference;


import java.util.Date;

/**
 * Cdruserinfo generated by MyEclipse Persistence Tools
 */

public class Conferenceuserinfo implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer tempuserid;
    private Integer tempconferenceid;
    private Date timestamp;
    private String role;
    private Integer status;


    // Constructors

    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    /**
     * default constructor
     */
    public Conferenceuserinfo() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getTempuserid() {
        return tempuserid;
    }


    public void setTempuserid(Integer tempuserid) {
        this.tempuserid = tempuserid;
    }


    public Integer getTempconferenceid() {
        return tempconferenceid;
    }


    public void setTempconferenceid(Integer tempconferenceid) {
        this.tempconferenceid = tempconferenceid;
    }


    public Date getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


}