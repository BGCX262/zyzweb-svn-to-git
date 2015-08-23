package com.mycms.cms.dao.main;

import com.mycms.cms.entity.main.ContentTxt;
import com.mycms.common.hibernate3.Updater;

public interface ContentTxtDao {
	public ContentTxt findById(Integer id);

	public ContentTxt save(ContentTxt bean);

	public ContentTxt updateByUpdater(Updater<ContentTxt> updater);
}