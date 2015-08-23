package com.zyz.service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.util.page.Pagination;
import com.zyz.datasource1.persistence.A01_1Mapper;
import com.zyz.datasource1.persistence.C02_1Mapper;
import com.zyz.datasource1.persistence.D01_1Mapper;
import com.zyz.datasource1.persistence.D16_1Mapper;
import com.zyz.datasource1.persistence.G00_1Mapper;
import com.zyz.domain.A01;
import com.zyz.domain.C02;
import com.zyz.domain.D01;
import com.zyz.domain.D16;
import com.zyz.domain.G00;
import com.zyz.domain.Zyzinfo;
import com.zyz.persistence.A01Mapper;
import com.zyz.persistence.C02Mapper;
import com.zyz.persistence.D01Mapper;
import com.zyz.persistence.D16Mapper;
import com.zyz.persistence.G00Mapper;
import com.zyz.persistence.ZyzinfoMapper;

@Service("zyzinfoService")
public class ZyzinfoService {

	private static final Logger logger = Logger.getLogger(ZyzinfoService.class);

	@Autowired
	private ZyzinfoMapper zyzinfoMapper;

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

	@Autowired
	private G00_1Mapper g00Mapper1;
	@Autowired
	private G00Mapper g00Mapper;

	@Transactional
	public void mergeA01() {
		HashMap param = new HashMap<String, Object>();
		int c = a01Mapper1.getTotalRows(param);
		logger.debug("mergeA01 size:" + c);

		Pagination p = new Pagination();
		p.setTotalCount(c);
		p.setPageSize(1000);

		for (int i = 1; i <= p.getTotalPage(); i++) {
			logger.debug("mergeA01 pageNo----------------------------------------------------------::"
					+ i);
			p.setPageNo(i);
			param.clear();
			param.putAll(p.toMap());
			List<A01> l = a01Mapper1.getA01List(param);
			for (com.zyz.domain.A01 d : l) {
				param.clear();
				param.put("A0100", d.getA0100());
				a01Mapper.deleteA01(param);
				a01Mapper.insertA01(d);
			}
		}
	}

	@Transactional
	public void mergeC02() {
		HashMap param = new HashMap<String, Object>();
		int c = c02Mapper1.getTotalRows(param);
		logger.debug("mergeC02 size--------------------------------------------:"
				+ c);

		Pagination p = new Pagination();
		p.setTotalCount(c);
		p.setPageSize(1000);

		for (int i = 1; i <= p.getTotalPage(); i++) {
			logger.debug("mergeC02 pageNo-----------------------------------------:"
					+ i);
			p.setPageNo(i);
			param.clear();
			param.putAll(p.toMap());
			List<C02> l = c02Mapper1.getC02List(param);
			for (com.zyz.domain.C02 d : l) {
				param.clear();
				param.put("A0100", d.getA0100());
				c02Mapper.deleteC02(param);
				c02Mapper.insertC02(d);
			}
		}
	}

	@Transactional
	public void mergeD16() {
		HashMap param = new HashMap<String, Object>();
		int c = d16Mapper1.getTotalRows(param);
		logger.debug("mergeD16 size----------------------------------------------------------:"
				+ c);

		Pagination p = new Pagination();
		p.setTotalCount(c);
		p.setPageSize(1000);

		for (int i = 1; i <= p.getTotalPage(); i++) {
			logger.debug("mergeD16 pageNo----------------------------------------------------------::"
					+ i);
			p.setPageNo(i);
			param.clear();
			param.putAll(p.toMap());
			List<D16> l = d16Mapper1.getD16List(param);
			for (com.zyz.domain.D16 d : l) {
				param.clear();
				param.put("D1600", d.getD1600());
				d16Mapper.deleteD16(param);
				d16Mapper.insertD16(d);
			}
		}
	}

