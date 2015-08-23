package com.mycms.cms.manager.main;

import com.mycms.cms.entity.main.Content;
import com.mycms.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}