package com.mycms.cms.manager.main;

import com.mycms.cms.entity.main.CmsMemberUser;
import com.mycms.cms.entity.main.CmsUserExt;
import com.mycms.common.page.Pagination;

public interface CmsMemberUserMng {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize);

	public CmsMemberUser findById(Integer id);

	public CmsMemberUser findByUsername(String username);

	public CmsMemberUser save(CmsMemberUser bean);
	public CmsMemberUser updateMember(Integer id,CmsMemberUser bean, String email, String password,
			Boolean isDisabled, CmsUserExt ext, Integer groupId);

	public CmsMemberUser deleteById(Integer id);

	public CmsMemberUser[] deleteByIds(Integer[] ids);

	public boolean usernameNotExist(String username);

	public boolean emailNotExist(String email);
	public CmsMemberUser getByUsernamePsw(String username,String password);
	public CmsMemberUser getByUsernameEmail(String username,String email);
	public void sendEmail(String username,String email);
	// MD5加码。32位 
	public String MD5(String inStr);
}