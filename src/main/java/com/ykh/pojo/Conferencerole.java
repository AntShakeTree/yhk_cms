package com.ykh.pojo;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * ClassName:Conferencerole
 * <p/>
 * ClassDesc：会议中角色对象，在产品定义的时候确定。
 *
 * @author dongyu.zhang
 * @version 1.0
 * @Date 2009 Apr 16, 2009 1:37:39 PM
 * @since Ver 1.0
 */
@XmlRootElement
public class Conferencerole implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer roleid;
    //	private Product product;
    private String rolename;
    //private Integer maxuser;
//	private Set<Conferenceprivilege> conferenceprivileges = new HashSet<Conferenceprivilege>(0);

    //private Integer productid;
    // Constructors

    /**
     * default constructor
     */
    public Conferencerole() {
    }

    /**
     * full constructor
     */
//	public Conferencerole(Product product, String rolename, Integer maxuser, Set<Conferenceprivilege> conferenceprivileges) {
//		this.product = product;
//		this.rolename = rolename;
//		this.maxuser = maxuser;
//		this.conferenceprivileges = conferenceprivileges;
//	}
    public Conferencerole(String rolename) {
        this.rolename = rolename;
    }

    // Property accessors
    public int hashCode() {

        int result = 179;
        result = 37 * result + (roleid == null ? System.identityHashCode(this) : roleid.hashCode());
        return result;
    }

    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

//	@XmlElement(name="product")
//	public Product getProduct() {
//		return this.product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

//	@XmlElement(name="conferenceprivilege")
//	public Set<Conferenceprivilege> getConferenceprivileges() {
//		return this.conferenceprivileges;
//	}
//
//	public void setConferenceprivileges(Set<Conferenceprivilege> conferenceprivileges) {
//		this.conferenceprivileges = conferenceprivileges;
//	}

    /**
     * maxuser
     *
     * @return the maxuser
     */

//	public Integer getMaxuser() {
//		return maxuser;
//	}
//
//	/**
//	 * maxuser
//	 * 
//	 * @param maxuser the maxuser to set
//	 */
//
//	public void setMaxuser(Integer maxuser) {
//		this.maxuser = maxuser;
//	}

//	public Integer getProductid() {
//		return productid;
//	}
//
//	public void setProductid(Integer productid) {
//		this.productid = productid;
//	}

}