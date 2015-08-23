package com.mycms.cms.manager.main;

import com.mycms.cms.entity.main.CmsUser;
import com.mycms.cms.entity.main.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
}