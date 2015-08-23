package com.mycms.core.dao;

import java.util.List;

import com.mycms.common.hibernate3.Updater;
import com.mycms.core.entity.Ftp;

public interface FtpDao {
	public List<Ftp> getList();

	public Ftp findById(Integer id);

	public Ftp save(Ftp bean);

	public Ftp updateByUpdater(Updater<Ftp> updater);

	public Ftp deleteById(Integer id);
}