package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.G00;

public interface G00Mapper {
	G00 getG00(Map<String,Object> param);
	List<G00> getG00List(Map<String,Object> param);
	void insertG00(G00 g00);
	void updateG00(G00 g00);
	void deleteG00(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }