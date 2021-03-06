package com.ykh.pojo;

import java.util.Date;

/**
 * Cdrconferernceinfo generated by MyEclipse Persistence Tools
 */

public class Cdrconferenceinfo implements java.io.Serializable {

    // Fields

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer tempconferenceid;
    private Integer conferenceid;
    private Date createtime;
    private Date starttime;
    private Date endtime;
    private String billingcode;
    private Date reservtime;

    private String conferencename;
    private String conferencedesc;
    private Integer creator;
    private Integer modifier;
    private Date modifytime;
    private Integer duration;
    private Integer parties;

    // Constructors

    /**
     * default constructor
     */
    public Cdrconferenceinfo() {
    }

    // part constructor
    public Cdrconferenceinfo(Integer conferenceid, String billingcode, Date reservtime) {
        this.conferenceid = conferenceid;
        this.billingcode = billingcode;
        this.reservtime = reservtime;
    }

    /**
     * full constructor
     */
    public Cdrconferenceinfo(Integer tempconferenceid, Integer conferenceid, Date createtime, Date starttime, Date endtime, String billingcode,
                             Date reservtime) {
        this.tempconferenceid = tempconferenceid;
        this.conferenceid = conferenceid;
        this.createtime = createtime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.billingcode = billingcode;
        this.reservtime = reservtime;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempconferenceid() {
        return this.tempconferenceid;
    }

    public void setTempconferenceid(Integer tempconferenceid) {
        this.tempconferenceid = tempconferenceid;
    }

    public Integer getConferenceid() {
        return this.conferenceid;
    }

    public void setConferenceid(Integer conferenceid) {
        this.conferenceid = conferenceid;
    }

    public Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getBillingcode() {
        return this.billingcode;
    }

    public void setBillingcode(String billingcode) {
        this.billingcode = billingcode;
    }

    /**
     * createtime
     *
     * @return the createtime
     */

    public Date getCreatetime() {
        return createtime;
    }

    /**
     * createtime
     *
     * @param createtime the createtime to set
     */

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * reservtime
     *
     * @return the reservtime
     */

    public Date getReservtime() {
        return reservtime;
    }

    /**
     * reservtime
     *
     * @param reservtime the reservtime to set
     */

    public void setReservtime(Date reservtime) {
        this.reservtime = reservtime;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public String getConferencedesc() {
        return conferencedesc;
    }

    public void setConferencedesc(String conferencedesc) {
        this.conferencedesc = conferencedesc;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getParties() {
        return parties;
    }

    public void setParties(Integer parties) {
        this.parties = parties;
    }

}