	@Transactional
	public void mergeD01() {
		HashMap param = new HashMap<String, Object>();
		int c = d01Mapper1.getTotalRows(param);
		logger.debug("mergeD01 size----------------------------------------------------------:"
				+ c);

		Pagination p = new Pagination();
		p.setTotalCount(c);
		p.setPageSize(1000);

		for (int i = 1; i <= p.getTotalPage(); i++) {
			logger.debug("mergeD01 pageNo----------------------------------------------------------::"
					+ i);
			p.setPageNo(i);
			param.clear();
			param.putAll(p.toMap());
			List<D01> l = d01Mapper1.getD01List(param);
			for (com.zyz.domain.D01 d : l) {
				param.clear();
				param.put("D0100", d.getD0100());
				d01Mapper.deleteD01(param);
				d01Mapper.insertD01(d);
			}
		}
	}

	@Transactional
	public void mergeG00() {
		HashMap param = new HashMap<String, Object>();
		int c = g00Mapper1.getTotalRows(param);
		logger.debug("mergeG00 size----------------------------------------------------------:"
				+ c);

		Pagination p = new Pagination();
		p.setTotalCount(c);
		p.setPageSize(1000);

		for (int i = 1; i <= p.getTotalPage(); i++) {
			logger.debug("mergeG00 pageNo----------------------------------------------------------::"
					+ i);
			p.setPageNo(i);
			param.clear();
			param.putAll(p.toMap());
			List<G00> l = g00Mapper1.getG00List(param);
			for (com.zyz.domain.G00 d : l) {
				param.clear();
				param.put("A0100", d.getA0100());
				g00Mapper.deleteG00(param);
				g00Mapper.insertG00(d);
			}
		}
	}

