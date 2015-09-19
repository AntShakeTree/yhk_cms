package com.ykh.tang.agent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ant_shake_tree on 15/8/30.
 */
@Component
public class JniCallBackRegister {
    private final static Logger LOGGER = Logger.getLogger(JniCallBackRegister.class);
    @Autowired
    private ICMSAgentInterface agent;
    @Autowired
    @Qualifier("getmessageHandler")
    private IMessageHandler getmessageHandler;
    @Autowired
    @Qualifier("getmessageHandlerByGroup")
    private IMessageHandler getmessageHandlerByGroup;

    @PostConstruct
    public void init() {
        LOGGER.info("[Tang CMS addMessageHandler && AddServiceMessageHandler regist ......]");
        this.regist();
        LOGGER.info("[Tang CMS addMessageHandler && AddServiceMessageHandler regist success!]");
    }

    @PreDestroy
    public void destroy() {
        agent.agentDestroy();
    }

    private void regist() {
        agent.agentInit();
        agent.addMessageHandler(getmessageHandler);
        agent.addServiceMessageHandler(getmessageHandlerByGroup);
    }


}

