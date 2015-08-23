package com.mycms.cms.web;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.mycms.cms.entity.main.CmsSite;

/**
 * 后台（管理员）本地化信息拦截器
 * 
 * 
 * 
 */
public class AdminLocaleInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 本地化字符串在ModelMap中的名称
	 */
	public static final String LOCALE = "locale";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		
		
		String url = request.getRequestURI();
		
		//以下页面取消权限控制
		if(url != null && !"".equals(url))
		{
			if(url.indexOf("memberuser/v_add.do") != -1)
			{
				return true;
			}
			if(url.indexOf("memberuser/v_modpw.do") != -1)
			{
				return true;
			}
			if(url.indexOf("memberuser/v_findPw.do") != -1)
			{
				return true;
			}
			if(url.indexOf("memberuser/o_savepw.do") != -1)
			{
				return true;
			}
			

			if(url.indexOf("memberuser/o_findPwByEmail.do") != -1)
			{
				return true;
			}
			if(url.indexOf("memberuser/o_save.do") != -1)
			{
				return true;
			}
			
		}
		LocaleResolver localeResolver = RequestContextUtils
				.getLocaleResolver(request);
		if (localeResolver == null) {
			throw new IllegalStateException(
					"No LocaleResolver found: not in a DispatcherServlet request?");
		}
		CmsSite site = CmsUtils.getSite(request);
		String newLocale = site.getLocaleAdmin();
		LocaleEditor localeEditor = new LocaleEditor();
		localeEditor.setAsText(newLocale);
		localeResolver.setLocale(request, response, (Locale) localeEditor
				.getValue());
		// Proceed in any case.
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LocaleResolver localeResolver = RequestContextUtils
				.getLocaleResolver(request);
		if (localeResolver == null) {
			throw new IllegalStateException(
					"No LocaleResolver found: not in a DispatcherServlet request?");
		}
		if (modelAndView != null) {
			modelAndView.getModelMap().addAttribute(LOCALE,
					localeResolver.resolveLocale(request).toString());
		}
	}
}