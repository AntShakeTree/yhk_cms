package com.ykh;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import com.ykh.common.BeanTranslatorUtil;
import com.ykh.common.Session;
import com.ykh.dao.conference.domain.Conference;


import com.ykh.pojo.User;
import com.ykh.tang.agent.excep.CMSException;
import com.ykh.tang.agent.message.ConfStartMsgResult;
import com.ykh.tang.agent.vo.*;
import com.ykh.vo.body.ConferenceSeedBody;
import org.junit.Test;
import org.w3c.dom.ls.LSException;

import javax.net.ssl.SSLServerSocket;
import java.util.*;

public class PushServiceTest {
	PushService pushService=new PushService();

	@Test
	public void createConference(){
		Conference conference =new Conference();
		conference.setConferenceId(28);
		conference.setConferencename("潘足迹");
		conference.setPassword("xxx");
		System.out.print(pushService.push("http://devyt.xiezuoyun.cn:8080/ykh_cms_v01/","conference/createConference",conference));
	}

	@Test
	public void opeanConference(){
		Conference conference =new Conference();
		ConferenceInfoBMS bms =getTestConferenceInfo();
		conference.setPassword(bms.getPassword());
		conference.setConferencename(bms.getName());
		conference.setAutoStopParams((AutoStopParams) bms.getStopParams());
		conference.setBillingcode("753053");
		conference.setConfScale(bms.getConfScale());
		conference.setPassword(bms.getPassword());
		conference.setServiceConfigs(bms.getServiceConfigs());

		conference.setRuleInfos(bms.getRoleInfo());
		System.out.print(JSON.toJSONString(conference));
		System.out.print(pushService.push("http://devyt.xiezuoyun.cn:8080/ykh_cms_v01/","conference/openConference",conference));
	}
	@Test
	public void modifyConference(){
		Conference conference =new Conference();

		conference.setConferencename("潘");
		conference.setPassword("xxx");
		System.out.print(pushService.push("http://devyt.xiezuoyun.cn:8080/ykh_cms_v01/","conference/modifyConference",conference));
	}
	@Test
	public   void startConf(){
		ConferenceSeedBody conferenceSeedBody =new ConferenceSeedBody();
		conferenceSeedBody.setTempConferenceId(5701632);
		System.out.print(pushService.push("http://devyt.xiezuoyun.cn:8080/ykh_cms_v01/","conference/startConference",conferenceSeedBody));
	}
	@Test
	public  void stopConference(){
		ConferenceSeedBody conferenceSeedBody =new ConferenceSeedBody();
		conferenceSeedBody.setTempConferenceId(3932160);
		System.out.print(pushService.push("http://devyt.xiezuoyun.cn:8080/ykh_cms_v01/","conference/stopConference",conferenceSeedBody));
	}
	@Test
	public  void joinConference() throws Exception {

//		BeanTranslatorUtil.copyUser2UserInfo(this.buildUser());

		System.out.print(pushService.push("http://devyt.xiezuoyun.cn:8080/ykh_cms_v01/","conference/joinConference",this.buildUser()));
	}

