package com.ykh.services.conference;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement
public class CtServiceAddr implements Serializable {
    private static final long serialVersionUID = -8154315532230981733L;

    private String accessip; // serverIP

    private String bakassessip;//备份ip

    private Integer channelID; // channel

    private Integer type;

    private Integer groupID;

    public CtServiceAddr(String accessip, String bakassessip, Integer channelID, Integer type, Integer groupID) {

        this.accessip = accessip;
        this.bakassessip = bakassessip;
        this.channelID = channelID;
        this.type = type;
        this.groupID = groupID;
    }

    /**
     * accessip
     *
     * @return the accessip
     */

    public String getAccessip() {
        return accessip;
    }

    /**
     * accessip
     *
     * @param accessip the accessip to set
     */

    public void setAccessip(String accessip) {
        this.accessip = accessip;
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

    public String getBakassessip() {
        return bakassessip;
    }

    public void setBakassessip(String bakassessip) {
        this.bakassessip = bakassessip;
    }

}
