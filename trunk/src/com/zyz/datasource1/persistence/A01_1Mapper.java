package com.zyz.datasource1.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.A01;

public interface A01_1Mapper {
	A01 getA01(Map<String,Object> param);
	List<A01> getA01List(Map<String,Object> param);
	void insertA01(A01 a01);
	void updateA01(A01 a01);
	void deleteA01(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }