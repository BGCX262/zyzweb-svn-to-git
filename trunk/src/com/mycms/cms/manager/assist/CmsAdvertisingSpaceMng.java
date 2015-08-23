package com.mycms.cms.manager.assist;

import java.util.List;

import com.mycms.cms.entity.assist.CmsAdvertisingSpace;
import com.mycms.common.page.Pagination;

public interface CmsAdvertisingSpaceMng {
	public List<CmsAdvertisingSpace> getList(Integer siteId);
	
	public Pagination getPageList(Integer siteId,int pageNo, int pageSize);

	public CmsAdvertisingSpace findById(Integer id);

	public CmsAdvertisingSpace save(CmsAdvertisingSpace bean);

	public CmsAdvertisingSpace update(CmsAdvertisingSpace bean);

	public CmsAdvertisingSpace deleteById(Integer id);

	public CmsAdvertisingSpace[] deleteByIds(Integer[] ids);
}