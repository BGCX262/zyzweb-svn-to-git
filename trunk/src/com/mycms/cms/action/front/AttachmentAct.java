package com.mycms.cms.action.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycms.cms.entity.assist.CmsGuestbookCtg;
import com.mycms.cms.entity.main.Channel;
import com.mycms.cms.entity.main.CmsConfig;
import com.mycms.cms.entity.main.CmsSite;
import com.mycms.cms.entity.main.CmsTopic;
import com.mycms.cms.entity.main.Content;
import com.mycms.cms.entity.main.ContentAttachment;
import com.mycms.cms.manager.main.ChannelMng;
import com.mycms.cms.manager.main.ContentCountMng;
import com.mycms.cms.manager.main.ContentMng;
import com.mycms.cms.web.CmsUtils;
import com.mycms.cms.web.FrontUtils;
import com.mycms.common.security.encoder.PwdEncoder;
import com.mycms.common.web.ResponseUtils;

@Controller
public class AttachmentAct {
	private static final Logger log = LoggerFactory
			.getLogger(AttachmentAct.class);
	
	@RequestMapping(value = "/attachment.jspx", method = RequestMethod.GET)
	public void attachment(Integer cid, Integer i, Long t, String k,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws IOException {
		CmsConfig config = CmsUtils.getSite(request).getConfig();
		String code = config.getDownloadCode();
		int h = config.getDownloadTime() * 60 * 60 * 1000;
		if (pwdEncoder.isPasswordValid(k, cid + ";" + i + ";" + t, code)) {
			long curr = System.currentTimeMillis();
			if (t + h > curr) {
				Content c = contentMng.findById(cid);
				if (c != null) {
					List<ContentAttachment> list = c.getAttachments();
					if (list.size() > i) {
						contentCountMng.downloadCount(c.getId());
						ContentAttachment ca = list.get(i);
						
						String basename=ca.getPath();
						if(basename.lastIndexOf("/")!=-1){
							String filename=basename.substring(basename.lastIndexOf("/")+1);
							String path=basename.substring(0,basename.lastIndexOf("/")+1);
							filename=java.net.URLEncoder.encode(filename, "UTF-8"); 
							basename=path+filename;
						}
//						String name=java.net.URLEncoder.encode(basename, "UTF-8");
						response.sendRedirect(basename);
						return;
					} else {
						log.info("download index is out of range: {}", i);
					}
				} else {
					log.info("Content not found: {}", cid);
				}
			} else {
				log.info("download time is expired!");
			}
		} else {
			
			log.info("download key error!");
		}
		response.sendRedirect(request.getContextPath()+"/404.html");
//		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
	@RequestMapping(value = "/attachment1.jspx", method = RequestMethod.GET)
	public void attachment1(Integer cid,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws IOException {
		CmsConfig config = CmsUtils.getSite(request).getConfig();
				Content c = contentMng.findById(cid);
				if (c != null) {
					List<ContentAttachment> list = c.getAttachments();
					if (list.size() > 0) {
						contentCountMng.downloadCount(c.getId());
						ContentAttachment ca = list.get(0);
						response.sendRedirect(ca.getPath());
						return;
					}  
				} else {
					response.sendRedirect(request.getContextPath()+"/404.html");
//					response.sendError(HttpServletResponse.SC_NOT_FOUND);
					log.info("Content not found: {}", cid);
				}
			 
		 
				response.sendRedirect(request.getContextPath()+"/404.html");
	}
	/**
	 * 获得下载key和time
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/attachment_url.jspx", method = RequestMethod.GET)
	public void url(Integer cid, Integer n, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		if (cid == null || n == null) {
			return;
		}
		CmsConfig config = CmsUtils.getSite(request).getConfig();
		String code = config.getDownloadCode();
		long t = System.currentTimeMillis();
		JSONArray arr = new JSONArray();
		String key;
		for (int i = 0; i < n; i++) {
			key = pwdEncoder.encodePassword(cid + ";" + i + ";" + t, code);
			arr.put("&t=" + t + "&k=" + key);
		}
		ResponseUtils.renderText(response, arr.toString());
	}
	
	@RequestMapping(value = "/getMobileType.jspx", method = RequestMethod.GET)
	public void getMobileType(Integer cid, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws JSONException{
		if (cid == null ) {
			return;
		}
		CmsConfig config = CmsUtils.getSite(request).getConfig();
		String code = config.getDownloadCode();
		List<Channel> channelList=channelMng.getChildList(cid, true);
		JSONArray arr = new JSONArray();
			JSONObject o;
			for (Channel t : channelList) {
				o = new JSONObject();
				o.put("id", t.getId());
				o.put("name", t.getName());
				arr.put(o);
			}
		ResponseUtils.renderText(response, arr.toString());
	}
	
	@RequestMapping(value = "/getChannelContent.jspx", method = RequestMethod.GET)
	public void getChannelContent(Integer channelid, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws JSONException{
		if (channelid == null ) {
			return;
		}
		List<Content> cList= 
		contentMng.getListByChannelIdsForTag(new Integer[]{channelid},
				null, null, null, null, 0, 0,
				0, 1);
		Content c = contentMng.findById(cList.get(0).getId());
		boolean found=false;
		if (c != null) {
			List<ContentAttachment> list = c.getAttachments();
			if (list.size() > 0) {
				found=true;
			}
		}
		JSONArray arr = new JSONArray();
			JSONObject o;
			for (Content t : cList) {
				o = new JSONObject();
				o.put("id", t.getId());
				arr.put(o);
			}
			if(found){
				o = new JSONObject();
				o.put("info", "ok");
				arr.put(o);
			}else{
				o = new JSONObject();
				o.put("info", "no");
				arr.put(o);
			}
		ResponseUtils.renderText(response, arr.toString());
	}
	@RequestMapping(value = "/jrtt.jspx")
	public String sitemap( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/content/今日头条.html";
	}
	@RequestMapping(value = "/mobileview.jspx", method = RequestMethod.GET)
	public String index( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/content/手机下载.html";
	}
	@RequestMapping(value = "/midview.jspx", method = RequestMethod.GET)
	public String index1( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/content/MID下载.html";
	}
	@RequestMapping(value = "/footmsg.jspx", method = RequestMethod.GET)
	public String gonggao( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页脚公告栏.html";
	}
	@RequestMapping(value = "/footmsg.jspx", method = RequestMethod.POST)
	public String gonggao1( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return gonggao(request, response, model);
	}
	@RequestMapping(value = "/footmsg_style.jspx")
	public String gonggao_style( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页脚公告栏_withstyle.html";
	}
	
	
	@RequestMapping(value = "/foot.jspx", method = RequestMethod.GET)
	public String foot( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页脚信息栏.html";
	}
	@RequestMapping(value = "/foot.jspx", method = RequestMethod.POST)
	public String foot1( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return foot(request, response, model);
	}
	
	@RequestMapping(value = "/foot_style.jspx")
	public String foot_style( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页脚信息栏_withstyle.html";
	}
	
	@RequestMapping(value = "/top_header.jspx")
	public String header( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页头.html";
	}
	@RequestMapping(value = "/top_search.jspx")
	public String top_search( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/顶部登录搜索.html";
	}
	@RequestMapping(value = "/top_menu.jspx")
	public String top_menu( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/顶部导航菜单.html";
	}
	@RequestMapping(value = "/notice.jspx")
	public String notice( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/通知公告.html";
	}	
	@RequestMapping(value = "/buttom.jspx")
	public String buttom( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/底部网站信息.html";
	}	
	@RequestMapping(value = "/headertop_other.jspx", method = RequestMethod.GET)
	public String headertop_qt( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页头顶栏-其他.html";
	}
	@RequestMapping(value = "/headertop_other.jspx", method = RequestMethod.POST)
	public String headertop_qt1( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return headertop_qt(request, response, model);
	}
	
	@RequestMapping(value = "/wap_index.jspx")
	public String wap_index( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/wap/index.html";
	}
	@RequestMapping(value = "/wap_list.jspx")
	public String wap_list( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		String pageNo=request.getParameter("pageNo");
		int page=1;
		if(pageNo!=null)page=Integer.parseInt(pageNo);
		model.put("pageNo",page);
		model.put("cname", request.getParameter("cname"));
		model.put("cid", request.getParameter("cid"));
          return "/WEB-INF/t/cms/www/red/wap/list.html";
	}
	@RequestMapping(value = "/wap_list_gq.jspx")
	public String wap_list_gq( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		String pageNo=request.getParameter("pageNo");
		int page=1;
		if(pageNo!=null)page=Integer.parseInt(pageNo);
		model.put("pageNo",page);
		model.put("cname", request.getParameter("cname"));
		model.put("cid", request.getParameter("cid"));
          return "/WEB-INF/t/cms/www/red/wap/list_gq.html";
	}
	@RequestMapping(value = "/wap_detail.jspx")
	public String wap_detail( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		model.put("cid", request.getParameter("cid"));
		model.put("cname", request.getParameter("cname"));
		
          return "/WEB-INF/t/cms/www/red/wap/detail.html";
	}
	@RequestMapping(value = "/wap_detail_gq.jspx")
	public String wap_detail_gq( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		model.put("cid", request.getParameter("cid"));
		model.put("cname", request.getParameter("cname"));
		
          return "/WEB-INF/t/cms/www/red/wap/detail_gq.html";
	}
	@RequestMapping(value = "/headertop_other_merc.jspx", method = RequestMethod.GET)
	public String headertop_qt_merc( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页头顶栏-其他-商户.html";
	}
	@RequestMapping(value = "/headertop_other_merc.jspx", method = RequestMethod.POST)
	public String headertop_qt_merc1( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return headertop_qt_merc(request, response, model);
	}
	
	@RequestMapping(value = "/headertop_other_login.jspx", method = RequestMethod.GET)
	public String headertop_qt_logined( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页头顶栏-其他-登录后.html";
	}
	@RequestMapping(value = "/headertop_other_login.jspx", method = RequestMethod.POST)
	public String headertop_qt_logined1( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return headertop_qt_logined(request, response, model);
	}
	
	@RequestMapping(value = "/headertop_other_login_style.jspx", method = RequestMethod.GET)
	public String headertop_qt_logined_style( HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/include/页头顶栏-其他-登录后_withstyle.html";
	}
	@RequestMapping(value = "/supply_list.jspx", method = RequestMethod.GET)
	public String supply_list( HttpServletRequest request,
			HttpServletResponse response, ModelMap model,String typeid) {
		CmsSite site = CmsUtils.getSite(request);
		model.addAttribute("typeid",typeid);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/channel/供求信息二级栏目.html";
	}
	@RequestMapping(value = "/supply_view.jspx", method = RequestMethod.GET)
	public String supply_view( HttpServletRequest request,
			HttpServletResponse response, ModelMap model,String infoid) {
		CmsSite site = CmsUtils.getSite(request);
		model.addAttribute("infoid",infoid);
		FrontUtils.frontData(request, model, site);
          return "/WEB-INF/t/cms/www/red/content/供求信息二级内容.html";
	}
	@Autowired
	private ContentMng contentMng;
	@Autowired
	private ContentCountMng contentCountMng;
	@Autowired
	private PwdEncoder pwdEncoder;
	@Autowired
	private ChannelMng channelMng;
}
