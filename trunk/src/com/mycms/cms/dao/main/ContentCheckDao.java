package com.mycms.cms.dao.main;

import com.mycms.cms.entity.main.ContentCheck;
import com.mycms.common.hibernate3.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}