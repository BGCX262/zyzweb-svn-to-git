package com.zyz.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;
import com.zyz.domain.Zyztbitem;
import com.zyz.domain.Zyztbrecord;
import com.zyz.persistence.ZyztbitemMapper;
import com.zyz.persistence.ZyztbrecordMapper;


@Service("zyztbitemService")
public class ZyztbitemService {
	@Autowired
	private ZyztbitemMapper zyztbitemMapper;
	@Autowired
	private ZyztbrecordMapper zyztbrecordMapper;

	/**
	 * 查询某个志愿淘宝商品信息
	 * @param param
	 * @return
	 */
	public Zyztbitem getZyztbitem(Map<String,Object> param) {
		return zyztbitemMapper.getZyztbitem(param);
	}
   
	/**
	 * 查询志愿淘宝商品信息列表
	 * @return
	 */
	public List<Zyztbitem> getZyztbitemList(Map<String,Object> param) {
		return zyztbitemMapper.getZyztbitemList(param);
	}
   
	/**
	 * 查询志愿淘宝商品信息列表
	 * @return
	 */
	public  Pagination getZyztbitemList(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=zyztbitemMapper.getTotalRows(param);
		List<Zyztbitem> list=	zyztbitemMapper.getZyztbitemList(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增志愿淘宝商品信息
	 * @param zyztbitem
	 * @param param
	 */
	@Transactional
	public void insertZyztbitem(Zyztbitem zyztbitem) {
		zyztbitemMapper.insertZyztbitem(zyztbitem);
	}
   
	/**
	 * 编辑志愿淘宝商品信息
	 * @param zyztbitem
	 * @param param
	 */
	@Transactional
	public void updateZyztbitem(Zyztbitem zyztbitem) {
		zyztbitemMapper.updateZyztbitem(zyztbitem);
	}
   
	/**
	 * 删除志愿淘宝商品信息
	 * @param param
	 */    
	@Transactional
	public void deleteZyztbitem(List<String> itemidList) {
		//delete record
		for(String itemid: itemidList){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("itemid", itemid);
	  		zyztbrecordMapper.deleteZyztbrecord(param);
	  		zyztbitemMapper.deleteZyztbitem(param);	  		
		}
	}

	public java.lang.Double getHistoryTotalAmount() {
		return zyztbitemMapper.getHistoryTotalAmount();
	}
	
	public double getMonthAmount(){
		return zyztbitemMapper.getMonthAmount();
	}

	public String getPeopleCount(){
		return zyztbitemMapper.getPeopleCount();
	}
	
	public int getTotal(Map<String, Object> param){
		return zyztbitemMapper.getTotalRows(param);
	}
	
	public  List<Zyztbitem> getIndexHelpList() {
		return zyztbitemMapper.getIndexHelpList(null);
	}

}