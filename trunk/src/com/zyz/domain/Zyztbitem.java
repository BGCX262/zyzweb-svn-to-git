package com.zyz.domain;

import java.io.Serializable;

import com.web.app.pub.BaseBean;

public class Zyztbitem extends BaseBean implements Serializable {

	private static final long serialVersionUID = -7492639752670189553L;

	/** itemid */
	private int itemid;
	/** 捐献对象 */
	private java.lang.String targetname;
	/** 标题 */
	private java.lang.String title;
	/** 目标金额 */
	private java.lang.Double targetamount;
	/** 截止日期 */
	private java.util.Date deadline;
	/** 创建日期 */
	private java.util.Date createtime;
	/** 已捐款 */
	private java.lang.Double amount;
	/** 内容 */
	private java.lang.String content;
	/** 图片 */
	private java.lang.String image;
	/** 爱心积分 */
	private Integer score;
	/** 类别 */
	private Integer type;
	/** 状态 */
	private Integer status;
	/** 备注 */
	private java.lang.String remark;
	/** 置顶 */
	private Integer top;
	
	
	//进度
	private String processStr;
	
	

	public String getProcessStr() {
		if(targetamount==0){
			return "0";
		}
		return String.format("%.2f", amount/targetamount*100);
	}


	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public java.lang.String getTargetname() {
		return targetname;
	}

	public void setTargetname(java.lang.String targetname) {
		this.targetname = targetname;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.Double getTargetamount() {
		return targetamount;
	}

	public void setTargetamount(java.lang.Double targetamount) {
		this.targetamount = targetamount;
	}

	public java.util.Date getDeadline() {
		return deadline;
	}

	public void setDeadline(java.util.Date deadline) {
		this.deadline = deadline;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.lang.Double getAmount() {
		return amount;
	}

	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getImage() {
		return image;
	}

	public void setImage(java.lang.String image) {
		this.image = image;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public String getDeadlineStr() {
		return com.web.app.util.DateFormator.formatDate(deadline);
	}

	public String getCreatetimeStr() {
		return com.web.app.util.DateFormator.formatDate(createtime);
	}

}