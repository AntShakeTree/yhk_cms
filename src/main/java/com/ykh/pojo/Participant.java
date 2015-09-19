package com.ykh.pojo;

/**
 * Participant entity. @author MyEclipse Persistence Tools
 */

public class Participant implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer conferenceid;
    private String name;
    private String phone;
    private String pin;
    private String email;
    private String mobile;
    private Integer valid = 1;
    private String userdefine1;
    private String userdefine2;
    private String userdefine3;
    private String userdefine4;

    // Constructors

    /**
     * default constructor
     */
    public Participant() {
    }

    /**
     * minimal constructor
     */
    public Participant(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public Participant(Integer id, Integer conferenceid, String name,
                       String phone, String pin, String email, String mobile,
                       Integer valid, String userdefine1, String userdefine2,
                       String userdefine3, String userdefine4) {
        this.id = id;
        this.conferenceid = conferenceid;
        this.name = name;
        this.phone = phone;
        this.pin = pin;
        this.email = email;
        this.mobile = mobile;
        this.valid = valid;
        this.userdefine1 = userdefine1;
        this.userdefine2 = userdefine2;
        this.userdefine3 = userdefine3;
        this.userdefine4 = userdefine4;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConferenceid() {
        return this.conferenceid;
    }

    public void setConferenceid(Integer conferenceid) {
        this.conferenceid = conferenceid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getValid() {
        return this.valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getUserdefine1() {
        return this.userdefine1;
    }

    public void setUserdefine1(String userdefine1) {
        this.userdefine1 = userdefine1;
    }

    public String getUserdefine2() {
        return this.userdefine2;
    }

    public void setUserdefine2(String userdefine2) {
        this.userdefine2 = userdefine2;
    }

    public String getUserdefine3() {
        return this.userdefine3;
    }

    public void setUserdefine3(String userdefine3) {
        this.userdefine3 = userdefine3;
    }

    public String getUserdefine4() {
        return this.userdefine4;
    }

    public void setUserdefine4(String userdefine4) {
        this.userdefine4 = userdefine4;
    }

}