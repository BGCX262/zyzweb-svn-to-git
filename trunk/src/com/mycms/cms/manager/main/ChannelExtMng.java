package com.mycms.cms.manager.main;

import com.mycms.cms.entity.main.Channel;
import com.mycms.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}