/**
 * 此类专门为DemoApp开发，以提高其性能。
 */
package com.ykh.pojo;

import java.util.Date;

public class ConferenceVODemoApp {

    private Integer conferenceid;// 会议id
    private String conferencename;// 会议名称
    private Date starttime;// 开始时间
    private Date reservtime;// 预约时间
    private Integer noticetime;// 通知时间
    private Integer status;

    public Integer getConferenceid() {
        return conferenceid;
    }

    public void setConferenceid(Integer conferenceid) {
        this.conferenceid = conferenceid;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getReservtime() {
        return reservtime;
    }

    public void setReservtime(Date reservtime) {
        this.reservtime = reservtime;
    }

    public Integer getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Integer noticetime) {
        this.noticetime = noticetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
