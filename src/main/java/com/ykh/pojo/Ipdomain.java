package com.ykh.pojo;

/**
 * Ipdomain entity. @author MyEclipse Persistence Tools
 */

public class Ipdomain implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String netip;
    private String mask;
    private Integer domain;

    // Constructors

    /**
     * default constructor
     */
    public Ipdomain() {
    }

    /**
     * full constructor
     */
    public Ipdomain(String netip, String mask, Integer domain) {
        this.netip = netip;
        this.mask = mask;
        this.domain = domain;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetip() {
        return this.netip;
    }

    public void setNetip(String netip) {
        this.netip = netip;
    }

    public String getMask() {
        return this.mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public Integer getDomain() {
        return this.domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

}