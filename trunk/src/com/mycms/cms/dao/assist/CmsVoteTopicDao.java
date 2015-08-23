package com.mycms.cms.dao.assist;

import com.mycms.cms.entity.assist.CmsVoteTopic;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface CmsVoteTopicDao {
	public Pagination getPage(Integer siteId, int pageNo, int pageSize);

	public CmsVoteTopic getDefTopic(Integer siteId);

	public CmsVoteTopic findById(Integer id);

	public CmsVoteTopic save(CmsVoteTopic bean);

	public CmsVoteTopic updateByUpdater(Updater<CmsVoteTopic> updater);

	public CmsVoteTopic deleteById(Integer id);
}