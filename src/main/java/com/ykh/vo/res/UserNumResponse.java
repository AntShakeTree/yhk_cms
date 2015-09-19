package com.ykh.vo.res;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserNumResponse {
    private Header head = new Header();
    private UserNumBody body;

    public static class UserNumBody {
        int userCounts;

        public int getUserCounts() {
            return userCounts;
        }

        public void setUserCounts(int userCounts) {
            this.userCounts = userCounts;
        }
    }

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public UserNumBody getBody() {
        return body;
    }

    public void setBody(UserNumBody body) {
        this.body = body;
    }
}
