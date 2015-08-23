package com.web.app.util.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.web.app.pub.Tdictionarytype;
import com.web.app.pub.TdictionarytypeService;
import com.web.app.pub.Tdictionay;
import com.web.app.pub.TdictionayService;
import com.web.app.util.DictUtils;

public class StartupInitServlet implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(arg0.getServletContext());
		TdictionayService tdictionayService = (TdictionayService) webApplicationContext
				.getBean("TdictionayService");
		TdictionarytypeService tdictionarytypeService = (TdictionarytypeService) webApplicationContext
				.getBean("TdictionarytypeService");
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> m = tdictionayService.getTdictionayList(param);
		List<Tdictionay> l = (List<Tdictionay>) m.get("rows");
		DictUtils.init(l);
		param.put("orderby", "name");
		param.put("order", "desc");
		Map<String, Object> m1 = tdictionarytypeService
				.getTdictionarytypeList(param);
		List<Tdictionarytype> l1 = (List<Tdictionarytype>) m1.get("rows");
		DictUtils.addDictType(l1);

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}
}
