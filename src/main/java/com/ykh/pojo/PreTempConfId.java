package com.ykh.pojo;

/**
 * PreTempConfId entity. @author MyEclipse Persistence Tools
 */

public class PreTempConfId implements java.io.Serializable {

    // Fields

    private Integer tempConfId;
    private Integer id;
    private Short useFlag;
    private Long version;

    // Constructors

    /**
     * default constructor
     */
    public PreTempConfId() {
    }

    /**
     * minimal constructor
     */
    public PreTempConfId(Integer tempConfId, Integer id, Short useFlag) {
        this.tempConfId = tempConfId;
        this.id = id;
        this.useFlag = useFlag;
    }

    /**
     * full constructor
     */
    public PreTempConfId(Integer tempConfId, Integer id, Short useFlag,
                         Long version) {
        this.tempConfId = tempConfId;
        this.id = id;
        this.useFlag = useFlag;
        this.version = version;
    }

    // Property accessors

    public Integer getTempConfId() {
        return this.tempConfId;
    }

    public void setTempConfId(Integer tempConfId) {
        this.tempConfId = tempConfId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getUseFlag() {
        return this.useFlag;
    }

    public void setUseFlag(Short useFlag) {
        this.useFlag = useFlag;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}