package com.mycms.cms.manager.assist;

import java.util.List;

import com.mycms.cms.entity.assist.CmsSensitivity;
import com.mycms.common.page.Pagination;

public interface CmsSensitivityMng {

	public String replaceSensitivity(String s);

	public List<CmsSensitivity> getList(boolean cacheable);
	
	public Pagination getPageList(boolean cacheable,int pageNo, int pageSize);

	public CmsSensitivity findById(Integer id);

	public CmsSensitivity save(CmsSensitivity bean);

	public void updateEnsitivity(Integer[] ids, String[] searchs,
			String[] replacements);

	public CmsSensitivity deleteById(Integer id);

	public CmsSensitivity[] deleteByIds(Integer[] ids);
}