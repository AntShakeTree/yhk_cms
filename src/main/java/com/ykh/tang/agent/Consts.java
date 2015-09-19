package com.ykh.tang.agent;

public class Consts {
    // 18 创建子会议成功消息
    public static final int CreateSubConfMsgResult_key = 0x00010012;

    // 19 创建子会议失败消息
    public static final int CreateSubConfMsgFault_key = 0x00010014;

    // 20 会议停止成功消息
    public static final int ConfStopMsgResult_key = 0x00010022;

    // 21 会议停止失败应答消息
    public static final int ConfStopMsgFault_key = 0x00010024;

    // 22 会议系统锁定通知
    public static final int ConfSysLockMsgResult_key = 0x00010030;

    // 23 会议系统解锁通知
    public static final int ConfSysUnlockMsgFault_key = 0x00010040;

    // 24 用户锁定会议成功消息
    public static final int ConfUserLockMsgResult_key = 0x00010052;

    // 25 用户锁定会议失败消息
    public static final int ConfUserLockMsgFault_key = 0x00010054;

    // 26 会议用户解锁成功消息
    public static final int ConfUserUnlockMsgResult_key = 0x00010062;

    // 27 会议用户解锁失败消息
    public static final int ConfUserUnlockMsgFault_key = 0x00010064;

    // 28 用户加入子会议成功消息
    public static final int UserJoinSubConfMsgResult_key = 0x00010072;

    // 29 用户加入子会议失败消息
    public static final int UserJoinSubConfMsgFault_key = 0x00010074;

    // 30 用户入会通知
    public static final int UserJoinConfResult_key = 0x00010152;

    // 31 用户退会失败消息
    public static final int UserExitConfMsgFault_key = 0x00010084;

    // 32 用户退出子会议成功消息
    public static final int UserExitConfMsgResult_key = 0x00010082;

    // 33 用户退出子会议失败消息
    public static final int UserExitSubConfMsgFault_key = 0x00010094;

    // 34 用户加入黑名单成功消息
    public static final int BlackUserMsgResult_key = 0x000100a2;

    // 35 用户加入黑名单失败消息
    public static final int BlackUserMsgFault_key = 0x000100a4;

    // 36 用户退出黑名单成功消息
    public static final int UnblackUserMsgResult_key = 0x000100b2;

    // 37 用户退出黑名单失败消息
    public static final int UnblackUserMsgFault_key = 0x000100b4;

    // 38 驱逐用户出会成功消息
    public static final int ExpelUserMsgResult_key = 0x000100c2;

    // 39 驱逐用户出会失败消息
    public static final int ExpelUserMsgFault_key = 0x000100c4;

    // 40 改变用户角色成功消息
    public static final int ChangeUserRoleMsgResult_key = 0x000100d2;

    // 41 改变用户角色失败消息
    public static final int ChangeUserRoleMsgFault_key = 0x000100d4;

    // 42 查询用户列表成功消息
    public static final int QueryUserListResult_key = 0x000100f2;

    // 43 查询用户列表失败消息
    public static final int QueryUserListFault_key = 0x000100f4;

    // 44 查询会议信息成功消息
    public static final int QueryConfInfoMsgResult_key = 0x00010102;

    // 45 查询会议信息失败消息
    public static final int QueryConfInfoMsgFault_key = 0x00010104;

    // 46 查询会议用户通道成功应答信息
    public static final int QueryConfChannelMsgResult_key = 0x00010172;

    // 47 查询会议用户通道失败应答信息
    public static final int QueryConfChannelMsgFault_key = 0x00010173;
    // 48 更新会议配置数据成功消息
    public static final int UpdateConfConfigMsgResult_key = 0x00010182;
    // 49 更新会议配置数据失败消息
    public static final int UpdateConfConfigMsgFault_key = 0x00010184;
    // 50 更新会议描述成功消息
    public static final int UpdateConfDesMsgResult_key = 0x00010192;
    // 51 更新会议描述失败消息
    public static final int UpdateConfDesMsgFault_key = 0x00010194;
    // 52 开启业务成功应答消息
    public static final int StartServiceMsgResult_key = 0x00010112;
    // 53 开启业务失败应答消息
    public static final int StartServiceMsgFault_key = 0x00010114;
    // 54 关闭业务成功应答消息
    public static final int StopServiceMsgResult_key = 0x00010122;
    // 55 关闭业务失败应答消息
    public static final int StopServiceMsgFault_key = 0x00010124;
    // 56 用户上线通知
    public static final int UserOnlineMsgResult_key = 0x00011111;
    // 57 电话用户上线通知
    public static final int PhoneUserOnlineMsgResult_key = 0x000101a2;
    // 58 用户下线通知
    public static final int UserOfflineMsgResult_key = 0x00011110;
    // 59 电话用户下线通知
    public static final int PhoneUserOfflineMsgResult_key = 0x000101b2;
    // 60 用户自定义消息失败
    public static final int UserDefineMsgFault_key = 0x00010164;
    // 61 传输服务器地址改变通知
    public static final int SysDTSIPModify_key = 0x00010142;
    // 62 下发会议开始消息
    public static final int ConfStartMsgResult_key = 0x00010132;
    // 63 服务上线消息
    public static final int ServiceOnlineMsgResult_key = 0x00008001;
    // 64 服务下线消息
    public static final int ServiceOfflineMsgResult_key = 0x00008002;
    // 1
    public static final int Channel_key = 0x0001;
    // 2
    public static final int Ip_key = 0x0002;
    // 3
    public static final int UserInfo_key = 0x0004;
    // 4
    public static final int ChannelInfo_key = 0x0008;
    // 5
    public static final int ChannelAndUserInfo_key = 0x0010;
    // 6
    public static final int JoinUserInfo_key = 0x0011;
    // 7
    public static final int RoleInfo_key = 0x0012;
    // 8
    public static final int Time0_key = 0x0014;
    // 9
    public static final int SubConfInfo_key = 0x0018;
    // 10
    public static final int ConferenceInfo_key = 0x0020;

    // chao.li add
    public static final int UserServiceAddr_key = 0x0040;
    public static final int SubConferenceInfo_key = 0x0041;
    public static final int BMSUserInfo_key = 0x0042;
    public static int ERROR_CODE = 0x5fffff01;
    public static String message = "cp userInfo exception.";
}
