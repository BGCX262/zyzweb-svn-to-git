package com.zyz.domain;

import java.io.Serializable;
import com.web.app.pub.BaseBean;

public class Chartmgr extends BaseBean implements Serializable {

  private static final long serialVersionUID = -7492639752670189553L;
 
  /**编号*/
  private java.lang.Integer id;
  /**名称*/
  private java.lang.String name;
  /**路径*/
  private java.lang.String url;
  /**备注*/
  private java.lang.String bz;
  /**分类*/
  private java.lang.String type;
  /**显示列*/
  private java.lang.String filed;

  public java.lang.Integer getId() {
    return id;
  }
  public java.lang.String getName() {
    return name;
  }
  public java.lang.String getUrl() {
    return url;
  }
  public java.lang.String getBz() {
    return bz;
  }
  public java.lang.String getType() {
    return type;
  }
  public java.lang.String getFiled() {
    return filed;
  }

  public void setId( java.lang.Integer  id) {
    this.id = id;
  } 
  public void setName( java.lang.String  name) {
    this.name = name;
  } 
  public void setUrl( java.lang.String  url) {
    this.url = url;
  } 
  public void setBz( java.lang.String  bz) {
    this.bz = bz;
  } 
  public void setType( java.lang.String  type) {
    this.type = type;
  } 
  public void setFiled( java.lang.String  filed) {
    this.filed = filed;
  }  

}