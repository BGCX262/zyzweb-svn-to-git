package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsModel;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsModelDao {
	public List<CmsModel> getList(boolean containDisabled);
	
	public Pagination getPageList(boolean containDisabled,int pageNo, int pageSize);

	public CmsModel getDefModel();

	public CmsModel findById(Integer id);

	public CmsModel save(CmsModel bean);

	public CmsModel updateByUpdater(Updater<CmsModel> updater);

	public CmsModel deleteById(Integer id);
}