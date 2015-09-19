package com.ykh.vo.res;

import com.ykh.tang.agent.vo.UserConferenceStatus;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserConferenceStatusResponse {
    private Header head = new Header();
    private UserConferenceStatus body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public UserConferenceStatus getBody() {
        return body;
    }

    public void setBody(UserConferenceStatus body) {
        this.body = body;
    }
}
