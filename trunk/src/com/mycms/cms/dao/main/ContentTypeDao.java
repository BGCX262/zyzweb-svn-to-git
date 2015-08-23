package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.ContentType;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface ContentTypeDao {
	public List<ContentType> getList(boolean containDisabled);
	
	public Pagination getPageList(boolean containDisabled,int pageNo, int pageSize);

	public ContentType getDef();

	public ContentType findById(Integer id);

	public ContentType save(ContentType bean);

	public ContentType updateByUpdater(Updater<ContentType> updater);

	public ContentType deleteById(Integer id);
}