package com.ykh.services.conference.impl;

import com.alibaba.fastjson.JSON;
import com.maxc.rest.common.ConfigUtil;
import com.maxc.rest.common.RestBeanUtils;
import com.maxc.rest.common.exception.ResourceNoFoundException;
import com.maxc.rest.common.exception.RestAssert;
import com.maxc.rest.common.exception.RestException;
import com.ykh.common.*;
import com.ykh.dao.Dao;
import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.ConferenceSeedDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.conference.domain.ConferenceSeed;
import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.pojo.*;
import com.ykh.services.ConfJoinTempConfService;
import com.ykh.services.conference.ConferenceSeedService;
import com.ykh.services.conference.ConferenceService;
import com.ykh.services.conference.exception.CMSErrorCode;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {
    Logger logger = Logger.getLogger(ConferenceService.class);
    @Autowired
    ConferenceSeedService conferenceSeedService;
    @Autowired
    ConfJoinTempConfService confJoinTempConfService;
    @Autowired
    private ICMSAgentInterface icmsAgentInterface;
    @Autowired
    private ConferenceDao conferenceDao;
    @Autowired
    private ConferenceSeedDao conferenceSeedDao;
    @Autowired
    private TempUserDao tempUserDao;

    @Override
    public ConferenceInfoBMS createConference(Conference conference) throws RuntimeException {
        logger.info("createConference===> enter");
        Integer seed = conference.getTempConferenceId();
        if (seed != null) {
            ConfJoinTempConf confJoinTempConf = confJoinTempConfService.findByTempConfId(conference.getTempConferenceId());
            if (confJoinTempConf != null) {
                ConferenceInfoBMS confInfo = icmsAgentInterface.getConfInfo(Integer.parseInt(ConfigUtil.getByKey("site")), conference.getTempConferenceId());
                return confInfo;
            }
        }
        seed = conferenceSeedService.getConfTempId(conference.getConferenceId(), conference.getConferencename());
        ConfJoinTempConf confJoinTempConf = new ConfJoinTempConf.Bulider().status(1).billingcode(conference.getBillingcode()).startTime(new Date()).tempConfId(seed).conferenceId(conference.getConferenceId()).create();
        ConferenceInfoBMS confInfo=   buildByConference(seed, conference);
        icmsAgentInterface.createConferenceWithoutUser(Constants.site, confInfo, YkhUtils.getAllServicetypelist());
//        confJoinTempConf.setConferenceInfoBMS(confInfo);
        confJoinTempConfService.saveTempConf(confJoinTempConf);

        //开会
        logger.info("createConference===> end" + JSON.toJSONString(confInfo));
        return confInfo;
    }

    @Override
    public Boolean stopConference(String applicationID, Integer tempConferenceID)
            throws RuntimeException {
        ConferenceSeed conferenceSeed = conferenceSeedDao.findOne(tempConferenceID);
        if (conferenceSeed == null) {
            throw new ResourceNoFoundException();
        }
        ConfJoinTempConf confJoinTempConf = confJoinTempConfService.findByTempConfId(tempConferenceID);
        if (confJoinTempConf.getStatus() != 2) {
            RestException restException = new RestException();
            restException.setErrorCode(CMSErrorCode.CONFERENCE_NOT_FOUND.value());
            restException.setMessage(CMSErrorCode.CONFERENCE_NOT_FOUND.getDescription());
            throw restException;
        }
        if (confJoinTempConf.getStatus() == 4) {
            return true;
        } else {
            icmsAgentInterface.startConferenceWithoutUser(Constants.site, tempConferenceID);
            confJoinTempConf.setStatus(4);
            confJoinTempConf.setEndTime(new Date());
            confJoinTempConfService.saveTempConf(confJoinTempConf);
        }
        icmsAgentInterface.stopConferenceWithoutUser(Constants.site, tempConferenceID);
        return true;
    }

    @Override
    public Boolean deleteConference(String applicationID, Integer conferenceID)
            throws RuntimeException {
        ConferenceSeed conferenceSeed = conferenceSeedDao.findOne(conferenceID);
        if (conferenceSeed == null) {
            throw new ResourceNoFoundException();
        }
        confJoinTempConfService.deleteByTempConfId(conferenceID);
        icmsAgentInterface.deleteConferenceWithoutUser(Constants.site, conferenceID);
        return true;
    }

    @Override
    public Integer queryUserNum(Integer tempConfID)
            throws Exception {

        return 0;
    }

    @Override
    public Boolean startConference(Integer tempConferenceID) {
        ConfJoinTempConf confJoinTempConf = confJoinTempConfService.findByTempConfId(tempConferenceID);
        if (confJoinTempConf.getStatus() > 2) {
            RestException restException = new RestException();
            restException.setErrorCode(CMSErrorCode.CONFERENCE_NOT_FOUND.value());
            restException.setMessage(CMSErrorCode.CONFERENCE_NOT_FOUND.getDescription());
            throw restException;
        }
        if (confJoinTempConf.getStatus() == 2) {
            return true;
        } else {
            icmsAgentInterface.startConferenceWithoutUser(Constants.site, tempConferenceID);
            confJoinTempConf.setStatus(2);
            confJoinTempConfService.saveTempConf(confJoinTempConf);
        }
        return true;
    }

    @Override
    public UserChannel joinConference(String applicationID,
                                      Integer tempConferenceID, User user) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ConfJoinTempConf getConferenceInfo(String applicationID, Integer tempConfID,Integer conferenceId) {

            ConfJoinTempConf confJoinTempConf = confJoinTempConfService.findByTempConfId(tempConfID);
            if (confJoinTempConf != null&&confJoinTempConf.getStatus()>2) {
                return confJoinTempConf;
            }else{
                ConfJoinTempConf confJoinTempConf1 =new ConfJoinTempConf();
                ConferenceInfoBMS conferenceInfoBMS=       icmsAgentInterface.getConfInfo(Consts.site, tempConfID);
                if(conferenceInfoBMS!=null){
                    if(conferenceInfoBMS.getStatus()==8) {
                        confJoinTempConf1.setStatus(conferenceInfoBMS.getStatus());
                        //confJoinTempConf1.setEndTime(conferenceInfoBMS.);
                        confJoinTempConf1.setConfScale(conferenceInfoBMS.getConfScale());
                        confJoinTempConf1.setTempConfId(confJoinTempConf.getTempConfId());
                        confJoinTempConf1.setConferenceId(conferenceId);
                        confJoinTempConf1.setBillingcode(conferenceInfoBMS.getBillingCode());
                        return confJoinTempConf1;
                    }else {
                        return confJoinTempConf1;
                    }
                }else
                    return confJoinTempConf;
            }
//        return icmsAgent.getConfInfo(Consts.site,tempConfID);
    }

    @Override
    public UserConferenceStatus getUserConferenceStatus(String applicationID, Integer tempConfID, String username) {
        return icmsAgentInterface.getUserConferenceStatus(Consts.site,tempConfID,Session.getCache(username,Integer.class));
    }

    @Override
    public UserConferenceStatus getUserConferenceStatus(String applicationID,
                                                        Integer tempConfID, Integer tempUserID) {
        return  icmsAgentInterface.getUserConferenceStatus(Consts.site,tempConfID,tempUserID);
    }

    @Override
    public Integer createConference(String applicationID, String billingCode)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer initConference(String applicationID, Integer conferenceID)
            throws Exception {
        return null;
    }

    /**
     * 保存会议模版
     *
     * @param conference
     */
    @Override
    public void openConference(Conference conference) {
        conferenceDao.save(conference);
    }

    @Override
    public Conference modifyConference(Conference conference) {
        Conference dao = conferenceDao.findOne(conference.getConferenceId());
        RestAssert.notNull(Conference.class, dao);
        RestBeanUtils.copyProperties(dao, conference, false);
        conferenceDao.save(dao);

        return dao;
    }


//    @Autowired
//    TempUserIdGenerateHelper tempUserIdGenerateHelper;

    @Override
    public UserServiceDTO userJoinConference(User request) {
        BMSUserInfo userInfo = new BMSUserInfo();
        TempUser tempUser = builderByUser(request);
        if (tempUser.isJoin()) {
            return tempUser.getUserChannel();
        }
        request.setTempuserid(tempUser.getIdTempUser());
        try {
            userInfo = BeanTranslatorUtil.copyUser2UserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            RestException r = new RestException();
            r.setErrorCode(com.ykh.tang.agent.Consts.ERROR_CODE);
            r.setMessage(com.ykh.tang.agent.Consts.message + " " + e.getMessage());
            throw r;
        }

        logger.info("userJoinConference  ===> jni start" + request.getTempConferenceId());
        UserChannel userChannel = icmsAgentInterface.userJoinConference(Constants.site, request.getTempConferenceId(), userInfo);
        userChannel.setTempConferenceID(request.getTempConferenceId());

        UserDTO userDTO = new UserDTO();

        userDTO.setTempuserid(tempUser.getIdTempUser());

        RestBeanUtils.copyProperties(userDTO, request, false);
        userDTO.setRolemap(request.getRolemap());
        tempUser.setPinCode(userInfo.pinCode);

        tempUser.setClientType(userInfo.getClientType());

        tempUserDao.save(tempUser);

        UserServiceDTO dto = getUserServiceByChannel(userChannel, userDTO);

        tempUser.setUserChannel(dto);

        return dto;
    }


    @Override
    public UserServiceDTO startConferenceWithUser(User request) {
        logger.info("UserConferenceServiceImpl ==>" + JSON.toJSONString(request));
        BMSUserInfo userInfo = new BMSUserInfo();
        TempUser tempUser = builderByUser(request);
        if (tempUser.isJoin()) {
            return tempUser.getUserChannel();
        }
        request.setTempuserid(tempUser.getIdTempUser());
        try {
            userInfo = BeanTranslatorUtil.copyUser2UserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            RestException r = new RestException();
            r.setErrorCode(com.ykh.tang.agent.Consts.ERROR_CODE);
            r.setMessage(com.ykh.tang.agent.Consts.message + " " + e.getMessage());
            throw r;
        }

        logger.info("userJoinConference  ===> jni start" + request.getTempConferenceId());
//		UserServiceDTO dto = new UserServiceDTO();
        UserChannel userChannel = icmsAgentInterface.startConferenceWithUser(Constants.site, request.getTempConferenceId(), userInfo);
        userChannel.setTempConferenceID(request.getTempConferenceId());

        UserDTO userDTO = new UserDTO();

        userDTO.setTempuserid(tempUser.getIdTempUser());
        RestBeanUtils.copyProperties(userDTO, request, false);
        userDTO.setRolemap(request.getRolemap());
        tempUser.setPinCode(userInfo.pinCode);
        tempUser.setClientType(userInfo.getClientType());

        tempUserDao.save(tempUser);

        UserServiceDTO dto = getUserServiceByChannel(userChannel, userDTO);

        tempUser.setUserChannel(dto);

        return dto;


    }

    @Override
    public Dao.PageVO<Conference> searchConference(Conference conference) {

        return conferenceDao.findPages(conference);

    }

    @Override
    public UserServiceDTO startConferecneWithUser(Integer conferenceId, User request) {
        Conference conference = this.conferenceDao.find(conferenceId);
        RestAssert.notNull(Conference.class, conference);
        ConferenceInfoBMS bms = this.createConference(conference);
        Integer tempConfId = bms.getConfID();
        request.setTempConferenceId(tempConfId);
        return this.startConferenceWithUser(request);
    }

    public static void main(String[] args) {
        System.out.print(JSON.toJSONString(new PageRequest(1, 1)));
    }


    private UserServiceDTO getUserServiceByChannel(UserChannel userChannel, UserDTO userDTO) {
        if (userChannel.getUserID() > 0) {
            userDTO.setTempuserid(Integer.valueOf(userChannel.getUserID()));
        }
        UserServiceDTO userServiceDTO = new UserServiceDTO();

        userServiceDTO.setTempconfernceid(userChannel.getTempConferenceID());

        userServiceDTO.setUser(userDTO);

        String userIpaddr = userDTO.getIpaddr();

        logger.info("userIpaddr from userDTO is:" + userIpaddr);

        List<DtServiceAddrDTO> dtsaddrDTOlist = new ArrayList<DtServiceAddrDTO>();

        if (userChannel.ctsAddr == null || userChannel.ctsAddr.isEmpty())

        {

            logger.error("业务管理返回的ctsAddr地址列表为空！调用中断，直接返回NULL！");

            throw new NullPointerException("业务管理返回的ctsAddr地址列表为空！调用中断，直接返回NULL！");

        }

        if (userChannel.dtsAddr == null || userChannel.dtsAddr.isEmpty())

        {

            logger.error("业务管理返回的dtsAddr地址列表为空！");

            dtsaddrDTOlist = null;

        } else

        {

            DtServiceAddrDTO usAddrDto = null;

            for (UserServiceAddr usaddr : userChannel.dtsAddr) {


                usAddrDto = new DtServiceAddrDTO();

                usAddrDto.setChannelID(intToLong(usaddr.channel));

                usAddrDto.setGroupID(intToLong(usaddr.groupID));

                usAddrDto.setType(intToLong(usaddr.serviceType));

                usAddrDto.setTransportip(IPTranslatorUtil.longToIP(usaddr.getServerIP0()));


                dtsaddrDTOlist.add(usAddrDto);

            }

        }

        userServiceDTO.setDtsaddrlist(dtsaddrDTOlist);

        List<CtServiceAddrDTO> ctsaddrDTOlist = new ArrayList<CtServiceAddrDTO>();

        CtServiceAddrDTO csAddrDto = null;

        for (UserServiceAddr usaddr : userChannel.ctsAddr) {

            csAddrDto = new CtServiceAddrDTO();

            csAddrDto.setType((usaddr.serviceType));

            csAddrDto.setChannelID((usaddr.channel));

            csAddrDto.setGroupID((usaddr.groupID));

            csAddrDto.setAccessip(IPTranslatorUtil.longToIP(usaddr.getServerIP0()));

            csAddrDto.setBakassessip(IPTranslatorUtil.longToIP(usaddr.getHotServerIP0()));

            if (csAddrDto != null) {

                logger.info("Accessip is:" + csAddrDto.getAccessip());

                logger.info("Bakessessip is:" + csAddrDto.getBakassessip());

                ctsaddrDTOlist.add(csAddrDto);
            }

        }

        userServiceDTO.setCtsaddrlist(ctsaddrDTOlist);

        return userServiceDTO;

    }

    private TempUser builderByUser(User request) {
        logger.info("UserConferenceServiceImpl ==>" + JSON.toJSONString(request));
        TempUser tempUser = null;
        RestAssert.notNull(request.getUsername(), "username");

        if (request.getTempuserid() != null) {
            tempUser = tempUserDao.find(request.getTempuserid());
            Session.setCache(tempUser.getUsername(), request.getTempuserid());

        }
        if (tempUser != null) {
            tempUser.setIsJoin(false);
            Session.setCache(tempUser.getUsername(), tempUser.getIdTempUser());
            Integer conft = tempUser.getTempConferenceId();
            ConfJoinTempConf confJoinTempConf = confJoinTempConfService.findByTempConfId(request.getTempConferenceId());
            if (conft == request.getTempConferenceId() && confJoinTempConf != null && confJoinTempConf.getStatus() != 2) {
                tempUser.setIsJoin(true);

                return tempUser;
            }
            if(conft!=request.getTempConferenceId()){
                tempUser.setIsJoin(true);
                return tempUser;
            }
        } else {
            tempUser = new TempUser();
            tempUser.setUsername(request.getUsername());
            tempUser.setStatus(request.getUserStatus() == null ? 0 : request.getUserStatus());
            tempUser.setTempConferenceId(request.getTempConferenceId());
            tempUserDao.save(tempUser);
            Session.setCache(tempUser.getUsername(), tempUser.getIdTempUser());

        }

        return tempUser;
    }

    private long intToLong(int value) {

        return value * 1l;

    }

    private ConferenceInfoBMS buildByConference(Integer tempId,Conference conference){
        ConferenceInfoBMS confInfo = new ConferenceInfoBMS();

        Conference dao = conferenceDao.find(conference.getConferenceId());
        confInfo.setConfID(tempId);
        confInfo.setName(conference.getConferencename());
//		confInfo.setPassword(conference.getPassword());
        confInfo.setStopParams(dao.getAutoStopParams());
//		confInfo.setRoleInfo(dao.get);
        confInfo.setRoleInfo(dao.getRuleInfos());

        long startSenconde = 0l;
        if (conference.getStarttime() == null) {

            startSenconde = System.currentTimeMillis() / 1000;

        } else {
            startSenconde = conference.getStarttime().getTime() / 1000;
        }

        confInfo.setPlanStartTime0((int) startSenconde & 0xFFFFFFFF);
        confInfo.setPlanStartTime1((int) startSenconde >> 32 & 0xffffffff);

        long endTimeSeconds = 0;
        if (conference.getEndTime() == null) {
            endTimeSeconds = (System.currentTimeMillis() + 24 * 60 * 60 * 1000) / 1000;

        } else {
            endTimeSeconds = (conference.getEndTime().getTime() / 1000);
        }

        confInfo.setPlanStartTime0((int) endTimeSeconds & 0xFFFFFFFF);
        confInfo.setPlanStartTime1((int) endTimeSeconds >> 32 & 0xffffffff);
        confInfo.setServiceConfigs(dao.getServiceConfigs());
        confInfo.setConfScale(dao.getConfScale());
        confInfo.setBillingCode(dao.getBillingcode() + "");
//		confInfo.setSubConference();
        //TODO 空的子会议
        SubConferenceInfo subConfInfo = new SubConferenceInfo();
        subConfInfo.setServiceConfigArr(dao.getServiceConfigs());
        subConfInfo.setRoleInfoArr(dao.getRuleInfos());
        confInfo.setSubConference(subConfInfo);
        return confInfo;
    }

}
