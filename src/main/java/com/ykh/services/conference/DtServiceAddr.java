package com.ykh.services.conference;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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
