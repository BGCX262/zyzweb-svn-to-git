package com.zyz.persistence;

import java.util.List;
import java.util.Map;

import com.zyz.domain.Zyzinfo;

public interface ZyzinfoMapper {
	Zyzinfo getZyzinfo(Map<String, Object> param);

	List<Zyzinfo> getZyzinfoList(Map<String, Object> param);
	
	List<Zyzinfo> tj_dy(Map<String, Object> param);
	List<Zyzinfo> px_dy(Map<String, Object> param);
	List<Zyzinfo> px_sqz(Map<String, Object> param);
	List<Zyzinfo> fl_dy(Map<String, Object> param);
	List<Zyzinfo> fl_sqz(Map<String, Object> param);
	
	List<Zyzinfo> tj_dzz(Map<String, Object> param);
	List<Zyzinfo> tj_dzzsub(Map<String, Object> param);
	
	List<Zyzinfo> queryDzzDy(Map<String, Object> param);
	List<Zyzinfo> queryDzzDyNot(Map<String, Object> param);
	List<Zyzinfo> queryDzzDyAll(Map<String, Object> param);

	
	List<Zyzinfo> queryZyzDy(Map<String, Object> param);
	List<Zyzinfo> queryZyzDyNot(Map<String, Object> param);
	List<Zyzinfo> queryZyzDyAll(Map<String, Object> param);
	
	
	List<Zyzinfo> queryDzzRsDy(Map<String, Object> param);
	List<Zyzinfo> queryDzzRsDyNot(Map<String, Object> param);
	List<Zyzinfo> queryDzzRsDyAll(Map<String, Object> param);
	
	List<Zyzinfo> queryZyzNlDy(Map<String, Object> param);
	List<Zyzinfo> queryZyzNlDyNot(Map<String, Object> param);
	List<Zyzinfo> queryZyzNlDyAll(Map<String, Object> param);
	
	void insertZyzinfo(Zyzinfo zyzinfo);

	void updateZyzinfo(Zyzinfo zyzinfo);

	void deleteZyzinfo(Map<String, Object> param);
	void updateA01ByUsernamePhone(Map<String, Object> param);
	void updateA01ByBirthday(Map<String, Object> param);
	void updateD01(Map<String, Object> param);
	void deleteA01IdcardIsNull(Map<String, Object> param);
	void deleteZyzinfoIdcardNotFound(Map<String, Object> param);
	

	int getTotalRows(Map<String, Object> param);

	 
	 
}