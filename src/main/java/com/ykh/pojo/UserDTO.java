/**
 * Copyright (c) 2009-2010 GNET
 * <p/>
 * Licensed under the Tang License, Version 1.0 (the "License");
 * <p/>
 * $Id: UserDTO.java 613 2010-10-25 ming.li $
 */
package com.ykh.pojo;

import com.google.common.collect.Lists;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 用户数据传输类
 * @author ming.li
 */
@XmlRootElement
public class UserDTO implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 序号
     */
    private Integer seqNo;
    /**
     * 会议中用户ID
     */
    private Integer tempuserid;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 客户端类型
     */
    private Integer clientType;
    /**
     * Pin code
     */
    private Integer pinCode;
    /**
     * 域
     */
    private Integer domain;
    /**
     * Ip地址
     */
    private String ipaddr;
    /**
     * 是否是主持人
     */
    private Boolean isowner;
    /**
     * 用户状态
     */
    private Integer userStatus;
    /**
     * 角色列表
     */
    private List<String> rolemap = Lists.newArrayList();

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getTempuserid() {
        return tempuserid;
    }

    public void setTempuserid(Integer tempuserid) {
        this.tempuserid = tempuserid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public Boolean getIsowner() {
        return isowner;
    }

    public void setIsowner(Boolean isowner) {
        this.isowner = isowner;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public List<String> getRolemap() {
        return rolemap;
    }

    public void setRolemap(List<String> rolemap) {
        this.rolemap = rolemap;
    }
}
