package com.ykh.pojo;

import java.util.Date;

public class ConferenceSite implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer tempConfId;
    private Integer site;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempConfId() {
        return tempConfId;
    }

    public void setTempConfId(Integer tempConfId) {
        this.tempConfId = tempConfId;
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

}
