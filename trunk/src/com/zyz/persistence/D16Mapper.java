package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.D16;

public interface D16Mapper {
	D16 getD16(Map<String,Object> param);
	List<D16> getD16List(Map<String,Object> param);
	void insertD16(D16 d16);
	void updateD16(D16 d16);
	void deleteD16(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }