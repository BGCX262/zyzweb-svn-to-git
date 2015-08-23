package com.web.app.pub;

import java.util.List;
import java.util.Map;

public interface TdictionayMapper {
	Tdictionay getTdictionay(Map<String,Object> param);
	List<Tdictionay> getTdictionayList(Map<String,Object> param);
	void insertTdictionay(Tdictionay tdictionay);
	void updateTdictionay(Tdictionay tdictionay);
	void deleteTdictionay(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }