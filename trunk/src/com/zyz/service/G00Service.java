package com.zyz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;
import com.zyz.datasource1.persistence.G00_1Mapper;
import com.zyz.domain.G00;

@Service("g00Service")
public class G00Service {
	@Autowired
	private G00_1Mapper g00Mapper;

	/**
	 * 查询某个入党申请人员信息
	 * @param param
	 * @return
	 */
	public G00 getG00(Map<String,Object> param) {
		return g00Mapper.getG00(param);
	}
   
	/**
	 * 查询入党申请人员信息列表
	 * @return
	 */
	public List<G00> getG00List(Map<String,Object> param) {
		return g00Mapper.getG00List(param);
	}
   
	/**
	 * 查询入党申请人员信息列表
	 * @return
	 */
	public  Pagination getG00List(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=g00Mapper.getTotalRows(param);
		List<G00> list=	g00Mapper.getG00List(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增入党申请人员信息
	 * @param g00
	 * @param param
	 */
	@Transactional
	public void insertG00(G00 g00) {
		g00Mapper.insertG00(g00);
	}
   
	/**
	 * 编辑入党申请人员信息
	 * @param g00
	 * @param param
	 */
	@Transactional
	public void updateG00(G00 g00) {
		g00Mapper.updateG00(g00);
	}
   
	/**
	 * 删除入党申请人员信息
	 * @param param
	 */    
	@Transactional
	public void deleteG00(List<String> A0100List) {
		for(String A0100: A0100List){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("A0100", A0100);
	 	   g00Mapper.deleteG00(param);	  		
		}
	}


}