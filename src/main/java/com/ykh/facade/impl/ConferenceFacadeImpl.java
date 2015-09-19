package com.ykh.facade.impl;

import com.maxc.rest.common.Utils;
import com.maxc.rest.common.exception.RestAssert;
import com.ykh.common.StringUtils;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.facade.ConferenceFacade;
import com.ykh.pojo.User;
import com.ykh.pojo.UserServiceDTO;
import com.ykh.services.conference.ConferenceService;
import com.ykh.vo.body.ConferenceSeedBody;
import com.ykh.vo.res.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ConferenceService;
//import com.ykh.tang.agent.ICMSAgent;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@Service
public class ConferenceFacadeImpl implements ConferenceFacade {

    @Autowired
    ConferenceService conferenceService;


    public ConferenceResponse openConference(Conference conference) {
        RestAssert.notNull(Conference.class, conference);
        RestAssert.notNull(conference.getBillingcode(), "billingcode");
        RestAssert.notNull(conference.getConferencename(), "conferencename");
        RestAssert.notNull(conference.getAutoStopParams(), "autoStopParams");
        RestAssert.notNull(conference.getConfScale(), "confScale");
        conferenceService.openConference(conference);
        ConferenceResponse response = new ConferenceResponse();
        response.setBody(conference);
        return response;
    }

    public ConferenceResponse modifyConference(Conference conference) {
        RestAssert.notNull(Conference.class, conference);
        RestAssert.notNull(conference.getConferenceId(), "tempConferenceId");
        ConferenceResponse response = new ConferenceResponse();
        response.setBody(conferenceService.modifyConference(conference));
        return response;
    }

    public CreateConferenceResponse createConference(Conference conference) {
        RestAssert.notNull(Conference.class, conference);
        RestAssert.notNull(conference.getConferenceId(), "tempConferenceId");
        RestAssert.notNull(conference.getConferencename(), "conferencename");
        CreateConferenceResponse response = new CreateConferenceResponse();
        CreateConferenceResponse.CreateConferenceBody body = new CreateConferenceResponse.CreateConferenceBody();
        body.setTempConferenceId(conferenceService.createConference(conference).getConfID());
        response.setBody(body);
        return response;
    }

    public Response stopConference(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        conferenceService.stopConference("", conference.getTempConferenceId());
        return new Response();
    }

    public Response deleteConference(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        conferenceService.deleteConference("", conference.getTempConferenceId());
        return new Response();
    }

    public UserNumResponse queryUserNum(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        //TODO queryNum;
//        conferenceService.queryUserNum("",conference.getTempConferenceId());

        UserNumResponse response = new UserNumResponse();
        return response;
    }

    public UserConferenceStatusResponse getUserConferenceStatus(User conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");

        UserConferenceStatusResponse response = new UserConferenceStatusResponse();
        if(StringUtils.isEmpty(conference.getUsername())){
            RestAssert.notNull(conference.getTempuserid());
            response.setBody(conferenceService.getUserConferenceStatus("",conference.getTempConferenceId(),conference.getTempuserid()));

        }
        if(conference.getTempuserid()==null){
            RestAssert.notNull(conference.getUsername(),"username");
            response.setBody(conferenceService.getUserConferenceStatus("",conference.getTempConferenceId(),conference.getUsername()));
        }

        return response;
    }

    public Response startConference(ConferenceSeedBody conference) {
        RestAssert.notNull(Conference.class, conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        conferenceService.startConference(conference.getTempConferenceId());
        return new Response();
    }

    @Override
    public UserChannelResponse joinConference(User request) {
        RestAssert.notNull(User.class, request);
        RestAssert.notNull(request.getTempConferenceId(), "tempConferenceId");
//        RestAssert.notNull(request.getUserId(),"userId");
        UserServiceDTO userChannel = conferenceService.userJoinConference(request);
        UserChannelResponse response = new UserChannelResponse();

        response.setBody(userChannel);
        return response;
    }

    @Override
    public BmsResponse getConferenceInfo(ConferenceSeedBody conference) {
        RestAssert.notNull(ConferenceSeedBody.class,conference);
        RestAssert.notNull(conference.getTempConferenceId(),"tempConferenceId");
        RestAssert.notNull(conference.getConferenceId(),"conferenceId");
        BmsResponse response=new BmsResponse();
        response.setBody(conferenceService.getConferenceInfo("",conference.getTempConferenceId(),conference.getConferenceId()));
        return new BmsResponse();
    }

    @Override
    public PageResponse searchConferenceTemp(Conference conference) {
        RestAssert.notNull(Conference.class, conference);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setBody(conferenceService.searchConference(conference));
        return pageResponse;
    }

    @Override
    public UserChannelResponse startConferecneWithUser(User request) {
        RestAssert.notNull(User.class, request);
        RestAssert.notNull(request.getConferenceId(), "conferenceId");
        UserServiceDTO res = conferenceService.startConferecneWithUser(request.getConferenceId(), request);
        UserChannelResponse response = new UserChannelResponse();
        response.setBody(res);
        return response;
    }


}
