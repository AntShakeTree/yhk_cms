package com.ykh.vo.res;

import com.ykh.dao.conference.domain.Conference;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class ConferenceResponse {
    private Header head = new Header();

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    private Conference body;

    public Conference getBody() {
        return body;
    }

    public void setBody(Conference body) {
        this.body = body;
    }
}
