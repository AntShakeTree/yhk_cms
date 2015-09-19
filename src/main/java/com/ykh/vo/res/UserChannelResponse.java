package com.ykh.vo.res;

import com.ykh.pojo.UserServiceDTO;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserChannelResponse {
    private Header head = new Header();
    private UserServiceDTO body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public UserServiceDTO getBody() {
        return body;
    }

    public void setBody(UserServiceDTO body) {
        this.body = body;
    }
}
