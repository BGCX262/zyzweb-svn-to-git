package com.mycms.cms.dao.main.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.main.MajorCompDao;
import com.mycms.cms.entity.main.CmsMajorComp;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.page.Pagination;

@Repository
public class MajorCompDaoImpl extends HibernateBaseDao<CmsMajorComp, Integer>
		implements MajorCompDao {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from CmsMajorComp bean");

		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	@SuppressWarnings("unchecked")
	public List<CmsMajorComp> getList() {
		String hql = "from CmsMajorComp bean order by bean.id asc";
		return find(hql);
	}

	public CmsMajorComp findById(Integer id) {
		CmsMajorComp entity = get(id);
		return entity;
	}

	public CmsMajorComp save(CmsMajorComp bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsMajorComp deleteById(Integer id) {
		CmsMajorComp entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsMajorComp> getEntityClass() {
		return CmsMajorComp.class;
	}
}