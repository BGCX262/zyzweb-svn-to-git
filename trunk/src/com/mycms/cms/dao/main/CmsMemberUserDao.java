package com.mycms.cms.dao.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsMemberUser;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

/**
 * 用户DAO接口
 * 
 * 
 * 
 */
public interface CmsMemberUserDao {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize);

	public List<CmsMemberUser> getAdminList(Integer siteId, Boolean allChannel,
			Boolean disabled, Integer rank);

	public CmsMemberUser findById(Integer id);

	public CmsMemberUser findByUsername(String username);

	public CmsMemberUser getByUsernamePsw(String username,String password);
	public CmsMemberUser getByUsernameEmail(String username,String email);
	public int countByUsernamePsw(String username,String password) ;
	public int countByUsername(String username);

	public int countByEmail(String email);

	public CmsMemberUser save(CmsMemberUser bean);

	public CmsMemberUser updateByUpdater(Updater<CmsMemberUser> updater);

	public CmsMemberUser deleteById(Integer id);
}