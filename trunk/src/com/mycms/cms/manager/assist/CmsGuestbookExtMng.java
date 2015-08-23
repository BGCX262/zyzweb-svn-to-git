package com.mycms.cms.manager.assist;

import com.mycms.cms.entity.assist.CmsGuestbook;
import com.mycms.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}