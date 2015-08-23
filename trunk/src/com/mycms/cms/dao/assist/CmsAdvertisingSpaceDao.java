package com.mycms.cms.dao.assist;

import java.util.List;

import com.mycms.cms.entity.assist.CmsAdvertisingSpace;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsAdvertisingSpaceDao {
	public List<CmsAdvertisingSpace> getList(Integer siteId);
	
	public Pagination getPageList(Integer siteId,int pageNo, int pageSize);

	public CmsAdvertisingSpace findById(Integer id);

	public CmsAdvertisingSpace save(CmsAdvertisingSpace bean);

	public CmsAdvertisingSpace updateByUpdater(
			Updater<CmsAdvertisingSpace> updater);

	public CmsAdvertisingSpace deleteById(Integer id);
}