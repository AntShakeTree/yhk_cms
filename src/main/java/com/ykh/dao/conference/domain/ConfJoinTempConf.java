package com.ykh.dao.conference.domain;


import com.alibaba.fastjson.JSON;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import com.ykh.tang.agent.vo.RoleInfo;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class ConfJoinTempConf implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer conferenceId;
    private Integer tempConfId;

    private Integer confScale;

    private String conferencename;

    private Date startTime;
    private Date endTime;

    private String billingcode;

    //	private Integer status;			//旧意义：1新建  2 结束；新意义：不使用
    private Integer status;//1，创建状态，2，开启状态，4停止状态，8删除状态
    @Transient
    private boolean needCreate = false;        //用于用户加入时，判断是否需要create conf，只在内存中使用，不需要保存到数据库

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public Integer getTempConfId() {
        return tempConfId;
    }

    public void setTempConfId(Integer tempConfId) {
        this.tempConfId = tempConfId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isNeedCreate() {
        return needCreate;
    }

    public void setNeedCreate(boolean needCreate) {
        this.needCreate = needCreate;
    }

    public Integer getConfScale() {
        return confScale;
    }

    public void setConfScale(Integer confScale) {
        this.confScale = confScale;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public static  class Bulider {
        ConfJoinTempConf confJoinTempConf =new ConfJoinTempConf();
        public Bulider conferenceId(Integer conferenceId){
            confJoinTempConf.setConferenceId(conferenceId);
            return this;
        }
        public   Bulider tempConfId (Integer tempConfId){
            confJoinTempConf.setTempConfId(tempConfId);
            return this;
        }

        public    Bulider confScale (Integer confScale){
            confJoinTempConf.setConfScale(confScale);
            return this;

        }

        public   Bulider conferencename(String conferencename){
            confJoinTempConf.setConferencename(conferencename);
            return this;

        } public   Bulider billingcode(String billingcode){
            confJoinTempConf.setBillingcode(billingcode);
            return this;

        }

        public   Bulider startTime(Date startTime) {
            confJoinTempConf.setStartTime(startTime);
            return this;
        };
        public   Bulider  endTime(Date endTime){
            confJoinTempConf.setEndTime(endTime);
            return this;
        };  public   Bulider  status(Integer status){
            confJoinTempConf.setStatus(status);
            return this;
        };
        public ConfJoinTempConf create(){
            return this.confJoinTempConf;
        }

    }

    public String getBillingcode() {
        return billingcode;
    }

    public void setBillingcode(String billingcode) {
        this.billingcode = billingcode;
    }
}
