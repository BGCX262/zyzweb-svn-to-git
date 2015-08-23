package com.web.app.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.web.app.pub.Tdictionarytype;
import com.web.app.pub.Tdictionay;
import com.web.app.pub.TdictionayService;

public class DictUtils {

	// 人员基本情况--性别
	public static String A01_A0104 = "XB";
	// 人员基本情况--民族
	public static String A01_A0117 = "MZ";
	// 人员基本情况--单位属性
	public static String A01_A0171 = "DWXZ";
	// 人员基本情况--所属行业
	public static String A01_A0174 = "SSHY";
	// 人员基本情况--个人身份
	public static String A01_A0151 = "ZYFL";
	// 人员基本情况--学历
	public static String A01_A0801 = "WHCD";
	   //入党申请人员信息--G0005
    public static String G00_G0005="SYSFZLX";
	   //党组织-自定义
    public static String D01_dzz="D01_dzz";
	// 字典表--类型
	public static String TDICTIONAY_TYPE = "1";
	private static Map<Object, Map<Object, String>> dict = new HashMap<Object, Map<Object, String>>();

	public static Map<Object, String> getDictByType(String type) {
		return dict.get(type);
	}

	public static String getNameById(Object type, String id) {
		Map<Object, String> m = dict.get(type);
		if (m != null)
			return m.get(id);
		else
			return "";
	}

	public static void init(List<Tdictionay> l) {
		for (Tdictionay d : l) {
			String type = d.getType();
			String key = d.getId();
			String value = d.getName();
			Map<Object, String> m = dict.get(type);
			if (m == null) {
				m = new LinkedHashMap<Object, String>();
				dict.put(type, m);
			}
			m.put(key, value);
		}
	}
	public static void init(String type,Map<String, String> map) {
	 
			Map<Object, String> m = dict.get(type);
			if (m == null) {
				m = new LinkedHashMap<Object, String>();
				dict.put(type, m);
			}
			m.putAll(map);
	}
	public static void addDictType(List<Tdictionarytype> l) {
		Map<Object, String> m = dict.get(TDICTIONAY_TYPE);
		if (m == null) {
			m = new HashMap<Object, String>();
			dict.put(TDICTIONAY_TYPE, m);
		}
		for (Tdictionarytype t : l) {
			m.put(t.getType(), t.getName());
		}
	}

	public static void reloadAll(TdictionayService tdictionayService) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> m = tdictionayService.getTdictionayList(param);
		List<Tdictionay> l = (List<Tdictionay>) m.get("rows");
		init(l);
	}

}
