package com.mycms.cms.dao.assist;

import java.util.List;

import com.mycms.cms.entity.assist.CmsComment;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsCommentDao {
	public Pagination getPage(Integer siteId, Integer contentId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int pageNo, int pageSize, boolean cacheable);

	public List<CmsComment> getList(Integer siteId, Integer contentId,
			Integer greaterThen, Boolean checked, boolean recommend,
			boolean desc, int count, boolean cacheable);

	public CmsComment findById(Integer id);

	public int deleteByContentId(Integer contentId);

	public CmsComment save(CmsComment bean);

	public CmsComment updateByUpdater(Updater<CmsComment> updater);

	public CmsComment deleteById(Integer id);
}