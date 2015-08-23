package com.web.app.pub;

import java.util.List;
import java.util.Map;

public interface TdictionarytypeMapper {
	Tdictionarytype getTdictionarytype(Map<String,Object> param);
	List<Tdictionarytype> getTdictionarytypeList(Map<String,Object> param);
	void insertTdictionarytype(Tdictionarytype tdictionarytype);
	void updateTdictionarytype(Tdictionarytype tdictionarytype);
	void deleteTdictionarytype(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }