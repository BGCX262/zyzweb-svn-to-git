package com.mycms.cms.manager.main.impl;

import java.io.InputStream;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mycms.cms.entity.main.CmsMajorComp;
import com.mycms.cms.manager.main.CmsMajorCompMng;
import com.mycms.common.hibernate3.Finder;
import com.mycms.common.hibernate3.HibernateBaseDao;
import com.mycms.common.hibernate3.Updater;
import com.mycms.common.page.Pagination;

@Service
@Transactional
public class CmsMajorCompMngImpl  extends HibernateBaseDao<CmsMajorComp, Integer> implements CmsMajorCompMng {
	public Pagination getPage(String username, String email, Integer siteId,
			Integer groupId, Boolean disabled, Boolean admin, Integer rank,
			int pageNo, int pageSize) {
		Finder f = Finder.create("select bean from CmsMajorComp bean");

		f.append(" order by bean.id desc");
		return find(f, pageNo, pageSize);
	}
	@SuppressWarnings("unchecked")
	public List<CmsMajorComp> getList() {
		String hql = "from CmsMajorComp bean order by bean.id asc";
		return find(hql);
	}

	public CmsMajorComp findById(Integer id) {
		CmsMajorComp entity = get(id);
		return entity;
	}

	public CmsMajorComp save(CmsMajorComp bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsMajorComp deleteById(Integer id) {
		CmsMajorComp entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	public void impSave(MultipartFile uploadFile,String upLoadPath) throws Exception {
		try
		{
			   InputStream is =uploadFile.getInputStream();
			   //InputStream is = new FileInputStream(fileName);
			   Workbook rwb = Workbook.getWorkbook(is);
			   Sheet st[] = rwb.getSheets();// 得到所有Excel中页的列表.
			      Sheet st1 = st[0];
			      
			      for (int i = 0; i < st1.getRows(); i++){
				      Cell c1 = st1.getCell(1, i);
				      // 通用的获取cell值的方式,返回字符串
				      String strc00 = c1.getContents().trim();
				      if(StringUtils.isNotEmpty(strc00) && !"商家名称".equals(strc00))
					  {
						  String name = c1.getContents().trim();
	
						  Cell c2 = st1.getCell(2, i);
						  String typeid = c2.getContents().trim();
						  
						  Cell c3 = st1.getCell(3, i);
						  String recommand = c3.getContents().trim();
							      
						  Cell c4 = st1.getCell(4, i);
						  String province = c4.getContents().trim();
							      
						  Cell c5 = st1.getCell(5, i);
						  String city = c5.getContents().trim();
							      
						  Cell c6 = st1.getCell(6, i);
						  String country = c6.getContents().trim();

						  Cell c7 = st1.getCell(7, i);
						  String pcode = c7.getContents().trim();

						  Cell c8 = st1.getCell(8, i);
						  String address = c8.getContents().trim();

						  Cell c9 = st1.getCell(9, i);
						  String telephone = c9.getContents().trim();

						  Cell c10 = st1.getCell(10, i);
						  String image = c10.getContents().trim();

						  Cell c11 = st1.getCell(11, i);
						  String compLevel = c11.getContents().trim();

						  //Cell c12 = st1.getCell(12, i);
						  //String tt = c12.getContents().trim();

						  Cell c13 = st1.getCell(13, i);
						  String lng = c13.getContents().trim();

						  Cell c14 = st1.getCell(14, i);
						  String lat = c14.getContents().trim();

						  Cell c15 = st1.getCell(15, i);
						  String isoffset = c15.getContents().trim();

						  Cell c16 = st1.getCell(16, i);
						  String content = c16.getContents().trim();

						  Cell c17 = st1.getCell(17, i);
						  String mtrust = c17.getContents().trim();

						  Cell c18 = st1.getCell(18, i);
						  String mdevice = c18.getContents().trim();

						  Cell c19 = st1.getCell(19, i);
						  String mcontent = c19.getContents().trim();

						  Cell c20 = st1.getCell(20, i);
						  String actContent = c20.getContents().trim();

						  CmsMajorComp bean = new CmsMajorComp();

						  bean.setName(name);
						  bean.setTypeid(typeid);
						  bean.setRecommand(Integer.parseInt(recommand));
						  bean.setProvince(province);
						  bean.setCity(city);
						  bean.setCountry(country);
						  bean.setPcode(pcode);
						  bean.setAddress(address);
						  bean.setTelephone(telephone);
						  bean.setImage(image);
						  if(StringUtils.isNotEmpty(compLevel))
						  {
							  bean.setCompLevel(Integer.parseInt(compLevel));							  
						  }
						  bean.setLng(lng);
						  bean.setLat(lat);
						  if(StringUtils.isNotEmpty(isoffset))
						  {
							  bean.setIsoffset(Integer.parseInt(isoffset));							  
						  }
						  bean.setContent(content);
						  if(StringUtils.isNotEmpty(mtrust))
						  {
							  bean.setMtrust(Integer.parseInt(mtrust));						  
						  }
						  if(StringUtils.isNotEmpty(mdevice))
						  {
							  bean.setMdevice(Integer.parseInt(mdevice));					  
						  }
						  bean.setMcontent(mcontent);
						  bean.setActContent(actContent);
						  this.save(bean);
				      }
			      }
			   
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("导入excel数据失败", e);
		}
	}
	public CmsMajorComp update(CmsMajorComp bean) {
		Updater<CmsMajorComp> updater = new Updater<CmsMajorComp>(bean);
		bean = updateByUpdater(updater);
		return bean;
	}
	public CmsMajorComp[] deleteByIds(Integer[] ids) {
		CmsMajorComp[] beans = new CmsMajorComp[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	@Override
	protected Class<CmsMajorComp> getEntityClass() {
		return CmsMajorComp.class;
	}
}