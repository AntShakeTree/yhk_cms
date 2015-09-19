package com.ykh.vo.res;

import com.ykh.dao.Dao;

/**
 * Created by ant_shake_tree on 15/9/10.
 */
public class PageResponse {
    Header head = new Header();


    Dao.PageVO body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public Dao.PageVO getBody() {
        return body;
    }

    public void setBody(Dao.PageVO body) {
        this.body = body;
    }
}
