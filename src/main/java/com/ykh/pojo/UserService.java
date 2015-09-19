/**
 * UserServiceAddr.java
 * com.gnetis.tang.conferencemanagement.pojo
 * <p/>
 * ver           date      		author
 * ──────────────────────────────────———————————
 * tang1.0       May 7, 2009     admin
 * <p/>
 * Copyright (c) 2009,创想空间软件技术(北京)有限公司
 */

package com.ykh.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:UserServiceAddr
 * <p>
 * ClassDesc：用简单的话描述本类
 *
 * @author admin
 * @version 1.0
 * @since Ver 1.0
 * @Date 2009 May 7, 2009 2:01:01 PM
 */

public class UserService implements Serializable {
    private static final long serialVersionUID = 4508169327075245618L;

    private List<CtServiceAddr> ctsaddrlist;

    private List<DtServiceAddr> dtsaddrlist;
    // 用户
    private User user;
    // 临时会议ID
    private Integer tempconfernceid;

    public UserService() {

    }

    public UserService(List<CtServiceAddr> ctsaddrlist, List<DtServiceAddr> dtsaddrlist, User user, Integer tempconfernceid) {
        this.ctsaddrlist = ctsaddrlist;
        this.dtsaddrlist = dtsaddrlist;
        this.user = user;
        this.tempconfernceid = tempconfernceid;
    }


    /**
     * ctsaddrlist
     * @return the ctsaddrlist
     */

    public List<CtServiceAddr> getCtsaddrlist() {
        return ctsaddrlist;
    }

    /**
     * ctsaddrlist
     * @param   ctsaddrlist    the ctsaddrlist to set
     */

    public void setCtsaddrlist(List<CtServiceAddr> ctsaddrlist) {
        this.ctsaddrlist = ctsaddrlist;
    }

    /**
     * dtsaddrlist
     * @return the dtsaddrlist
     */

    public List<DtServiceAddr> getDtsaddrlist() {
        return dtsaddrlist;
    }

    /**
     * dtsaddrlist
     * @param   dtsaddrlist    the dtsaddrlist to set
     */

    public void setDtsaddrlist(List<DtServiceAddr> dtsaddrlist) {
        this.dtsaddrlist = dtsaddrlist;
    }

    /**
     * user
     *
     * @return the user
     */

    public User getUser() {
        return user;
    }

    /**
     * user
     *
     * @param user the user to set
     */

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * tempconfernceid
     *
     * @return the tempconfernceid
     */

    public Integer getTempconfernceid() {
        return tempconfernceid;
    }

    /**
     * tempconfernceid
     *
     * @param tempconfernceid the tempconfernceid to set
     */

    public void setTempconfernceid(Integer tempconfernceid) {
        this.tempconfernceid = tempconfernceid;
    }

}
