package com.zyz.domain;

import java.io.Serializable;

import com.web.app.pub.BaseBean;

public class D01 extends BaseBean implements Serializable {

  private static final long serialVersionUID = -7492639752670189553L;
  private boolean hasChild;

 
  public boolean isHasChild() {
	return hasChild;
}
public void setHasChild(boolean hasChild) {
	this.hasChild = hasChild;
}

public java.lang.Integer getPcount() {
	return pcount;
}
public void setPcount(java.lang.Integer pcount) {
	this.pcount = pcount;
}

private java.lang.Integer pcount;
  /**党组织ID*/
  private java.lang.String D0100;
  /**组织名称*/
  private java.lang.String D0101;
  /**组织全称*/
  private java.lang.String D0104;
  /**序号*/
  private int D0105;
  /**(同类）数量*/
  private int D0106;
  /**组织VARCHAR(%N)*/
  private java.lang.String D0107;
  /**党组织VARCHAR(%N)*/
  private java.lang.String D0108;
  /**组织分类*/
  private java.lang.String D0112;
  /**是否类别*/
  private java.lang.String D0113;
  /**组织属性*/
  private java.lang.String D0121;
  /**组织级别VARCHAR(%N)*/
  private java.lang.String D0123;
  /**建立DATE*/
  private java.util.Date D0144;
  /**建立文号*/
  private java.lang.String D0147;
  /**建立原因*/
  private java.lang.String D0151;
  /**撤销DATE*/
  private java.util.Date D0154;
  /**撤销文号*/
  private java.lang.String D0157;
  /**撤销原因*/
  private java.lang.String D0161;
  /**录入人*/
  private java.lang.String D0172;
  /**录入时间*/
  private java.util.Date D0173;
  /**党组织属地关系*/
  private java.lang.String D0175;
  /**建立党员服务机构标识*/
  private java.lang.String D0189;
  /**通讯地址*/
  private java.lang.String D0191;
  /**邮政VARCHAR(%N)*/
  private java.lang.String D0192;
  /**联系电话*/
  private java.lang.String D0193;
  /**传真号码*/
  private java.lang.String D0194;
  /**法人单位标识*/
  private java.lang.String D01A1;
  /**政府工作部门建立党组织情况*/
  private java.lang.String D01A2;
  /**在岗职工、从业人数*/
  private int D01A3;
  /**35岁以下在岗职工、从业人数*/
  private int D01A4;
  /**职工中工人数*/
  private int D01A5;
  /**在岗专业技术人员数*/
  private int D01A6;
  /**是否建立党员志愿者队伍*/
  private java.lang.String D01B1;
  /**是否党建工作指导员联系的*/
  private java.lang.String D01B2;
  /**是否派出党建指导员*/
  private java.lang.String D01B3;
  /**党建指导员数量*/
  private int D01B4;
  /**是否改制企业*/
  private java.lang.String D01B5;
  /**法定代表人是否党员*/
  private java.lang.String D01B6;
  /**法人代表兼任企业党组织书记*/
  private java.lang.String D01B7;
  /**单位ID*/
  private java.lang.String D01DW;
  /**单位名称*/
  private java.lang.String E0202;
  /**单位类型*/
  private java.lang.String E0203;
  /**所属行业*/
  private java.lang.String E0205;
  /**单位属性*/
  private java.lang.String E0206;
  /**企业类型*/
  private java.lang.String E0207;
  /**重要骨干企业*/
  private java.lang.String E0208;
  /**法人单位建立党的基层组织*/
  private java.lang.String E0209;
  /**单位隶属关系*/
  private java.lang.String E0261;
  /**经济类型*/
  private java.lang.String E0263;
  /**城市街道社区镇乡村标识*/
  private java.lang.String E0265;
  /**中介组织类型*/
  private java.lang.String E0267;
  /**企业规模*/
  private java.lang.String E0326;
  /**升级标志*/
  private java.lang.String F_UPDATE;

