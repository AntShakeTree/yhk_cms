package com.ykh.services.conference.impl;

import org.apache.log4j.Logger;

import com.ykh.tang.agent.IMessageHandler;
import com.ykh.tang.agent.message.IMessage;
import com.ykh.tang.agent.message.ServiceOfflineMsgResult;
import com.ykh.tang.agent.message.ServiceOnlineMsgResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("getmessageHandlerByGroup")
public class GetmessageHandlerByGroup implements IMessageHandler {
	private final static Logger LOGGER = Logger.getLogger(GetmessageHandlerByGroup.class);

	@Override
	public void handler(IMessage msg) {
		// 解析消息类型
		int messagetype = msg.getMsgID();

		switch (messagetype) {
			case com.ykh.tang.agent.Consts.ServiceOnlineMsgResult_key&0xFFFF:
				LOGGER.info("Tang CMS receive user group online msg.");

				ServiceOnlineMsgResult userOnlineMsgResult = (ServiceOnlineMsgResult)msg;
				LOGGER.info("user group online msg." + userOnlineMsgResult.getConfID()+"|"+
				userOnlineMsgResult.getServType() + "|" + userOnlineMsgResult.getGroupID() + "|" +
				userOnlineMsgResult.getUserID() + "|" + Consts.ONLINE + "|" + userOnlineMsgResult.getTimestamp());
//
//				Cdrusergroupinfo cdrUserGroupInfo = new Cdrusergroupinfo();
//				cdrUserGroupInfo.setConferenceid(userOnlineMsgResult.getConfID());
//				cdrUserGroupInfo.setUserid(userOnlineMsgResult.getUserID());
//				cdrUserGroupInfo.setGroupid(userOnlineMsgResult.getGroupID());
//				cdrUserGroupInfo.setServicetype(userOnlineMsgResult.getServType());
//				cdrUserGroupInfo.setActiontypeid(Consts.ONLINE);
//				cdrUserGroupInfo.setMsgtimestamp(userOnlineMsgResult.getTimestamp());
//				cdrUserGroupInfo.setReceivetime(new Date());
//
//				try {
//					ConferenceBusinessImpl.getCdrUserGroupInfoManager().create(cdrUserGroupInfo);
//				}catch (Exception e) {
//					if(e.getClass().equals(org.hibernate.exception.ConstraintViolationException.class)){
//						//多CMS处理，此为正常异常，不需要提示
//					}else{
//						e.printStackTrace();
//						LOGGER.error(e.getMessage());
//					}
//				}
//
				break;
			case com.ykh.tang.agent.Consts.ServiceOfflineMsgResult_key&0xFFFF:
				LOGGER.info("Tang CMS receive user group offline msg.");

				ServiceOfflineMsgResult userOfflineMsgResult = (ServiceOfflineMsgResult)msg;

				LOGGER.info("user group offline msg." + userOfflineMsgResult.getConfID()+"|"+
				userOfflineMsgResult.getServType() + "|" + userOfflineMsgResult.getGroupID() + "|" +
				userOfflineMsgResult.getUserID() + "|" + Consts.OFFLINE + "|" + userOfflineMsgResult.getTimestamp());

//				Cdrusergroupinfo cdrUserGroupInfoOffLine = new Cdrusergroupinfo();
//				cdrUserGroupInfoOffLine.setConferenceid(userOfflineMsgResult.getConfID());
//				cdrUserGroupInfoOffLine.setUserid(userOfflineMsgResult.getUserID());
//				cdrUserGroupInfoOffLine.setGroupid(userOfflineMsgResult.getGroupID());
//				cdrUserGroupInfoOffLine.setServicetype(userOfflineMsgResult.getServType());
//				cdrUserGroupInfoOffLine.setActiontypeid(Consts.OFFLINE);
//				cdrUserGroupInfoOffLine.setMsgtimestamp(userOfflineMsgResult.getTimestamp());
//				cdrUserGroupInfoOffLine.setReceivetime(new Date());
//
//				try {
//					ConferenceBusinessImpl.getCdrUserGroupInfoManager().create(cdrUserGroupInfoOffLine);
//				} catch (Exception e) {
//					if(e.getClass().equals(org.hibernate.exception.ConstraintViolationException.class)){
//						//多CMS处理，此为正常异常，不需要提示
//					}else{
//						e.printStackTrace();
//						LOGGER.error(e.getMessage());
//					}
//				}
//
				break;
		}
	}
}
