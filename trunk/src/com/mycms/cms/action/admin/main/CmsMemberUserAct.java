package com.mycms.cms.action.admin.main;

import static com.mycms.common.page.SimplePage.cpn;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycms.cms.entity.main.CmsGroup;
import com.mycms.cms.entity.main.CmsMemberUser;
import com.mycms.cms.entity.main.CmsUserExt;
import com.mycms.cms.manager.main.CmsGroupMng;
import com.mycms.cms.manager.main.CmsLogMng;
import com.mycms.cms.manager.main.CmsMemberUserMng;
import com.mycms.cms.web.WebErrors;
import com.mycms.common.page.Pagination;
import com.mycms.common.security.encoder.PwdEncoder;
import com.mycms.common.web.CookieUtils;
import com.mycms.common.web.RequestUtils;
import com.mycms.common.web.ResponseUtils;

@Controller
public class CmsMemberUserAct {
	private static final Logger log = LoggerFactory
			.getLogger(CmsMemberUserAct.class);

	@RequestMapping("/memberuser/v_list.do")
	public String list(String queryUsername, String queryEmail,
			Integer queryGroupId, Boolean queryDisabled, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		Pagination pagination = manager.getPage(queryUsername, queryEmail,
				null, queryGroupId, queryDisabled, false, null, cpn(pageNo),
				CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);

		model.addAttribute("queryUsername", queryUsername);
		model.addAttribute("queryEmail", queryEmail);
		model.addAttribute("queryGroupId", queryGroupId);
		model.addAttribute("queryDisabled", queryDisabled);

		return "member_user/list";
	}

	@RequestMapping("/memberuser/o_save.do")
	public String save(CmsMemberUser bean, String[] perms,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.save(bean);
		log.info("save CmsRole id={}", bean.getId());
		cmsLogMng.operating(request, "cmsMember.log.save", "id=" + bean.getId()
				+ ";name=" + bean.getUserName());
		return "member_user/success";
	}
	@RequestMapping("/memberuser/v_add.do")
	public String add(ModelMap model) {
		List<CmsGroup> groupList = cmsGroupMng.getList();
		model.addAttribute("groupList", groupList);
		return "member_user/add";
	}

	@RequestMapping("/memberuser/v_modpw.do")
	public String modpw(ModelMap model) {
		return "member_user/modpw";
	}
	
	@RequestMapping("/memberuser/v_findPw.do")
	public String findPw(ModelMap model) {
		return "member_user/findPw";
	}
	
	@RequestMapping("/memberuser/o_savepw.do")
	public String savePw(String username, String newPassword,String oldPassword,
			HttpServletRequest request, ModelMap model) {
		CmsMemberUser bean = manager.getByUsernamePsw(username, oldPassword);
		if(bean != null)
		{
			bean.setPassword(newPassword);
			manager.save(bean);
		}
		return "member_user/modPwSuccess";
	}
	

	@RequestMapping("/memberuser/o_findPwByEmail.do")
	public String findPwByEmail(String username, String email,
			HttpServletRequest request, ModelMap model) {
		CmsMemberUser bean = manager.getByUsernameEmail(username, email);
		if(bean != null)
		{
			//String newPassword = manager.MD5("123456");
			bean.setPassword("123456");
			bean = manager.save(bean);
			if(bean != null)
			{
				manager.sendEmail(username, email);
			}
			
		}
		return "member_user/findPwByEmailSuccess";
	}
	
	@RequestMapping("/memberuser/v_edit.do")
	public String edit(Integer id, Integer queryGroupId, Boolean queryDisabled,
			HttpServletRequest request, ModelMap model) {
		String queryUsername = RequestUtils.getQueryParam(request,
				"queryUsername");
		String queryEmail = RequestUtils.getQueryParam(request, "queryEmail");
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		List<CmsGroup> groupList = cmsGroupMng.getList();
		model.addAttribute("queryUsername", queryUsername);
		model.addAttribute("queryEmail", queryEmail);
		model.addAttribute("queryGroupId", queryGroupId);
		model.addAttribute("queryDisabled", queryDisabled);
		model.addAttribute("groupList", groupList);
		model.addAttribute("cmsMemberUser", manager.findById(id));
		return "member_user/edit";
	}


	@RequestMapping("/memberuser/o_update.do")
	public String update(Integer id,CmsMemberUser bean, String email, String password,
			Boolean disabled, CmsUserExt ext, Integer groupId,
			String queryUsername, String queryEmail, Integer queryGroupId,
			Boolean queryDisabled, Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		WebErrors errors = validateUpdate(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		if(bean != null)
		{
			bean.setUpdateTime(new Date());
			bean.setLastUpdateTime(new Date());
		}
		bean = manager.updateMember(id, bean,email, password, disabled, ext,
				groupId);
		log.info("update CmsMember id={}.", bean.getId());
		cmsLogMng.operating(request, "cmsMember.log.update", "id="
				+ bean.getId() + ";username=" + bean.getUserName());

		return list(queryUsername, queryEmail, queryGroupId, queryDisabled,
				pageNo, request, model);
	}

	@RequestMapping("/memberuser/o_delete.do")
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
		CmsMemberUser[] beans = manager.deleteByIds(ids);
		for (CmsMemberUser bean : beans) {
			log.info("delete CmsMember id={}", bean.getId());
			cmsLogMng.operating(request, "cmsMember.log.delete", "id="
					+ bean.getId() + ";username=" + bean.getUserName());
		}
		return list(queryUsername, queryEmail, queryGroupId, queryDisabled,
				pageNo, request, model);
	}

	@RequestMapping(value = "/memberuser/v_check_username.do")
	public void checkUsername(String username, HttpServletResponse response) {
		String pass;
		if (StringUtils.isBlank(username)) {
			pass = "false";
		} else {
			pass = manager.usernameNotExist(username) ? "true" : "false";
		}
		ResponseUtils.renderJson(response, pass);
	}

	private WebErrors validateSave(CmsMemberUser bean, HttpServletRequest request) {
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
		// TODO 验证是否为管理员，管理员不允许修改。
		return errors;
	}

	private WebErrors validateDelete(Integer[] ids, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		errors.ifEmpty(ids, "ids");
		for (Integer id : ids) {
			vldExist(id, errors);
		}
		return errors;
	}

	private boolean vldExist(Integer id, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		CmsMemberUser entity = manager.findById(id);
		if (errors.ifNotExist(entity, CmsMemberUser.class, id)) {
			return true;
		}
		return false;
	}

	@Autowired
	private CmsGroupMng cmsGroupMng;
	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private CmsMemberUserMng manager;
	private PwdEncoder pwdEncoder;
}