package com.mycms.cms.dao.main;

import com.mycms.cms.entity.main.CmsConfig;
import com.mycms.common.hibernate3.Updater;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}