package com.mycms.cms.action.directive;

import static com.mycms.cms.Constants.TPL_STYLE_LIST;
import static com.mycms.cms.Constants.TPL_SUFFIX;
import static com.mycms.cms.web.FrontUtils.PARAM_STYLE_LIST;
import static com.mycms.common.web.Constants.UTF8;
import static com.mycms.common.web.freemarker.DirectiveUtils.OUT_LIST;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.mycms.cms.action.directive.abs.AbstractContentDirective;
import com.mycms.cms.entity.main.CmsSite;
import com.mycms.cms.web.FrontUtils;
import com.mycms.common.web.freemarker.DirectiveUtils;
import com.mycms.common.web.freemarker.DirectiveUtils.InvokeType;
import com.mycms.common.web.freemarker.ParamsRequiredException;
import com.web.app.util.SpringBeanUtils;
import com.zyz.domain.Zyzinfo;
import com.zyz.service.ZyzinfoService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 内容列表标签
 * 
 * 
 * 
 */
public class ZyzListDirective extends AbstractContentDirective {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "content_list";

	/**
	 * 输入参数，文章ID。允许多个文章ID，用","分开。排斥其他所有筛选参数。
	 */
	public static final String PARAM_IDS = "ids";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		List<Zyzinfo> list = getList(params, env);

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(OUT_LIST, DEFAULT_WRAPPER.wrap(list));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(TPL_STYLE_LIST + listStyle + TPL_SUFFIX, UTF8, true);
		} else if (InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(TPL_STYLE_LIST, site, env);
		} else if (InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
		} else if (InvokeType.body == type) {
			body.render(env.getOut());
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}

	@SuppressWarnings("unchecked")
	protected List<Zyzinfo> getList(Map<String, TemplateModel> params,
			Environment env) throws TemplateException {
		Map<String, Object> param = new HashMap<String, Object>();
		String t = DirectiveUtils.getString("t",params);

		List	list=	null;
		if("1".equals(t))
			list=getZyzinfoService().queryZyzDy(param,20,1,"desc","cscore").getList();
		else
			list=getZyzinfoService().queryDzzDy(param,20,1,"desc","cscore").getList();
		return list;
  
	}
	private ZyzinfoService zyzinfoService;
	
	public ZyzinfoService getZyzinfoService() {
		if(this.zyzinfoService==null){
			zyzinfoService=			 ((ZyzinfoService)SpringBeanUtils.getBean("zyzinfoService"));
		}
		return zyzinfoService;
	}

	@Override
	protected boolean isPage() {
		return false;
	}
}
