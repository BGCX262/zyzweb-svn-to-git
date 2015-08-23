package com.mycms.cms.dao.main.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.main.CmsModelDao;
import com.mycms.cms.entity.main.CmsModel;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.page.Pagination;

@Repository
public class CmsModelDaoImpl extends HibernateBaseDao<CmsModel, Integer>
		implements CmsModelDao {
	@SuppressWarnings("unchecked")
	public List<CmsModel> getList(boolean containDisabled) {
		Finder f = Finder.create("from CmsModel bean");
		if (!containDisabled) {
			f.append(" where bean.disabled=false");
		}
		f.append(" order by bean.priority");
		return find(f);
	}

	@SuppressWarnings("unchecked")
	public CmsModel getDefModel() {
		String hql = "from CmsModel bean where bean.def=true";
		List<CmsModel> list = getSession().createQuery(hql).setMaxResults(1)
				.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public CmsModel findById(Integer id) {
		CmsModel entity = get(id);
		return entity;
	}

	public CmsModel save(CmsModel bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsModel deleteById(Integer id) {
		CmsModel entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsModel> getEntityClass() {
		return CmsModel.class;
	}

	@Override
	public Pagination getPageList(boolean containDisabled, int pageNo,
			int pageSize) {
		Finder f = Finder.create("from CmsModel bean where 1=1");
		if (!containDisabled) {
			f.append(" and bean.disabled=false");
		}
		f.append(" order by bean.priority");
		return find(f, pageNo, pageSize);
	}

	
}