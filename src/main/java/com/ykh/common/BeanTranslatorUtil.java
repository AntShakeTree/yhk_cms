package com.ykh.common;

import com.ykh.pojo.CtServiceAddr;
import com.ykh.pojo.DtServiceAddr;
import com.ykh.pojo.User;
import com.ykh.tang.agent.vo.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * BeanTranslatorUtil:业务bean翻译工具类，主要负责将一个业务bean转换成另外的业务bean
 *
 * @author Dongyu Zhang
 *         <p/>
 *         Revision History
 * @version 0.0.1
 * @if CR/PR ID Author Date Major Change
 * @endif
 * @bug
 * @see
 */

public class BeanTranslatorUtil {

    /**
     * logger:log4j变量，用于本地日志的输出
     */
    private static final Logger LOGGER = Logger.getLogger(BeanTranslatorUtil.class);

    /**
     * 转换user信息到业务管理需要的userinfo
     * <p/>
     * <p/>
     * <b>Detail:</b>
     * <p/>
     * 适用条件：userinfo对象是业务管理通过dbus生成的对象，user对象是自定义对象，二者结构高度相似，主要转换Integer和UInt
     * <p/>
     * 执行流程：拷贝user对象的每个属性，循环复制到userinfo对象
     * <p/>
     * 使用方法：本方法为静态方法，直接通过类名.copyUser2UserInfo调用
     * <p/>
     * 注意事项：调用过程中需传递IConferenceRole接口
     * <p/>
     *
     * @param user 用户对象
     * @param user IConferenceRole接口
     * @return UserInfo dbus生成的userinfo对象
     * @throws Exception 抛出异常
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public static BMSUserInfo copyUser2UserInfo(User user) throws Exception {

        if (user == null) {
            LOGGER.error("copyUser2UserInfo方法调用，参数为NULL，调用中断，直接返回NULL");
            return null;
        }
        // 转换获得的角色ID信息

//		List<String> roleIdList = new ArrayList<String>();
//		for(Integer roleID : roleidSet) {
//			roleIdList.add(roleID+"");
//		}

        LOGGER.info("userJoin user ip=" + user.getIpaddr());

        // 转换获得的用户信息
        String username = user.getUsername();
        if (username == null) {
            return null;
        }
        // 获得用户外网IP，支持ipv6
        List<String> ipList = new ArrayList<String>();
        if (user.getIpaddr() != null) {
            String[] iplist = user.getIpaddr().split("\\.", -1);
            for (String ip : iplist) {
                ipList.add(ip);
                LOGGER.info("userJoin ip=" + ip);
            }
        }

        BMSUserInfo userInfo = new BMSUserInfo();
        userInfo.setUserID(user.getTempuserid());
        userInfo.setUserName(username);
        userInfo.setClientType(user.getClientType());
        if (user.getPinCode() != null)
            userInfo.setPinCode(user.getPinCode());
        else
            userInfo.setPinCode(0);

        userInfo.setDomain(user.getDomain());
        userInfo.setIPArr(ipList);
        userInfo.setRoleTypeArr(user.getRolemap());

        if (user.getUserStatus() != null)
            userInfo.setStatus(user.getUserStatus());
        return userInfo;

    }

    /**
     *
     * 转换conference信息到业务管理需要的conferenceinfo
     *
     * @param conference
     *            拷贝的会议信息源
     * @param tempConferenceID
     *            临时会议ID
     * @param user
     *            用户对象，可为null，代表没有用户信息
     * @param conferenceRoleManager
     *            角色业务操作接口
     * @return ConferenceInfo dbus生成的会议信息
     * @throws Exception
     *             抛出异常
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @since JDK1.6
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
    //	 */
//	public static ConferenceInfoBMS copyConference2ConferenceInfo(Conference conference, Integer tempConferenceID, User user,
//			IProductRole productRoleManager) throws Exception {
//		// 参数为空判断
//		if (null == conference || null == tempConferenceID || null == productRoleManager) {
//			LOGGER.error("Conference转换到ConferenceInfo方法参数：conference、tempConferenceID、conferenceRoleManager为空！");
//			return null;
//		}
//
////		Date startTime = conference.getStarttime();
////		Calendar calendar = Calendar.getInstance();
////		//支持即时会议
////	//	if(startTime == null && conference.getIfpasswordfixed() != null && conference.getIfpasswordfixed())
////			startTime = new Date();
////		calendar.setTime(startTime);
////
////		Integer duration = conference.getConferenceminutes();
////		if(duration != null && duration.intValue() >0) {
////			calendar.add(Calendar.MINUTE, +duration);
////		}
////
////		Date endTime = calendar.getTime();
////
////		// 获得会议配置信息
////		List<String> conferenceConfigs = new ArrayList<String>();
////		Integer uservalueset = conference.getConferenceminutes();
//////		for (Conferenceuservalue uservalue : uservalueset) {
//////			conferenceConfigs.add(uservalue.getValue()+"");
//////		}
////
////		String roleArray = "";
////		List<String> rolesInteger = new ArrayList<String>();
////		if(conference.getRoles() != null && !"".equals(conference.getRoles())) {
////			//roleArray = conference.getRoles();
////			for(String role : roleArray.split(",",-1)) {
////				rolesInteger.add(role);
////			}
////		}
//
//		ConferenceInfoBMS confInfo = new ConferenceInfoBMS();
//		List<RoleInfo> roleinfoList = new ArrayList<RoleInfo>();
//		// 获得会议角色信息,无论有没有用户
////		Set<ProductRole> confRoles = conference.getProduct().getProductroles();
////		List<Integer> roleIdList = new ArrayList<Integer>();
////		for (ProductRole confrole : confRoles) {
////			roleIdList.add(((Object) confrole.getRole()).getRoleid());
////		}
////
////		Integer productID = (conference.getProduct()).getProductid();
////		Map<Integer, List<Integer>> privilegemap = productRoleManager.queryAllRolePrivileges(productID, roleIdList);
////		for (Map.Entry<Integer, List<Integer>> entry : privilegemap.entrySet()) {
////			List<String> templist = new ArrayList<String>();
////			for(Integer privs : entry.getValue()) {
////				templist.add(privs+"");
////			}
////			ProductRole role = productRoleManager.getProductRole(productID, entry.getKey());
////			RoleInfo roleInfo = new RoleInfo();
////			if (role == null) {
////				roleInfo.setRoleType(entry.getKey());
////				roleInfo.setMaxUser(1);
////				roleInfo.setServPrivArr(templist);
////			}else{
////				roleInfo.setRoleType(entry.getKey());
////				roleInfo.setMaxUser(role.getMaxuser());
////				roleInfo.setServPrivArr(templist);
////			}
////			roleinfoList.add(roleInfo);
////		}
////		// 如果有用户信息
////		if (null != user) {
////			// 获得用户信息
////			List<Byte> nameByte = new ArrayList<Byte>();// 用户名byte数组
////			String username = user.getUserName();
////			if (username == null) {
////				return null;
////			}
////			byte[] usernameBytes = username.getBytes();
////			for (int i = 0; i < usernameBytes.length; i++) {
////				nameByte.add(usernameBytes[i]);
////			}
////			// 初始化子会议能力配置
////			// 获得用户外网IP，支持ipv6
////			List<Long> iplist = new ArrayList<Long>();
////			iplist.add(new Long(IPTranslatorUtil.ipToLong(user.getIpaddr())));
////
////		} else {
////			// 如果没有用户信息,roleinfoList.size()为0
////			// 初始化子会议能力配置
////			// 初始化子会议能力配置
////		}
////
////		SubConferenceInfo subconf = new SubConferenceInfo();
////		subconf.setRoleInfoArr(roleinfoList);
////		subconf.setServiceConfigArr(conferenceConfigs);
////		confInfo.setSubConference(subconf);
////
////		AutoStopParams stopParams = new AutoStopParams();
////		Integer time1 = 0;
////		if(conference.getTime1() != null) {
////			time1 = conference.getTime1() * 60;
////		}
////		Integer time2 = 0;
////		if(conference.getTime2() != null) {
////			time2 = conference.getTime2() * 60;
////		}
////		stopParams.setRoles(rolesInteger);
////		stopParams.setTime1(time1);
////		stopParams.setStopwhenoneuser(conference.isStopwhenoneuser());
////		stopParams.setTime2(time2);
////
////		confInfo.setConfID(tempConferenceID);
////		confInfo.setName(conference.getConferencename());
////		confInfo.setBillingCode(conference.getBillingcode());
////		confInfo.setPassword(conference.getPassword());
////		long startTimeSeconds = startTime.getTime() / 1000;
////		int planStartTime0 = (int) (startTimeSeconds & 0xFFFFFFFF);
////		int planStartTime1 = (int) (startTimeSeconds >> 32 & 0xffffffff);
////		confInfo.setPlanStartTime0(planStartTime0);
////		confInfo.setPlanStartTime1(planStartTime1);
////		long endTimeSeconds = 0;
////		if(!( conference.getIfpasswordfixed()))
////		{
////			endTimeSeconds = endTime.getTime() / 1000;
////		}
////		int planStopTime0 = (int) (endTimeSeconds & 0xFFFFFFFF);
////		int planStopTime1 = (int) (endTimeSeconds >> 32 & 0xffffffff);
////		confInfo.setPlanStopTime0(planStopTime0);
////		confInfo.setPlanStopTime1(planStopTime1);
////		confInfo.setConfScale(conference.getConfscale());
////		confInfo.setRoleInfo(roleinfoList);
////		confInfo.setServiceConfigs(conferenceConfigs);
////		confInfo.setStopParams(stopParams);
//		return confInfo;
//	}

