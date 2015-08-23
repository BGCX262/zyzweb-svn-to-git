package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsMajorComp;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface MajorCompDao {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize);
	public List<CmsMajorComp> getList();

	public CmsMajorComp findById(Integer id);

	public CmsMajorComp save(CmsMajorComp bean);

	public CmsMajorComp updateByUpdater(Updater<CmsMajorComp> updater);
	
	public CmsMajorComp deleteById(Integer id);
}