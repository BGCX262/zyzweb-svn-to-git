package com.mycms.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.main.CmsUserExtDao;
import com.mycms.cms.entity.main.CmsUserExt;
import com.mycms.common.hibernate3.HibernateBaseDao;

@Repository
public class CmsUserExtDaoImpl extends HibernateBaseDao<CmsUserExt, Integer> implements CmsUserExtDao {
	public CmsUserExt findById(Integer id) {
		CmsUserExt entity = get(id);
		return entity;
	}

	public CmsUserExt save(CmsUserExt bean) {
		getSession().save(bean);
		return bean;
	}
	
	@Override
	protected Class<CmsUserExt> getEntityClass() {
		return CmsUserExt.class;
	}
}