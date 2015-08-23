package com.zyz.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
 
/*	public Qjscuser getUserFromSession(HttpServletRequest request)
			throws Exception {
		Qjscuser user = (Qjscuser) request.getSession().getAttribute(
				Constants.USER_INFO_SESSION);
		if (user == null)
			throw new Exception("会话无效，请重新登录!");
		return user;
	}
*/
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// System.out.println("init binder =======================");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(
				BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, null,
				new CustomNumberEditor(Integer.class, null, true));
		// binder.registerCustomEditor(int.class, null, new CustomNativeEditor(
		// Integer.class, null , true));
		binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(
				Long.class, null, true));
		// binder.registerCustomEditor(long.class, null, new CustomNativeEditor(
		// Long.class, null, true));
		binder.registerCustomEditor(Float.class, new CustomNumberEditor(
				Float.class, true));
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(
				Double.class, true));
		binder.registerCustomEditor(BigInteger.class, new CustomNumberEditor(
				BigInteger.class, true));
	}
 
}
