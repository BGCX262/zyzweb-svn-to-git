package com.zyz.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;
import com.zyz.domain.Zyztbrecord;
import com.zyz.persistence.ZyztbrecordMapper;


@Service("zyztbrecordService")
public class ZyztbrecordService {
	@Autowired
	private ZyztbrecordMapper zyztbrecordMapper;

	/**
	 * 查询某个志愿淘宝用户购买信息
	 * @param param
	 * @return
	 */
	public Zyztbrecord getZyztbrecord(Map<String,Object> param) {
		return zyztbrecordMapper.getZyztbrecord(param);
	}
   
	/**
	 * 查询志愿淘宝用户购买信息列表
	 * @return
	 */
	public List<Zyztbrecord> getZyztbrecordList(Map<String,Object> param) {
		return zyztbrecordMapper.getZyztbrecordList(param);
	}
   
	/**
	 * 查询志愿淘宝用户购买信息列表
	 * @return
	 */
	public  Pagination getZyztbrecordList(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=zyztbrecordMapper.getTotalRows(param);
		List<Zyztbrecord> list=	zyztbrecordMapper.getZyztbrecordList(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增志愿淘宝用户购买信息
	 * @param zyztbrecord
	 * @param param
	 */
	@Transactional
	public void insertZyztbrecord(Zyztbrecord zyztbrecord) {
		zyztbrecordMapper.insertZyztbrecord(zyztbrecord);
		zyztbrecordMapper.addamounttoitem(zyztbrecord);
	}
   
	/**
	 * 编辑志愿淘宝用户购买信息
	 * @param zyztbrecord
	 * @param param
	 */
	@Transactional
	public void updateZyztbrecord(Zyztbrecord zyztbrecord) {
		zyztbrecordMapper.updateZyztbrecord(zyztbrecord);
	}
   
	/**
	 * 删除志愿淘宝用户购买信息
	 * @param param
	 */    
	@Transactional
	public void deleteZyztbrecord(List<String> inidList) {
		for(String inid: inidList){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("inid", inid);
	 	   zyztbrecordMapper.deleteZyztbrecord(param);	  		
		}
	}


}