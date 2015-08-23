package com.web.app.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.web.app.pub.Tdictionarytype;
import com.web.app.pub.TdictionarytypeService;
import com.web.app.pub.Tdictionay;
import com.web.app.pub.TdictionayService;
import com.zyz.service.D01Service;
@Service
public class InitDictData implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderby", "type,sequence,id");
		param.put("order", "asc");
		Map<String, Object> m = ((TdictionayService)SpringBeanUtils.getBean("tdictionayService")).getTdictionayList(param);
		List<Tdictionay> l = (List<Tdictionay>) m.get("rows");
		DictUtils.init(l);
		param.put("orderby", "name");
		param.put("order", "desc");
		Map<String, Object> m1 = ((TdictionarytypeService) SpringBeanUtils
				.getBean("tdictionarytypeService"))
				.getTdictionarytypeList(param);
		List<Tdictionarytype> l1 = (List<Tdictionarytype>) m1.get("rows");
		DictUtils.addDictType(l1);
		Map<String, String> d01map = ((D01Service)SpringBeanUtils.getBean("d01Service")).getD01Dict();
		DictUtils.init(DictUtils.D01_dzz,d01map);
	}
}
