package com.mycms.cms.dao.main;

import com.mycms.cms.entity.main.ChannelExt;
import com.mycms.common.hibernate3.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}