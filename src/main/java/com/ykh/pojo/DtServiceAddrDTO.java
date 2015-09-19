/**
 * **********************************************
 * Copyright (c) 2010-2012 G-Net All rights
 * reserved. G-Net Integrated Services co. Ltd.
 * *******************************************************************
 *
 * @(#)DtServiceAddrDTO.java 1.0 2010-11-10
 * @author ming.li
 * @date 2010-11-10 13:40:36
 * @version 0.1.1
 * @warning
 * @par 需求: REQ1.10[Tang]:
 * svn://vobserver/tang/doc/SRS.doc
 */
package com.ykh.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * DTS信息传输类
 * @author ming.li
 */
@XmlRootElement
public class DtServiceAddrDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 传输IP
     */
    private String transportip;
    /**
     * channel
     */
    private Long channelID;
    /**
     * 传输类型
     */
    private Long type;
    /**
     * 通道组ID
     */
    private Long groupID;

    public String getTransportip() {
        return transportip;
    }

    public void setTransportip(String transportip) {
        this.transportip = transportip;
    }

    public Long getChannelID() {
        return channelID;
    }

    public void setChannelID(Long channelID) {
        this.channelID = channelID;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }


}
