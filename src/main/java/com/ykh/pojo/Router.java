package com.ykh.pojo;

import java.util.Date;

public class Router implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String mainCMS;
    private String applicationID;
    private Integer tempconfID;
    private String backCMS;
    private Boolean ifSub;
    private Date createtime;
    private Date updatetime;
    private Long version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainCMS() {
        return mainCMS;
    }

    public void setMainCMS(String mainCMS) {
        this.mainCMS = mainCMS;
    }

    public Integer getTempconfID() {
        return tempconfID;
    }

    public void setTempconfID(Integer tempconfID) {
        this.tempconfID = tempconfID;
    }

    public String getBackCMS() {
        return backCMS;
    }

    public void setBackCMS(String backCMS) {
        this.backCMS = backCMS;
    }

    public Boolean getIfSub() {
        return ifSub;
    }

    public void setIfSub(Boolean ifSub) {
        this.ifSub = ifSub;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }


}
