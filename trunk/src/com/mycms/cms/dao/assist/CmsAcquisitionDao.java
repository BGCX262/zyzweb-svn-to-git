package com.mycms.cms.dao.assist;

import java.util.List;

import com.mycms.cms.entity.assist.CmsAcquisition;
import com.mycms.common.hibernate3.Updater;

public interface CmsAcquisitionDao {
	public List<CmsAcquisition> getList(Integer siteId);

	public CmsAcquisition findById(Integer id);

	public CmsAcquisition save(CmsAcquisition bean);

	public CmsAcquisition updateByUpdater(Updater<CmsAcquisition> updater);

	public CmsAcquisition deleteById(Integer id);

	public int countByChannelId(Integer channelId);
}