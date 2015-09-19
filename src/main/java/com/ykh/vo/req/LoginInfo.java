package com.ykh.vo.req;

//public class LoginInfo implements Serializable {
public class LoginInfo {
    private int id;
    private String name;
    private boolean status;

    public LoginInfo(int nid, String strname, boolean bstatus) {
        // TODO Auto-generated constructor stub
        id = nid;
        name = strname;
        status = bstatus;

    }

    public LoginInfo() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
