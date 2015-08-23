package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.MerchantMarking;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

public interface MerchantMarkingDao {
	public Pagination getPage(String name,int pageNo, int pageSize);
	public List<MerchantMarking> getList();

	public MerchantMarking findById(Integer id);

	public MerchantMarking save(MerchantMarking bean);

	public MerchantMarking updateByUpdater(Updater<MerchantMarking> updater);
	
	public MerchantMarking deleteById(Integer id);
}