    /**
     * 提取UserServiceAddr列表中DtServiceAddr信息（数据传输服务器地址对象）
     *
     * @param userservicelist UserServiceAddr列表
     * @return List<DtServiceAddr> 数据传输地址列表
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public static List<DtServiceAddr> copyUserServiceAddr2DtServiceAddr(List<UserServiceAddr> userservicelist) {
        // 参数为空判断
        if (userservicelist == null || userservicelist.isEmpty()) {
            return null;
        }
        List<DtServiceAddr> dtsddrlist = new ArrayList<DtServiceAddr>();
        for (UserServiceAddr usaddr : userservicelist) {
            dtsddrlist.add(new DtServiceAddr(IPTranslatorUtil.longToIP(usaddr.getServerIP0()), usaddr.channel, usaddr.serviceType, usaddr.groupID));
        }
        return dtsddrlist;
    }

    /**
     * 提取UserServiceAddr列表中CtServiceAddr信息（接入服务器地址对象）
     *
     * @param userservicelist UserServiceAddr列表
     * @return List<CtServiceAddr> 接入服务器地址列表
     * @code {这里可以添加函数调用示例代码}
     * @endcode
     * @par 需求:REQ1.10[Tang]: svn://vobserver/tang/doc/SRS.doc
     * @see
     * @since JDK1.6
     */
    public static List<CtServiceAddr> copyUserServiceAddr2CtServiceAddr(List<UserServiceAddr> userservicelist) {
        // 参数为空判断
        if (userservicelist == null || userservicelist.isEmpty()) {
            return null;
        }
        List<CtServiceAddr> ctsddrlist = new ArrayList<CtServiceAddr>();
        for (UserServiceAddr usaddr : userservicelist) {
            ctsddrlist.add(new CtServiceAddr(IPTranslatorUtil.longToIP(usaddr.getServerIP0()), IPTranslatorUtil
                    .longToIP(usaddr.getHotServerIP0()), usaddr.channel, usaddr.serviceType, usaddr.groupID));
        }
        return ctsddrlist;
    }

