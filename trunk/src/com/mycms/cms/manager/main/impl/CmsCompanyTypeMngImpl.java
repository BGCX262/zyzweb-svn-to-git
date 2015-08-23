package com.mycms.cms.manager.main.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.cms.manager.main.CmsCompanyTypeMng;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

@Service
@Transactional
public class CmsCompanyTypeMngImpl extends HibernateBaseDao<CmsCompanyType, Integer> 
implements CmsCompanyTypeMng {
	@SuppressWarnings("unchecked")
	public List<CmsCompanyType> getList() {
		String hql = "from CmsCompanyType bean order by bean.id asc";
		return find(hql);
	}

	public Pagination getPage(Integer rank,
			int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from CmsCompanyType bean");

		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
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

	public CmsCompanyType update(CmsCompanyType bean) {
		Updater<CmsCompanyType> updater = new Updater<CmsCompanyType>(bean);
		bean = updateByUpdater(updater);
		return bean;
	}
	public CmsCompanyType[] deleteByIds(Integer[] ids) {
		CmsCompanyType[] beans = new CmsCompanyType[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	@Override
	protected Class<CmsCompanyType> getEntityClass() {
		return CmsCompanyType.class;
	}
}