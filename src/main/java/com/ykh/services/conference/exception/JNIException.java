package com.ykh.services.conference.exception;

public class JNIException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 23L;

    public String codeID;

    public String msg;

    private String message;

    public JNIException() {

    }

    public JNIException(String msg) {

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
