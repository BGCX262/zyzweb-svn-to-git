package com.zyz.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.app.util.page.Pagination;

import com.zyz.domain.D16;
import com.zyz.persistence.D16Mapper;

@Service("d16Service")
public class D16Service {
	@Autowired
	private D16Mapper d16Mapper;

	/**
	 * 查询某个单位信息
	 * @param param
	 * @return
	 */
	public D16 getD16(Map<String,Object> param) {
		return d16Mapper.getD16(param);
	}
   
	/**
	 * 查询单位信息列表
	 * @return
	 */
	public List<D16> getD16List(Map<String,Object> param) {
		return d16Mapper.getD16List(param);
	}
   
	/**
	 * 查询单位信息列表
	 * @return
	 */
	public  Pagination getD16List(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=d16Mapper.getTotalRows(param);
		List<D16> list=	d16Mapper.getD16List(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增单位信息
	 * @param d16
	 * @param param
	 */
	@Transactional
	public void insertD16(D16 d16) {
		d16Mapper.insertD16(d16);
	}
   
	/**
	 * 编辑单位信息
	 * @param d16
	 * @param param
	 */
	@Transactional
	public void updateD16(D16 d16) {
		d16Mapper.updateD16(d16);
	}
   
	/**
	 * 删除单位信息
	 * @param param
	 */    
	@Transactional
	public void deleteD16(List<String> D1600List) {
		for(String D1600: D1600List){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("D1600", D1600);
	 	   d16Mapper.deleteD16(param);	  		
		}
	}


}