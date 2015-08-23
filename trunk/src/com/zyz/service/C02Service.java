package com.zyz.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.app.util.page.Pagination;

import com.zyz.domain.C02;
import com.zyz.persistence.C02Mapper;

@Service("c02Service")
public class C02Service {
	@Autowired
	private C02Mapper c02Mapper;

	/**
	 * 查询某个党员基本情况
	 * @param param
	 * @return
	 */
	public C02 getC02(Map<String,Object> param) {
		return c02Mapper.getC02(param);
	}
   
	/**
	 * 查询党员基本情况列表
	 * @return
	 */
	public List<C02> getC02List(Map<String,Object> param) {
		return c02Mapper.getC02List(param);
	}
   
	/**
	 * 查询党员基本情况列表
	 * @return
	 */
	public  Pagination getC02List(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=c02Mapper.getTotalRows(param);
		List<C02> list=	c02Mapper.getC02List(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增党员基本情况
	 * @param c02
	 * @param param
	 */
	@Transactional
	public void insertC02(C02 c02) {
		c02Mapper.insertC02(c02);
	}
   
	/**
	 * 编辑党员基本情况
	 * @param c02
	 * @param param
	 */
	@Transactional
	public void updateC02(C02 c02) {
		c02Mapper.updateC02(c02);
	}
   
	/**
	 * 删除党员基本情况
	 * @param param
	 */    
	@Transactional
	public void deleteC02(List<String> A0100List) {
		for(String A0100: A0100List){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("A0100", A0100);
	 	   c02Mapper.deleteC02(param);	  		
		}
	}


}