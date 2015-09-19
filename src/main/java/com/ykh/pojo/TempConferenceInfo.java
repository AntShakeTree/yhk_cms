/**
 * TempConferenceInfo.java
 * com.gnetis.tang.conferencemanagement.pojo
 * <p/>
 * ver           date      		author
 * ──────────────────────────────────———————————
 * tang1.0       May 7, 2009     admin
 * <p/>
 * Copyright (c) 2009,创想空间软件技术(北京)有限公司
 */

package com.ykh.pojo;

import java.io.Serializable;

/**
 * ClassName:TempConferenceInfo
 * <p>
 * ClassDesc：正在进行的会议信息类，正在进行的会议信息存储于内存，动态更新
 *
 * @author admin
 * @version 1.0
 * @since Ver 1.0
 * @Date 2009 May 7, 2009 2:04:33 PM
 */

public class TempConferenceInfo implements Serializable {
    private static final long serialVersionUID = 4520352883830032436L;
    // 预约会议ID
    private Integer conferenceID;
    // 会议临时状态，动态更新 0：未开始；1：已创建未开始；2：已经开始；3：已经结束
    private Integer conferencestatus;
    // 会议临时ID，会议被创建时建立，会议结束销毁
    private Integer tempConferenceID;

    public TempConferenceInfo() {

    }

    public TempConferenceInfo(Integer conferenceID, Integer conferencestatus, Integer tempConferenceID) {

        this.conferenceID = conferenceID;
        this.conferencestatus = conferencestatus;
        this.tempConferenceID = tempConferenceID;
    }

    public int hashCode() {

        int result = 179;
        result = 37 * result + (tempConferenceID == null ? System.identityHashCode(this) : tempConferenceID.hashCode());
        return result;
    }

    public boolean equals(Object o) {

        // 内存地址相同
        if (this == o) {
            return true;
        }

        // 如果传入对象为空
        if (o == null) {
            return false;
        }

        // 传入对象是否User实例
        if (!(o instanceof TempConferenceInfo)) {
            return false;
        }

        // 判断tempConferenceID是否相等，如果相等，则该TempConferenceInfo是同一个TempConferenceInfo
        TempConferenceInfo confinfo = (TempConferenceInfo) o;
        if (this.tempConferenceID.equals(confinfo.tempConferenceID)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * conferencestatus
     *
     * @return the conferencestatus
     */

    public Integer getConferencestatus() {
        return conferencestatus;
    }

    /**
     * conferencestatus
     *
     * @param conferencestatus the conferencestatus to set
     */

    public void setConferencestatus(Integer conferencestatus) {
        this.conferencestatus = conferencestatus;
    }

    /**
     * tempConferenceID
     *
     * @return the tempConferenceID
     */

    public Integer getTempConferenceID() {
        return tempConferenceID;
    }

    /**
     * tempConferenceID
     *
     * @param tempConferenceID the tempConferenceID to set
     */

    public void setTempConferenceID(Integer tempConferenceID) {
        this.tempConferenceID = tempConferenceID;
    }

    /**
     * conferenceID
     *
     * @return the conferenceID
     */

    public Integer getConferenceID() {
        return conferenceID;
    }

    /**
     * conferenceID
     *
     * @param conferenceID the conferenceID to set
     */

    public void setConferenceID(Integer conferenceID) {
        this.conferenceID = conferenceID;
    }

}
