package com.mycms.cms.entity.main.base;

import java.io.Serializable;

public class BaseMerchantMarking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8937121929501021295L;
	public static String REF = "MerchantMarking";
	public static String PROP_MERCHANTID = "merchantId";
	public static String PROP_M_TYPE = "mType";
	public static String PROP_M_D_TOPIC = "mdTopic";
	public static String PROP_M_Content = "mContent";
	public static String PROP_M_B_TOPIC = "mbTopic";
	public static String PROP_M_INTRODUCTION = "mIntroduction";
	public static String PROP_M_B_PIC = "mbPic";
	public static String PROP_M_D_PIC = "mdPic";
	public static String PROP_OPDATE = "opDate";
	public static String PROP_OPERID = "operId";
	public static String PROP_STATUS = "status";
	// constructors
	public BaseMerchantMarking () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMerchantMarking (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMerchantMarking (
			java.lang.Integer id,
			java.lang.Integer merchantId,
			java.lang.String mtype,
			java.lang.Integer mdTopic,
			java.lang.String mcontent,
			java.lang.String mbTopic,
			java.lang.String mintroduction,
			java.lang.String mbPic,
			java.lang.String mdPic,
			java.util.Date opDate,
			java.lang.String operId,
			java.lang.String status) {

			this.setId(id);
			this.setMerchantId(merchantId);
			this.setMtype(mtype);
			this.setMdTopic(mdTopic);
			this.setMcontent(mcontent);
			this.setMbTopic(mbTopic);
			this.setMintroduction(mintroduction);
			this.setMbPic(mbPic);
			this.setMdPic(mdPic);
			this.setOpDate(opDate);
			this.setOperId(operId);
			this.setStatus(status);
			initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer merchantId;
	private java.lang.String mtype;
	private java.lang.Integer mdTopic;
	private java.lang.String mcontent;
	private java.lang.String mbTopic;
	private java.lang.String mintroduction;
	private java.lang.String mbPic;
	private java.lang.String mdPic;
	private java.util.Date opDate;
	private java.lang.String operId;
	private java.lang.String status;
	
	
	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.Integer getId() {
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






	public java.lang.Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(java.lang.Integer merchantId) {
		this.merchantId = merchantId;
	}

	public java.lang.String getMtype() {
		return mtype;
	}

	public void setMtype(java.lang.String mtype) {
		this.mtype = mtype;
	}

	public java.lang.Integer getMdTopic() {
		return mdTopic;
	}

	public void setMdTopic(java.lang.Integer mdTopic) {
		this.mdTopic = mdTopic;
	}

	public java.lang.String getMcontent() {
		return mcontent;
	}

	public void setMcontent(java.lang.String mcontent) {
		this.mcontent = mcontent;
	}

	public java.lang.String getMbTopic() {
		return mbTopic;
	}

	public void setMbTopic(java.lang.String mbTopic) {
		this.mbTopic = mbTopic;
	}

	public java.lang.String getMintroduction() {
		return mintroduction;
	}

	public void setMintroduction(java.lang.String mintroduction) {
		this.mintroduction = mintroduction;
	}

	public java.lang.String getMbPic() {
		return mbPic;
	}

	public void setMbPic(java.lang.String mbPic) {
		this.mbPic = mbPic;
	}

	public java.lang.String getMdPic() {
		return mdPic;
	}

	public void setMdPic(java.lang.String mdPic) {
		this.mdPic = mdPic;
	}

	public java.util.Date getOpDate() {
		return opDate;
	}

	public void setOpDate(java.util.Date opDate) {
		this.opDate = opDate;
	}

	public java.lang.String getOperId() {
		return operId;
	}

	public void setOperId(java.lang.String operId) {
		this.operId = operId;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.mycms.cms.entity.main.CmsUser)) return false;
		else {
			com.mycms.cms.entity.main.CmsMemberUser cmsMemberUser = (com.mycms.cms.entity.main.CmsMemberUser) obj;
			if (null == this.getId() || null == cmsMemberUser.getId()) return false;
			else return (this.getId().equals(cmsMemberUser.getId()));
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


	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public String toString () {
		return super.toString();
	}

}
