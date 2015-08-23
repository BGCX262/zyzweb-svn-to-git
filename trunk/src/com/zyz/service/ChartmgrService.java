package com.zyz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;
import com.zyz.domain.Chartmgr;
import com.zyz.persistence.ChartmgrMapper;

@Service("chartmgrService")
public class ChartmgrService {
	@Autowired
	private ChartmgrMapper chartmgrMapper;

	/**
	 * 查询某个图表管理
	 * @param param
	 * @return
	 */
	public Chartmgr getChartmgr(Map<String,Object> param) {
		return chartmgrMapper.getChartmgr(param);
	}
   
	/**
	 * 查询图表管理列表
	 * @return
	 */
	public List<Chartmgr> getChartmgrList(Map<String,Object> param) {
		return chartmgrMapper.getChartmgrList(param);
	}
   
	/**
	 * 查询图表管理列表
	 * @return
	 */
	public  Pagination getChartmgrList(Map<String,Object> param,int pageSize,Integer pageNo,String order,String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count=chartmgrMapper.getTotalRows(param);
		List<Chartmgr> list=	chartmgrMapper.getChartmgrList(param);
	
		p.setList(list);
		p.setTotalCount(count);
		return p;
		
	}
      
	/**
	 * 新增图表管理
	 * @param chartmgr
	 * @param param
	 */
	@Transactional
	public void insertChartmgr(Chartmgr chartmgr) {
		chartmgrMapper.insertChartmgr(chartmgr);
	}
   
	/**
	 * 编辑图表管理
	 * @param chartmgr
	 * @param param
	 */
	@Transactional
	public void updateChartmgr(Chartmgr chartmgr) {
		chartmgrMapper.updateChartmgr(chartmgr);
	}
   
	/**
	 * 删除图表管理
	 * @param param
	 */    
	@Transactional
	public void deleteChartmgr(List<String> idList) {
		for(String id: idList){
	  		Map<String,Object> param = new HashMap<String,Object>();
	  		param.put("id", id);
	 	   chartmgrMapper.deleteChartmgr(param);	  		
		}
	}


}