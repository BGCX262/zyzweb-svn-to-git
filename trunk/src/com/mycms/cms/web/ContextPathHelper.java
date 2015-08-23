package com.mycms.cms.web;

import static com.mycms.cms.Constants.RES_PATH;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mycms.cms.dao.main.impl.CmsSiteDaoImpl;
import com.mycms.cms.entity.main.CmsSite;
import com.mycms.cms.manager.main.CmsSiteMng;
import com.mycms.cms.manager.main.impl.CmsSiteMngImpl;
public class ContextPathHelper {
	 
private static String path=null;
	
	public static  String getContextPath(HttpServletRequest request){
		if(path!=null)return path;
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		CmsSiteMng cmsSiteMng=(CmsSiteMng)webApplicationContext.getBean("cmsSiteMng");
		String ctx=request.getContextPath();
		List<CmsSite> list = cmsSiteMng.getListFromCache();
		CmsSite site =list.get(0);
		
		String res = ctx + RES_PATH + "/" + site.getPath() + "/"
		+ site.getTplSolution();
		//ctx=res.substring(1);
		return res;
	}
}
