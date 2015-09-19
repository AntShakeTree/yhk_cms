/**
 * *****************************************************************
 * Copyright (c) 2006-2009 G-Net
 * All rights reserved.
 * G-Net Integrated Services co. Ltd.
 * *******************************************************************
 *
 * @(#)ServiceAddr.java 1.0 2009-07-06
 * @author Dongyu Zhang
 * @date 2009-07-06 13:25:38
 * @version 0.1.1
 * @warning
 * @par 需求: REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
 */

package com.ykh.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * ServiceAddr
 *
 * @version 0.0.1
 * @author Dongyu Zhang
 *
 * Revision History
 * @if CR/PR ID Author Date Major Change
 * @endif
 * @bug CR0001 Dongyu Zhang Sept. 20 2008 create version 0.0.1\n PR0001 Dongyu
 *      Zhang Sept. 20 2008 create version 0.0.2\n PR0002 Dongyu Zhang Sept. 20
 *      2008 create version 0.1.1\n
 *
 * @see SomeClass
 */
@XmlRootElement
public class DtServiceAddr implements Serializable {
    private static final long serialVersionUID = 1502925242464504634L;

    private String transportip;

    private Integer channelID; // channel

    private Integer type;

    private Integer groupID;

    public DtServiceAddr(String transportip, Integer channelID, Integer type, Integer groupID) {

        this.transportip = transportip;
        this.channelID = channelID;
        this.type = type;
        this.groupID = groupID;
    }

    /**
     * transportip
     *
     * @return the transportip
     */

    public String getTransportip() {
        return transportip;
    }

    /**
     * transportip
     *
     * @param transportip the transportip to set
     */

    public void setTransportip(String transportip) {
        this.transportip = transportip;
    }

    /**
     * channelID
     *
     * @return the channelID
     */

    public Integer getChannelID() {
        return channelID;
    }

    /**
     * channelID
     *
     * @param channelID the channelID to set
     */

    public void setChannelID(Integer channelID) {
        this.channelID = channelID;
    }

    /**
     * type
     *
     * @return the type
     */

    public Integer getType() {
        return type;
    }

    /**
     * type
     *
     * @param type the type to set
     */

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * groupID
     *
     * @return the groupID
     */

    public Integer getGroupID() {
        return groupID;
    }

    /**
     * groupID
     *
     * @param groupID the groupID to set
     */

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

}
