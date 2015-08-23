package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.Chartmgr;

public interface ChartmgrMapper {
	Chartmgr getChartmgr(Map<String,Object> param);
	List<Chartmgr> getChartmgrList(Map<String,Object> param);
	void insertChartmgr(Chartmgr chartmgr);
	void updateChartmgr(Chartmgr chartmgr);
	void deleteChartmgr(Map<String,Object> param);
   int getTotalRows(Map<String,Object> param);
 }