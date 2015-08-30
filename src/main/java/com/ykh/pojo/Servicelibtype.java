package com.ykh.pojo;

import com.sun.xml.bind.CycleRecoverable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Servicelibtype generated by MyEclipse Persistence Tools
 */
@XmlRootElement
public class Servicelibtype implements java.io.Serializable, CycleRecoverable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer servicelibtypeid;
	private String servicelibtypename;
	private Integer servicecode;
	private Set<Servicelib> servicelibs = new HashSet<Servicelib>(0);

	// Constructors

	/** default constructor */
	public Servicelibtype() {
	}

	/** full constructor */
	public Servicelibtype(String servicelibtypename, Integer servicecode,
			Set<Servicelib> servicelibs) {
		this.servicelibtypename = servicelibtypename;
		this.servicecode = servicecode;
		this.servicelibs = servicelibs;
	}
	
	@Override
	public Object onCycleDetected(Context context) {
		Servicelibtype tempServicelibtype = new Servicelibtype();
		tempServicelibtype.setServicelibtypeid(servicelibtypeid);
		return tempServicelibtype;
	}

	// Property accessors
	public int hashCode() {

		int result = 179;
		result = 37 * result + this.servicelibtypeid.hashCode();
		return result;
	}
	public Integer getServicelibtypeid() {
		return this.servicelibtypeid;
	}

	public void setServicelibtypeid(Integer servicelibtypeid) {
		this.servicelibtypeid = servicelibtypeid;
	}

	public String getServicelibtypename() {
		return this.servicelibtypename;
	}

	public void setServicelibtypename(String servicelibtypename) {
		this.servicelibtypename = servicelibtypename;
	}

	public Integer getServicecode() {
		return this.servicecode;
	}

	public void setServicecode(Integer servicecode) {
		this.servicecode = servicecode;
	}

	@XmlElement(name="servicelibs")
	public Set<Servicelib> getServicelibs() {
		return this.servicelibs;
	}

	public void setServicelibs(Set<Servicelib> servicelibs) {
		this.servicelibs = servicelibs;
	}
}