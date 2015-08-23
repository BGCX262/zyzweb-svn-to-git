package com.zyz.domain;

import java.io.Serializable;
import java.util.Date;

import com.web.app.pub.BaseBean;

public class Zyzinfo extends BaseBean implements Serializable {

	private static final long serialVersionUID = -7492639752670189553L;

	public Zyzinfo() {
		// TODO Auto-generated constructor stub
	}
	 public String  getInsertdateStr() {
		    if(insertdate==null)return "";
		    return com.web.app.util.DateFormator.formatDate1(insertdate);
		  }
	public Zyzinfo(String username, String cardid, String phone, String area,
			String sex, String servicetype, String createdate, String score,
			String servicetimes, String workdate, String worktime,
			String company, String professional, String password) {
		this.username = username;
		this.cardid = cardid;
		this.phone = phone;
		this.area = area;
		this.sex = sex;
		this.servicetype = servicetype;
		this.createdate = createdate;
		this.score = score;
		this.servicetimes = servicetimes;
		this.workdate = workdate;
		this.worktime = worktime;
		this.company = company;
		this.professional = professional;
		this.password = password;
		this.insertdate=new Date();
	}

	/** 编号 */
	private Integer zyzid;
	/** 用户姓名 */
	private String username;
	/** 证件号码 */
	private String cardid;
	/** 手机号码 */
	private String phone;
	/** 归口单位 */
	private String area;
	/** 性别 */
	private String sex;
	/** 服务类别 */
	private String servicetype;
	/** 建立时间 */
	private String createdate;
	/** 积分 */
	private String score;
	/** 服务时长 */
	private String servicetimes;
	/** 可服务时间 */
	private String workdate;
	/** 可服务时段 */
	private String worktime;
	/** 工作单位 */
	private String company;
	/** 专业或特长 */
	private String professional;
	/** 密码 */
	private String password;
	  /**数据导入时间*/
	  private java.util.Date insertdate;
	  
	public java.util.Date getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(java.util.Date insertdate) {
		this.insertdate = insertdate;
	}

	public Integer getZyzid() {
		return zyzid;
	}

	public String getUsername() {
		return username;
	}

	public String getCardid() {
		return cardid;
	}

	public String getPhone() {
		return phone;
	}

	public String getArea() {
		return area;
	}

	public String getSex() {
		return sex;
	}

	public String getServicetype() {
		return servicetype;
	}

	public String getCreatedate() {
		return createdate;
	}

	public String getScore() {
		return score;
	}

	public String getServicetimes() {
		return servicetimes;
	}

	public String getWorkdate() {
		return workdate;
	}

	public String getWorktime() {
		return worktime;
	}

	public String getCompany() {
		return company;
	}

	public String getProfessional() {
		return professional;
	}

	public String getPassword() {
		return password;
	}

