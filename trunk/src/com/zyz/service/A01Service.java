package com.zyz.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.app.util.page.Pagination;

import com.zyz.domain.A01;
import com.zyz.persistence.A01Mapper;

@Service("a01Service")
public class A01Service {
	@Autowired
	private A01Mapper a01Mapper;

	/**
	 * 查询某个人员基本情况
	 * @param param
	 * @return
	 */
	public A01 getA01(Map<String,Object> param) {
		return a01Mapper.getA01(param);
	}
   
	/**
	 * 查询人员基本情况列表
	 * @return
	 */
	public List<A01> getA01List(Map<String,Object> param) {
		return a01Mapper.getA01List(param);
	}
   
	/**
	 * 查询人员基本情况列表
	 * @return
	 */
	public  Pagination getA01List(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=a01Mapper.getTotalRows(param);
		List<A01> list=	a01Mapper.getA01List(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增人员基本情况
	 * @param a01
	 * @param param
	 */
	@Transactional
	public void insertA01(A01 a01) {
		a01Mapper.insertA01(a01);
	}
   
	/**
	 * 编辑人员基本情况
	 * @param a01
	 * @param param
	 */
	@Transactional
	public void updateA01(A01 a01) {
		a01Mapper.updateA01(a01);
	}
   
	/**
	 * 删除人员基本情况
	 * @param param
	 */    
	@Transactional
	public void deleteA01(List<String> A0100List) {
		for(String A0100: A0100List){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("A0100", A0100);
	 	   a01Mapper.deleteA01(param);	  		
		}
	}


}