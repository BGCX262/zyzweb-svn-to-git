package com.zyz.domain;

import java.io.Serializable;

import com.web.app.pub.BaseBean;

public class Zyztbrecord extends BaseBean implements Serializable {

	private static final long serialVersionUID = -7492639752670189553L;

	/** inid */
	private int inid;
	/** itemid */
	private int itemid;
	/** 用户名 */
	private java.lang.String username;
	/** 类型(实名,匿名) */
	private Integer type;
	/** 金额 */
	private java.lang.Double amount;
	/** 祝福 */
	private java.lang.String wish;
	/** 不公开捐献金额 */
	private Integer unpublic;
	/** 捐献日期 */
	private java.util.Date createdate;
	/** 手机号码 */
	private String phoneNo;
	/** 查询密码 */
	private java.lang.String pwd;
	/** 身份证号 */
	private String idcard;
	/** E-mail */
	private java.lang.String eMail;
	/** 工作单位 */
	private String workplace;
	
	/**项目名称*/
	private java.lang.String itemTitle;
	private Integer itemType;
	private Integer itemStatus;
	
	
	public Integer getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Integer itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public java.lang.String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(java.lang.String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public int getInid() {
		return inid;
	}

	public void setInid(int inid) {
		this.inid = inid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public java.lang.Double getAmount() {
		return amount;
	}

	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}

	public java.lang.String getWish() {
		return wish;
	}

	public void setWish(java.lang.String wish) {
		this.wish = wish;
	}

	public Integer getUnpublic() {
		return unpublic;
	}

	public void setUnpublic(Integer unpublic) {
		this.unpublic = unpublic;
	}

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public java.lang.String getPwd() {
		return pwd;
	}

	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public java.lang.String geteMail() {
		return eMail;
	}

	public void seteMail(java.lang.String eMail) {
		this.eMail = eMail;
	}

	public String getCreatedateStr() {
		return com.web.app.util.DateFormator.formatDate(createdate);
	}
}