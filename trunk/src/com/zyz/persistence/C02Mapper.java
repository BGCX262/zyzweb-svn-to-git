package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.C02;

public interface C02Mapper {
	C02 getC02(Map<String,Object> param);
	List<C02> getC02List(Map<String,Object> param);
	void insertC02(C02 c02);
	void updateC02(C02 c02);
	void deleteC02(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }