package com.ykh.log;

import com.maxc.rest.common.ParseJSON;
import com.maxc.rest.common.exception.DatabaseException;
import com.maxc.rest.common.exception.ExceptionHandle;
import com.maxc.rest.common.exception.RestException;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
/**
 * 通用的异常与日志管理
 * @author ant_shake_tree
 *
 */
public class LogManager {
    static Logger log = Logger.getLogger("YHK");

    @Pointcut("execution(* com.ykh.dao..*.*(..))")
    public void daoException() {
    }

    @Pointcut("execution(* com.ykh.web..*.*(..))")
    public void serviceException() {
    }


    @Pointcut("execution(* com.ykh.facade..*.*(..))")
    public void serviceLog() {
    }

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(Logger.class);

    /**
     * 统一所有数据库异常
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "daoException() ", throwing = "ex")
    public void packingToEngineRestException(JoinPoint joinPoint, Exception ex) {
        StringBuilder sb = new StringBuilder();
        DatabaseException de = new DatabaseException(ex);
        RestException er = ExceptionHandle.throwException(de);
        String classname = joinPoint.getSignature().getDeclaringTypeName();
        sb.append("[" + classname + "]")
                .append("{\"error\":").append(er.getErrorCode()).append("}");
        logger.error(sb.toString(), ex);
        throw er;
    }

    /**
     * 拦截所有业务方法
     *
     * @param joinPoint
     * @param ex
     */
    @AfterReturning(value = "serviceLog()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        if (log.isInfoEnabled()) {

            String classname = joinPoint.getSignature().getDeclaringTypeName();
            String method = joinPoint.getSignature().getName();
            StringBuilder sb = new StringBuilder();
            sb.append("[" + classname + "] ")
                    .append("[" + method + "]")
                    .append(ParseJSON.toJson(joinPoint.getArgs()))
                    .append("[result]")
                    .append(result instanceof String ? result : ParseJSON
                            .toJson(result));
            log.info(sb.toString());
        }

    }


}
