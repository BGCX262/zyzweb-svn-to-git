package com.mycms.cms.dao.main;

import com.mycms.cms.entity.main.CmsUserExt;
import com.mycms.common.hibernate3.Updater;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
}