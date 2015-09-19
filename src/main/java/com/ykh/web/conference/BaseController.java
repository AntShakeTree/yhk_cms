package com.ykh.web.conference;

import com.maxc.rest.common.exception.ExceptionCode;
import com.maxc.rest.common.exception.RestException;
import com.ykh.tang.agent.excep.CMSException;
import com.ykh.vo.res.Response;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class BaseController {
    static Logger logger = Logger.getLogger(BaseController.class);
    public static final String CONTENT_TYPE = "application/json; charset=UTF-8";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Response handleBadRequest(Exception ex) {
        logger.error("BaseController ::" + ex.getMessage(), ex);
//		EngineExceptionHandle.throwEngineException(ex);
        Response re = new Response();
        if (ex instanceof RestException) {
            RestException resstException = (RestException) ex;
            re.getHead().setError(resstException.getErrorCode());
            re.getHead().setMessage(ex.getMessage());
            return re;
        } else if (ex instanceof CMSException) {

            re.getHead().setError(Integer.parseInt(((CMSException) ex).getCodeID()));
            re.getHead().setMessage("CMS exception.");
            return re;
        } else {
            re.getHead().setError(ExceptionCode.UnknowException.getErrorCode());
            re.getHead().setMessage("unknowException [" + ex.getMessage() + "]");
            return re;
        }
    }
}