	@Transactional
	public void merge() {
		logger.debug("merge begin..........");

		try {
			mergeA01();
			mergeC02();
			mergeD01();
			mergeD16();
			mergeG00();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("merge finish..........");
		try {
			update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			updateCache();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 查询某个志愿者信息
	 * 
	 * @param param
	 * @return
	 */
	public Zyzinfo getZyzinfo(Map<String, Object> param) {
		return zyzinfoMapper.getZyzinfo(param);
	}

	/**
	 * 查询志愿者信息列表
	 * 
	 * @return
	 */
	public List<Zyzinfo> getZyzinfoList(Map<String, Object> param) {
		return zyzinfoMapper.getZyzinfoList(param);
	}

	/**
	 * 查询志愿者信息列表
	 * 
	 * @return
	 */
	public Pagination getZyzinfoList(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		p.setPageNo(pageNo);
		p.setPageSize(pageSize);
		p.setOrder(order);
		p.setSort(sort);
		param.putAll(p.toMap());
		int count = zyzinfoMapper.getTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.getZyzinfoList(param);

		p.setList(list);
		p.setTotalCount(count);
		return p;

	}

	/**
	 * 新增志愿者信息
	 * 
	 * @param zyzinfo
	 * @param param
	 */
	@Transactional
	public void insertZyzinfo(Zyzinfo zyzinfo) {
		zyzinfoMapper.insertZyzinfo(zyzinfo);
	}

	/**
	 * 编辑志愿者信息
	 * 
	 * @param zyzinfo
	 * @param param
	 */
	@Transactional
	public void updateZyzinfo(Zyzinfo zyzinfo) {
		zyzinfoMapper.updateZyzinfo(zyzinfo);
	}

	/**
	 * 删除志愿者信息
	 * 
	 * @param param
	 */
	@Transactional
	public void deleteZyzinfo(List<String> zyzidList) {
		for (String zyzid : zyzidList) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("zyzid", zyzid);
			zyzinfoMapper.deleteZyzinfo(param);
		}
	}
	@Transactional
	public void deleteZyzinfo(Integer zyzid ) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("zyzid", zyzid);
			zyzinfoMapper.deleteZyzinfo(param);
	}
	public Pagination queryDzzDy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryDzzDy(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryDzzDyNot(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		
		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryDzzDyNot(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryDzzDyAll(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryDzzDyAll(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	// 按党员与申请党员统计
	public Pagination queryZyzDy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}
		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryZyzDy(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryZyzDyNot(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryZyzDyNot(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryZyzDyAll(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryZyzDyAll(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryDzzRsDy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryDzzRsDy(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryDzzRsDyNot(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryDzzRsDyNot(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryDzzRsDyAll(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryDzzRsDyAll(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryZyzNlDy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryZyzNlDy(param);

		p.setList(list);
		updateNlPercent(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryZyzNlDyNot(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryZyzNlDyNot(param);

		p.setList(list);
		updateNlPercent(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination queryZyzNlDyAll(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.queryZyzNlDyAll(param);

		p.setList(list);
		updateNlPercent(list);
		// p.setTotalCount(count);
		return p;

	}

	private void updateNlPercent(List<Zyzinfo> list) {
		int total = 0;
		for (Zyzinfo z : list) {
			total += Integer.parseInt(z.getCzyz());
		}
		for (Zyzinfo z : list) {
			String percent = NumberFormat.getPercentInstance().format(
					(Integer.parseInt(z.getCzyz()))
							/ (total == 0 ? 1.0 : total + 0.0));
			z.setNlPercert(percent);
			String nlBarWidth=(int) ((Integer.parseInt(percent.replace(PERCENTSIGN, ""))) * COEFFICIENT)
					+ PERCENTSIGN;
			z.setNlBarWidth(nlBarWidth);
		}
	}
	public static final String PERCENTSIGN = "%";
	public static final double COEFFICIENT = 0.8;
	@Transactional
	public void updateCache() {
		HashMap<String, Object> param = new HashMap<String, Object>();
		queryDzzDyAll(param,20,null,"desc","cscore");
		queryDzzDy(param,20,null,"desc","cscore");
		queryDzzDyNot(param,20,null,"desc","cscore");
		queryZyzDyAll(param,20,null,"desc","cscore");
		queryZyzDy(param,20,null,"desc","cscore");
		queryZyzDyNot(param,20,null,"desc","cscore");
		queryDzzRsDyAll(param,20,null,"desc","cscore");
		queryDzzRsDy(param,20,null,"desc","cscore");
		queryDzzRsDyNot(param,20,null,"desc","cscore");
		queryZyzNlDyAll(param,20,null,"desc","cscore");
		queryZyzNlDy(param,20,null,"desc","cscore");
		queryZyzNlDyNot(param,20,null,"desc","cscore");
	}
	@Transactional
	public void update() {
		HashMap<String, Object> param = new HashMap<String, Object>();
		zyzinfoMapper.updateA01ByUsernamePhone(param);
		zyzinfoMapper.updateA01ByBirthday(param);
		zyzinfoMapper.updateD01(param);
		//zyzinfoMapper.deleteA01IdcardIsNull(param);
		//zyzinfoMapper.deleteZyzinfoIdcardNotFound(param);
	}
	
	

	public Pagination tj_dy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.tj_dy(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}
	
	public Pagination px_dy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.px_dy(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}
	public Pagination px_sqz(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.px_sqz(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}
	public Pagination fl_dy(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.fl_dy(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}

	public Pagination fl_sqz(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.fl_sqz(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}
	public Pagination tj_dzz(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.tj_dzz(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}
	public Pagination tj_dzzsub(Map<String, Object> param, int pageSize,
			Integer pageNo, String order, String sort) {
		Pagination p = new Pagination();
		/*
		 * p.setPageNo(pageNo); p.setPageSize(pageSize); p.setOrder(order);
		 * p.setSort(sort); param.putAll(p.toMap());
		 */
		
		if(pageNo!=null){
			param.put("startRows", (pageNo-1)*pageSize);
	    	param.put("limitRows", pageSize);
			}

		param.put("orderby", sort);
		param.put("order", order);
		// int count=zyzinfoMapper.queryDzzDyTotalRows(param);
		List<Zyzinfo> list = zyzinfoMapper.tj_dzzsub(param);

		p.setList(list);
		// p.setTotalCount(count);
		return p;

	}
}