    public static void copyConferenceBillInfo(ConferenceBillInfoBMS billInfo, ConferenceInfoBMS info) {
        billInfo.setBillingCode(info.getBillingCode());
        billInfo.setConfID(info.getConfID());
        billInfo.setConfScale(info.getConfScale());
        billInfo.setName(info.getName());
        billInfo.setPassword(info.getPassword());
        billInfo.setPlanStartTime0(info.getPlanStartTime0());
        billInfo.setPlanStartTime1(info.getPlanStartTime1());
        billInfo.setPlanStopTime0(info.getPlanStopTime0());
        billInfo.setPlanStopTime1(info.getPlanStopTime1());
        billInfo.setRoleInfo(info.getRoleInfo());
        billInfo.setServiceConfigs(info.getServiceConfigs());
        billInfo.setStatus(info.getStatus());
        billInfo.setStopParams((AutoStopParams) info.getStopParams());
        billInfo.setSubConference(info.getSubConference());
    }

    public static void copyUserBillInfo(BMSUserBillInfo billInfo, BMSUserInfo info) {
        billInfo.setClientType(info.getClientType());
        billInfo.setDomain(info.getDomain());
        billInfo.setIPArr(info.getIPArr());
        billInfo.setPinCode(info.getPinCode());
        billInfo.setRoleTypeArr(info.getRoleTypeArr());
        billInfo.setStatus(info.getStatus());
        billInfo.setUserID(info.getUserID());
        billInfo.setUserName(info.getUserName());
    }

}
