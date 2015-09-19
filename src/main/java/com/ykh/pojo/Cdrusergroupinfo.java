package com.ykh.pojo;

import java.util.Date;

public class Cdrusergroupinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer conferenceid;
    private Integer userid;
    private Integer groupid;
    private Integer servicetype;
    private Integer actiontypeid;
    private Integer msgtimestamp;
    private Date receivetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConferenceid() {
        return conferenceid;
    }

    public void setConferenceid(Integer conferenceid) {
        this.conferenceid = conferenceid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getServicetype() {
        return servicetype;
    }

    public void setServicetype(Integer servicetype) {
        this.servicetype = servicetype;
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public Integer getActiontypeid() {
        return actiontypeid;
    }

    public void setActiontypeid(Integer actiontypeid) {
        this.actiontypeid = actiontypeid;
    }

    public Integer getMsgtimestamp() {
        return msgtimestamp;
    }

    public void setMsgtimestamp(Integer msgtimestamp) {
        this.msgtimestamp = msgtimestamp;
    }

}
