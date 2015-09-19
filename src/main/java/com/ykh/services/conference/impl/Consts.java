package com.ykh.services.conference.impl;

import com.maxc.rest.common.ConfigUtil;

public class Consts {

    //用户动作类型id
    public static int JOIN = 1;//加入
    public static int ONLINE = 2;//上线
    public static int OFFLINE = 3;//下线
    public static int EXIT = 4;//退会

    // 客户端类型
    public static int CLIENT_TYPE_UNKNOWN = 0;// 未知类型
    public static int CLIENT_TYPE_FLASH = 1;// Flash客户端
    public static int CLIENT_TYPE_CLIENT = 2;// C客户端
    public static int CLIENT_TYPE_PSTN = 3;// PSTN类型
    public static int CLIENT_TYPE_BROWER = 4;// 浏览器类型

    // 用户状态信息
    public static final int USER_NORMAL_OFFLINE = 0;//用户正常不在线
    public static final int USER_NORMAL_ONLINE = 1;//用户正常在线
    public static final int USER_BLACKED_OFFLINE = 2;//用户被黑不在线
    public static final int USER_BLACKED_ONLINE = 3;//用户被黑在线

    // 属性文件路径
    public static final String FILEPATH = "/messagetype.properties";

    public static final Integer UNSTART = 0;// 会议未开始
    public static final Integer CREATED = 1;// 会议已经创建，未开始
    public static final Integer STARTED = 2;// 会议已经开始
    public static final Integer STOPPED = 3;// 会议已经结束，主要用于临时会议

    // 消息版本号
    public static final Integer VERSION = 0x00010000;

