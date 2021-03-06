package com.mycms.cms.dao.main;

import com.mycms.cms.entity.main.ContentExt;
import com.mycms.common.hibernate3.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}