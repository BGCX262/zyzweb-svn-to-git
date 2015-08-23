package com.mycms.cms.action.admin.main;

import static com.mycms.common.page.SimplePage.cpn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycms.cms.entity.main.CmsCompanyType;
import com.mycms.cms.manager.main.CmsCompanyTypeMng;
import com.mycms.cms.manager.main.CmsLogMng;
import com.mycms.cms.web.WebErrors;
import com.mycms.common.page.Pagination;
import com.mycms.common.web.CookieUtils;

@Controller
public class CmsCompanyTypeAct {
	private static final Logger log = LoggerFactory.getLogger(CmsCompanyTypeAct.class);

	@RequestMapping("/comtype/v_list.do")
	public String list(HttpServletRequest request, ModelMap model, Integer pageNo) {
		Pagination pagination = manager.getPage( null, cpn(pageNo),
				CookieUtils.getPageSize(request));
//		List<CmsCompanyType> list = manager.getList();
//		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		return "comtype/list";
	}

	@RequestMapping("/comtype/v_add.do")
	public String add(ModelMap model) {
		List<CmsCompanyType> list = manager.getList();
		model.addAttribute("typelist", list);
		return "comtype/add";
	}

	@RequestMapping("/comtype/v_edit.do")
	public String edit(Integer id, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		List<CmsCompanyType> list = manager.getList();
		model.addAttribute("typelist", list);
		model.addAttribute("cmsCompType", manager.findById(id));
		return "comtype/edit";
	}

	@RequestMapping("/comtype/o_save.do")
	public String save(CmsCompanyType bean, String[] perms,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.save(bean);
		log.info("save CmsRole id={}", bean.getId());
		cmsLogMng.operating(request, "cmsRole.log.save", "id=" + bean.getId()
				+ ";name=" + bean.getName());
		return "redirect:v_list.do";
	}

	@RequestMapping("/comtype/o_update.do")
	public String update(CmsCompanyType bean,
			HttpServletRequest request, ModelMap model, Integer pageNo) {
		WebErrors errors = validateUpdate(bean.getId(), request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.update(bean);
		log.info("update CmsRole id={}.", bean.getId());
		cmsLogMng.operating(request, "cmsRole.log.update", "id=" + bean.getId()
				+ ";name=" + bean.getName());
		return list(request, model,pageNo);
	}

	@RequestMapping("/comtype/o_delete.do")
	public String delete(Integer[] ids, HttpServletRequest request,
			ModelMap model, Integer pageNo) {
		WebErrors errors = validateDelete(ids, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		CmsCompanyType[] beans = manager.deleteByIds(ids);
		for (CmsCompanyType bean : beans) {
			log.info("delete CmsRole id={}", bean.getId());
			cmsLogMng.operating(request, "cmsRole.log.delete", "id="
					+ bean.getId() + ";name=" + bean.getName());
		}
		return list(request, model,pageNo);
	}

	private WebErrors validateSave(CmsCompanyType bean, HttpServletRequest request) {
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
		CmsCompanyType entity = manager.findById(id);
		if (errors.ifNotExist(entity, CmsCompanyType.class, id)) {
			return true;
		}
		return false;
	}

	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private CmsCompanyTypeMng manager;
}