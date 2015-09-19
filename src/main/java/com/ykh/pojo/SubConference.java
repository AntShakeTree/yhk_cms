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
 * SubConferenceInfo
 * <p>
 * ClassDesc：子会议信息类 ，动态更新
 *
 * @author admin
 * @version 1.0
 * @since Ver 1.0
 * @Date 2009 May 7, 2009 2:04:33 PM
 */

public class SubConference implements Serializable {
    private static final long serialVersionUID = 4199063158377678649L;

    // 子会议ID
    private Integer subconferenceID;

    // 子会议名称
    private String subConfName;

    public SubConference() {

    }

    public SubConference(Integer subconferenceID, String subConfName) {

        this.subconferenceID = subconferenceID;
        this.subConfName = subConfName;
    }

    public int hashCode() {

        int result = 179;
        result = 37 * result + (subconferenceID == null ? System.identityHashCode(this) : subconferenceID.hashCode());
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

        // 传入对象是否SubConferenceInfo实例
        if (!(o instanceof SubConference)) {
            return false;
        }

        // 判断subconferenceID是否相等，如果相等，则是同一个子会议
        SubConference subconfinfo = (SubConference) o;
        if (this.subconferenceID.equals(subconfinfo.subconferenceID)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * subconferenceID
     *
     * @return the subconferenceID
     */

    public Integer getSubconferenceID() {
        return subconferenceID;
    }

    /**
     * subconferenceID
     *
     * @param subconferenceID the subconferenceID to set
     */

    public void setSubconferenceID(Integer subconferenceID) {
        this.subconferenceID = subconferenceID;
    }

    /**
     * subConfName
     *
     * @return the subConfName
     */

    public String getSubConfName() {
        return subConfName;
    }

    /**
     * subConfName
     *
     * @param subConfName the subConfName to set
     */

    public void setSubConfName(String subConfName) {
        this.subConfName = subConfName;
    }

}
