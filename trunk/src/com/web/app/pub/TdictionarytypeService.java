package com.web.app.pub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;


@Service("tdictionarytypeService")
public class TdictionarytypeService {
	@Autowired
	private TdictionarytypeMapper tdictionarytypeMapper;

	/**
	 * 查询某个字典类型表
	 * @param param
	 * @return
	 */
	public Tdictionarytype getTdictionarytype(Map<String,Object> param) {
		return tdictionarytypeMapper.getTdictionarytype(param);
	}
   
	/**
	 * 查询字典类型表列表
	 * @return
	 */
	public Map<String,Object> getTdictionarytypeList(Map<String,Object> param) {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("total", tdictionarytypeMapper.getTotalRows(param));
		returnMap.put("rows", tdictionarytypeMapper.getTdictionarytypeList(param));
		return returnMap;
	}
   
	/**
	 * 查询字典类型表列表
	 * @return
	 */
	public  Pagination getTdictionarytypeList(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=tdictionarytypeMapper.getTotalRows(param);
		List<Tdictionarytype> list=	tdictionarytypeMapper.getTdictionarytypeList(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增字典类型表
	 * @param tdictionarytype
	 * @param param
	 */
	@Transactional
	public void insertTdictionarytype(Tdictionarytype tdictionarytype) {
		tdictionarytypeMapper.insertTdictionarytype(tdictionarytype);
	}
   
	/**
	 * 编辑字典类型表
	 * @param tdictionarytype
	 * @param param
	 */
	@Transactional
	public void updateTdictionarytype(Tdictionarytype tdictionarytype) {
		tdictionarytypeMapper.updateTdictionarytype(tdictionarytype);
	}
   
	/**
	 * 删除字典类型表
	 * @param param
	 */    
	@Transactional
	public void deleteTdictionarytype(List<String> typeList) {
		for(String type: typeList){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("type", type);
	 	   tdictionarytypeMapper.deleteTdictionarytype(param);	  		
		}
	}


}