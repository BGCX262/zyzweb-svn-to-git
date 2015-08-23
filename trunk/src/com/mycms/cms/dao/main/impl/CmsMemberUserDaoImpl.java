package com.mycms.cms.dao.main.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mycms.cms.dao.main.CmsMemberUserDao;
import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.cms.entity.main.CmsMemberUser;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.page.Pagination;

@Repository
public class CmsMemberUserDaoImpl extends HibernateBaseDao<CmsMemberUser, Integer>
		implements CmsMemberUserDao {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from CmsMemberUser bean");
/*
		f.append(" where 1=1");
		
		if (!StringUtils.isBlank(username)) {
			f.append(" and bean.username like :username");
			f.setParam("username", "%" + username + "%");
		}
		if (!StringUtils.isBlank(email)) {
			f.append(" and bean.email like :email");
			f.setParam("email", "%" + email + "%");
		}
		if (groupId != null) {
			f.append(" and bean.group.id=:groupId");
			f.setParam("groupId", groupId);
		}
		if (disabled != null) {
			f.append(" and bean.disabled=:disabled");
			f.setParam("disabled", disabled);
		}
		if (rank != null) {
			f.append(" and bean.rank<=:rank");
			f.setParam("rank", rank);
		}
		*/
		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<CmsMemberUser> getAdminList(Integer siteId, Boolean allChannel,
			Boolean disabled, Integer rank) {
		Finder f = Finder.create("select bean from CmsMemberUser");
		f.append(" bean join bean.userSites us");
		f.append(" where us.site.id=:siteId");
		f.setParam("siteId", siteId);
		if (allChannel != null) {
			f.append(" and us.allChannel=:allChannel");
			f.setParam("allChannel", allChannel);
		}
		if (disabled != null) {
			f.append(" and bean.disabled=:disabled");
			f.setParam("disabled", disabled);
		}
		if (rank != null) {
			f.append(" and bean.rank<=:rank");
			f.setParam("rank", rank);
		}
		f.append(" and bean.admin=true");
		f.append(" order by bean.id asc");
		return find(f);
	}

	public CmsMemberUser findById(Integer id) {
		CmsMemberUser entity = get(id);
		return entity;
	}

	public CmsMemberUser findByUsername(String username) {
		return findUniqueByProperty("username", username);
	}

	public int countByUsername(String username) {
		String hql = "select count(*) from CmsMemberUser bean where bean.username=:username";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		return ((Number) query.iterate().next()).intValue();
	}

	public CmsMemberUser getByUsernamePsw(String username,String password) {
		Finder f = Finder.create("select bean from CmsMemberUser bean");
		f.append(" where bean.userName=:userName and bean.password=:password");
		f.setParam("userName", username);
		f.setParam("password", password);
		List list = find(f);		
		if(list != null && list.size() > 0)
		{
			return (CmsMemberUser)list.get(0);
		}
		else
		{
			return null;
		}
				
	}
	public CmsMemberUser getByUsernameEmail(String username,String email) {
		Finder f = Finder.create("select bean from CmsMemberUser bean");
		f.append(" where bean.userName=:userName and bean.userEmail=:userEmail");
		f.setParam("userName", username);
		f.setParam("userEmail", email);
		List list = find(f);		
		if(list != null && list.size() > 0)
		{
			return (CmsMemberUser)list.get(0);
		}
		else
		{
			return null;
		}	
	}
	public int countByUsernamePsw(String username,String password) {
		String hql = "select count(*) from CmsMemberUser bean where bean.username=:username and bean.password=:password";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return ((Number) query.iterate().next()).intValue();
	}
	public int countByEmail(String email) {
		String hql = "select count(*) from CmsMemberUser bean where bean.email=:email";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		return ((Number) query.iterate().next()).intValue();
	}

	public CmsMemberUser save(CmsMemberUser bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsMemberUser deleteById(Integer id) {
		CmsMemberUser entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsMemberUser> getEntityClass() {
		return CmsMemberUser.class;
	}
}