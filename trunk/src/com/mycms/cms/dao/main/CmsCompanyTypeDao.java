package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.common.hibernate3.Updater;

public interface CmsCompanyTypeDao {
	public List<CmsCompanyType> getList();

	public CmsCompanyType findById(Integer id);

	public CmsCompanyType save(CmsCompanyType bean);

	public CmsCompanyType updateByUpdater(Updater<CmsCompanyType> updater);

	public List<CmsCompanyType> getList(Integer parent);
	
	public CmsCompanyType deleteById(Integer id);
}