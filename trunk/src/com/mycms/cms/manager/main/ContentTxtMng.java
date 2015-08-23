package com.mycms.cms.manager.main;

import com.mycms.cms.entity.main.Content;
import com.mycms.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}