package com.web.app.pub;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;



@Service("tdictionayService")
public class TdictionayService {
	@Autowired
	private TdictionayMapper tdictionayMapper;

	/**
	 * 查询某个字典表
	 * @param param
	 * @return
	 */
	public Tdictionay getTdictionay(Map<String,Object> param) {
		return tdictionayMapper.getTdictionay(param);
	}
   
	/**
	 * 查询字典表列表
	 * @return
	 */
	public Map<String,Object> getTdictionayList(Map<String,Object> param) {
		Map<String,Object> returnMap = new LinkedHashMap<String,Object>();
		returnMap.put("total", tdictionayMapper.getTotalRows(param));
		returnMap.put("rows", tdictionayMapper.getTdictionayList(param));
		return returnMap;
	}
   
	/**
	 * 查询字典表列表
	 * @return
	 */
	public  Pagination getTdictionayList(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=tdictionayMapper.getTotalRows(param);
		List<Tdictionay> list=	tdictionayMapper.getTdictionayList(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增字典表
	 * @param tdictionay
	 * @param param
	 */
	@Transactional
	public void insertTdictionay(Tdictionay tdictionay) {
		tdictionayMapper.insertTdictionay(tdictionay);
	}
   
	/**
	 * 编辑字典表
	 * @param tdictionay
	 * @param param
	 */
	@Transactional
	public void updateTdictionay(Tdictionay tdictionay) {
		tdictionayMapper.updateTdictionay(tdictionay);
	}
   
	/**
	 * 删除字典表
	 * @param param
	 */    
	@Transactional
	public void deleteTdictionay(List<String> typeList) {
		for(String type: typeList){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("id", type.substring(0, type.indexOf("|")));
	  		param.put("type", type.substring(type.indexOf("|")+1));
	 	   tdictionayMapper.deleteTdictionay(param);	  		
		}
	}


}