  public java.lang.String getD0100() {
    return D0100;
  }
  public java.lang.String getD0101() {
    return D0101;
  }
  public java.lang.String getD0104() {
    return D0104;
  }
  public int getD0105() {
    return D0105;
  }
  public int getD0106() {
    return D0106;
  }
  public java.lang.String getD0107() {
    return D0107;
  }
  public java.lang.String getD0108() {
    return D0108;
  }
  public java.lang.String getD0112() {
    return D0112;
  }
  public java.lang.String getD0113() {
    return D0113;
  }
  public java.lang.String getD0121() {
    return D0121;
  }
  public java.lang.String getD0123() {
    return D0123;
  }
  public java.util.Date getD0144() {
    return D0144;
  }
  public java.lang.String getD0147() {
    return D0147;
  }
  public java.lang.String getD0151() {
    return D0151;
  }
  public java.util.Date getD0154() {
    return D0154;
  }
  public java.lang.String getD0157() {
    return D0157;
  }
  public java.lang.String getD0161() {
    return D0161;
  }
  public java.lang.String getD0172() {
    return D0172;
  }
  public java.util.Date getD0173() {
    return D0173;
  }
  public java.lang.String getD0175() {
    return D0175;
  }
  public java.lang.String getD0189() {
    return D0189;
  }
  public java.lang.String getD0191() {
    return D0191;
  }
  public java.lang.String getD0192() {
    return D0192;
  }
  public java.lang.String getD0193() {
    return D0193;
  }
  public java.lang.String getD0194() {
    return D0194;
  }
  public java.lang.String getD01A1() {
    return D01A1;
  }
  public java.lang.String getD01A2() {
    return D01A2;
  }
  public int getD01A3() {
    return D01A3;
  }
  public int getD01A4() {
    return D01A4;
  }
  public int getD01A5() {
    return D01A5;
  }
  public int getD01A6() {
    return D01A6;
  }
  public java.lang.String getD01B1() {
    return D01B1;
  }
  public java.lang.String getD01B2() {
    return D01B2;
  }
  public java.lang.String getD01B3() {
    return D01B3;
  }
  public int getD01B4() {
    return D01B4;
  }
  public java.lang.String getD01B5() {
    return D01B5;
  }
  public java.lang.String getD01B6() {
    return D01B6;
  }
  public java.lang.String getD01B7() {
    return D01B7;
  }
  public java.lang.String getD01DW() {
    return D01DW;
  }
  public java.lang.String getE0202() {
    return E0202;
  }
  public java.lang.String getE0203() {
    return E0203;
  }
  public java.lang.String getE0205() {
    return E0205;
  }
  public java.lang.String getE0206() {
    return E0206;
  }
  public java.lang.String getE0207() {
    return E0207;
  }
  public java.lang.String getE0208() {
    return E0208;
  }
  public java.lang.String getE0209() {
    return E0209;
  }
  public java.lang.String getE0261() {
    return E0261;
  }
  public java.lang.String getE0263() {
    return E0263;
  }
  public java.lang.String getE0265() {
    return E0265;
  }
  public java.lang.String getE0267() {
    return E0267;
  }
  public java.lang.String getE0326() {
    return E0326;
  }
  public java.lang.String getF_UPDATE() {
    return F_UPDATE;
  }
  public String  getD0144Str() {
    return com.web.app.util.DateFormator.formatDate(D0144);
  }
  public String  getD0154Str() {
    return com.web.app.util.DateFormator.formatDate(D0154);
  }
  public String  getD0173Str() {
    return com.web.app.util.DateFormator.formatDate(D0173);
  }
  public void setD0100( java.lang.String  D0100) {
    this.D0100 = D0100;
  } 
  public void setD0101( java.lang.String  D0101) {
    this.D0101 = D0101;
  } 
  public void setD0104( java.lang.String  D0104) {
    this.D0104 = D0104;
  } 
  public void setD0105( int  D0105) {
    this.D0105 = D0105;
  } 
  public void setD0106( int  D0106) {
    this.D0106 = D0106;
  } 
  public void setD0107( java.lang.String  D0107) {
    this.D0107 = D0107;
  } 
  public void setD0108( java.lang.String  D0108) {
    this.D0108 = D0108;
  } 
  public void setD0112( java.lang.String  D0112) {
    this.D0112 = D0112;
  } 
  public void setD0113( java.lang.String  D0113) {
    this.D0113 = D0113;
  } 
  public void setD0121( java.lang.String  D0121) {
    this.D0121 = D0121;
  } 
  public void setD0123( java.lang.String  D0123) {
    this.D0123 = D0123;
  } 
  public void setD0144( java.util.Date  D0144) {
    this.D0144 = D0144;
  } 
  public void setD0147( java.lang.String  D0147) {
    this.D0147 = D0147;
  } 
  public void setD0151( java.lang.String  D0151) {
    this.D0151 = D0151;
  } 
  public void setD0154( java.util.Date  D0154) {
    this.D0154 = D0154;
  } 
  public void setD0157( java.lang.String  D0157) {
    this.D0157 = D0157;
  } 
  public void setD0161( java.lang.String  D0161) {
    this.D0161 = D0161;
  } 
  public void setD0172( java.lang.String  D0172) {
    this.D0172 = D0172;
  } 
  public void setD0173( java.util.Date  D0173) {
    this.D0173 = D0173;
  } 
  public void setD0175( java.lang.String  D0175) {
    this.D0175 = D0175;
  } 
  public void setD0189( java.lang.String  D0189) {
    this.D0189 = D0189;
  } 
  public void setD0191( java.lang.String  D0191) {
    this.D0191 = D0191;
  } 
  public void setD0192( java.lang.String  D0192) {
    this.D0192 = D0192;
  } 
  public void setD0193( java.lang.String  D0193) {
    this.D0193 = D0193;
  } 
  public void setD0194( java.lang.String  D0194) {
    this.D0194 = D0194;
  } 
  public void setD01A1( java.lang.String  D01A1) {
    this.D01A1 = D01A1;
  } 
  public void setD01A2( java.lang.String  D01A2) {
    this.D01A2 = D01A2;
  } 
  public void setD01A3( int  D01A3) {
    this.D01A3 = D01A3;
  } 
  public void setD01A4( int  D01A4) {
    this.D01A4 = D01A4;
  } 
  public void setD01A5( int  D01A5) {
    this.D01A5 = D01A5;
  } 
  public void setD01A6( int  D01A6) {
    this.D01A6 = D01A6;
  } 
  public void setD01B1( java.lang.String  D01B1) {
    this.D01B1 = D01B1;
  } 
  public void setD01B2( java.lang.String  D01B2) {
    this.D01B2 = D01B2;
  } 
  public void setD01B3( java.lang.String  D01B3) {
    this.D01B3 = D01B3;
  } 
  public void setD01B4( int  D01B4) {
    this.D01B4 = D01B4;
  } 
  public void setD01B5( java.lang.String  D01B5) {
    this.D01B5 = D01B5;
  } 
  public void setD01B6( java.lang.String  D01B6) {
    this.D01B6 = D01B6;
  } 
  public void setD01B7( java.lang.String  D01B7) {
    this.D01B7 = D01B7;
  } 
  public void setD01DW( java.lang.String  D01DW) {
    this.D01DW = D01DW;
  } 
  public void setE0202( java.lang.String  E0202) {
    this.E0202 = E0202;
  } 
  public void setE0203( java.lang.String  E0203) {
    this.E0203 = E0203;
  } 
  public void setE0205( java.lang.String  E0205) {
    this.E0205 = E0205;
  } 
  public void setE0206( java.lang.String  E0206) {
    this.E0206 = E0206;
  } 
  public void setE0207( java.lang.String  E0207) {
    this.E0207 = E0207;
  } 
  public void setE0208( java.lang.String  E0208) {
    this.E0208 = E0208;
  } 
  public void setE0209( java.lang.String  E0209) {
    this.E0209 = E0209;
  } 
  public void setE0261( java.lang.String  E0261) {
    this.E0261 = E0261;
  } 
  public void setE0263( java.lang.String  E0263) {
    this.E0263 = E0263;
  } 
  public void setE0265( java.lang.String  E0265) {
    this.E0265 = E0265;
  } 
  public void setE0267( java.lang.String  E0267) {
    this.E0267 = E0267;
  } 
  public void setE0326( java.lang.String  E0326) {
    this.E0326 = E0326;
  } 
  public void setF_UPDATE( java.lang.String  F_UPDATE) {
    this.F_UPDATE = F_UPDATE;
  }  

}