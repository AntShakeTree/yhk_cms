package com.ykh.tang.agent.excep;

public class CMSException extends RuntimeException {


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public String codeID;

    public String msg;

    private String message;

    public CMSException() {

    }

    public CMSException(String msg) {

        String[] strArr = msg.split("=", 2);
        this.message = msg;
        this.codeID = strArr[0];
        this.msg = strArr[1];
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCodeID() {
        return codeID;
    }

    public void setCodeID(String codeID) {
        this.codeID = codeID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