	public static ConferenceInfoBMS getTestConferenceInfo() {
		// create conference without user
		List<String> servicetypelist = new ArrayList<String>();
		servicetypelist.add("775");
		servicetypelist.add("776");

		ConferenceInfoBMS confInfo = new ConferenceInfoBMS();
		confInfo.setBillingCode("753053");
		confInfo.setName("test");
		confInfo.setPassword("");
		confInfo.setPlanStartTime0(0);
		confInfo.setPlanStartTime1(0);
		confInfo.setConfID(0xfffffe00);
		confInfo.setConfScale(200);
		List<String> servconfarr = new ArrayList<String>();
		servconfarr.add("0x2e03001f");
		servconfarr.add("0x1400000f");
		servconfarr.add("0xe031fff");
		servconfarr.add("0x5e03000f");
		servconfarr.add("0x5d000001");
		servconfarr.add("0xc000007");
		servconfarr.add("0x12000010");
		servconfarr.add("0x1600000e");
		servconfarr.add("0x52000001");
		servconfarr.add("0x36000010");
		servconfarr.add("0x1100000f");
		servconfarr.add("0x9f000001");
		servconfarr.add("0x3d000001");
		servconfarr.add("0x42000010");
		servconfarr.add("0x8f000001");
		servconfarr.add("0x1e0300ff");
		servconfarr.add("0x1");
		servconfarr.add("0x8e0300ff");
		servconfarr.add("0xa000001");
		servconfarr.add("0x1d000001");
		servconfarr.add("0x40003ff");
		servconfarr.add("0x9100000f");
		servconfarr.add("0x37000001");
		servconfarr.add("0x5f000000");
		servconfarr.add("0x41000003");
		servconfarr.add("0x3e01801f");
		servconfarr.add("0x90000001");
		servconfarr.add("0x54000007");
		servconfarr.add("0xd0000001");
		servconfarr.add("0x2000002");
		servconfarr.add("0xd000001");
		servconfarr.add("0x35000003");
		servconfarr.add("0x40000001");
		servconfarr.add("0x4d000001");
		servconfarr.add("0x23000032");
		servconfarr.add("0x4b0307ff");
		servconfarr.add("0x100000f");
		servconfarr.add("0x3f000001");
		servconfarr.add("0xde000fff");
		servconfarr.add("0x5000010");
		servconfarr.add("0x4c0307ff");
		servconfarr.add("0x8d000001");
		servconfarr.add("0x9e0301ff");
		servconfarr.add("0x330012c0");
		servconfarr.add("0x9000000");
		servconfarr.add("0x8100000f");
		servconfarr.add("0x26000001");
		servconfarr.add("0x10000001");
		servconfarr.add("0x82000000");
		servconfarr.add("0x53000001");
		servconfarr.add("0x50000001");
		servconfarr.add("0x51000007");
		servconfarr.add("0x2f000001");
		servconfarr.add("0x4a000007");
		servconfarr.add("0x20000001");
		servconfarr.add("0x15000007");
		servconfarr.add("0x24000001");
		servconfarr.add("0x6000007");
		servconfarr.add("0x20000001");
		servconfarr.add("0x15000007");
		servconfarr.add("0x24000001");
		servconfarr.add("0x6000007");
		servconfarr.add("0x221fffff");
		servconfarr.add("0x21000003");
		servconfarr.add("0x30000001");
		servconfarr.add("0x13000010");
		servconfarr.add("0x300000f");
		servconfarr.add("0x2d000001");
		servconfarr.add("0x32000007");
		servconfarr.add("0x80000001");
		servconfarr.add("0x9d000001");
		servconfarr.add("0x4f000001");
		servconfarr.add("0x92000001");
		servconfarr.add("0xb00000f");
		servconfarr.add("0x1f000001");
		servconfarr.add("0xf000001");
		servconfarr.add("0x270007d0");
		servconfarr.add("0x2500ffff");
		servconfarr.add("0x4e0307ff");
		servconfarr.add("0x31000007");
		servconfarr.add("0xde000fff");

		confInfo.setServiceConfigs(servconfarr);

		List<RoleInfo> roleinfoarr = new ArrayList<RoleInfo>();
		RoleInfo role1 = new RoleInfo();
		role1.roleType = 1;
		role1.maxUser = 100;
		List<String> privs = new ArrayList<String>();
		privs.add("0x4e0307df");
		privs.add("0xe031fff");
		privs.add("0x1e03ffff");
		privs.add("0xde001fff");
		privs.add("0x3e03001f");
		privs.add("0x5e03000f");
		privs.add("0x8e0300ff");
		privs.add("0x9e0301ff");
		privs.add("0x2e03001f");
		privs.add("0x4b0307df");
		privs.add("0x4c0307df");
		role1.setServPrivArr(privs);

		RoleInfo role2 = new RoleInfo();
		role2.roleType = 2;
		role2.maxUser = 100;
		List<String> privs2 = new ArrayList<String>();
		privs2.add("0x4e0307ff");
		privs2.add("0xe031fff");
		privs2.add("0x1e0300ff");
		privs2.add("0xde000fff");
		privs2.add("0x3e03001f");
		privs2.add("0x5e03000f");
		privs2.add("0x8e0300ff");
		privs2.add("0x9e0301ff");
		privs2.add("0x2e03001f");
		privs2.add("0x4b0307df");
		privs2.add("0x4c0307df");
		role2.setServPrivArr(privs2);

		RoleInfo role3 = new RoleInfo();
		role3.roleType = 3;
		role3.maxUser = 100;
		List<String> privs3 = new ArrayList<String>();
		privs3.add("0xe031fff");
		privs3.add("0x1e0300ff");
		privs3.add("0xde000fff");
		privs3.add("0x4e0307df");
		privs3.add("0x3e03001f");
		privs3.add("0x5e03000f");
		privs3.add("0x8e0300ff");
		privs3.add("0x9e0301ff");
		privs3.add("0x2e03001f");
		privs3.add("0x4b0307df");
		privs3.add("0x4c0307df");
		role3.setServPrivArr(privs3);

		RoleInfo role4 = new RoleInfo();
		role4.roleType = 4;
		role4.maxUser = 100;
		List<String> privs4 = new ArrayList<String>();
		privs4.add("0x4e0307df");
		privs4.add("0xe000002");
		privs4.add("0x1e0000e0");
		privs4.add("0xde000000");
		privs4.add("0x3e01801f");
		role4.setServPrivArr(privs4);

		roleinfoarr.add(role1);
		roleinfoarr.add(role2);
		roleinfoarr.add(role3);
		roleinfoarr.add(role4);

		confInfo.setRoleInfo(roleinfoarr);

		SubConferenceInfo subConfInfo = new SubConferenceInfo();
		List<String> subServConfArr = new ArrayList<String>();
		subConfInfo.setServiceConfigArr(subServConfArr);
		List<RoleInfo> subRoleInfoArr = new ArrayList<RoleInfo>();
		subConfInfo.setRoleInfoArr(subRoleInfoArr);
		// SubConferenceInfo subConfInfo = null;
		confInfo.setSubConference(subConfInfo);

		AutoStopParams stopParams = new AutoStopParams();
		List<String> roles = new ArrayList<String>();
		roles.add("1");roles.add("2");

		stopParams.setRoles(roles);
		stopParams.setStopwhenoneuser(false);

		stopParams.setTime1(45);
		stopParams.setTime2(45);
		confInfo.setStopParams(stopParams);

		BMSUserInfo userInfo = new BMSUserInfo();
		userInfo.clientType = 2;
		userInfo.domain = 1;
		List<String> listIp = new ArrayList<String>();
		listIp.add("0");
		listIp.add("0");
		listIp.add("0");
		listIp.add("0");
		userInfo.setIPArr(listIp);
		userInfo.pinCode = 111;

		List<String> roletypes = new ArrayList<String>();
		System.out.println("roletype = 1");
		roletypes.add("1");
		userInfo.setRoleTypeArr(roletypes);

		userInfo.status = 0;
		userInfo.setUserID(9999999);
		userInfo.userName = "dasha";

		// create conference
		System.out
				.println("---------------- create conference without user ---------------");
		// test.createConferenceWithoutUser(1, confInfo, servicetypelist);

		System.out
				.println("---------------- create conference with user ---------------");




		// update conference service configs
		// List<String> newservconfarr = new ArrayList<String>();
		// newservconfarr.add("0x2e03001f");
		// test.updateServiceConfigs(1, 0xfffffe00, 9999999, newservconfarr);

		// start conference
		System.out
				.println("---------------- start conference  ---------------");

		// System.out.println("---------------- start conference with user ---------------");
		// test.startConferenceWithUser(1, 0xfffffe00, userInfo);

		// get conference information
		System.out
				.println("---------------- get conference information ---------------");

		// add new user
		System.out.println("---------------- add new user ---------------");
		BMSUserInfo newuser = new BMSUserInfo();
		newuser.clientType = 2;
		newuser.domain = 1;
		List<String> listIp2 = new ArrayList<String>();
		listIp2.add("0");
		listIp2.add("0");
		listIp2.add("0");
		listIp2.add("0");
		newuser.setIPArr(listIp2);
		newuser.pinCode = 111;

		List<String> newroletypes = new ArrayList<String>();
		System.out.println("roletype = 1");
		newroletypes.add("1");
		newuser.setRoleTypeArr(newroletypes);

		newuser.status = 0;
		newuser.setUserID(8888888);
		newuser.userName = "bb";
		System.out.println("userid = " + newuser.getUserID());



		// get user list

		// update conference service configs
		// System.out.println("---------------- update config ---------------");
		// List<String> newconfarr = new ArrayList<String>();
		// newconfarr.add("0x2e03001f");
		// newconfarr.add("0x1400000f");
		// newconfarr.add("0xe031fff");
		// newconfarr.add("0xffffffff");
		// test.updateServiceConfigs(1, 0xfffffe00, 9999999, newconfarr);

		// black user
		System.out.println("---------------- black user ---------------");
		List<String> blackUsers = new ArrayList<String>();
		blackUsers.add("8888888");
		blackUsers.add("9999999");


		// unblack user
		System.out.println("---------------- unblack user ---------------");
		List<String> unblackUsers = new ArrayList<String>();
		unblackUsers.add("8888888");
		unblackUsers.add("9999999");



		// exit user
		System.out.println("---------------- exit user ---------------");



		// delete user
		System.out.println("---------------- delete user ---------------");
		List<String> users = new ArrayList<String>();
		users.add("8888888");
		users.add("9999999");


		// get user list


		// sys lock conference
		System.out
				.println("---------------- sys lock conference ---------------");


		// user join conference
		System.out
				.println("---------------- user join conference fail---------------");



		// user join conference
		System.out
				.println("---------------- sys unlock conference---------------");


		// user join conference
		System.out
				.println("---------------- user join conference success---------------");
		BMSUserInfo nuser = new BMSUserInfo();
		nuser.clientType = 2;
		nuser.domain = 1;
		List<String> listIp3 = new ArrayList<String>();
		listIp3.add("0");
		listIp3.add("0");
		listIp3.add("0");
		listIp3.add("0");
		nuser.setIPArr(listIp3);
		nuser.pinCode = 111;

		List<String> nroletypes = new ArrayList<String>();
		System.out.println("roletype = 1");
		nroletypes.add("1");
		nuser.setRoleTypeArr(nroletypes);

		nuser.status = 0;
		nuser.setUserID(7777777);
		nuser.userName = "cc";
		System.out.println("userid = " + nuser.getUserID());



		// start service
		System.out.println("---------------- start service ---------------");


		// stop service
		System.out.println("---------------- stop service ---------------");

		// user lock
		System.out.println("---------------- user lock ---------------");


		// change role
		System.out.println("---------------- change role ---------------");
		List<String> userArr = new ArrayList<String>();
		userArr.add("7777777");
		// userArr.add("9999999");

		List<String> newRoleArr = new ArrayList<String>();
		newRoleArr.add("2");
		// newRoleArr.add("3");

		// op: 1:add 2:del 3:modify

		System.out.println("change role..........");

		// user lock
		System.out.println("---------------- user unlock ---------------");


		// op: 1:add 2:del 3:modify

		System.out.println("change role..........");

		// stop conference
		System.out.println("---------------- stop conference ---------------");


		// delete conference
		System.out
				.println("---------------- delete conference ---------------");




		// System.out

		// agent销毁
		return confInfo;
	}
	private User buildUser() {

		List<String> rolemap = Lists.newArrayList();
		rolemap.add("1");
		rolemap.add("2");
//		rolemap.put(4);
//		rolemap.put(5, new ArrayList<Integer>());
//		rolemap.put(10, new ArrayList<Integer>());
//		rolemap.put(11, new ArrayList<Integer>());
//		rolemap.put(12, new ArrayList<Integer>());
//		rolemap.put(13, new ArrayList<Integer>());
//		rolemap.put(14, new ArrayList<Integer>());

		User user = new User();

		user.setTempConferenceId(5701632);
		user.setUsername("liming");
		user.setUserStatus(0);
		user.setClientType(2);
		user.setPinCode(1234);
		user.setDomain(1);
		user.setIsowner(true);
		user.setRolemap(rolemap);
		user.setIpaddr("192.168.13.99");

		return user;
	}
	@Test
	public void testUserChannel(){
		UserChannel userChannel =new UserChannel();

		UserServiceAddr userServiceAddr=new UserServiceAddr();
		userServiceAddr.setServerIP0(1);
		userServiceAddr.setServerIP1(3);
		userServiceAddr.setServerIP2(2);
		userServiceAddr.setServerIP2(3);

		List<UserServiceAddr> l=Lists.newArrayList();
		l.add(userServiceAddr);
		userChannel.setCtsAddr(l);
		System.out.print(JSON.toJSONString(userChannel));
	}
	@Test
	public void testSession(){
		Session.setCache("123", 123);
		System.out.print(Session.getCache("123", Integer.class));
	}
}
