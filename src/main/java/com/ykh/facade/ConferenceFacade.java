package com.ykh.facade;

import com.ykh.dao.conference.domain.Conference;
import com.ykh.pojo.User;
import com.ykh.vo.body.ConferenceSeedBody;
import com.ykh.vo.res.*;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public interface ConferenceFacade {
    ConferenceResponse openConference(Conference conference);

    ConferenceResponse modifyConference(Conference conference);

    CreateConferenceResponse createConference(Conference conference);

    Response stopConference(ConferenceSeedBody conference);

    Response deleteConference(ConferenceSeedBody conference);

    UserNumResponse queryUserNum(ConferenceSeedBody conference);

    UserConferenceStatusResponse getUserConferenceStatus(User conference);

    Response startConference(ConferenceSeedBody conference);

    UserChannelResponse joinConference(User request);

    BmsResponse getConferenceInfo(ConferenceSeedBody conference);

    PageResponse searchConferenceTemp(Conference conference);

    UserChannelResponse startConferecneWithUser(User request);
}
