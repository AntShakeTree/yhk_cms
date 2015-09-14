package com.ykh.tang.agent;

import java.util.List;

import com.ykh.tang.agent.excep.CMSException;
import com.ykh.tang.agent.vo.BMSUserBillInfo;
import com.ykh.tang.agent.vo.BMSUserInfo;
import com.ykh.tang.agent.vo.ConferenceBillInfoBMS;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserConferenceStatus;

public interface ICMSAgentInterface
{
	// 1--------废除--------

	// 2--------废除--------

	// 3 获得会议信息
	public ConferenceInfoBMS getConfInfo(int site, int confID) throws CMSException;

	// 4获得用户列表
	public List<BMSUserInfo> getUserList(int site, int confID)throws CMSException;

	// 5--------废除--------

	// 6--------废除--------

	// 7更新服务配置
	//public void getUpdateServiceConfigs(int site, int confID, int userID, List<int> confArr)throws CMSException;

	// 8用户退出子会议
	//public void userExitSubConference(int site, int confID, int op, int target)throws CMSException;

	// 9用户加入子会议
	//public UserChannel userJoinSubConference(int site, int confID, int op, int target, List<int> rolesArr, UserChannel userchannel)throws CMSException;

	// 10改变会议角色
	public void changeRole(int site, int confID, int op, List<String> userArr, List<String> newRoleArr)throws CMSException;

	// 11会议踢人
	public void expelUser(int site, int confID, List<String> userArr)throws CMSException;

	// 12黑人解除
	public void unblackUser(int site, int confID, List<String> userArr)throws CMSException;

	// 13黑人
	public void blackUser(int site, int confID, List<String> userArr)throws CMSException;

	// 14用户退出会议
	public void userExitConference(int site, int confID, int userID)throws CMSException;

	// 15用户加入会议
	public UserChannel userJoinConference(int site, int confID, BMSUserInfo userInfo)throws CMSException;

	// 16删除子会议
	//public void deleteSubConference(int site, int confID, int userID)throws CMSException;

	// 17创建子会议
	//public void createSubConference(int site, int confID, int userID)throws CMSException;

	// 18锁定会议
	public void userLockConference(int site, int confID)throws CMSException;

	// 19解锁会议
	public void userUnlockConference(int site, int confID)throws CMSException;

	// 20系统解锁会议
	public void sysUnlockConference(int site, int confID)throws CMSException;

	// 21系统加锁会议
	public void sysLockConference(int site, int confID)throws CMSException;

	// 22--------废除--------

	// 23不带user停止会议
	public void stopConferenceWithoutUser(int site, int confID)throws CMSException;

	// 24不带user删除会议
	public void deleteConferenceWithoutUser(int site, int confID)throws CMSException;

	// 25不带user启动会议
	public void startConferenceWithoutUser(int site, int confID)throws CMSException;

	// 26带user启动会议
	public UserChannel startConferenceWithUser(int site, int confID, BMSUserInfo userInfo)throws CMSException;

	// 27创建会议，不带用户。该方法直接提供给系统管理员调用。
	public void createConferenceWithoutUser(int site, ConferenceInfoBMS confInfo, List<String> typeArr)throws CMSException;

	// 28带用户创建会议。
	public UserChannel createConferenceWithUser(int site, ConferenceInfoBMS confInfo, BMSUserInfo userInfo, List<String> typeArr)throws CMSException;

	// 29向服务器请求开启某种业务
	public void startService(int site, int confID, int serviceType)throws CMSException;

	// 30向服务器请求开启某种业务。
	public void stopService(int site, int confID, int serviceType)throws CMSException;

	// 31向服务器请求开始录制某种业务
	public void startRecord(int site, int confID, int serviceType)throws CMSException;

	// 32向服务器请求关闭录制某种业务
	public void stopRecord(int site, int confID, int serviceType)throws CMSException;

	// 33 根据临时会议ID查询会议扩展信息
	//public ConferenceInfoBMSExt getBMSConferenceInfoExt(int site, int confID, ConferenceInfoBMSExt bMSConferenceInfoExt)throws CMSException;

	// 34 根据临时会议ID和临时用户ID查询该用户在该会议中的状态
	public UserConferenceStatus getUserConferenceStatus(int site, int confID, int userID)throws CMSException;

	// 35 --------废除--------

	// 36会议消息定义接口，CMS使用
	public String subConfMsg(int site, int confID, String result)throws CMSException;

	/*** JNI对CMS的单独接口  */

	// 1  注册用户消息回调接口     备注:CMS调用此接口，向JNI注册回调函数
	public void addMessageHandler(IMessageHandler handler);

	// 2 注册业务消息回调接口       备注:CMS调用此接口，向JNI注册回调函数
	public void addServiceMessageHandler(IMessageHandler serviceHandler);

	public void setConfigTimes(int site, int confID, int time1, int time2) throws CMSException;

	// 27创建会议，不带用户。该方法直接提供给系统管理员调用。
	public void createConferenceBillInfoWithoutUser(int site, ConferenceBillInfoBMS confInfo, List<String> typeArr)throws CMSException;

	// 28带用户创建会议。
	public UserChannel createConferenceBillInfoWithUser(int site, ConferenceBillInfoBMS confInfo, BMSUserBillInfo userInfo, List<String> typeArr)throws CMSException;

	public UserChannel userJoinConferenceWithBillInfo(int site, int confID, BMSUserBillInfo userInfo)throws CMSException;

	public UserChannel startConferenceBillInfoWithUser(int site, int confID, BMSUserBillInfo userinfo)throws CMSException;

	public void agentInit();

	void agentDestroy();
}
