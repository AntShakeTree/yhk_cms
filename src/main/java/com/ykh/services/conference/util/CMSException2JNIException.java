package com.ykh.services.conference.util;

import com.ykh.services.conference.exception.JNIException;
import com.ykh.tang.agent.excep.CMSException;


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
