package com.mycms.cms.entity.main.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_role table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_role"
 */

public abstract class BaseCmsCompanyType  implements Serializable {

	public static String REF = "CmsCompanyType";
	public static String PROP_CODE = "code";
	public static String PROP_NAME = "name";
	public static String PROP_MEMO = "memo";
	public static String PROP_PARENT = "parent";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsCompanyType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsCompanyType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsCompanyType (
		java.lang.Integer id,
		java.lang.Integer parent,
		java.lang.String name,
		java.lang.String memo,
		java.lang.Integer code) {

		this.setId(id);
		this.setName(name);
		this.setMemo(memo);
		this.setCode(code);
		this.setParent(parent);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String memo;
	private java.lang.Integer code;
	private java.lang.Integer parent;




	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="role_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	/**
	 * Return the value associated with the column: role_name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: role_name
	 * @param name the role_name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}


	public java.lang.Integer getCode() {
		return code;
	}

	public void setCode(java.lang.Integer code) {
		this.code = code;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.mycms.cms.entity.main.CmsRole)) return false;
		else {
			com.mycms.cms.entity.main.CmsRole cmsRole = (com.mycms.cms.entity.main.CmsRole) obj;
			if (null == this.getId() || null == cmsRole.getId()) return false;
			else return (this.getId().equals(cmsRole.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

	public java.lang.Integer getParent() {
		return parent;
	}

	public void setParent(java.lang.Integer parent) {
		this.parent = parent;
	}


}