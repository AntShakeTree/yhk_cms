package com.ykh.common;


import com.maxc.rest.common.ConfigUtil;

/*
 * mxc
 * 
 */
public class Constants {
    //lls config
    public static final String SERVICE_BMS = "0x1";
    public static final String SERVICE_AUDIO = "0x102";
    public static final String SERVICE_VEDIO = "0x103";
    public static final String SERVICE_CHAT = "0x204";
    public static final String SERVICE_QA = "0x205";
    public static final String SERVICE_SURVEY = "0x206";
    public static final String SERVICE_WHITEBOARD = "0x307";
    public static final String SERVICE_DOCSHARE = "0x308";
    public static final String SERVICE_DESKTOP = "0x309";
    public static final Integer site = Integer.parseInt(ConfigUtil.getByKey("site"));
}
