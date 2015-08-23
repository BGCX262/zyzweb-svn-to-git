package com.mycms.cms.action.front;

import static com.mycms.cms.Constants.RES_PATH;
import static com.mycms.cms.Constants.TPLDIR_SPECIAL;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycms.cms.entity.main.CmsSite;
import com.mycms.cms.entity.main.ContentTag;
import com.mycms.cms.manager.main.CmsSiteMng;
import com.mycms.cms.manager.main.ContentTagMng;
import com.mycms.cms.web.CmsUtils;
import com.mycms.cms.web.FrontUtils;

@Controller
public class TagAct1 {
	@Autowired
	private   CmsSiteMng cmsSiteMng;
	@Autowired
	private ContentTagMng contentTagMng;
	public  String getContextPath(){
		String ctx="";
		List<CmsSite> list = cmsSiteMng.getListFromCache();
		CmsSite site =list.get(0);
		
		String res = ctx + RES_PATH + "/" + site.getPath() + "/"
		+ site.getTplSolution();
		ctx=res.substring(1);
		return ctx;
	}
}
