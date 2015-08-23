package com.mycms.cms.manager.main.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycms.cms.entity.main.MerchantMarking;
import com.mycms.cms.manager.main.MerchantMarkingMng;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

@Service
@Transactional
public class MerchantMarkingMngImpl  extends HibernateBaseDao<MerchantMarking, Integer> implements MerchantMarkingMng {
	public Pagination getPage(String name,int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from MerchantMarking bean");

		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	@SuppressWarnings("unchecked")
	public List<MerchantMarking> getList() {
		String hql = "from MerchantMarking bean order by bean.id asc";
		return find(hql);
	}

	public MerchantMarking findById(Integer id) {
		MerchantMarking entity = get(id);
		return entity;
	}

	public MerchantMarking save(MerchantMarking bean) {
		getSession().save(bean);
		return bean;
	}

	public MerchantMarking deleteById(Integer id) {
		MerchantMarking entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	public MerchantMarking update(MerchantMarking bean) {
		Updater<MerchantMarking> updater = new Updater<MerchantMarking>(bean);
		bean = updateByUpdater(updater);
		return bean;
	}
	public MerchantMarking[] deleteByIds(Integer[] ids) {
		MerchantMarking[] beans = new MerchantMarking[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	@Override
	protected Class<MerchantMarking> getEntityClass() {
		return MerchantMarking.class;
	}
}