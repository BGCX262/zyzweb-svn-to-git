package com.mycms.cms.dao.main.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.main.MerchantMarkingDao;
import com.mycms.cms.entity.main.MerchantMarking;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.page.Pagination;

@Repository
public class MerchantMarkingDaoImpl extends HibernateBaseDao<MerchantMarking, Integer>
		implements MerchantMarkingDao {
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

	@Override
	protected Class<MerchantMarking> getEntityClass() {
		return MerchantMarking.class;
	}
}