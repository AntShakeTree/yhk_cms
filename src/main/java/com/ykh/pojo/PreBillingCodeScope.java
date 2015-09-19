package com.ykh.pojo;

import java.util.Date;

public class PreBillingCodeScope implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cms;
    private Integer minid;
    private Integer maxid;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCms() {
        return cms;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public Integer getMinid() {
        return minid;
    }

    public void setMinid(Integer minid) {
        this.minid = minid;
    }

    public Integer getMaxid() {
        return maxid;
    }

    public void setMaxid(Integer maxid) {
        this.maxid = maxid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
