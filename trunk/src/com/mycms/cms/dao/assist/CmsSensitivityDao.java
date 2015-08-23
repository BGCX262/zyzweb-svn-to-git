package com.mycms.cms.dao.assist;

import java.util.List;

import com.mycms.cms.entity.assist.CmsSensitivity;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsSensitivityDao {
	public List<CmsSensitivity> getList(boolean cacheable);

	public Pagination getPageList(boolean cacheable,int pageNo, int pageSize);
	
	public CmsSensitivity findById(Integer id);

	public CmsSensitivity save(CmsSensitivity bean);

	public CmsSensitivity updateByUpdater(Updater<CmsSensitivity> updater);

	public CmsSensitivity deleteById(Integer id);
}