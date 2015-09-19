/**
 * **********************************************
 * Copyright (c) 2010-2012 G-Net All rights
 * reserved. G-Net Integrated Services co. Ltd.
 * *******************************************************************
 *
 * @(#)CtServiceAddrDTO.java 1.0 2010-11-10
 * @author ming.li
 * @date 2010-11-10 13:40:36
 * @version 0.1.1
 * @warning
 * @par 需求: REQ1.10[Tang]:
 * svn://vobserver/tang/doc/SRS.doc
 */
package com.ykh.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * CTS信息传输类
 * @author ming.li
 */
@XmlRootElement
public class CtServiceAddrDTO {
    /**
     * serverIP
     */
    private String accessip;
    /**
     * 备份ip
     */
    private String bakassessip;
    /**
     * channel ID
     */
    private Integer channelID;
    /**
     * 服务类型
     */
    private Integer type;
    /**
     * 通道组ID
     */
    private Integer groupID;

    public String getAccessip() {
        return accessip;
    }

    public void setAccessip(String accessip) {
        this.accessip = accessip;
    }

    public String getBakassessip() {
        return bakassessip;
    }

    public void setBakassessip(String bakassessip) {
        this.bakassessip = bakassessip;
    }

    public Integer getChannelID() {
        return channelID;
    }

    public void setChannelID(Integer channelID) {
        this.channelID = channelID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }


}
