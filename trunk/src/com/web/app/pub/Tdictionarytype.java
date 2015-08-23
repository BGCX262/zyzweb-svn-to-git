package com.web.app.pub;

import java.io.Serializable;

public class Tdictionarytype extends BaseBean implements Serializable {

  private static final long serialVersionUID = -7492639752670189553L;
 
  /**类型*/
  private java.lang.String type;
  /**名称*/
  private java.lang.String name;
  /**描述*/
  private java.lang.String remark;

  public java.lang.String getType() {
    return type;
  }
  public java.lang.String getName() {
    return name;
  }
  public java.lang.String getRemark() {
    return remark;
  }

  public void setType( java.lang.String  type) {
    this.type = type;
  } 
  public void setName( java.lang.String  name) {
    this.name = name;
  } 
  public void setRemark( java.lang.String  remark) {
    this.remark = remark;
  }  

}