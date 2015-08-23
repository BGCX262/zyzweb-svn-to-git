package com.mycms.cms.entity.main.base;

import java.io.Serializable;

public class BaseCmsMajorComp implements Serializable {

	public static String REF = "CmsMajorComp";
	public static String PROP_NAME = "name";
	public static String PROP_TYPEID = "typeid";
	public static String PROP_RECOMMAND = "recommand";
	public static String PROP_PROVINCE = "province";
	public static String PROP_CITY = "city";
	public static String PROP_COUNTRY = "country";
	public static String PROP_PCODE = "pcode";
	public static String PROP_ADDRESS = "address";
	public static String PROP_TELEPHONE = "telephone";
	public static String PROP_FAX = "fax";
	public static String PROP_CHIEF = "chief";
	public static String PROP_CHIEF_TELEPHONE = "chiefTelephone";
	public static String PROP_ISALLIANCE = "isalliance";
	public static String PROP_ALLIANCEID = "allianceid";
	public static String PROP_ID = "id";
	public static String PROP_AUDIT_BY = "auditBy";
	public static String PROP_AUDIT_TIME = "auditTime";
	public static String PROP_OPERATE_BY = "createBy";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_IMAGE = "image";
	public static String PROP_GUIDEPIC = "guidepic";
	public static String PROP_COMP_LEVEL = "compLevel";
	public static String PROP_TAG = "tag";
	public static String PROP_LNG = "lng";	
	public static String PROP_LAT = "lat";
	public static String PROP_ISOFFSET = "isoffset";
	public static String PROP_SON_ID = "sonId";
	public static String PROP_CONTENT = "content";
	public static String PROP_PRONAME = "proname";
	public static String PROP_NORMAL_PRICE = "normalPrice";
	public static String PROP_HOLIDAY_PRICE = "holddayPrice";
	public static String PROP_M_TYPE = "mType";
	public static String PROP_M_TRUST = "mTrust";
	public static String PROP_M_Device = "mDevice";
	public static String PROP_M_Content = "mContent";
	public static String PROP_ISACT = "isact";
	public static String PROP_ACT_CONTENT = "actContent";
	// constructors
	public BaseCmsMajorComp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsMajorComp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsMajorComp (
			java.lang.Integer id,
			java.lang.String name,
			java.lang.String typeid,
			java.lang.Integer recommand,
			java.lang.String province,
			java.lang.String city,
			java.lang.String country,
			java.lang.String pcode,
			java.lang.String address,
			java.lang.String telephone,
			java.lang.String fax,
			java.lang.String chief,
			java.lang.String chiefTelephone,
			java.lang.Integer isalliance,
			java.lang.Integer allianceid,
			java.lang.String auditBy,
			java.util.Date auditTime,
			java.lang.String createBy,
			java.util.Date createTime,
			java.lang.String image,
			java.lang.String guidepic,
			java.lang.Integer compLevel,
			java.lang.String tag,
			java.lang.String lng,
			java.lang.String lat,
			java.lang.Integer isoffset,
			java.lang.String sonId,
			java.lang.String content,
			java.lang.String proname,
			java.lang.String normalPrice,
			java.lang.String holddayPrice,
			java.lang.String mtype,
			java.lang.Integer mtrust,
			java.lang.Integer mdevice,
			java.lang.String mcontent,
			java.lang.Integer isact,
			java.lang.String actContent) {

			this.setId(id);
			this.setName(name);
			this.setTypeid(typeid);
			this.setRecommand(recommand);
			this.setProvince(province);
			this.setCity(city);
			this.setCountry(country);
			this.setPcode(pcode);
			this.setAddress(address);
			this.setTelephone(telephone);
			this.setFax(fax);
			this.setChief(chief);
			this.setChiefTelephone(chiefTelephone);
			this.setIsalliance(isalliance);
			this.setAllianceid(allianceid);
			this.setAuditBy(auditBy);
			this.setAuditTime(auditTime);
			this.setCreateBy(createBy);
			this.setCreateTime(createTime);
			this.setImage(image);
			this.setGuidepic(guidepic);
			this.setCompLevel(compLevel);
			this.setTag(tag);
			this.setLng(lng);
			this.setLat(lat);
			this.setIsoffset(isoffset);
			this.setSonId(sonId);
			this.setContent(content);
			this.setProname(proname);
			this.setNormalPrice(normalPrice);
			this.setHolddayPrice(holddayPrice);
			this.setMtype(mtype);
			this.setMtrust(mtrust);
			this.setMdevice(mdevice);
			this.setMcontent(mcontent);
			this.setIsact(isact);
			this.setActContent(actContent);
			initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String typeid;
	private java.lang.Integer recommand;
	private java.lang.String province;
	private java.lang.String city;
	private java.lang.String country;
	private java.lang.String pcode;
	private java.lang.String address;
	private java.lang.String telephone;
	private java.lang.String fax;
	private java.lang.String chief;
	private java.lang.String chiefTelephone;
	private java.lang.Integer isalliance;
	private java.lang.Integer allianceid;
	private java.lang.String auditBy;
	private java.util.Date auditTime;
	private java.lang.String createBy;
	private java.util.Date createTime;
	private java.lang.String image;
	private java.lang.String guidepic;
	private java.lang.Integer compLevel;
	private java.lang.String tag;
	private java.lang.String lng;
	private java.lang.String lat;
	private java.lang.Integer isoffset;
	private java.lang.String sonId;
	private java.lang.String content;
	private java.lang.String proname;
	private java.lang.String normalPrice;
	private java.lang.String holddayPrice;
	private java.lang.String mtype;
	private java.lang.Integer mtrust;
	private java.lang.Integer mdevice;
	private java.lang.String mcontent;
	private java.lang.Integer isact;
	private java.lang.String actContent;
	
	
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




	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getTypeid() {
		return typeid;
	}

	public void setTypeid(java.lang.String typeid) {
		this.typeid = typeid;
	}

	public java.lang.Integer getRecommand() {
		return recommand;
	}

	public void setRecommand(java.lang.Integer recommand) {
		this.recommand = recommand;
	}

	public java.lang.String getProvince() {
		return province;
	}

	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	public java.lang.String getCity() {
		return city;
	}

	public void setCity(java.lang.String city) {
		this.city = city;
	}


	public java.lang.String getCountry() {
		return country;
	}

	public void setCountry(java.lang.String country) {
		this.country = country;
	}

	public java.lang.String getPcode() {
		return pcode;
	}

	public void setPcode(java.lang.String pcode) {
		this.pcode = pcode;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getTelephone() {
		return telephone;
	}

	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.lang.String getChief() {
		return chief;
	}

	public void setChief(java.lang.String chief) {
		this.chief = chief;
	}

	public java.lang.String getChiefTelephone() {
		return chiefTelephone;
	}

	public void setChiefTelephone(java.lang.String chiefTelephone) {
		this.chiefTelephone = chiefTelephone;
	}

	public java.lang.Integer getIsalliance() {
		return isalliance;
	}

	public void setIsalliance(java.lang.Integer isalliance) {
		this.isalliance = isalliance;
	}

	public java.lang.Integer getAllianceid() {
		return allianceid;
	}

	public void setAllianceid(java.lang.Integer allianceid) {
		this.allianceid = allianceid;
	}

	public java.lang.String getAuditBy() {
		return auditBy;
	}

	public void setAuditBy(java.lang.String auditBy) {
		this.auditBy = auditBy;
	}

	public java.util.Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(java.util.Date auditTime) {
		this.auditTime = auditTime;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getImage() {
		return image;
	}

	public void setImage(java.lang.String image) {
		this.image = image;
	}

	public java.lang.String getGuidepic() {
		return guidepic;
	}

	public void setGuidepic(java.lang.String guidepic) {
		this.guidepic = guidepic;
	}

	public java.lang.Integer getCompLevel() {
		return compLevel;
	}

	public void setCompLevel(java.lang.Integer compLevel) {
		this.compLevel = compLevel;
	}

	public java.lang.String getTag() {
		return tag;
	}

	public void setTag(java.lang.String tag) {
		this.tag = tag;
	}

	public java.lang.String getLng() {
		return lng;
	}

	public void setLng(java.lang.String lng) {
		this.lng = lng;
	}

	public java.lang.String getLat() {
		return lat;
	}

	public void setLat(java.lang.String lat) {
		this.lat = lat;
	}

	public java.lang.Integer getIsoffset() {
		return isoffset;
	}

	public void setIsoffset(java.lang.Integer isoffset) {
		this.isoffset = isoffset;
	}

	public java.lang.String getSonId() {
		return sonId;
	}

	public void setSonId(java.lang.String sonId) {
		this.sonId = sonId;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getProname() {
		return proname;
	}

	public void setProname(java.lang.String proname) {
		this.proname = proname;
	}

	public java.lang.String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(java.lang.String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public java.lang.String getHolddayPrice() {
		return holddayPrice;
	}

	public void setHolddayPrice(java.lang.String holddayPrice) {
		this.holddayPrice = holddayPrice;
	}



	public java.lang.String getMtype() {
		return mtype;
	}

	public void setMtype(java.lang.String mtype) {
		this.mtype = mtype;
	}

	public java.lang.Integer getMtrust() {
		return mtrust;
	}

	public void setMtrust(java.lang.Integer mtrust) {
		this.mtrust = mtrust;
	}


	public java.lang.Integer getMdevice() {
		return mdevice;
	}

	public void setMdevice(java.lang.Integer mdevice) {
		this.mdevice = mdevice;
	}

	public java.lang.String getMcontent() {
		return mcontent;
	}

	public void setMcontent(java.lang.String mcontent) {
		this.mcontent = mcontent;
	}


	public java.lang.Integer getIsact() {
		return isact;
	}

	public void setIsact(java.lang.Integer isact) {
		this.isact = isact;
	}

	public java.lang.String getActContent() {
		return actContent;
	}

	public void setActContent(java.lang.String actContent) {
		this.actContent = actContent;
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


	public String toString () {
		return super.toString();
	}

}
