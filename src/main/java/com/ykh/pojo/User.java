/**
 * User.java
 * com.gnetis.tang.conferencemanagement.pojo
 * <p/>
 * ver           date      		author
 * ──────────────────────────────────———————————
 * tang1.0       May 5, 2009     admin
 * <p/>
 * Copyright (c) 2009,创想空间软件技术(北京)有限公司
 */

package com.ykh.pojo;

import com.google.common.collect.Lists;

import javax.persistence.Transient;
import java.util.List;

/**
 * ClassName:User
 * <p>
 * ClassDesc：临时缓存用户对象，主要为实现用户列表
 *
 * @author admin
 * @version 1.0
 * @since Ver 1.0
 * @Date 2009 May 5, 2009 5:48:23 PM
 */

public class User implements java.io.Serializable {
    // Fields

    private static final long serialVersionUID = 1L;
    private Integer seqNo;
    private Integer tempuserid;
    private String username;
    private Integer clientType;
    private Integer pinCode;

    private Integer domain;
    private String ipaddr;
    private Boolean isowner;
    private Integer userStatus;
    @Transient
    private Integer conferenceId;
    private Integer tempConferenceId;
    private List<String> rolemap = Lists.newArrayList();

    // Constructors

    /** default constructor */
    public User() {
    }

    /** full constructor */
    public User(Integer tempuserid, String userName, Integer clientType, Integer pinCode, Integer domain, String ipaddr, Boolean isowner, Integer userStatus,
                List<String> rolemap) {
        this.tempuserid = tempuserid;
        this.username = userName;
        this.clientType = clientType;
        this.pinCode = pinCode;
        this.domain = domain;
        this.ipaddr = ipaddr;
        this.isowner = isowner;
        this.userStatus = userStatus;
        this.rolemap = rolemap;
    }

    public int hashCode() {

        int result = 179;
        result = 37 * result + (tempuserid == null ? System.identityHashCode(this) : tempuserid.hashCode());
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
        if (!(o instanceof User)) {
            return false;
        }

        // 判断tempuserid是否相等，如果相等，则该user是同一个user
        User user = (User) o;
        if (this.tempuserid.equals(user.tempuserid)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clientType
     *
     * @return the clientType
     * @since CodingExample Ver 1.0
     */

    public Integer getClientType() {
        return clientType;
    }

    /**
     * clientType
     *
     * @param clientType the clientType to set
     * @since Ver 1.0
     */

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }


    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public List<String> getRolemap() {
        return rolemap;
    }

    public void setRolemap(List<String> rolemap) {
        this.rolemap = rolemap;
    }

    public Integer getTempuserid() {
        return this.tempuserid;
    }

    public void setTempuserid(Integer tempuserid) {
        this.tempuserid = tempuserid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * isowner
     *
     * @return the isowner
     */

    public Boolean getIsowner() {
        return isowner;
    }

    /**
     * isowner
     *
     * @param isowner the isowner to set
     */

    public void setIsowner(Boolean isowner) {
        this.isowner = isowner;
    }

    /**
     * ipaddr
     *
     * @return the ipaddr
     */

    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * ipaddr
     *
     * @param ipaddr the ipaddr to set
     */

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /**
     * userStatus
     *
     * @return the userStatus
     */

    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * userStatus
     *
     * @param userStatus the userStatus to set
     */

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer v) {
        seqNo = v;
    }


    public Integer getTempConferenceId() {
        return tempConferenceId;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public void setTempConferenceId(Integer tempConferenceId) {
        this.tempConferenceId = tempConferenceId;
    }
}
