package com.ykh.vo.res;

public class JobResponse {
    private Header head = new Header();
    private Job body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public Job getBody() {
        return body;
    }

    public void setBody(Job body) {
        this.body = body;
    }

}
