package com.ykh.tang.agent;

import com.ykh.tang.agent.excep.CMSException;
import com.ykh.tang.agent.message.ConfStartMsgResult;
import com.ykh.tang.agent.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ICMSAgentImpl implements ICMSAgentInterface {
    @Autowired
    private ICMSAgent icmsAgent;

    // 3
    @Override
    public ConferenceInfoBMS getConfInfo(int site, int confID)
            throws CMSException {
        ConferenceInfoBMS conferenceInfoBMS = new ConferenceInfoBMS();
        icmsAgent.getConfInfo(site, confID, conferenceInfoBMS);

        return conferenceInfoBMS;
    }

    // 4
    @Override
    public List<BMSUserInfo> getUserList(int site, int confID)
            throws CMSException {
        List<BMSUserInfo> userList = new ArrayList<BMSUserInfo>();

        icmsAgent.getUserList(site, confID, userList);

        return userList;
    }

    /**
     * // 7 public int updateServiceConfigs(int site, int confID, int userID,
     * List<String> servConfArr) { try {
     *
     * int result = icmsAgent.updateServiceConfigs(site, confID, userID,
     * servConfArr);
     *
     * return result; } catch (CMSException e) { e.printStackTrace();
     *
     * // 异常 return -1; } }
     */

    /**
     * // 8 ------不用测试------- public int userExitSubConference(int site, int
     * confID, int op) { try { int target = 0;
     *
     * int result = icmsAgent.userExitSubConference(site, confID,op,target);
     *
     * if (result >= 0) { // 成功 return target; } else { // 失败 return 0; } }
     * catch (CMSException e) { e.printStackTrace();
     *
     * // 异常 return 0; } }
     */

    /**
     * // 9 ------不用测试------- public UserChannel userJoinSubConference(int site,
     * int confID, int op, int target, List rolesArr) { try { UserChannel
     * userchannel = new UserChannel();
     * <p/>
     * int result = icmsAgent.userJoinSubConference(site, confID, op, target,
     * rolesArr, userchannel);
     * <p/>
     * if (result >= 0) { // 成功 return userchannel; } else { // 失败 return null;
     * } } catch (CMSException e) { e.printStackTrace();
     * <p/>
     * // 异常 return null; } }
     *
     * @throws CMSException
     */

    // 10
    @Override
    public void changeRole(int site, int confID, int op, List<String> userArr,
                           List<String> newRoleArr) throws CMSException {
        icmsAgent.changeRole(site, confID, op, userArr, newRoleArr);
    }

    // 11
    @Override
    public void expelUser(int site, int confID, List<String> userIDArr)
            throws CMSException {

        icmsAgent.expelUser(site, confID, userIDArr);
    }

    // 12
    @Override
    public void unblackUser(int site, int confID, List<String> userIDArr)
            throws CMSException {

        icmsAgent.unblackUser(site, confID, userIDArr);
    }

    // 13
    @Override
    public void blackUser(int site, int confID, List<String> userIDArr)
            throws CMSException {

        icmsAgent.blackUser(site, confID, userIDArr);
    }

    // 14
    @Override
    public void userExitConference(int site, int confID, int userID)
            throws CMSException {

        icmsAgent.userExitConference(site, confID, userID, new Object());
    }

    // 15
    @Override
    public UserChannel userJoinConference(int site, int confID,
                                          BMSUserInfo userInfo) throws CMSException {
        UserChannel channel = new UserChannel();
        icmsAgent.userJoinConference(site, confID, userInfo, channel);

        return channel;
    }

    /**
     * // 16 ------不用测试------- public int deleteSubConference(int site, int
     * confID) { int userID = 0;
     * <p/>
     * try { return icmsAgent.deleteSubConference(site, confID, userID); } catch
     * (CMSException e) { e.printStackTrace(); return 0; } }
     * <p/>
     * // 17 ------不用测试------- public int createSubConference(int site, int
     * confID) { int userID = 0;
     * <p/>
     * try { return icmsAgent.createSubConference(site, confID, userID); } catch
     * (CMSException e) { e.printStackTrace(); return 0; } }
     *
     * @throws CMSException
     */
    // 18
    @Override
    public void userLockConference(int site, int confID) throws CMSException {
        icmsAgent.userLockConference(site, confID, new Object());
    }

    // 19
    @Override
    public void userUnlockConference(int site, int confID) throws CMSException {
        icmsAgent.userUnlockConference(site, confID, new Object());
    }

    // 20
    @Override
    public void sysUnlockConference(int site, int confID) throws CMSException {
        icmsAgent.sysUnlockConference(site, confID, new Object());
    }

    // 21
    @Override
    public void sysLockConference(int site, int confID) throws CMSException {
        icmsAgent.sysLockConference(site, confID, new Object());
    }

    // 22
    @Override
    public void stopConferenceWithoutUser(int site, int confID)
            throws CMSException {
        icmsAgent.stopConferenceWithoutUser(site, confID, new Object());
    }

    // 23
    @Override
    public void deleteConferenceWithoutUser(int site, int confID)
            throws CMSException {

        icmsAgent.deleteConferenceWithoutUser(site, confID, new Object());
    }

    // 24
    @Override
    public void startConferenceWithoutUser(int site, int confID)
            throws CMSException {
        icmsAgent.startConferenceWithoutUser(site, confID, new Object());
    }

    // 25
    @Override
    public UserChannel startConferenceWithUser(int site, int confID,
                                               BMSUserInfo userInfo) throws CMSException {
        UserChannel userchannel = new UserChannel();

        icmsAgent.startConferenceWithUser(site, confID, userInfo, userchannel);
        return userchannel;

    }

    // 26 创建会议，不带用户。该方法直接提供给系统管理员调用。
    @Override
    public void createConferenceWithoutUser(int site,
                                            ConferenceInfoBMS confInfo, List<String> typeArr)
            throws CMSException {
        icmsAgent.createConferenceWithoutUser(site, confInfo, typeArr);
    }

    // 27
    @Override
    public UserChannel createConferenceWithUser(int site,
                                                ConferenceInfoBMS confInfo, BMSUserInfo userInfo,
                                                List<String> typeArr) throws CMSException {
        UserChannel userchannel = new UserChannel();

        icmsAgent.createConferenceWithUser(site, confInfo, userInfo, typeArr,
                userchannel);

        return userchannel;

    }

    // 28
    @Override
    public void startService(int site, int confID, int serviceType)
            throws CMSException {

        icmsAgent.startService(site, confID, serviceType, new Object());
    }

    // 29
    @Override
    public void stopService(int site, int confID, int serviceType)
            throws CMSException {

        icmsAgent.stopService(site, confID, serviceType, new Object());
    }

    /**
     * // 30 public int startRecord(int site, ConferenceInfoBMS confInfo) { int
     * serviceType=0;
     *
     * try { return icmsAgent.startRecord(site, confInfo, serviceType); } catch
     * (CMSException e) {
     *
     * e.printStackTrace(); return 0; } }
     *
     * // 31 public int stopRecord(int site, ConferenceInfoBMS confInfo) { int
     * serviceType=0;
     *
     * try { return icmsAgent.stopRecord(site, confInfo, serviceType); } catch
     * (CMSException e) {
     *
     * e.printStackTrace(); return 0; } }
     */
    /**
     * // 32 public BMSConferenceInfo getBMSConferenceInfo(int site, int confID)
     * { BMSConferenceInfo confInfo = new BMSConferenceInfo();
     *
     * try { int result = icmsAgent.getBMSConferenceInfo(site, confID,
     * confInfo);
     *
     * if (result >= 0) { // 成功 return confInfo; } else { // 失败 return null; } }
     * catch (CMSException e) {
     *
     * e.printStackTrace(); return null; } }
     */
    /**
     * // 33 public List getBMSConferenceUserList(int site, int confID) { List
     * userInfoArr = new ArrayList();
     * <p/>
     * try { int result = icmsAgent.getBMSConferenceUserList(site, confID,
     * userInfoArr);
     * <p/>
     * if (result >= 0) { // 成功 return userInfoArr; } else { // 失败 return null;
     * } } catch (CMSException e) {
     * <p/>
     * e.printStackTrace();
     * <p/>
     * return null; } }
     *
     * @throws CMSException
     */
    // 34 根据临时会议ID和临时用户ID查询该用户在该会议中的状态
    @Override
    public UserConferenceStatus getUserConferenceStatus(int site, int confID,
                                                        int userID) throws CMSException {
        UserConferenceStatus userConferenceStatus = new UserConferenceStatus();

        icmsAgent.getUserConferenceStatus(site, confID, userID, userConferenceStatus);

        return userConferenceStatus;
    }

    public void agentInit() {
        icmsAgent.agentInit();
    }

    @Override
    public void agentDestroy() {
        icmsAgent.agentDestroy();
    }

    public void agentDestory() {
        icmsAgent.agentDestroy();
    }

    public Object getObject(int clsid) {
        return icmsAgent.getStructInstance(clsid);
    }

    public void pUserList(int site, int confID) throws CMSException {
        System.out.println("---------------- get user list ---------------");
        List<BMSUserInfo> userlist = getUserList(1, 0xfffffe00);
        if (userlist != null && userlist.size() > 0) {
            for (int i = 0; i < userlist.size(); i++) {
                System.out.println("----------------");
                System.out.println("client type : "
                        + userlist.get(i).getClientType());
                System.out.println(" user id : " + userlist.get(i).getUserID());
                System.out.println(" user name : "
                        + userlist.get(i).getUserName());
            }
        }
    }

    public static void main(String[] args) throws CMSException {
        ICMSAgentImpl test = new ICMSAgentImpl();

        // agent初始化
        test.agentInit();

        try {
            System.out.print("Input anything to start:");
            System.console().readLine();
            // System.in.read(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Continue Now ...");

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
        stopParams.setRoles(roles);
        stopParams.setStopwhenoneuser(false);
        stopParams.setTime1(0);
        stopParams.setTime2(0);
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
        UserChannel userchannel = test.createConferenceWithUser(1, confInfo,
                userInfo, servicetypelist);
        System.out.println("userid:" + userchannel.getUserID());
//		if (userchannel.getCtsAddr() != null) {
//			int size =( (List<UserServiceAddr>)(userchannel.getCtsAddr())).size();
//			System.out.println("ctsaddr size :" + size);
//			if (size > 0)
//				System.out.println("cts addr: "
//						+ userchannel.getCtsAddr().get(0).getGroupID());
//		}
//
//		if (userchannel.getDtsAddr() != null) {
//			int size = userchannel.getDtsAddr().size();
//			System.out.println("dtsaddr size :" + size);
//			if (size > 0)
//				System.out.println("dts addr: "
//						+ userchannel.getDtsAddr().get(0).getGroupID());
//		}

        // update conference service configs
        // List<String> newservconfarr = new ArrayList<String>();
        // newservconfarr.add("0x2e03001f");
        // test.updateServiceConfigs(1, 0xfffffe00, 9999999, newservconfarr);

        // start conference
        System.out
                .println("---------------- start conference  ---------------");
        test.startConferenceWithoutUser(1, 0xfffffe00);
        // System.out.println("---------------- start conference with user ---------------");
        // test.startConferenceWithUser(1, 0xfffffe00, userInfo);

        // get conference information
        System.out
                .println("---------------- get conference information ---------------");
        ConferenceInfoBMS newconfInfo = test.getConfInfo(1, 0xfffffe00);
        System.out.println("conf id : " + newconfInfo.getConfID());
        System.out.println("name : " + newconfInfo.getName());
        System.out.println("rote type "
                + newconfInfo.getRoleInfo().get(0).getRoleType());

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
        test.userJoinConference(1, 0xfffffe00, newuser);

        // get user list
        test.pUserList(1, 0xfffffe00);

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
        test.blackUser(1, 0xfffffe00, blackUsers);
        test.pUserList(1, 0xfffffe00);

        // unblack user
        System.out.println("---------------- unblack user ---------------");
        List<String> unblackUsers = new ArrayList<String>();
        unblackUsers.add("8888888");
        unblackUsers.add("9999999");
        test.unblackUser(1, 0xfffffe00, unblackUsers);
        test.pUserList(1, 0xfffffe00);

        // exit user
        System.out.println("---------------- exit user ---------------");
        test.userExitConference(1, 0xfffffe00, 9999999);
        test.pUserList(1, 0xfffffe00);

        // delete user
        System.out.println("---------------- delete user ---------------");
        List<String> users = new ArrayList<String>();
        users.add("8888888");
        users.add("9999999");
        test.expelUser(1, 0xfffffe00, users);

        // get user list
        test.pUserList(1, 0xfffffe00);

        // sys lock conference
        System.out
                .println("---------------- sys lock conference ---------------");
        test.sysLockConference(1, 0xfffffe00);

        // user join conference
        System.out
                .println("---------------- user join conference fail---------------");
        test.userJoinConference(1, 0xfffffe00, newuser);
        test.pUserList(1, 0xfffffe00);

        // user join conference
        System.out
                .println("---------------- sys unlock conference---------------");
        test.sysUnlockConference(1, 0xfffffe00);

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
        test.userJoinConference(1, 0xfffffe00, nuser);
        test.pUserList(1, 0xfffffe00);

        // start service
        System.out.println("---------------- start service ---------------");
        test.startService(1, 0xfffffe00, 0x204);

        // stop service
        System.out.println("---------------- stop service ---------------");
        test.stopService(1, 0xfffffe00, 0x204);

        // user lock
        System.out.println("---------------- user lock ---------------");
        test.userLockConference(1, 0xfffffe00);

        // change role
        System.out.println("---------------- change role ---------------");
        List<String> userArr = new ArrayList<String>();
        userArr.add("7777777");
        // userArr.add("9999999");

        List<String> newRoleArr = new ArrayList<String>();
        newRoleArr.add("2");
        // newRoleArr.add("3");

        // op: 1:add 2:del 3:modify
        test.changeRole(1, 0xfffffe00, 3, userArr, newRoleArr);
        System.out.println("change role..........");

        // user lock
        System.out.println("---------------- user unlock ---------------");
        test.userUnlockConference(1, 0xfffffe00);

        // op: 1:add 2:del 3:modify
        test.changeRole(1, 0xfffffe00, 3, userArr, newRoleArr);
        System.out.println("change role..........");

        // stop conference
        System.out.println("---------------- stop conference ---------------");
        test.stopConferenceWithoutUser(1, 0xfffffe00);

        // delete conference
        System.out
                .println("---------------- delete conference ---------------");
        test.deleteConferenceWithoutUser(1, 0xfffffe00);

        ConfStartMsgResult obj = (ConfStartMsgResult) test.getObject(0x010132);
        obj.setChannelID(111);
        obj.setContentLength(2222);

        // System.out

        // agent销毁
        test.agentDestory();
    }

    @Override
    public void addMessageHandler(IMessageHandler handler) {
        icmsAgent.setHandler(handler);
    }

    @Override
    public void addServiceMessageHandler(IMessageHandler serviceHandler) {
        icmsAgent.setServiceHandler(serviceHandler);
    }

    @Override
    public void startRecord(int site, int confID, int serviceType)
            throws CMSException {
        // TODO Auto-generated method stub

    }

    @Override
    public void stopRecord(int site, int confID, int serviceType)
            throws CMSException {
        // TODO Auto-generated method stub

    }

    @Override
    public String subConfMsg(int site, int confID, String result)
            throws CMSException {
        String s = "false";
        int i = icmsAgent.subConfMsg(site, confID, result);
        if (i == 1) {
            s = "true";
        }
        return s;
    }

    @Override
    public void setConfigTimes(int site, int confID, int time1, int time2) throws CMSException {
        Object lock = new Object();
        icmsAgent.setConfigTimes(site, confID, time1, time2, lock);
    }


    @Override
    public void createConferenceBillInfoWithoutUser(int site,
                                                    ConferenceBillInfoBMS confInfo, List<String> typeArr)
            throws CMSException {
        icmsAgent.createConferenceBillInfoWithoutUser(site, confInfo, typeArr);
    }


    @Override
    public UserChannel createConferenceBillInfoWithUser(int site,
                                                        ConferenceBillInfoBMS confInfo, BMSUserBillInfo userInfo,
                                                        List<String> typeArr) throws CMSException {
        UserChannel userchannel = new UserChannel();

        icmsAgent.createConferenceBillInfoWithUser(site, confInfo, userInfo, typeArr,
                userchannel);

        return userchannel;
    }

    @Override
    public UserChannel userJoinConferenceWithBillInfo(int site, int confID,
                                                      BMSUserBillInfo userInfo) throws CMSException {
        UserChannel channel = new UserChannel();
        icmsAgent.userJoinConferenceWithBillInfo(site, confID, userInfo, channel);

        return channel;
    }

    @Override
    public UserChannel startConferenceBillInfoWithUser(int site, int confID,
                                                       BMSUserBillInfo userInfo) throws CMSException {
        UserChannel userchannel = new UserChannel();
        icmsAgent.startConferenceBillInfoWithUser(site, confID, userInfo, userchannel);
        return userchannel;

    }


}
