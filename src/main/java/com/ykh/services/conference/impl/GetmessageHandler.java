/**
 * **********************************************
 * Copyright (c) 2006-2009 G-Net All rights
 * reserved. G-Net Integrated Services co. Ltd.
 * *******************************************************************
 *
 * @(#)GetmessageHandler.java 1.0 Oct 30, 2009
 * <p/>
 * 消息处理业务类
 * @author Dongyu Zhang
 * @date Oct 30, 2009
 * @version 0.2
 * @warning
 * @par 需求: REQ1.10[Tang]:
 * svn://vobserver/tang/doc/SRS.doc
 */
package com.ykh.services.conference.impl;

import com.ykh.common.Session;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.services.ConfJoinTempConfService;
import com.ykh.services.TempUserService;
import com.ykh.tang.agent.IMessageHandler;
import com.ykh.tang.agent.message.*;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Qualifier("getmessageHandler")
public class GetmessageHandler implements IMessageHandler {

    private final static Logger LOGGER = Logger.getLogger(GetmessageHandler.class);

    @Autowired
    TempUserService tempUserService;
    @Autowired
    ConfJoinTempConfService confJoinTempConfService;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * handle接口实现，判断接收信号的类型，做相应的处理
     *
     * @param msg
     *            消息操作句柄
     */
    @Override
    public void handler(IMessage msg) {
        // 解析消息类型
        int messagetype = msg.getMsgID();

        // 判断信号类型
        switch (messagetype) {
            case com.ykh.tang.agent.Consts.ConfStartMsgResult_key & 0xFFFF:
                // 收到会议启动消息
                LOGGER.info("Tang CMS receive start conference message!!!!!");

                try {
                    ConfStartMsgResult confStartMsgResult = (ConfStartMsgResult) msg;
                    Integer tempConfID = confStartMsgResult.getConfID();
                    LOGGER.info("Tang CMS receive start conference message=" + tempConfID);
                    //TempUser tempUser =new TempUser();


//				/********************add by lilonglong 2011-09-22*********************/
//				Cdrconferencemsg cdrconferencemsg =  new Cdrconferencemsg();
//				cdrconferencemsg.setTempconferenceid(tempConfID);
//				cdrconferencemsg.setActiontypeid(Consts.ONLINE);
//				cdrconferencemsg.setTimestamp(new Date());
//				cdrConferencemsgManager.create(cdrconferencemsg);
//				/******************end***********************/
//
//				//add by tanyunhua 2011-10-31		user online时，start conference后，修改会议状态
//                    confJoinTempConfService.updateStatus(tempConfID,1);

                    Session.setCache(tempConfID,confJoinTempConfService.findConferenceByTempConfId(tempConfID));


                    //end add
//				Cdrconferenceinfo cdrconf = ConferenceBusinessImpl.getCdrConferenceInfoManager().queryCdrConfByConfIDAndTempID(tempConfID);
//				if (cdrconf == null) {
//					LOGGER.error("not found the confID[" + tempConfID + "] cdrconferenceinfo record");
//				}
//				else
//				{
//					cdrconf.setStarttime(new Date());
//					ConferenceBusinessImpl.getCdrConferenceInfoManager().update(cdrconf);
//				}
                } catch (Exception e) {
                    dealKeysException(e);
                }
                break;
            case com.ykh.tang.agent.Consts.UserOnlineMsgResult_key & 0xFFFF:
                //收到用户上线消息
                LOGGER.info("Tang Tang CMS receive user online message!!!!!");
                // 修改用户状态，获得用户ID
                UserOnlineMsgResult userOnlineMsgResult = (UserOnlineMsgResult) msg;

                LOGGER.info("Tang Tang CMS receive user online message=" + userOnlineMsgResult.getConfID()
                        + "|" + userOnlineMsgResult.getUserID() + "|" + Consts.ONLINE + "|" +
                        userOnlineMsgResult.getTimestamp());


                Integer onLineUserid = userOnlineMsgResult.getUserID();

                tempUserService.updateStatus(onLineUserid, Consts.ONLINE);


//			// 添加数据库cdruser记录
//			Cdruserinfo cdruserinfo = new Cdruserinfo();
//			cdruserinfo.setTimestamp(new Date());
//			cdruserinfo.setTempconferenceid(userOnlineMsgResult.getConfID());
//			cdruserinfo.setTempuserid(onLineUserid);
//			cdruserinfo.setActiontypeid(Consts.ONLINE);
//			cdruserinfo.setMsgtimestamp(userOnlineMsgResult.getTimestamp());
//
//			try {
//				ConferenceBusinessImpl.getCdrUserInfoManager().create(cdruserinfo);
//			} catch (Exception e) {
//				dealKeysException(e);
//			}

                break;
            case com.ykh.tang.agent.Consts.UserJoinConfResult_key & 0xFFFF:
                // 收到用户加入会议消息
                LOGGER.info("Tang CMS receive user enter message!!!!!");
                UserJoinConfResult userJoinConfResult = (UserJoinConfResult) msg;

                JoinUserInfo joinUserInfo = (JoinUserInfo) userJoinConfResult.getUserInfo();

                LOGGER.info("Tang Tang CMS receive user enter message=" + userJoinConfResult.getConfID()
                        + "|" + joinUserInfo.getUserID() + "|" + Consts.JOIN + "|" +
                        userJoinConfResult.getTimestamp());

                Ip ip = (Ip) joinUserInfo.getIP();
                String ips = ip.getIP0() + "." + ip.getIP1() + "." + ip.getIP2() + "." + ip.getIP3();
                Integer id = joinUserInfo.getUserID();

                tempUserService.updateStatus(id, Consts.JOIN);

                // 添加数据库cdruser记录
//			Cdruserinfo cdruserinfoJoin = new Cdruserinfo();
//			cdruserinfoJoin.setIpaddr(ips);
//			cdruserinfoJoin.setTimestamp(new Date());
//			cdruserinfoJoin.setTempconferenceid(userJoinConfResult.getConfID());
//			cdruserinfoJoin.setTempuserid(joinUserInfo.getUserID());
//			cdruserinfoJoin.setUsername(joinUserInfo.getUserName());
//			cdruserinfoJoin.setActiontypeid(Consts.JOIN);
//			cdruserinfoJoin.setClienttype(joinUserInfo.getClientType());
//			cdruserinfoJoin.setDomain(joinUserInfo.getDomain());
//			cdruserinfoJoin.setTimestamp(new Date());
//			cdruserinfoJoin.setMsgtimestamp(userJoinConfResult.getTimestamp());
//
//			String role = "";
//			if(joinUserInfo.getRoleArr() != null) {
//				for(String roleid : joinUserInfo.getRoleArr()) {
//					role = role + roleid + ",";
//				}
//			}
//			cdruserinfoJoin.setRole(role);
//
//			try {
//				ConferenceBusinessImpl.getCdrUserInfoManager().create(cdruserinfoJoin);
//			} catch (Exception e) {
//				dealKeysException(e);
//			}

                break;
            case com.ykh.tang.agent.Consts.UserOfflineMsgResult_key & 0xFFFF:
                //用户下线消息
                LOGGER.info("Tang CMS receive user offline message!!!!!");

                UserOfflineMsgResult userOfflineMsgResult = (UserOfflineMsgResult) msg;

                LOGGER.info("Tang Tang CMS receive user offline message=" + userOfflineMsgResult.getConfID()
                        + "|" + userOfflineMsgResult.getUserID() + "|" + Consts.OFFLINE + "|" +
                        userOfflineMsgResult.getTimestamp());
                tempUserService.updateStatus(userOfflineMsgResult.getUserID(), Consts.OFFLINE);

                break;
            case Consts.BMS_SUB_CONF_USER_JOIN_NOTIFY & 0xFFFF:
                // 收到用户加入子会成功消息
                break;
            case Consts.BMS_SUB_CONF_USER_JOIN_ERR_NOTIFY & 0xFFFF:
                // 收到用户加入子会失败消息
                break;
            case Consts.BMS_CONF_USER_BLACK_NOTIFY & 0xFFFF:
                // 收到黑人成功信号
                break;
            case Consts.BMS_CONF_USER_BLACK_ERR_NOTIFY & 0xFFFF:
                // 收到黑人失败信号
                break;
            case Consts.BMS_CONF_USER_UNBLACK_NOTIFY & 0xFFFF:
                // 收到用户解除被黑成功信号
                break;
            case Consts.BMS_CONF_USER_UNBLACK_ERR_NOTIFY & 0xFFFF:
                // 收到用户解除被黑失败信号
                break;
            case com.ykh.tang.agent.Consts.ExpelUserMsgResult_key & 0xFFFF:
                // 收到踢人成功信号
                LOGGER.info("Tang CMS receive user expel message!!!!!");

                ExpelUserMsgResult userExpelMsgResult = (ExpelUserMsgResult) msg;

                for (String userid : userExpelMsgResult.getUserArr()) {
                    LOGGER.info("Tang Tang CMS receive user expel message=" + userExpelMsgResult.getConfID()
                            + "|" + userid + "|" + Consts.EXIT + "|" + userExpelMsgResult.getTimestamp());
//				// 添加数据库cdruser记录
//				Cdruserinfo cdruserinfoExpel = new Cdruserinfo();
//				cdruserinfoExpel.setActiontypeid(Consts.EXIT);
//				cdruserinfoExpel.setTimestamp(new Date());
//				cdruserinfoExpel.setTempconferenceid(userExpelMsgResult.getConfID());
//				cdruserinfoExpel.setTempuserid(Integer.parseInt(userid));
//				cdruserinfoExpel.setMsgtimestamp(userExpelMsgResult.getTimestamp());
//
//				try {
//					ConferenceBusinessImpl.getCdrUserInfoManager().create(cdruserinfoExpel);
//				} catch (Exception e) {
//					dealKeysException(e);
//				}
                    tempUserService.updateStatus(Integer.parseInt(userid), Consts.EXIT);


                }
                break;
            case Consts.BMS_CONF_USER_EXPEL_ERR_NOTIFY & 0xFFFF:
                // 收到踢人失败信号
                break;
            case Consts.BMS_SUB_CONF_CREATE_NOTIFY & 0xFFFF:
                // 收到创建子会议成功消息
                // 解析出子会议ID
                break;
            case Consts.BMS_SUB_CONF_CREATE_ERR_NOTIFY & 0xFFFF:
                // 收到创建子会议失败消息
                break;
            case com.ykh.tang.agent.Consts.ConfStopMsgResult_key & 0xFFFF:
                // 收到会议关闭成功消息
                LOGGER.info("Tang CMS receive conference stop message!!!!!");

                try {
                    ConfStopMsgResult confStopMsgResult = (ConfStopMsgResult) msg;
                    LOGGER.info("Tang Tang CMS receive conference stop message=" + confStopMsgResult.getConfID());
                    Integer tempConfID = confStopMsgResult.getConfID();

                    Date endtime = new Date();
                    tempUserService.deleteByTempConferenceId(tempConfID);
                ConfJoinTempConf confJoinTempConf=    confJoinTempConfService.findConferenceByTempConfId(tempConfID);
                    confJoinTempConf.setStatus(8);
                    Session.setCache(tempConfID, confJoinTempConf, 10, TimeUnit.MINUTES);
                    confJoinTempConfService.updateStatus(tempConfID,8);
//                    te.updateStatus(tempConfID,8);
//				/********************add by lilonglong 2011-09-22*********************/
//				Cdrconferencemsg cdrconferencemsg =  new Cdrconferencemsg();
//				cdrconferencemsg.setTempconferenceid(tempConfID);
//				cdrconferencemsg.setActiontypeid(Consts.OFFLINE);
//				cdrconferencemsg.setTimestamp(endtime);
//				cdrConferencemsgManager.create(cdrconferencemsg);
//				/******************end***********************/
//
//				ConferenceBusinessImpl.getConfJoinTempConfManager().deleteConfJoinTempConfByTempConfID(tempConfID);
//				try
//				{
//					ConferenceBusinessImpl.getConferenceUserInfoManager().deleteByTempConferenceId(tempConfID);
//				}
//				catch(Exception ex)
//				{
//					LOGGER.info("delete userinfo");
//				}
//				Cdrconferenceinfo cdrconf = ConferenceBusinessImpl.getCdrConferenceInfoManager().queryCdrConfByConfIDAndTempID(tempConfID);
//
//				if (cdrconf == null) {
//					LOGGER.info("database not found tempConfID[" + tempConfID + "] cdrconference");
//					break;
//				}else{
//
//					//更新会议cdr结束时间
//					cdrconf.setEndtime(endtime);
//					try{
//						ConferenceBusinessImpl.getCdrConferenceInfoManager().update(cdrconf);
//					}catch(Exception ex){
//						LOGGER.info("update CdrConferenceInfo endtime fail");
//						ex.printStackTrace();
//					}
//					//modify by tanyunhua 删除非固定pin码会议的pin码
//					Conference conf = conferenceManager.query(cdrconf.getConferenceid());
//					if(conf != null && (conf.getPin() == null || !conf.getPin()))
//					{
//						LOGGER.info("find 11111111111111111 " + conf + " " + conf.getBillingcode());
//						// add by lilongong 09-19 14:55
//						String billingCode = conf.getBillingcode();
//						if(billingCode!=null && !billingCode.equals("")){
//							reservationService.deletePin(billingCode);
//							pinrefManager.deletePin(billingCode);
//							if(!conf.getIfpasswordfixed())
//							{
//								reservationService.deleteACMConference(billingCode);
//							}
//						}
//					}
//				}
//				routerManager.deleteRouterByTempConfID(tempConfID);
//
////				tempUserManager.deleteTempuserByTempconfid(tempConfID);	//delete tempconfid and tempuserid
                } catch (Exception e) {
                    dealKeysException(e);
                }
                break;
            case com.ykh.tang.agent.Consts.ConfStopMsgFault_key & 0xFFFF:
                // 收到会议关闭失败消息
                //ConfStopMsgFault ConfStopMsgFault = (ConfStopMsgFault)msg;
                //LOGGER.info("Tang CMS receive conference stop failed message!!!!! " );
//			//ConfStopMsgFault.invoke();

                break;
            case com.ykh.tang.agent.Consts.UserExitConfMsgResult_key & 0xFFFF:
                //用户退出消息
                LOGGER.info("Tang CMS receive user quit message!!!!!");

                UserExitConfMsgResult userExitConfMsgResult = (UserExitConfMsgResult) msg;

                LOGGER.info("Tang Tang CMS receive user online message=" + userExitConfMsgResult.getConfID()
                        + "|" + userExitConfMsgResult.getUserID() + "|" + Consts.EXIT + "|" +
                        userExitConfMsgResult.getTimestamp());
//			// 添加数据库cdruser记录
//                tempUserService.ByTempConferenceId(tempConfID);
            tempUserService.deleteUser(userExitConfMsgResult.getUserID());
//			Cdruserinfo cdruserinfoExit = new Cdruserinfo();
//			cdruserinfoExit.setActiontypeid(Consts.EXIT);
//			cdruserinfoExit.setTimestamp(new Date());
//			cdruserinfoExit.setTempconferenceid(userExitConfMsgResult.getConfID());
//			cdruserinfoExit.setTempuserid(userExitConfMsgResult.getUserID());
//			cdruserinfoExit.setMsgtimestamp(userExitConfMsgResult.getTimestamp());
//
//			try {
//				ConferenceBusinessImpl.getCdrUserInfoManager().create(cdruserinfoExit);
//			} catch (Exception e) {
//				dealKeysException(e);
//			}

                break;
            case com.ykh.tang.agent.Consts.ChangeUserRoleMsgResult_key & 0xFFFF:
                // 改变角色成功消息
                LOGGER
                        .info("Tang CMS receive user role change success message!!!!!");

                ChangeUserRoleMsgResult changeUserRoleMsgResult = (ChangeUserRoleMsgResult) msg;

                LOGGER.info("Tang CMS receive user role change success message="
                        + changeUserRoleMsgResult.getConfID() + "|"
                        + changeUserRoleMsgResult.getType() + "|"
                        + changeUserRoleMsgResult.getUserArr().toString() + "|"
                        + changeUserRoleMsgResult.getRoleArr().toString());
                try {
                    //1增加，3替换
                    if (changeUserRoleMsgResult.getType() == 1 || changeUserRoleMsgResult.getType() == 3) {

                    }
                } catch (Exception e) {
                    dealKeysException(e);
                }
                break;
            default:
                break;
        }
    }

//	public void setConferenceManager(IConference conferenceManager) {
//		this.conferenceManager = conferenceManager;
//	}

//	public void setPhoneConferenceReserve(
//			IPhoneConferenceReserve phoneConferenceReserve) {
//		this.phoneConferenceReserve = phoneConferenceReserve;
//	}


    private void dealKeysException(Exception e) {
        Throwable tr = e.getCause();
        if (tr != null && ConstraintViolationException.class.equals(tr.getClass())) {
            //多CMS处理，此为正常异常，不需要提示
        } else {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

}
