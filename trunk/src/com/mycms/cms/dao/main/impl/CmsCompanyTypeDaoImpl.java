package com.mycms.cms.dao.main.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.main.CmsCompanyTypeDao;
import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;

@Repository
public class CmsCompanyTypeDaoImpl extends HibernateBaseDao<CmsCompanyType, Integer>
		implements CmsCompanyTypeDao {
	@SuppressWarnings("unchecked")
	public List<CmsCompanyType> getList() {
		String hql = "from CmsCompanyType bean order by bean.id asc";
		return find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<CmsCompanyType> getList(Integer parent) {
		Finder f = Finder.create("select bean from CmsCompanyType bean");
		f.append(" where parent=:parent");
		f.setParam("parent", parent);
		f.append(" order by bean.id asc");
		return find(f);
		
	}
	public CmsCompanyType findById(Integer id) {
		CmsCompanyType entity = get(id);
		return entity;
	}

	public CmsCompanyType save(CmsCompanyType bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsCompanyType deleteById(Integer id) {
		CmsCompanyType entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsCompanyType> getEntityClass() {
		return CmsCompanyType.class;
	}
}