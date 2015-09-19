package com.ykh.tang.agent;

import com.alibaba.fastjson.JSON;
import com.ykh.tang.agent.excep.CMSException;
import com.ykh.tang.agent.message.*;
import com.ykh.tang.agent.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianchao.ji
 *         <p/>
 *         JNI 本地调用方式
 */
@Component
public class ICMSAgent

{
    Logger logger = Logger.getLogger(ICMSAgent.class);
    @Autowired
    @Qualifier("getmessageHandler")
    private IMessageHandler handler;
    @Autowired
    @Qualifier("getmessageHandlerByGroup")
    private IMessageHandler serviceHandler;

    static {
        try {
            System.out.println("load cmsagent start!!!!!!!");
            System.load("/tang/lib/libcmsagent.so.1.0.0");
            System.out.println("load cmsagent end!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("load cmsagnet lib failure!!!!!!");
        }
    }

//	private static  final  ICMSAgent ICMS_AGENT=new ICMSAgent();


    // 初始化
    public native int agentInit();

    // 销毁
    public native int agentDestroy();

    // 1 -----作废-----

    // 2 -----作废-----

    // 3 获得会议信息
    public native int getConfInfo(int site, int confID, ConferenceInfoBMS confInfo) throws CMSException;

    // 4 获得用户列表
    public native int getUserList(int site, int confID, List<BMSUserInfo> userArr) throws CMSException;

    // 5 -----作废-----

    // 6 -----作废-----

    // 7 更新服务配置
    //public native int updateServiceConfigs(int site, int confID, int userID, List<String> confArr) throws CMSException;

    // 8 用户退出子会议
    //public native int userExitSubConference(int site, int confID, int op, int target) throws CMSException;

    // 9 用户加入子会议
    //public native int userJoinSubConference(int site, int confID, int op, int target, List rolesArr, UserChannel userchannel) throws CMSException;

    // 10 改变会议角色
    public native int changeRole(int site, int confID, int op, List<String> userArr, List<String> newRoleArr) throws CMSException;

    // 11 会议踢人
    public native int expelUser(int site, int confID, List<String> userArr) throws CMSException;

    // 12 黑人解除
    public native int unblackUser(int site, int confID, List<String> userArr) throws CMSException;

    // 13 黑人
    public native int blackUser(int site, int confID, List<String> userArr) throws CMSException;

    // 14 用户退出会议
    public native int userExitConference(int site, int confID, int userID, Object lock) throws CMSException;

    // 15 用户加入会议
    public native int userJoinConference(int site, int confID, BMSUserInfo userInfo, UserChannel channel) throws CMSException;

    // 16 删除子会议
    //public native int deleteSubConference(int site, int confID, int userID) throws CMSException;

    // 17 创建子会议
    //public native int createSubConference(int site, int confID, int userID) throws CMSException;

    // 18 锁定会议
    public native int userLockConference(int site, int confID, Object lock) throws CMSException;

    // 19 解锁会议
    public native int userUnlockConference(int site, int confID, Object lock) throws CMSException;

    // 20 系统解锁会议
    public native int sysUnlockConference(int site, int confID, Object lock) throws CMSException;

    // 21 系统加锁会议
    public native int sysLockConference(int site, int confID, Object lock) throws CMSException;

    // 22 -----作废-----

    // 23 不带user停止会议
    public native int stopConferenceWithoutUser(int site, int confID, Object lock) throws CMSException;

    // 24 不带user删除会议
    public native int deleteConferenceWithoutUser(int site, int confID, Object lock) throws CMSException;

    // 25 不带user启动会议
    public native int startConferenceWithoutUser(int site, int confID, Object lock) throws CMSException;

    // 26 带user启动会议
    public native int startConferenceWithUser(int site, int confID, BMSUserInfo userInfo, UserChannel userchannel) throws CMSException;

    // 27 创建会议，不带用户。该方法直接提供给系统管理员调用。
    public native int createConferenceWithoutUser(int site, ConferenceInfoBMS confInfo, List<String> servicetypelist) throws CMSException;

    // 28 带用户创建会议
    public native int createConferenceWithUser(int site, ConferenceInfoBMS confInfo, BMSUserInfo userInfo, List<String> typeArr,
                                               UserChannel userchannel) throws CMSException;

    // 29 向服务器请求开启某种业务
    public native int startService(int site, int confID, int serviceType, Object lock) throws CMSException;

    // 30 向服务器请求关闭某种业务
    public native int stopService(int site, int confID, int serviceType, Object lock) throws CMSException;

    // 31 向服务器请求开始录制某种业务
    public native int startRecord(int site, ConferenceInfoBMS confInfo, int serviceType) throws CMSException;

    // 32 向服务器请求关闭录制某种业务
    public native int stopRecord(int site, ConferenceInfoBMS confInfo, int serviceType) throws CMSException;

    // 33 根据临时会议ID查询会议扩展信息（等同于 getBMSConferenceInfoExt()）
    //public native int getBMSConferenceInfo(int site, int confID, BMSConferenceInfo confInfo) throws CMSException;

    // 34 查询用户会议状态 （添加的！）
    public native int getUserConferenceStatus(int site, int confID, int userID, UserConferenceStatus serConferenceStatus) throws CMSException;

    // 35 -----作废-----

    // 36会议消息定义接口，CMS使用
    public synchronized native int subConfMsg(int site, int confID, String result) throws CMSException;

    // 37 用户消息回调接口  备注:C实现部分调用此函数，向下推送消息
    public void messageHandler(Object msg) {
        if (this.handler != null) {
            this.handler.handler((IMessage) msg);
        }
    }

    // 38 业务消息回调接口  备注:C实现部分调用此函数，向下推送消息
    public void serviceMessageHandler(Object msg) {
        if (this.serviceHandler != null) {
            this.serviceHandler.handler((IMessage) msg);
        }
    }

    // 无序号
    //public native int getBMSConferenceUserList(int site, int confID, List userInfoArr) throws CMSException;

    public native void setConfigTimes(int site, int confID, int time1, int time2, Object lock) throws CMSException;

    // 带有分账信息创建会议，不带用户.
    public native int createConferenceBillInfoWithoutUser(int site, ConferenceBillInfoBMS confInfo, List<String> servicetypelist) throws CMSException;

    // 带有分账信息带用户创建会议。
    public native int createConferenceBillInfoWithUser(int site, ConferenceBillInfoBMS confInfo, BMSUserBillInfo userInfo, List<String> typeArr,
                                                       UserChannel userchannel) throws CMSException;

    public native int userJoinConferenceWithBillInfo(int site, int confID, BMSUserBillInfo userInfo, UserChannel channel) throws CMSException;

    public native int startConferenceBillInfoWithUser(int site, int confID, BMSUserBillInfo userInfo, UserChannel userchannel) throws CMSException;

    public Object getStructInstance(int clsid) {
        switch (clsid) {
            // 18 创建子会议成功消息 [0x10012]
            case Consts.CreateSubConfMsgResult_key:
                return new CreateSubConfMsgResult();
            // 19 创建子会议失败消息 [0x10014]
            case Consts.CreateSubConfMsgFault_key:
                return new CreateSubConfMsgFault();
            // 20 会议停止成功消息 [0x10022]
            case Consts.ConfStopMsgResult_key:
                return new ConfStopMsgResult();
            // 21 会议停止失败应答消息 [0x10024]
            case Consts.ConfStopMsgFault_key:
                return new ConfStopMsgFault();
            // 22 会议系统锁定通知 [0x10030]
            case Consts.ConfSysLockMsgResult_key:
                return new ConfSysLockMsgResult();
            // 23 会议系统解锁通知 [0x10040]
            case Consts.ConfSysUnlockMsgFault_key:
                return new ConfSysUnlockMsgFault();
            // 24 用户锁定会议成功消息 [0x10052]
            case Consts.ConfUserLockMsgResult_key:
                return new ConfUserLockMsgResult();
            // 25 用户锁定会议失败消息 [0x10054]
            case Consts.ConfUserLockMsgFault_key:
                return new ConfUserLockMsgFault();
            // 26 会议用户解锁成功消息 [0x10062]
            case Consts.ConfUserUnlockMsgResult_key:
                return new ConfUserUnlockMsgResult();
            // 27 会议用户解锁失败消息 [0x10064]
            case Consts.ConfUserUnlockMsgFault_key:
                return new ConfUserUnlockMsgFault();
            // 28 用户加入子会议成功消息 [0x10072]
            case Consts.UserJoinSubConfMsgResult_key:
                return new UserJoinSubConfMsgResult();
            // 29 用户加入子会议失败消息 [0x10074]
            case Consts.UserJoinSubConfMsgFault_key:
                return new UserJoinSubConfMsgFault();
            // 30 用户入会通知 [0x10152]
            case Consts.UserJoinConfResult_key:
                return new UserJoinConfResult();
            // 31 用户退会失败消息 [0x10084]
            case Consts.UserExitConfMsgFault_key:
                return new UserExitConfMsgFault();
            // 32 用户退出会议成功消息 [0x10082]
            case Consts.UserExitConfMsgResult_key:
                return new UserExitConfMsgResult();
            // 33 用户退出子会议失败消息
            /**
             * case Consts.UserExitSubConfMsgFault_key: return new UserExitSubConfMsgFault();
             */
            // 34 用户加入黑名单成功消息 [0x100a2]
            case Consts.BlackUserMsgResult_key:
                return new BlackUserMsgResult();
            // 35 用户加入黑名单失败消息 [0x100a4]
            case Consts.BlackUserMsgFault_key:
                return new BlackUserMsgFault();
            // 36 用户退出黑名单成功消息 [0x100b2]
            case Consts.UnblackUserMsgResult_key:
                return new UnblackUserMsgResult();
            // 37 用户退出黑名单失败消息 [0x100b4]
            case Consts.UnblackUserMsgFault_key:
                return new UnblackUserMsgFault();
            // 38 驱逐用户出会成功消息 [0x100c2]
            case Consts.ExpelUserMsgResult_key:
                return new ExpelUserMsgResult();
            // 39 驱逐用户出会失败消息 [0x100c4]
            case Consts.ExpelUserMsgFault_key:
                return new ExpelUserMsgFault();
            // 40 改变用户角色成功消息 [0x100d2]
            case Consts.ChangeUserRoleMsgResult_key:
                return new ChangeUserRoleMsgResult();
            // 41 改变用户角色失败消息 [0x100d4]
            case Consts.ChangeUserRoleMsgFault_key:
                return new ChangeUserRoleMsgFault();
            // 42 查询用户列表成功消息 [0x100f2]
            case Consts.QueryUserListResult_key:
                return new QueryUserListResult();
            // 43 查询用户列表失败消息 [0x100f4]
            case Consts.QueryUserListFault_key:
                return new QueryUserListFault();
            // 44 查询会议信息成功消息 [0x10102]
            case Consts.QueryConfInfoMsgResult_key:
                return new QueryConfInfoMsgResult();
            // 45 查询会议信息失败消息 [0x10104]
            case Consts.QueryConfInfoMsgFault_key:
                return new QueryConfInfoMsgFault();
            // 46 查询会议用户通道成功应答信息 [0x10172]
            case Consts.QueryConfChannelMsgResult_key:
                return new QueryConfChannelMsgResult();
            // 47 查询会议用户通道失败应答信息 [0x10173]
            case Consts.QueryConfChannelMsgFault_key:
                return new QueryConfChannelMsgFault();
            // 48 更新会议配置数据成功消息 [0x10182]
            case Consts.UpdateConfConfigMsgResult_key:
                return new UpdateConfConfigMsgResult();
            // 49 更新会议配置数据失败消息 [0x10184]
            case Consts.UpdateConfConfigMsgFault_key:
                return new UpdateConfConfigMsgFault();
            // 50 更新会议描述成功消息 [0x10192]
            case Consts.UpdateConfDesMsgResult_key:
                return new UpdateConfDesMsgResult();
            // 51 更新会议描述失败消息 [0x10194]
            case Consts.UpdateConfDesMsgFault_key:
                return new UpdateConfDesMsgFault();
            // 52 开启业务成功应答消息 [0x10112]
            case Consts.StartServiceMsgResult_key:
                return new StartServiceMsgResult();
            // 53 开启业务失败应答消息 [0x10114]
            case Consts.StartServiceMsgFault_key:
                return new StartServiceMsgFault();
            // 54 关闭业务成功应答消息 [0x10122]
            case Consts.StopServiceMsgResult_key:
                return new StopServiceMsgResult();
            // 55 关闭业务失败应答消息 [0x10124]
            case Consts.StopServiceMsgFault_key:
                return new StopServiceMsgFault();
            // 56 用户上线通知 [0x11111]
            case Consts.UserOnlineMsgResult_key:
                return new UserOnlineMsgResult();
            // 57 电话用户上线通知 [0x101a2]
            case Consts.PhoneUserOnlineMsgResult_key:
                return new PhoneUserOnlineMsgResult();
            // 58 用户下线通知 [0x11110]
            case Consts.UserOfflineMsgResult_key:
                return new UserOfflineMsgResult();
            // 59 电话用户下线通知 [0x101b2]
            case Consts.PhoneUserOfflineMsgResult_key:
                return new PhoneUserOfflineMsgResult();
            // 60 用户自定义消息失败 [0x10164]
            case Consts.UserDefineMsgFault_key:
                return new UserDefineMsgFault();
            // 61 传输服务器地址改变通知 [0x10142]
            case Consts.SysDTSIPModify_key:
                return new SysDTSIPModify();
            // 62 下发会议开始消息 [0x10132]
            case Consts.ConfStartMsgResult_key:
                return new ConfStartMsgResult();
            // 63 服务上线消息 [0x8001]
            case Consts.ServiceOnlineMsgResult_key:
                return new ServiceOnlineMsgResult();
            // 64 服务下线消息 [0x8002]
            case Consts.ServiceOfflineMsgResult_key:
                return new ServiceOfflineMsgResult();
            // 1 from chao.li [0x1]
            case Consts.Channel_key:
                return new Channel();
            // 2 from chao.li  [0x2]
            case Consts.Ip_key:
                return new Ip();
            // 3 from chao.li  [0x4]
            case Consts.UserInfo_key:
                return new UserInfo();
            // 4 from chao.li  [0x8]
            case Consts.ChannelInfo_key:
                return new ChannelInfo();
            // 5 from chao.li  [0x10]
            case Consts.ChannelAndUserInfo_key:
                return new ChannelAndUserInfo();
            // 6 from chao.li  [0x11]
            case Consts.JoinUserInfo_key:
                return new JoinUserInfo();
            // 7 from chao.li  [0x12]
            case Consts.RoleInfo_key:
                return new RoleInfo();
            // 8 from chao.li  [0x14]
            case Consts.Time0_key:
                return new Time0();
            // 9 from chao.li  [0x18]
            case Consts.SubConfInfo_key:
                return new SubConfInfo();
            // 10 from chao.li  [0x20]
            case Consts.ConferenceInfo_key:
                return new ConferenceInfo();
            //  [0x40]
            case Consts.UserServiceAddr_key:
                return new UserServiceAddr();
            //  [0x41]
            case Consts.SubConferenceInfo_key:
                return new SubConferenceInfo();
            //  [0x42]
            case Consts.BMSUserInfo_key:
                return new BMSUserInfo();
        }

        return null;
    }

    public List<Object> getArrayInstance() {
        return new ArrayList<Object>();
    }

    public void test() {
        int confID = 88776655;

        int site = 1;

        // agent初始化
        agentInit();

        int ret;
        try {
            ret = startConferenceWithoutUser(site, confID, new Object());

            if (ret != 0) {
                System.out.println("start conference without user");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // agent销毁
        agentDestroy();
    }

    public void setHandler(Object handler) {
        logger.info("[Tang CMS serviceHandler  Handler]" + JSON.toJSONString(handler));

        this.handler = (IMessageHandler) handler;
    }

    public void setServiceHandler(Object serviceHandler) {
        logger.info("[Tang CMS serviceHandler  serviceHandler]" + JSON.toJSONString(serviceHandler));

        this.serviceHandler = (IMessageHandler) serviceHandler;
    }


    public ICMSAgent() {
    }

//	public ICMSAgent(IMessageHandler handler,IMessageHandler serviceHandler){
//		this.handler=handler;
//		this.serviceHandler=serviceHandler;
//	}

//	public static ICMSAgent getInstance(){
//		return ICMS_AGENT;
//	}

}
