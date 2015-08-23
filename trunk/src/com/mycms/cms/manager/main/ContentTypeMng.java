package com.mycms.cms.manager.main;

import java.util.List;

import com.mycms.cms.entity.main.ContentType;
import com.mycms.common.page.Pagination;

public interface ContentTypeMng {
	public List<ContentType> getList(boolean containDisabled);

	public Pagination getPageList(boolean containDisabled,int pageNo, int pageSize);
	
	public ContentType getDef();

	public ContentType findById(Integer id);

	public ContentType save(ContentType bean);

	public ContentType update(ContentType bean);

	public ContentType deleteById(Integer id);

	public ContentType[] deleteByIds(Integer[] ids);
}