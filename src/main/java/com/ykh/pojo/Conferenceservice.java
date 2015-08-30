package com.ykh.pojo;

import com.sun.xml.bind.CycleRecoverable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

/**
 * Conferenceservice generated by MyEclipse Persistence Tools
 */
@XmlRootElement
public class Conferenceservice implements java.io.Serializable, CycleRecoverable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer conferenceserviceid;
	// 预约时不用封装
	private Product product;
	// 可以只封装ID引用
	private Servicelib servicelib;
	private String conferenceservicename;
	private String inputtype;
//	// 预约时不用封装，模板创建时需要封装
//	private Set<Conferenceprivilege> conferenceprivileges = new HashSet<Conferenceprivilege>(0);
	// 预约时需要封装页面配置的信息为conferenceservicevalues
	/**
	 * 只用于内存存储，不会存储到数据库中
	 */
	private Set<Conferenceservicevalue> conferenceservicevalues = new HashSet<Conferenceservicevalue>(0);
//	// 任何时候不用主动封装，只为查询conferenceservice级联被动加载应用
//	private Set<Conferenceuservalue> conferenceuservalues = new HashSet<Conferenceuservalue>(0);

	// Constructors

	/** default constructor */
	public Conferenceservice() {
	}

//	/** full constructor */
//	public Conferenceservice(Product product, Servicelib servicelib, String conferenceservicename,String inputtype, 
//			Set<Conferenceservicevalue> conferenceservicevalues, Set<Conferenceuservalue> conferenceuservalues) {
//		this.product = product;
//		this.servicelib = servicelib;
//		this.conferenceservicename = conferenceservicename;
//		this.inputtype = inputtype;
////		this.conferenceprivileges = conferenceprivileges;
//		this.conferenceservicevalues = conferenceservicevalues;
////		this.conferenceuservalues = conferenceuservalues;
//	}
	
	@Override
	public Object onCycleDetected(Context context) {
		Conferenceservice tempConfService = new Conferenceservice();
		tempConfService.setConferenceserviceid(conferenceserviceid);
		tempConfService.setConferenceservicename(conferenceservicename);
		tempConfService.setInputtype(inputtype);
		return tempConfService;
	}

	// Property accessors
	public int hashCode() {

		int result = 179;
		result = 37 * result + (conferenceserviceid == null ? System.identityHashCode(this) : conferenceserviceid.hashCode());
		return result;
	}
	public Integer getConferenceserviceid() {
		return this.conferenceserviceid;
	}

	public void setConferenceserviceid(Integer conferenceserviceid) {
		this.conferenceserviceid = conferenceserviceid;
	}

//	@XmlElement(name="product")
	@XmlTransient
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@XmlElement(name="servicelib")
	public Servicelib getServicelib() {
		return this.servicelib;
	}

	public void setServicelib(Servicelib servicelib) {
		this.servicelib = servicelib;
	}

	public String getConferenceservicename() {
		return this.conferenceservicename;
	}

	public void setConferenceservicename(String conferenceservicename) {
		this.conferenceservicename = conferenceservicename;
	}

//	@XmlElement(name="conferenceservicevalues")
	/**
	 * 只用于内存存储，不会存储到数据库中
	 */
	public Set<Conferenceservicevalue> getConferenceservicevalues() {
		return this.conferenceservicevalues;
	}

	/**
	 * 只用于内存存储，不会存储到数据库中
	 */
	public void setConferenceservicevalues(Set<Conferenceservicevalue> conferenceservicevalues) {
		this.conferenceservicevalues = conferenceservicevalues;
	}

//	@XmlElement(name="conferenceuservalues")
//	public Set<Conferenceuservalue> getConferenceuservalues() {
//		return conferenceuservalues;
//	}
//
//	public void setConferenceuservalues(Set<Conferenceuservalue> conferenceuservalues) {
//		this.conferenceuservalues = conferenceuservalues;
//	}

//	@XmlElement(name="conferenceprivileges")
//	public Set<Conferenceprivilege> getConferenceprivileges() {
//		return conferenceprivileges;
//	}
//
//	public void setConferenceprivileges(Set<Conferenceprivilege> conferenceprivileges) {
//		this.conferenceprivileges = conferenceprivileges;
//	}

	/**
	 * inputtype
	 * @return  the inputtype
	 */
	
	public String getInputtype() {
		return inputtype;
	}

	/**
	 * inputtype
	 * @param   inputtype    the inputtype to set
	 */
	
	public void setInputtype(String inputtype) {
		this.inputtype = inputtype;
	}
}