package com.mycms.cms.manager.main;

import java.util.Date;

import com.mycms.cms.entity.main.CmsConfig;
import com.mycms.cms.entity.main.MarkConfig;
import com.mycms.cms.entity.main.MemberConfig;

public interface CmsConfigMng {
	public CmsConfig get();

	public void updateCountCopyTime(Date d);

	public void updateCountClearTime(Date d);

	public CmsConfig update(CmsConfig bean);

	public MarkConfig updateMarkConfig(MarkConfig mark);

	public void updateMemberConfig(MemberConfig memberConfig);
}