package com.ykh.pojo;

public class PreBillingCode implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String BillingCode;
    private Boolean useFlag;
    private Long version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillingCode() {
        return BillingCode;
    }

    public void setBillingCode(String billingCode) {
        BillingCode = billingCode;
    }

    public Boolean getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


}