	public void setZyzid(Integer zyzid) {
		this.zyzid = zyzid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public void setServicetimes(String servicetimes) {
		this.servicetimes = servicetimes;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 统计字段

	private String cservicetimes;// 时长
	private String cscore;// 分数
	
	private String cservicetimesavg;// 平均时长
	private String cscoreavg;// 平均分数
	
	private String D0100;// 党组织ID
	private String D0104;// 党组织名称

	private String D1600;// 单位ID
	private String D1601A;// 单位名称
	private String czyz;// 志愿者人数
	private String subdzz;//下级党组织
	
	private String dyrs;// 党员人数
	private String zyrs;// 志愿者人数
	private String rs;// 总人数
	private String percent;// 百分比
	private String flid;// 分类id
	private String flname;// 分类id
	private String score1;;
	private String score2;
	private String servicetimes1;
	private String servicetimes2;
/*	private String A0174;
	private String A0135;
	private String A0151;
	private String A0184;
	private String C0203;
	private String A0117;
	private String A0801;*/
	private String D0107;
	private String D0101;

	
	
	public String getSubdzz() {
		return subdzz;
	}

	public void setSubdzz(String subdzz) {
		this.subdzz = subdzz;
	}

	public String getCservicetimesavg() {
		return cservicetimesavg;
	}

	public void setCservicetimesavg(String cservicetimesavg) {
		this.cservicetimesavg = cservicetimesavg;
	}

	public String getCscoreavg() {
		return cscoreavg;
	}

	public void setCscoreavg(String cscoreavg) {
		this.cscoreavg = cscoreavg;
	}

	public String getD0107() {
		return D0107;
	}

	public void setD0107(String d0107) {
		D0107 = d0107;
	}

	public String getD0101() {
		return D0101;
	}

	public void setD0101(String d0101) {
		D0101 = d0101;
	}

	public String getZyrs() {
		return zyrs;
	}

	public void setZyrs(String zyrs) {
		this.zyrs = zyrs;
	}

	public String getScore1() {
		return score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}

	public String getServicetimes1() {
		return servicetimes1;
	}

	public void setServicetimes1(String servicetimes1) {
		this.servicetimes1 = servicetimes1;
	}

	public String getServicetimes2() {
		return servicetimes2;
	}

	public void setServicetimes2(String servicetimes2) {
		this.servicetimes2 = servicetimes2;
	}

	public String getFlid() {
		return flid;
	}

	public void setFlid(String flid) {
		this.flid = flid;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getDyrs() {
		return dyrs;
	}

	public void setDyrs(String dyrs) {
		this.dyrs = dyrs;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	private String nl;// 年龄段
	private String nlPercert;
	private String nlBarWidth;

	private String zrs;
	private String dyzr;

	public String getZrs() {
		return zrs;
	}

	public void setZrs(String zrs) {
		this.zrs = zrs;
	}

	public String getDyzr() {
		return dyzr;
	}

	public void setDyzr(String dyzr) {
		this.dyzr = dyzr;
	}

	public String getNlBarWidth() {
		return nlBarWidth;
	}

	public void setNlBarWidth(String nlBarWidth) {
		this.nlBarWidth = nlBarWidth;
	}

	public String getNlPercert() {
		return nlPercert;
	}

	public void setNlPercert(String nlPercert) {
		this.nlPercert = nlPercert;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
		if (nl.equals("192")) {
			this.nl = "20年代";
		} else if (nl.equals("193")) {
			this.nl = "30年代";
		} else if (nl.equals("193")) {
			this.nl = "30年代";
		} else if (nl.equals("194")) {
			this.nl = "40年代";
		} else if (nl.equals("195")) {
			this.nl = "50年代";
		} else if (nl.equals("196")) {
			this.nl = "60年代";
		} else if (nl.equals("197")) {
			this.nl = "70年代";
		} else if (nl.equals("198")) {
			this.nl = "80年代";
		} else if (nl.equals("199")) {
			this.nl = "90年代";
		} else if (nl.equals("200")) {
			this.nl = "00年代";
		} else if (nl.equals("201")) {
			this.nl = "10年代";
		}
	}
	public String getNlFromFlName() {
		this.nl = flname;
		if (nl.equals("192")) {
			this.nl = "20年代";
		} else if (nl.equals("193")) {
			this.nl = "30年代";
		} else if (nl.equals("193")) {
			this.nl = "30年代";
		} else if (nl.equals("194")) {
			this.nl = "40年代";
		} else if (nl.equals("195")) {
			this.nl = "50年代";
		} else if (nl.equals("196")) {
			this.nl = "60年代";
		} else if (nl.equals("197")) {
			this.nl = "70年代";
		} else if (nl.equals("198")) {
			this.nl = "80年代";
		} else if (nl.equals("199")) {
			this.nl = "90年代";
		} else if (nl.equals("200")) {
			this.nl = "00年代";
		} else if (nl.equals("201")) {
			this.nl = "10年代";
		}
		return this.nl;
	}

	public String getCzyz() {
		return czyz;
	}

	public void setCzyz(String czyz) {
		this.czyz = czyz;
	}

	public String getD1600() {
		return D1600;
	}

	public void setD1600(String d1600) {
		D1600 = d1600;
	}

	public String getD1601A() {
		return D1601A;
	}

	public void setD1601A(String d1601a) {
		D1601A = d1601a;
	}

	public String getCservicetimes() {
		return cservicetimes;
	}

	public void setCservicetimes(String cservicetimes) {
		this.cservicetimes = cservicetimes;
	}

	public String getCscore() {
		return cscore;
	}

	public void setCscore(String cscore) {
		this.cscore = cscore;
	}

	public String getD0100() {
		return D0100;
	}

	public void setD0100(String d0100) {
		D0100 = d0100;
	}

	public String getD0104() {
		return D0104;
	}

	public void setD0104(String d0104) {
		D0104 = d0104;
	}

}