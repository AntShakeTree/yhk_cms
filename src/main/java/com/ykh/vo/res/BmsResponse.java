package com.ykh.vo.res;

import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class BmsResponse {
    private Header head = new Header();
    private ConfJoinTempConf body;

    public ConfJoinTempConf getBody() {
        return body;
    }

    public void setBody(ConfJoinTempConf body) {
        this.body = body;
    }

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }


}
