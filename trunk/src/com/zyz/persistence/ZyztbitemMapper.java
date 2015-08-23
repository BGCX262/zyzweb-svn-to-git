package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.Zyztbitem;

public interface ZyztbitemMapper {
	Zyztbitem getZyztbitem(Map<String, Object> param);
	List<Zyztbitem> getZyztbitemList(Map<String, Object> param);
	void insertZyztbitem(Zyztbitem zyztbitem);
	void updateZyztbitem(Zyztbitem zyztbitem);
	void deleteZyztbitem(Map<String, Object> param);
	int getTotalRows(Map<String, Object> param);
	// 获取历史善款总数
	double getHistoryTotalAmount();
	// 获取本月善款总数
	double getMonthAmount();
	// 获取捐献总人数
	String getPeopleCount();
	//首页获取捐助记录
	List<Zyztbitem> getIndexHelpList(Map<String, Object> param);
}