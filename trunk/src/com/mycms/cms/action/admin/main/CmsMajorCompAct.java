package com.mycms.cms.action.admin.main;

import static com.mycms.common.page.SimplePage.cpn;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.cms.entity.main.CmsMajorComp;
import com.mycms.cms.entity.main.CmsUserExt;
import com.mycms.cms.manager.main.CmsCompanyTypeMng;
import com.mycms.cms.manager.main.CmsLogMng;
import com.mycms.cms.manager.main.CmsMajorCompMng;
import com.mycms.cms.web.WebErrors;
import com.mycms.common.page.Pagination;
import com.mycms.common.web.CookieUtils;
import com.mycms.common.web.RequestUtils;

@Controller
public class CmsMajorCompAct {
	private static final Logger log = LoggerFactory.getLogger(CmsMajorCompAct.class);

	@RequestMapping("/majorcomp/v_list.do")
	public String list(String queryUsername, String queryEmail,
			Integer queryGroupId, Boolean queryDisabled, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		Pagination pagination = manager.getPage(queryUsername, queryEmail,
				null, queryGroupId, queryDisabled, false, null, cpn(pageNo),
				CookieUtils.getPageSize(request));
		List<CmsCompanyType> list = typeManager.getList();
		model.addAttribute("typelist", list);
		model.addAttribute("pagination", pagination);
		return "majorcomp/list";
	}

	@RequestMapping("/majorcomp/v_add.do")
	public String add(ModelMap model) {
		List<CmsCompanyType> list = typeManager.getList();
		model.addAttribute("typelist", list);
		return "majorcomp/add";
	}


	@RequestMapping("/majorcomp/v_imp.do")
	public String imp(ModelMap model) {
		return "majorcomp/imp";
	}
	
	@RequestMapping("/majorcomp/v_edit.do")
	public String edit(Integer id, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		List<CmsCompanyType> list = typeManager.getList();
		model.addAttribute("typelist", list);
		model.addAttribute("cmsMajorComp", manager.findById(id));
		return "majorcomp/edit";
	}

	@RequestMapping("/majorcomp/o_impSave.do")
	public String impSave(String upLoadFile,@RequestParam(value = "uploadFile", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) throws IOException {
		try {
			manager.impSave(file, upLoadFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:v_list.do";
	}
	@RequestMapping("/majorcomp/o_save.do")
	public String save(CmsMajorComp bean, String[] perms,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.save(bean);
		log.info("save CmsRole id={}", bean.getId());
		cmsLogMng.operating(request, "cmsMember.log.save", "id=" + bean.getId()
				+ ";name=" + bean.getName());
		return "redirect:v_list.do";
	}

	@RequestMapping("/majorcomp/o_update.do")
	public String update(Integer id,CmsMajorComp bean, String email, String password,
			Boolean disabled, CmsUserExt ext, Integer groupId,
			String queryUsername, String queryEmail, Integer queryGroupId,
			Boolean queryDisabled, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		WebErrors errors = validateUpdate(bean.getId(), request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.update(bean);
		log.info("update cmsMajorComp id={}.", bean.getId());
		cmsLogMng.operating(request, "cmsRole.log.update", "id=" + bean.getId()
				+ ";name=" + bean.getName());
		return list(queryUsername, queryEmail, queryGroupId, queryDisabled,
				pageNo, request, model);
	}


	@RequestMapping("/majorcomp/o_delete.do")
	public String delete(Integer[] ids, Integer queryGroupId,
			Boolean queryDisabled, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		String queryUsername = RequestUtils.getQueryParam(request,
				"queryUsername");
		String queryEmail = RequestUtils.getQueryParam(request, "queryEmail");
		WebErrors errors = validateDelete(ids, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		CmsMajorComp[] beans = manager.deleteByIds(ids);
		for (CmsMajorComp bean : beans) {
			log.info("delete cmsMajorComp id={}", bean.getId());
			cmsLogMng.operating(request, "cmsMember.log.delete", "id="
					+ bean.getId() + ";username=" + bean.getName());
		}
		return list(queryUsername, queryEmail, queryGroupId, queryDisabled,
				pageNo, request, model);
	}

	private WebErrors validateSave(CmsMajorComp bean, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		return errors;
	}

	private WebErrors validateEdit(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (vldExist(id, errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateUpdate(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (vldExist(id, errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateDelete(Integer[] ids, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (errors.ifEmpty(ids, "ids")) {
			return errors;
		}
		for (Integer id : ids) {
			vldExist(id, errors);
		}
		return errors;
	}

	private boolean vldExist(Integer id, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		CmsMajorComp entity = manager.findById(id);
		if (errors.ifNotExist(entity, CmsMajorComp.class, id)) {
			return true;
		}
		return false;
	}

	public void setTypeManager(CmsCompanyTypeMng typeManager) {
		this.typeManager = typeManager;
	}

	public CmsCompanyTypeMng getTypeManager() {
		return typeManager;
	}

	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private CmsMajorCompMng manager;
	@Autowired
	private CmsCompanyTypeMng typeManager;
}