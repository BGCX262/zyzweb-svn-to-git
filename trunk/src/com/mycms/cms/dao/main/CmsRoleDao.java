package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsRole;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsRoleDao {
	public List<CmsRole> getList();
	public Pagination getPageList(int pageNo, int pageSize);

	public CmsRole findById(Integer id);

	public CmsRole save(CmsRole bean);

	public CmsRole updateByUpdater(Updater<CmsRole> updater);

	public CmsRole deleteById(Integer id);
}