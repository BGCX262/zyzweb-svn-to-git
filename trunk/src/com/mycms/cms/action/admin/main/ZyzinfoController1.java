package com.mycms.cms.action.admin.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.app.util.page.CookieUtils;
import com.web.app.util.page.Pagination;
import com.zyz.domain.D01;
import com.zyz.domain.Zyzinfo;
import com.zyz.service.A01Service;
import com.zyz.service.C02Service;
import com.zyz.service.D01Service;
import com.zyz.service.D16Service;
import com.zyz.service.ZyzinfoService;
import com.zyz.tools.ExcelReader;

@Controller("zyzinfoController")
@RequestMapping("/zyzinfo1")
public class ZyzinfoController1  {

	private static final Logger logger = Logger
			.getLogger(ZyzinfoController1.class);
 
	@Autowired
	private D01Service d01Service;
 
	@RequestMapping(value = "/dzztree.do")
	public String dzztree(String root,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		boolean isRoot;
		// jquery treeview的根请求为root=source
		if (StringUtils.isBlank(root) || "source".equals(root)) {
			isRoot = true;
		} else {
			isRoot = false;
		}
		model.addAttribute("isRoot", isRoot);
		
		if(pageNo==null)pageNo=1;
		if(pageSize==null)
			pageSize = CookieUtils.getPageSize(request);
		Map<String, Object> param = new HashMap<String, Object>();
		if (isRoot) {
			param.put("len", 6);
		}else
		{
			param.put("len", root.length()+3);
		}

		List<D01>  list= d01Service.tree(param);
		model.addAttribute("list", list);
		model.addAttribute("root", root);
		return "dzz/tree";

	}
 
}