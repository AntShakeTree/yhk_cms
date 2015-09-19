package com.ykh.pojo;

public class ConfJoinTempConf implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer confID;
    private Integer tempConfID;
    private Integer status;            //旧意义：1新建  2 结束；新意义：不使用
    private Integer bmsStatus;        //旧意义：0新建  1 会议已创建	3会议已开始；新意义：0新建,  1 会议已创建, 2会议已开始, 3已结束，4 未找到
    private boolean needCreate = false;        //用于用户加入时，判断是否需要create conf，只在内存中使用，不需要保存到数据库

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfID() {
        return confID;
    }

    public void setConfID(Integer confID) {
        this.confID = confID;
    }

    public Integer getTempConfID() {
        return tempConfID;
    }

    public void setTempConfID(Integer tempConfID) {
        this.tempConfID = tempConfID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBmsStatus() {
        return bmsStatus;
    }

    public void setBmsStatus(Integer bmsStatus) {
        this.bmsStatus = bmsStatus;
    }

    public boolean isNeedCreate() {
        return needCreate;
    }

    public void setNeedCreate(boolean needCreate) {
        this.needCreate = needCreate;
    }

}
