package com.web.app.pub;

import java.util.Map;

import com.web.app.util.DictUtils;

public class BaseBean { // 字典表--类型
	public Map<Object, String> getTdictionay_type_Dict() {
		return DictUtils.getDictByType(DictUtils.TDICTIONAY_TYPE);
	}

	// 人员基本情况--性别
	public Map<Object, String> getA01_a0104_Dict() {
		return DictUtils.getDictByType(DictUtils.A01_A0104);
	}

	// 人员基本情况--民族
	public Map<Object, String> getA01_a0117_Dict() {
		return DictUtils.getDictByType(DictUtils.A01_A0117);
	}

	// 人员基本情况--单位属性
	public Map<Object, String> getA01_a0171_Dict() {
		return DictUtils.getDictByType(DictUtils.A01_A0171);
	}

	// 人员基本情况--所属行业
	public Map<Object, String> getA01_a0174_Dict() {
		return DictUtils.getDictByType(DictUtils.A01_A0174);
	}

	// 人员基本情况--个人身份
	public Map<Object, String> getA01_a0151_Dict() {
		return DictUtils.getDictByType(DictUtils.A01_A0151);
	}

	// 人员基本情况--学历
	public Map<Object, String> getA01_a0801_Dict() {
		return DictUtils.getDictByType(DictUtils.A01_A0801);
	}
	 //入党申请人员信息--G0005
	public Map<Object, String> getG00_g0005_Dict() {
		return DictUtils.getDictByType(DictUtils.G00_G0005);
	}
	
	 //D01_dzz
	public Map<Object, String> getD01_dzz_Dict() {
		return DictUtils.getDictByType(DictUtils.D01_dzz);
	}
}
