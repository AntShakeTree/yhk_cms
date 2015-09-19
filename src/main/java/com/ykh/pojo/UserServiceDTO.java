/**
 * **********************************************
 * Copyright (c) 2010-2012 G-Net All rights
 * reserved. G-Net Integrated Services co. Ltd.
 * *******************************************************************
 *
 * @(#)UserServiceDTO.java 1.0 2010-11-10
 * @author ming.li
 * @date 2010-11-10 13:40:36
 * @version 0.1.1
 * @warning
 * @par 需求: REQ1.10[Tang]:
 * svn://vobserver/tang/doc/SRS.doc
 */
package com.ykh.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * TANG 用户信息传输类
 * @author ming.li
 */
@XmlRootElement
public class UserServiceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<CtServiceAddrDTO> ctsaddrlist;
    private List<DtServiceAddrDTO> dtsaddrlist;

    /**
     * 用户
     */

    private UserDTO user;
    /**
     * 临时会议ID
     */
    private Integer tempconfernceid;

    public UserServiceDTO() {
    }

    @XmlElement(name = "ctsaddr")
    public List<CtServiceAddrDTO> getCtsaddrlist() {
        return ctsaddrlist;
    }

    public void setCtsaddrlist(List<CtServiceAddrDTO> ctsaddrlist) {
        this.ctsaddrlist = ctsaddrlist;
    }

    @XmlElement(name = "dtsaddr")
    public List<DtServiceAddrDTO> getDtsaddrlist() {
        return dtsaddrlist;
    }

    public void setDtsaddrlist(List<DtServiceAddrDTO> dtsaddrlist) {
        this.dtsaddrlist = dtsaddrlist;
    }

    @XmlElement(name = "user")
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Integer getTempconfernceid() {
        return tempconfernceid;
    }

    public void setTempconfernceid(Integer tempconfernceid) {
        this.tempconfernceid = tempconfernceid;
    }


}
