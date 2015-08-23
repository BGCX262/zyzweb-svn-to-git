package com.mycms.cms.manager.main;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mycms.cms.entity.main.CmsMajorComp;
import com.mycms.common.page.Pagination;


public interface CmsMajorCompMng {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize);
	public List<CmsMajorComp> getList();

	public CmsMajorComp findById(Integer id);

	public CmsMajorComp save(CmsMajorComp bean);

	public CmsMajorComp update(CmsMajorComp bean);

	public CmsMajorComp deleteById(Integer id);

	public CmsMajorComp[] deleteByIds(Integer[] ids);
	
	public void impSave(MultipartFile file,String upLoadFile) throws Exception;
}