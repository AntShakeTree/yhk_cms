package com.ykh.pojo;

/**
 * ServerDomain entity. @author MyEclipse Persistence Tools
 */

public class ServerDomain implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer serverIp0;
    private String domain;
    private String netip;
    private String type;

    // Constructors

    /**
     * default constructor
     */
    public ServerDomain() {
    }

    /**
     * full constructor
     */
    public ServerDomain(Integer serverIp0, String domain, String netip) {
        this.serverIp0 = serverIp0;
        this.domain = domain;
        this.netip = netip;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServerIp0() {
        return this.serverIp0;
    }

    public void setServerIp0(Integer serverIp0) {
        this.serverIp0 = serverIp0;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getNetip() {
        return this.netip;
    }

    public void setNetip(String netip) {
        this.netip = netip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}