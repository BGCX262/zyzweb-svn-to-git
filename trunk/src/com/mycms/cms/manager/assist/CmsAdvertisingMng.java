package com.mycms.cms.manager.assist;

import java.util.List;
import java.util.Map;

import com.mycms.cms.entity.assist.CmsAdvertising;
import com.mycms.common.page.Pagination;

public interface CmsAdvertisingMng {
	public Pagination getPage(Integer siteId, Integer adspaceId,
			Boolean enabled, int pageNo, int pageSize);

	public List<CmsAdvertising> getList(Integer adspaceId, Boolean enabled);

	public CmsAdvertising findById(Integer id);

	public CmsAdvertising save(CmsAdvertising bean, Integer adspaceId,
			Map<String, String> attr);

	public CmsAdvertising update(CmsAdvertising bean, Integer adspaceId,
			Map<String, String> attr);

	public CmsAdvertising deleteById(Integer id);

	public CmsAdvertising[] deleteByIds(Integer[] ids);

	public void display(Integer id);

	public void click(Integer id);
}