    // 自定义会议删除信息
    public static final int BMS_CONF_DEL_NOTIFY = 10;// /<会议删除成功
    // message_type类型定义
    public static final int BMS_CONF_USER_JOIN_NOTIFY = 0x00010152;// /<用户加入主会议
    public static final int BMS_SUB_CONF_CREATE = 0x00010011;// /<创建子会议
    public static final int BMS_SUB_CONF_CREATE_NOTIFY = 0x00010012;// /<创建子会议成功
    public static final int BMS_SUB_CONF_CREATE_ERR_NOTIFY = 0x00010014;// /<创建子会议失败
    public static final int BMS_CONF_STOP = 0x00010021;// /<会议关闭
    public static final int BMS_CONF_STOP_NOTIFY = 0x00010022;// /<会议关闭成功
    public static final int BMS_CONF_STOP_ERR_NOTIFY = 0x00010024;// /<会议关闭失败
    public static final int BMS_CONF_SYS_LOCK_NOTIFY = 0x00010030;// /<会议系统锁定
    public static final int BMS_CONF_SYS_UNLOCK_NOTIFY = 0x00010040;// /<会议系统解锁定
    public static final int BMS_CONF_USER_LOCK = 0x00010051;// /<用户锁定
    public static final int BMS_CONF_USER_LOCK_NOTIFY = 0x00010052;// /<用户锁定成功
    public static final int BMS_CONF_USER_LOCK_ERR_NOTIFY = 0x00010054;// /<用户锁定失败
    public static final int BMS_CONF_USER_UNLOCK = 0x00010061;// /<解除用户锁定
    public static final int BMS_CONF_USER_UNLOCK_NOTIFY = 0x00010062;// /<解除用户锁定成功
    public static final int BMS_CONF_USER_UNLOCK_ERR_NOTIFY = 0x00010064;// /<解除用户锁定失败
    public static final int BMS_SUB_CONF_USER_JOIN = 0x00010071;// /<用户加入子会议
    public static final int BMS_SUB_CONF_USER_JOIN_NOTIFY = 0x00010072;// /<用户加入子会议成功
    public static final int BMS_SUB_CONF_USER_JOIN_ERR_NOTIFY = 0x00010074;// /<用户加入子会议失败
    public static final int BMS_CONF_USER_EXIT = 0x00010081;// /<用户退出会议
    public static final int BMS_CONF_USER_EXIT_NOTIFY = 0x00010082;// /<用户退出会议成功
    public static final int BMS_CONF_USER_EXIT_ERR_NOTIFY = 0x00010084;// /<用户退出会议失败
    public static final int BMS_SUB_CONF_USER_EXIT = 0x00010011;// /<用户退出子会议
    public static final int BMS_SUB_CONF_USER_EXIT_NOTIFY = 0x00010011;// /<用户退出子会议成功
    public static final int BMS_SUB_CONF_USER_EXIT_ERR_NOTIFY = 0x00010011;// /<用户退出子会议失败
    public static final int BMS_CONF_USER_BLACK = 0x000100a1;// /<用户被黑
    public static final int BMS_CONF_USER_BLACK_NOTIFY = 0x000100a2;// /<用户被黑成功
    public static final int BMS_CONF_USER_BLACK_ERR_NOTIFY = 0x000100a4;// /<用户被黑失败
    public static final int BMS_CONF_USER_UNBLACK = 0x000100b1;// /<用户解除被黑
    public static final int BMS_CONF_USER_UNBLACK_NOTIFY = 0x000100b2;// /<用户解除被黑成功
    public static final int BMS_CONF_USER_UNBLACK_ERR_NOTIFY = 0x000100b4;// /<用户解除被黑失败
    public static final int BMS_CONF_USER_EXPEL = 0x000100c1;// /<用户被驱逐
    public static final int BMS_CONF_USER_EXPEL_NOTIFY = 0x000100c2;// /<用户驱逐成功
    public static final int BMS_CONF_USER_EXPEL_ERR_NOTIFY = 0x000100c4;// /<用户驱逐失败
    public static final int BMS_CONF_USER_CHANGE_ROLE = 0x000100d1;// /<用户角色改变
    public static final int BMS_CONF_USER_CHANGE_ROLE_NOTIFY = 0x000100d2;// /<用户角色改变成功
    public static final int BMS_CONF_USER_CHANGE_ROLE_ERR_NOTIFY = 0x000100d4;// /<用户角色改变失败
    public static final int BMS_CONF_USER_ADD_ROLE = 0x000100e1;// /<用户角色增加
    public static final int BMS_CONF_USER_ADD_ROLE_NOTIFY = 0x000100e2;// /<用户角色增加成功
    public static final int BMS_CONF_USER_ADD_ROLE_ERR_NOTIFY = 0x000100e4;// /<用户角色增加失败
    public static final int BMS_CONF_USER_LIST_REQUEST = 0x000100f1;// /<用户列表查询
    public static final int BMS_CONF_USER_LIST_REQUEST_NOTIFY = 0x000100f2;// /<用户列表查询成功
    public static final int BMS_CONF_USER_LIST_REQUEST_ERR_NOTIFY = 0x000100f4;// /<用户列表查询失败
    public static final int BMS_CONF_INFO_REQUEST = 0x00010101;// /<用户会议信息查询
    public static final int BMS_CONF_INFO_REQUEST_NOTIFY = 0x00010102;// /<用户会议信息查询成功
    public static final int BMS_CONF_INFO_REQUEST_ERR_NOTIFY = 0x00010104;// /<用户会议信息查询失败
    public static final int BMS_CONF_START_SERVICE = 0x00010111;// /<开启会议中某项业务
    public static final int BMS_CONF_START_SERVICE_NOTIFY = 0x00010112;// /<开启会议中某项业务成功
    public static final int BMS_CONF_START_SERVICE_ERR_NOTIFY = 0x00010114;// /<开启会议中某项业务失败
    public static final int BMS_CONF_STOP_SERVICE = 0x00010121;// /<关闭会议中某项业务
    public static final int BMS_CONF_STOP_SERVICE_NOTIFY = 0x00010122;// /<关闭会议中某项业务成功
    public static final int BMS_CONF_STOP_SERVICE_ERR_NOTIFY = 0x00010124;// /<关闭会议中某项业务失败
    public static final int BMS_CONF_START_NOTIFY = 0x00010132;// /<下发会议开启消息
    public static final int BMS_TRANS_SERVER_UPDATE_NOTIFY = 0x00010142;// /<下发传输服务地址修改消息
    public static final int BMS_CONF_USER_ONLINE = 0x00008001;// /<用户上线
    public static final int BMS_CONF_USER_ONLINE_NOTIFY = 0x00011111;// /<用户上线通知
    public static final int BMS_CONF_USER_OFFLINE = 0x00008002;// /<用户下线
    public static final int BMS_CONF_USER_OFFLINE_NOTIFY = 0x00011110;// /<用户下线通知
    public static final int BMS_CONF_USER_MSG = 0x00010131;// /<用户自定义消息
    public static final int BMS_CONF_USER_MSG_NOTIFY = 0x00010134;// /<用户自定义消息通知

    // 会议未找到异常编码
    public static final String CODE601 = "org.freedesktop.DBus.GLib.UnmappedError.TangBmsError.Code601";
    public static final String CODE404 = "org.freedesktop.DBus.GLib.UnmappedError.TangBmsError.Code404";
    public static final String CODE416 = "org.freedesktop.DBus.GLib.UnmappedError.TangBmsError.Code416";

    //会议状态
    public static final Integer CONF_STATUS_DB_NEW = 0;
    public static final Integer CONF_STATUS_BMS_NEW = 1;
    public static final Integer CONF_STATUS_BMS_START = 2;
    public static final Integer CONF_STATUS_END = 4;
    public static final Integer CONF_STATUS_NOT_FOUND = -1;

    public static final int ID_CONTROL_BILLINGCODE_ID = 1;
    public static final int ID_CONTROL_PASSCODE_ID = 11;
    public static final int ID_CONTROL_TEMPCONFID_ID = 21;
    public static final int ID_CONTROL_TEMPUSERID_ID = 31;
    public static final int ID_CONTROL_SHORTPASSCODE_ID = 41;
    public static final int ID_CONTROL_TRAILPASSCODE_ID = 51;

    private static final String CONFFILEPATH = "/config.properties";

    public static final int site=Integer.parseInt( ConfigUtil.getByKey("site"));
}
