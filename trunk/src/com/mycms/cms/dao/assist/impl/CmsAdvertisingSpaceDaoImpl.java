package com.mycms.cms.dao.assist.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.assist.CmsAdvertisingSpaceDao;
import com.mycms.cms.entity.assist.CmsAdvertisingSpace;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.page.Pagination;

@Repository
public class CmsAdvertisingSpaceDaoImpl extends
		HibernateBaseDao<CmsAdvertisingSpace, Integer> implements
		CmsAdvertisingSpaceDao {
	@SuppressWarnings("unchecked")
	public List<CmsAdvertisingSpace> getList(Integer siteId) {
		Finder f = Finder.create("from CmsAdvertisingSpace bean");
		if (siteId != null) {
			f.append(" where bean.site.id=:siteId");
			f.setParam("siteId", siteId);
		}
		return find(f);
	}

	public CmsAdvertisingSpace findById(Integer id) {
		CmsAdvertisingSpace entity = get(id);
		return entity;
	}

	public CmsAdvertisingSpace save(CmsAdvertisingSpace bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsAdvertisingSpace deleteById(Integer id) {
		CmsAdvertisingSpace entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsAdvertisingSpace> getEntityClass() {
		return CmsAdvertisingSpace.class;
	}

	@Override
	public Pagination getPageList(Integer siteId, int pageNo, int pageSize) {
		Finder f = Finder.create("from CmsAdvertisingSpace bean where 1=1 ");
		if (siteId != null) {
			f.append(" and bean.site.id=:siteId");
			f.setParam("siteId", siteId);
		}
		return find(f, pageNo, pageSize);
	}
}