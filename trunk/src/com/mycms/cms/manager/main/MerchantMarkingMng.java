package com.mycms.cms.manager.main;

import java.util.List;

import com.mycms.cms.entity.main.MerchantMarking;
import com.mycms.common.page.Pagination;


public interface MerchantMarkingMng {
	public Pagination getPage(String name,int pageNo, int pageSize);
	public List<MerchantMarking> getList();

	public MerchantMarking findById(Integer id);

	public MerchantMarking save(MerchantMarking bean);

	public MerchantMarking update(MerchantMarking bean);

	public MerchantMarking deleteById(Integer id);

	public MerchantMarking[] deleteByIds(Integer[] ids);
	
}