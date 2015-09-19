package com.ykh.vo.req;

import com.ykh.dao.PageRequest;
import com.ykh.dao.conference.domain.Conference;

/**
 * Created by ant_shake_tree on 15/9/10.
 */
public class ConferencePageRequest {
    Conference conference;
    PageRequest page;

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public PageRequest getPage() {
        return page;
    }

    public void setPage(PageRequest page) {
        this.page = page;
    }
}
