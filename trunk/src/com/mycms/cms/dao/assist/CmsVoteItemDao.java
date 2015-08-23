package com.mycms.cms.dao.assist;

import com.mycms.cms.entity.assist.CmsVoteItem;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsVoteItemDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsVoteItem findById(Integer id);

	public CmsVoteItem save(CmsVoteItem bean);

	public CmsVoteItem updateByUpdater(Updater<CmsVoteItem> updater);

	public CmsVoteItem deleteById(Integer id);
}