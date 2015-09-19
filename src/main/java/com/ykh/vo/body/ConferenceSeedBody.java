package com.ykh.vo.body;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class ConferenceSeedBody {
    private Integer tempConferenceId;
    private Integer applicationId;
    private String conferencename;
    private Integer conferenceId;

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public Integer getTempConferenceId() {
        return tempConferenceId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public void setTempConferenceId(Integer tempConferenceId) {
        this.tempConferenceId = tempConferenceId;
    }
}
