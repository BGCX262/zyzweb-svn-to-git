package com.mycms.cms.manager.main;

import java.util.List;
import java.util.Set;

import com.mycms.cms.entity.main.CmsRole;
import com.mycms.common.page.Pagination;

public interface CmsRoleMng {
	public List<CmsRole> getList();
	public Pagination getPageList(int pageNo, int pageSize);
	public CmsRole findById(Integer id);

	public CmsRole save(CmsRole bean, Set<String> perms);

	public CmsRole update(CmsRole bean, Set<String> perms);

	public CmsRole deleteById(Integer id);

	public CmsRole[] deleteByIds(Integer[] ids);
}