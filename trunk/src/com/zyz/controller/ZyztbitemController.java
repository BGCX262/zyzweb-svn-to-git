package com.zyz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.app.util.page.CookieUtils;
import com.web.app.util.page.Pagination;
import com.zyz.domain.Zyztbitem;
import com.zyz.service.ZyztbitemService;
import com.zyz.service.ZyztbrecordService;

@Controller("zyztbitemController")
@RequestMapping("/zyztbitem")
public class ZyztbitemController extends BaseController {

	private static final Logger logger = Logger.getLogger(ZyztbitemController.class);
	// 状态:可用:1/不可用:0
	private static final int STATUS_ENABLE = 1;
	private static final int STATUS_DISABLE = 2;

	@Autowired
	private ZyztbitemService zyztbitemService;
	@Autowired
	private ZyztbrecordService zyztbrecordService;

	/**
	 * 保存志愿淘宝商品信息信息（新增志愿淘宝商品信息or编辑志愿淘宝商品信息）
	 * 
	 * @param request
	 * @param response
	 * @param zyztbitem
	 * @return
	 */
	@RequestMapping(value = "/zyztbitemSave.do")
	public String zyztbitemSave(@RequestParam("actiontype") String actiontype, Zyztbitem zyztbitem, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			if ("edit".equals(actiontype)) {
				// 编辑
				zyztbitemService.updateZyztbitem(zyztbitem);
			} else {
				// 新增
				zyztbitem.setCreatetime(new Date());
				zyztbitem.setStatus(this.STATUS_ENABLE);
				zyztbitem.setAmount(0d);
				// zyztbitem.setAddtime(new Date());
				zyztbitemService.insertZyztbitem(zyztbitem);
				// tlogService.insertTloger(LoggerHelper.getTloger(request,
				// LoggerHelper.OPERATING, "新增志愿淘宝商品信息",
				// "itemid="+zyztbitem.getItemid()));
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return "info_save_ok";
	}

	/**
	 * 删除志愿淘宝商品信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyztbitemRemove.do")
	public String zyztbitemRemove(@RequestParam("ids") List<String> itemidList, Zyztbitem zyztbitem, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			zyztbitemService.deleteZyztbitem(itemidList);
			// StringBuffer sb=new StringBuffer();
			// for(String s:itemidList){
			// sb.append(s).append("|");
			// }
			// tlogService.insertTloger(LoggerHelper.getTloger(request,
			// LoggerHelper.OPERATING, "删除志愿淘宝商品信息", "itemid="+sb.toString()));
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}

		return zyztbitemList(zyztbitem, null, null, "", "", model, request, response);
	}

	/**
	 * 删除志愿淘宝商品信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyztbitemRemove1.do")
	public String zyztbitemRemove1(String usernmae, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("username", usernmae);
			Zyztbitem zyztbitem = zyztbitemService.getZyztbitem(param);
			List<String> itemidList = new ArrayList<String>();
			// itemidList.add(zyztbitem.getItemid().toString());

			zyztbitemService.deleteZyztbitem(itemidList);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}

		return "delete_ok";
	}

	/**
	 * 志愿淘宝商品信息新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zyztbitemAdd.do")
	public String zyztbitemAdd(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("zyztbitem", new Zyztbitem());
		return "zyztbitemEdit";

	}

	/**
	 * 志愿淘宝商品信息编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zyztbitemEdit.do")
	public String zyztbitemEdit(@RequestParam("actiontype") String actiontype, Model model, HttpServletRequest request) throws Exception {
		try {
			String itemid = request.getParameter("itemid");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("itemid", itemid);
			Zyztbitem zyztbitem = zyztbitemService.getZyztbitem(param);
			model.addAttribute("zyztbitem", zyztbitem);
			model.addAttribute("actiontype", actiontype);
			if ("view".equals(actiontype)) {
				model.addAttribute("recordPage", zyztbrecordService.getZyztbrecordList(param, 1000, 1, "desc", "createtime"));
				return "zyztbitemView";
			}
			if ("view_f".equals(actiontype)) {
				return "fourthly/particular";
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return "zyztbitemEdit";
	}

	/**
	 * 检查是否已经存在
	 * 
	 * @return
	 * @throws Exception
	 */
	/**
	 * 志愿淘宝商品信息查询
	 * 
	 * @param zyztbitem
	 * @param pageNo
	 * @param order
	 * @param sort
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyztbitemList.do")
	public String zyztbitemList(Zyztbitem zyztbitem, Integer pageNo, Integer pageSize, String order, String sort, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String isfront = request.getParameter("isfront");
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("itemid", zyztbitem.getItemid());
			param.put("targetname", zyztbitem.getTargetname());
			param.put("title", zyztbitem.getTitle());
			param.put("targetamount", zyztbitem.getTargetamount());
			param.put("deadline", zyztbitem.getDeadline());
			param.put("createtime", zyztbitem.getCreatetime());
			param.put("amount", zyztbitem.getAmount());
			param.put("content", zyztbitem.getContent());
			param.put("image", zyztbitem.getImage());
			param.put("score", zyztbitem.getScore());
			param.put("type", zyztbitem.getType());
			param.put("status", zyztbitem.getStatus());
			param.put("remark", zyztbitem.getRemark());
			// if(isfront!=null){
			// param.put("username", getUserFromSession(request).getUsername());
			// }
			Pagination page = zyztbitemService.getZyztbitemList(param, pageSize, pageNo, "desc", "createtime");
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		if (isfront != null)
			return "zyztbitemList_f";
		return "zyztbitemList";

	}

	// 志愿淘宝首页
	@RequestMapping(value = "/zyztbitemIndex.do")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Zyztbitem zyztbitem = new Zyztbitem();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			// get top 10 enable item
			param.put("status", this.STATUS_ENABLE);
			model.addAttribute("enablePage", zyztbitemService.getZyztbitemList(param, 10, 1, "desc", "createtime"));
			// get top 10 disable item
			Map<String, Object> param2 = new HashMap<String, Object>();
			param2.put("status", this.STATUS_DISABLE);
			model.addAttribute("disablePage", zyztbitemService.getZyztbitemList(param2, 10, 1, "desc", "createtime"));
			// get top 5 recommendation item
			param = new HashMap<String, Object>();
			param.put("status", this.STATUS_ENABLE);
			param.put("top", 1);
			model.addAttribute("recommendPage", zyztbitemService.getZyztbitemList(param, 5, 1, "desc", "createtime"));
			// get history sum
			model.addAttribute("historySum", zyztbitemService.getHistoryTotalAmount());
			// get thismonth sum
			model.addAttribute("monthSum", zyztbitemService.getMonthAmount());
			// get peopleCount
			model.addAttribute("peopleCount", zyztbitemService.getPeopleCount());
			// get done total
			param.clear();
			param.put("status", this.STATUS_DISABLE);
			model.addAttribute("doneCount", zyztbitemService.getTotal(param));
			param.clear();
			model.addAttribute("recordPage", zyztbrecordService.getZyztbrecordList(param, 20, 1, "desc", "createdate"));
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return "fourthly/index";
	}

	@RequestMapping(value = "/zyztbitemList_f.do")
	public String zyztbitemList_f(Zyztbitem zyztbitem, Integer pageNo, Integer pageSize, String order, String sort, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("itemid", zyztbitem.getItemid());
			param.put("targetname", zyztbitem.getTargetname());
			param.put("title", zyztbitem.getTitle());
			param.put("targetamount", zyztbitem.getTargetamount());
			param.put("deadline", zyztbitem.getDeadline());
			param.put("createtime", zyztbitem.getCreatetime());
			param.put("amount", zyztbitem.getAmount());
			param.put("content", zyztbitem.getContent());
			param.put("image", zyztbitem.getImage());
			param.put("score", zyztbitem.getScore());
			param.put("type", zyztbitem.getType());
			param.put("status", zyztbitem.getStatus());
			param.put("remark", zyztbitem.getRemark());
			// if(isfront!=null){
			// param.put("username", getUserFromSession(request).getUsername());
			// }
			Pagination page = zyztbitemService.getZyztbitemList(param, pageSize, pageNo, "desc", "createtime");
			model.addAttribute("page", page);
			if (zyztbitem.getStatus() == null)
				model.addAttribute("status", 0);
			else
				model.addAttribute("status", zyztbitem.getStatus());
			if (zyztbitem.getType() == null)
				model.addAttribute("type", 0);
			else
				model.addAttribute("type", zyztbitem.getType());
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return "fourthly/allProjectList";

	}

	@RequestMapping(value = "/zyztbitemListNew.do")
	public String zyztbitemListNew(Zyztbitem zyztbitem, Integer pageNo, Integer pageSize, String order, String sort, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String isfront = request.getParameter("isfront");
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Pagination page = zyztbitemService.getZyztbitemList(new HashMap<String, Object>(), pageSize, pageNo, "desc", "createtime");
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return "zyztbitemListNew";
	}
}