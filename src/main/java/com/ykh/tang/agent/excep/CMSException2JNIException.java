package com.ykh.tang.agent.excep;

import com.ykh.services.conference.exception.JNIException;

public class CMSException2JNIException {

    public static JNIException getJNIException(CMSException cmsExcep) {
        if (cmsExcep == null)
            return null;

        JNIException jniExcep = new JNIException();
        jniExcep.setCodeID(cmsExcep.getCodeID());
        jniExcep.setMsg(cmsExcep.getMsg());
        jniExcep.setMessage(cmsExcep.getMessage());
        return jniExcep;
    }
}
