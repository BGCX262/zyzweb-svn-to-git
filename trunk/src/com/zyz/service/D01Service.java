package com.zyz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;
import com.zyz.datasource1.persistence.A01_1Mapper;
import com.zyz.datasource1.persistence.C02_1Mapper;
import com.zyz.datasource1.persistence.D01_1Mapper;
import com.zyz.datasource1.persistence.D16_1Mapper;
import com.zyz.domain.D01;
import com.zyz.persistence.A01Mapper;
import com.zyz.persistence.C02Mapper;
import com.zyz.persistence.D01Mapper;
import com.zyz.persistence.D16Mapper;

@Service("d01Service")
public class D01Service {
	@Autowired
	private D01_1Mapper d01Mapper1;
	@Autowired
	private D01Mapper d01Mapper;

	@Autowired
	private A01_1Mapper a01Mapper1;
	@Autowired
	private A01Mapper a01Mapper;

	@Autowired
	private C02_1Mapper c02Mapper1;
	@Autowired
	private C02Mapper c02Mapper;

	@Autowired
	private D16_1Mapper d16Mapper1;
	@Autowired
	private D16Mapper d16Mapper;

	/**
	 * 查询某个党组织基本情况
	 * 
	 * @param param
	 * @return
	 */
	public D01 getD01(Map<String, Object> param) {
		return d01Mapper.getD01(param);
	}

	public List<D01> getD01All(Map<String, Object> param) {
		return d01Mapper.getD01List(param);
	}
	public Map<String,String> getD01Dict() {
		Map<String, Object> param =new HashMap<String, Object>();
		List<D01>  list= d01Mapper.getD01List(param);
		Map<String,String> r=new HashMap<String, String>();
		for(D01 d:list){
			r.put(d.getD0107(), d.getD0101());
		}
		return r;
	}

	/**
	 * 查询党组织基本情况列表
	 * 
	 * @return
	 */
	public Pagination getD01List(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count = d01Mapper.getTotalRows(param);
		List<D01> list = d01Mapper.getD01List(param);

		p.setList(list);
		p.setTotalCount(count);
		return p;

	}

	/**
	 * 新增党组织基本情况
	 * 
	 * @param d01
	 * @param param
	 */
	@Transactional
	public void insertD01(D01 d01) {
		d01Mapper.insertD01(d01);
	}

	/**
	 * 编辑党组织基本情况
	 * 
	 * @param d01
	 * @param param
	 */
	@Transactional
	public void updateD01(D01 d01) {
		d01Mapper.updateD01(d01);
	}

	/**
	 * 删除党组织基本情况
	 * 
	 * @param param
	 */
	@Transactional
	public void deleteD01(List<String> D0100List) {
		for (String D0100 : D0100List) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("D0100", D0100);
			d01Mapper.deleteD01(param);
		}
	}

	public List<com.zyz.domain.D01> getD01List(Map<String, Object> param) {
		return d01Mapper.getD01List(param);
	}

	public List<D01> tree(Map<String, Object> param) {
		List<D01> l = d01Mapper.tree(param);
		Map<String, Object> param1 = new HashMap<String, Object>();
		for (D01 d : l) {
			param1.clear();
//			int len = d.getD0107().trim().length() + 3;
			param1.put("code", d.getD0107().trim());
			param1.put("codelike", d.getD0107().trim()+"%");
			Integer c = d01Mapper.treecount(param1);
			if (c!=null&&c > 1)
				d.setHasChild(true);
		}
		return l;
	}
	public List<D01> getNodes(Map<String, Object> param) {
		return d01Mapper.getNodes(param);
	}
}