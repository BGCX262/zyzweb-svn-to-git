package com.zyz.datasource1.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.D01;

public interface D01_1Mapper {
	D01 getD01(Map<String,Object> param);
	List<D01> getD01List(Map<String,Object> param);
	void insertD01(D01 d01);
	void updateD01(D01 d01);
	void deleteD01(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }