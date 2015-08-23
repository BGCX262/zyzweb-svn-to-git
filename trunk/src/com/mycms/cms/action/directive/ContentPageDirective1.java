package com.mycms.cms.action.directive;

import static com.mycms.cms.Constants.TPL_STYLE_LIST;
import static com.mycms.cms.Constants.TPL_SUFFIX;
import static com.mycms.cms.web.FrontUtils.PARAM_STYLE_LIST;
import static com.mycms.common.web.Constants.UTF8;
import static com.mycms.common.web.freemarker.DirectiveUtils.OUT_LIST;
import static com.mycms.common.web.freemarker.DirectiveUtils.OUT_PAGINATION;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.mycms.cms.action.directive.abs.AbstractContentDirective;
import com.mycms.cms.entity.main.CmsSite;
import com.mycms.cms.entity.main.Content.ContentStatus;
import com.mycms.cms.web.FrontUtils;
import com.mycms.common.page.Pagination;
import com.mycms.common.web.freemarker.DirectiveUtils;
import com.mycms.common.web.freemarker.ParamsRequiredException;
import com.mycms.common.web.freemarker.DirectiveUtils.InvokeType;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 内容分页标签
 * 
 * 
 * 
 */
public class ContentPageDirective1 extends AbstractContentDirective {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "content_page";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		Pagination page = (Pagination) getData(params, env);

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(OUT_PAGINATION, DEFAULT_WRAPPER.wrap(page));
		paramWrap.put(OUT_LIST, DEFAULT_WRAPPER.wrap(page.getList()));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(TPL_STYLE_LIST + listStyle + TPL_SUFFIX, UTF8, true);
			FrontUtils.includePagination(site, params, env);
		} else if (InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(TPL_STYLE_LIST, site, env);
			FrontUtils.includePagination(site, params, env);
		} else if (InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
			FrontUtils.includePagination(site, params, env);
		} else if (InvokeType.body == type) {
			if (body != null) {
				body.render(env.getOut());
				FrontUtils.includePagination(site, params, env);
			}
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}
	protected Object getData(Map<String, TemplateModel> params, Environment env)
	throws TemplateException {
int orderBy = getOrderBy(params);
Boolean titleImg = getHasTitleImg(params);
Boolean recommend = getRecommend(params);
Integer[] typeIds = getTypeIds(params);
Integer[] siteIds = getSiteIds(params);
String title = getTitle(params);
int count = FrontUtils.getCount(params);

Integer[] tagIds = getTagIds(params);
 
Integer[] channelIds = getChannelIds(params);
if (channelIds != null) {
	int option = getChannelOption(params);
	if (isPage()) {
		int pageNo = FrontUtils.getPageNo(env);
		return super.contentMng.getPageByRight(title, null, null, false, recommend!=null?recommend.booleanValue():false, ContentStatus.all, Byte.parseByte("2"), 1, channelIds[0], 1, orderBy, pageNo, count);
	} else {
		int first = FrontUtils.getFirst(params);
		return super.contentMng.getPageByRight(title, null, null, false, recommend!=null?recommend.booleanValue():false, ContentStatus.all, Byte.parseByte("2"), 1, channelIds[0], 1, orderBy, first, count).getList();
	}
}
 
// 主要条件为空，则执行此处代码。
if (isPage()) {
	int pageNo = FrontUtils.getPageNo(env);
	return contentMng.getPageBySiteIdsForTag(siteIds, typeIds,
			titleImg, recommend, title, orderBy, pageNo, count);
} else {
	int first = FrontUtils.getFirst(params);
	return contentMng.getListBySiteIdsForTag(siteIds, typeIds,
			titleImg, recommend, title, orderBy, first, count);
}
}
	@Override
	protected boolean isPage() {
		return true;
	}
}
