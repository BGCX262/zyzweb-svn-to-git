package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.Zyztbrecord;


public interface ZyztbrecordMapper {
	Zyztbrecord getZyztbrecord(Map<String,Object> param);
	List<Zyztbrecord> getZyztbrecordList(Map<String,Object> param);
	void insertZyztbrecord(Zyztbrecord zyztbrecord);
	void updateZyztbrecord(Zyztbrecord zyztbrecord);
	void deleteZyztbrecord(Map<String,Object> param);
	void addamounttoitem(Zyztbrecord zyztbrecord);
   int getTotalRows(Map<String,Object> param);
 }