package com.ykh.pojo;

/**
 * MaxIdcontrol entity. @author MyEclipse Persistence Tools
 */

public class MaxIdcontrol implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer maxid;
    private String description;

    // Constructors

    /**
     * default constructor
     */
    public MaxIdcontrol() {
    }

    /**
     * minimal constructor
     */
    public MaxIdcontrol(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MaxIdcontrol(Integer id, Integer maxid, String description) {
        this.id = id;
        this.maxid = maxid;
        this.description = description;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxid() {
        return this.maxid;
    }

    public void setMaxid(Integer maxid) {
        this.maxid = maxid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}