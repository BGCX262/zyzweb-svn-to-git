package com.mycms.cms.entity.main.base;

import java.io.Serializable;

public class BaseCmsMemberUser implements Serializable {

	public static String REF = "CmsMemberUser";
	public static String PROP_REGISTER_TIME = "registerTime";
	public static String PROP_USER_MOBILE = "userMobile";
	public static String PROP_M_IMSI = "mimsi";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_USER_TYPE = "userType";
	public static String PROP_PASSWORD = "password";
	public static String PROP_USER_GENDER = "userGender";
	public static String PROP_USER_EMAIL = "userEmail";
	public static String PROP_USER_ADDRESS = "userEmail";
	public static String PROP_OTHER_PHONE = "otherPhone";
	public static String PROP_IDENTIFIER = "identifier";
	public static String PROP_CAR_TYPE = "carType";
	public static String PROP_VALID_BEGIN_DATE = "validBeginDate";
	public static String PROP_VALID_PERIOD = "validPeriod";
	public static String PROP_ID = "id";
	public static String PROP_CAR_NUMBER = "carNumber";
	public static String PROP_SUFFIX_NUM = "suffixNum";
	public static String PROP_CAR_REGISTER_TIME = "carRegisterTime";
	public static String PROP_USER_REGISTER_CHANNEL_ID = "userRegisterChannelId";
	public static String PROP_USER_REGISTER_CP_SERVICE_ID = "userRegisterCpServiceId";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_USER_STATUS = "userStatus";
	public static String PROP_LAST_UPDATE_BY = "lastUpdateBy";
	public static String PROP_LAST_UPDATE_TIME = "lastUpdateTime";
	public static String PROP_MEMO = "memo";
	// constructors
	public BaseCmsMemberUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsMemberUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsMemberUser (
			java.lang.Integer id,
			java.lang.String userMobile,
			java.lang.String mimsi,
			java.lang.String userName,
			java.lang.Integer userType,
			java.lang.String password,
			java.lang.Integer userGender,
			java.lang.String userEmail,
			java.lang.String userAddress,
			java.lang.String otherPhone,
			java.lang.String identifier,
			java.lang.String carType,
			java.lang.String validBeginDate,
			java.lang.String validPeriod,
			java.lang.String carNumber,
			java.lang.String suffixNum,
			java.lang.String carRegisterTime,
			java.lang.String userRegisterChannelId,
			java.lang.String userRegisterCpServiceId,
			java.util.Date registerTime,
			java.util.Date updateTime,
			java.lang.Integer userStatus,
			java.lang.String lastUpdateBy,
			java.util.Date lastUpdateTime,
			java.lang.String memo) {

			this.setId(id);
			this.setCarNumber(carNumber);
			this.setCarRegisterTime(carRegisterTime);
			this.setCarType(carType);
			this.setIdentifier(identifier);
			this.setLastUpdateBy(lastUpdateBy);
			this.setLastUpdateTime(lastUpdateTime);
			this.setMemo(memo);
			this.setMimsi(mimsi);
			this.setOtherPhone(otherPhone);
			this.setPassword(password);
			this.setRegisterTime(registerTime);
			this.setSuffixNum(suffixNum);
			this.setUpdateTime(lastUpdateTime);
			this.setUserAddress(userAddress);
			this.setUserEmail(userEmail);
			this.setUserGender(userGender);
			this.setUserMobile(userMobile);
			this.setUserName(userName);
			this.setUserRegisterChannelId(userRegisterChannelId);
			this.setUserRegisterCpServiceId(userRegisterCpServiceId);
			this.setUserStatus(userStatus);
			this.setUserType(userType);
			this.setValidBeginDate(validBeginDate);
			this.setValidPeriod(validPeriod);
			initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userMobile;
	private java.lang.String mimsi;
	private java.lang.String userName;
	private java.lang.Integer userType;
	private java.lang.String password;
	private java.lang.Integer userGender;
	private java.lang.String userEmail;
	private java.lang.String userAddress;
	private java.lang.String otherPhone;
	private java.lang.String identifier;
	private java.lang.String carType;
	private java.lang.String validBeginDate;
	private java.lang.String validPeriod;
	private java.lang.String carNumber;
	private java.lang.String suffixNum;
	private java.lang.String carRegisterTime;
	private java.lang.String userRegisterChannelId;
	private java.lang.String userRegisterCpServiceId;
	private java.util.Date registerTime;
	private java.util.Date updateTime;
	private java.lang.Integer userStatus;
	private java.lang.String lastUpdateBy;
	private java.util.Date lastUpdateTime;
	private java.lang.String memo;


	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(java.lang.String userMobile) {
		this.userMobile = userMobile;
	}

	public java.lang.String getMimsi() {
		return mimsi;
	}

	public void setMimsi(java.lang.String mimsi) {
		this.mimsi = mimsi;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.Integer getUserType() {
		return userType;
	}

	public void setUserType(java.lang.Integer userType) {
		this.userType = userType;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(java.lang.Integer userGender) {
		this.userGender = userGender;
	}

	public java.lang.String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}

	public java.lang.String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(java.lang.String userAddress) {
		this.userAddress = userAddress;
	}

	public java.lang.String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(java.lang.String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public java.lang.String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(java.lang.String identifier) {
		this.identifier = identifier;
	}

	public java.lang.String getCarType() {
		return carType;
	}

	public void setCarType(java.lang.String carType) {
		this.carType = carType;
	}

	public java.lang.String getValidBeginDate() {
		return validBeginDate;
	}

	public void setValidBeginDate(java.lang.String validBeginDate) {
		this.validBeginDate = validBeginDate;
	}

	public java.lang.String getValidPeriod() {
		return validPeriod;
	}

	public void setValidPeriod(java.lang.String validPeriod) {
		this.validPeriod = validPeriod;
	}

	public java.lang.String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(java.lang.String carNumber) {
		this.carNumber = carNumber;
	}

	public java.lang.String getSuffixNum() {
		return suffixNum;
	}

	public void setSuffixNum(java.lang.String suffixNum) {
		this.suffixNum = suffixNum;
	}


	public java.lang.String getCarRegisterTime() {
		return carRegisterTime;
	}

	public void setCarRegisterTime(java.lang.String carRegisterTime) {
		this.carRegisterTime = carRegisterTime;
	}

	public java.lang.String getUserRegisterChannelId() {
		return userRegisterChannelId;
	}

	public void setUserRegisterChannelId(java.lang.String userRegisterChannelId) {
		this.userRegisterChannelId = userRegisterChannelId;
	}

	public java.lang.String getUserRegisterCpServiceId() {
		return userRegisterCpServiceId;
	}

	public void setUserRegisterCpServiceId(java.lang.String userRegisterCpServiceId) {
		this.userRegisterCpServiceId = userRegisterCpServiceId;
	}

	public java.util.Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(java.util.Date registerTime) {
		this.registerTime = registerTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}


	public java.lang.Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(java.lang.Integer userStatus) {
		this.userStatus = userStatus;
	}

	public java.lang.String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(java.lang.String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
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
