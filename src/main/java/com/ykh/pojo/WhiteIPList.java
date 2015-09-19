package com.ykh.pojo;

public class WhiteIPList implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String netip;
    private String mask;
    private Long netipvalue;
    private Long maskvalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetip() {
        return netip;
    }

    public void setNetip(String netip) {
        this.netip = netip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public Long getNetipvalue() {
        return netipvalue;
    }

    public void setNetipvalue(Long netipvalue) {
        this.netipvalue = netipvalue;
    }

    public Long getMaskvalue() {
        return maskvalue;
    }

    public void setMaskvalue(Long maskvalue) {
        this.maskvalue = maskvalue;
    }
}
