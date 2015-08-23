package com.mycms.cms.manager.main;

import java.util.List;

import com.mycms.cms.entity.main.CmsModel;
import com.mycms.common.page.Pagination;

/**
 * 模型Manager接口
 * 
 * 
 * 
 */
public interface CmsModelMng {
	/**
	 * 获得模型列表
	 * 
	 * @param containDisabled
	 *            是否所有模型（即包含禁用模型）
	 * @return
	 */
	public List<CmsModel> getList(boolean containDisabled);

	public Pagination getPageList(boolean containDisabled,int pageNo, int pageSize);
	
	/**
	 * 获得默认模型
	 * 
	 * @return
	 */
	public CmsModel getDefModel();

	public CmsModel findById(Integer id);

	public CmsModel save(CmsModel bean);

	public CmsModel update(CmsModel bean);

	public CmsModel deleteById(Integer id);

	public CmsModel[] deleteByIds(Integer[] ids);

	public CmsModel[] updatePriority(Integer[] ids, Integer[] priority,
			Boolean[] disabled, Integer defId);
}