package com.mycms.cms.action.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycms.cms.manager.main.ContentCountMng;
import com.mycms.cms.service.ContentCountCache;
import com.mycms.common.web.ResponseUtils;

@Controller
public class ContentCountAct {
	private static final Logger log = LoggerFactory
			.getLogger(ContentCountAct.class);

	@RequestMapping(value = "/content_view.jspx", method = RequestMethod.GET)
	public void contentView(Integer contentId, HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		if (contentId == null) {
			ResponseUtils.renderJson(response, "[]");
			return;
		}
		int[] counts = contentCountCache.viewAndGet(contentId);
		String json;
		if (counts != null) {
			json = new JSONArray(counts).toString();
			ResponseUtils.renderJson(response, json);
		} else {
			ResponseUtils.renderJson(response, "[]");
		}
	}

	@RequestMapping(value = "/content_up.jspx", method = RequestMethod.GET)
	public void contentUp(Integer contentId, HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		if (contentId == null) {
			ResponseUtils.renderJson(response, "false");
		} else {
			contentCountMng.contentUp(contentId);
			ResponseUtils.renderJson(response, "true");
		}
	}

	@RequestMapping(value = "/content_down.jspx", method = RequestMethod.GET)
	public void contentDown(Integer contentId, HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		if (contentId == null) {
			ResponseUtils.renderJson(response, "false");
		} else {
			contentCountMng.contentDown(contentId);
			ResponseUtils.renderJson(response, "true");
		}
	}

	@Autowired
	private ContentCountCache contentCountCache;
	@Autowired
	private ContentCountMng contentCountMng;
}
