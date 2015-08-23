package com.mycms.cms.manager.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.common.page.Pagination;


public interface CmsCompanyTypeMng {
	public List<CmsCompanyType> getList();

	public Pagination getPage(Integer rank,
			int pageNo, int pageSize);
	public CmsCompanyType findById(Integer id);

	public CmsCompanyType save(CmsCompanyType bean);

	public CmsCompanyType update(CmsCompanyType bean);

	public CmsCompanyType deleteById(Integer id);

	public List<CmsCompanyType> getList(Integer parent);
	public CmsCompanyType[] deleteByIds(Integer[] ids);
}