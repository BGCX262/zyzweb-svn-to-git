package com.zyz.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyz.domain.Chartmgr;
import com.zyz.service.ChartmgrService;
import com.web.app.util.page.CookieUtils;
import com.web.app.util.page.Pagination;
import com.qjsc.web.domain.Qjscuser;

@Controller("chartmgrController")
@RequestMapping("/chartmgr")
public class ChartmgrController extends BaseController{

	private static final Logger logger = Logger.getLogger(ChartmgrController.class);

	@Autowired
	private ChartmgrService chartmgrService;
//	@Autowired
//	private TlogerService tlogService;   


	/**
	 * 保存图表管理信息（新增图表管理or编辑图表管理）
	 * @param request
	 * @param response
	 * @param chartmgr
	 * @return
	 */	@RequestMapping(value="/chartmgrSave.do")
	public String chartmgrSave(@RequestParam("actiontype") String actiontype,Chartmgr chartmgr,HttpServletRequest request,   
            HttpServletResponse response) throws Exception{
		try {
  			chartmgr.setModtime(new Date());
            	if (chartmgr.getUsername() == null
						|| chartmgr.getUsername().equals("")) {
					Qjscuser user = getUserFromSession(request);
					chartmgr.setUsername(user.getUsername());
				}         
			if ("edit".equals(actiontype)) {
				// 编辑
				chartmgrService.updateChartmgr(chartmgr);
			} 
          else if("audit".equals(actiontype)){
				//管理员审核
				String isPass = request.getParameter("isPass");
				if ("0".equals(isPass)) {
					// 否
					chartmgr.setStatus("2");//审核失败
					chartmgr.setModtime(new Date());
				} else {
					chartmgr.setStatus("1");//审核通过
					chartmgr.setModtime(new Date());
				}
				chartmgrService.updateChartmgr(chartmgr);
				saveAudithis(com.web.app.util.Constants.auditType_chartmgr, chartmgr.getInfoid(), chartmgr.getAuditinfo(), isPass, "xx");
				return "redirect:chartmgrList.do?status=0&order=desc&sort=modtime";
			}         
         else {
				// 新增			

				chartmgr.setAddtime(new Date());            
				chartmgrService.insertChartmgr(chartmgr);
				//tlogService.insertTloger(LoggerHelper.getTloger(request, LoggerHelper.OPERATING, "新增图表管理", "id="+chartmgr.getId()));
			}
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}
    return "info_save_ok";
     } 
     

	/**
	 * 删除图表管理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/chartmgrRemove.do")
	public String chartmgrRemove(@RequestParam("ids") List<String> idList,Chartmgr chartmgr,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			chartmgrService.deleteChartmgr(idList);
			//StringBuffer sb=new StringBuffer();
			//for(String s:idList){
			//	sb.append(s).append("|");
			//}
			//tlogService.insertTloger(LoggerHelper.getTloger(request, LoggerHelper.OPERATING, "删除图表管理", "id="+sb.toString()));
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}

		return chartmgrList(chartmgr, null, null,"", "", model, request, response);
	}
   

   	/**
	 * 删除图表管理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/chartmgrRemove1.do")
	public String chartmgrRemove1(
			String usernmae,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("username", usernmae);
			Chartmgr chartmgr= chartmgrService.getChartmgr(param);
			List<String> idList=new ArrayList<String>();
			idList.add(chartmgr.getId().toString());
      
			chartmgrService.deleteChartmgr(idList);
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}

		return "delete_ok";
	}
   

	/**
	 * 图表管理新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chartmgrAdd.do")
	public String chartmgrAdd(Model model,HttpServletRequest request) throws Exception {
      model.addAttribute("chartmgr", new Chartmgr());
		return "jsp/chartmgrAdd";
        
	}

	/**
	 * 图表管理编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chartmgrEdit.do")
	public String chartmgrEdit(@RequestParam("actiontype") String actiontype,Model model, HttpServletRequest request)
			throws Exception {
      try{
		String id = request.getParameter("id");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		Chartmgr chartmgr = chartmgrService.getChartmgr(param);
		model.addAttribute("chartmgr", chartmgr);
		if("view".equals(actiontype)){
			return "jsp/chartmgrView";
		}      
      } catch (Exception e) {
			logger.error(e);
         throw e;
		}
		return "jsp/chartmgrEdit";
	}

	/**
	 * 检查是否已经存在
	 * 
	 * @return
	 * @throws Exception
	 */	
	/**
	 * 图表管理查询
	 * 
	 * @param chartmgr
	 * @param pageNo
	 * @param order
	 * @param sort
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/chartmgrList.do")
	public String chartmgrList(Chartmgr chartmgr, Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
       String isfront=request.getParameter("isfront");   
      try {
		if(pageNo==null)pageNo=1;
		if(pageSize==null)
			pageSize = CookieUtils.getPageSize(request);
		Map<String, Object> param = new HashMap<String, Object>();
              param.put("id", chartmgr.getId());
        param.put("name", chartmgr.getName());
        param.put("url", chartmgr.getUrl());
        param.put("bz", chartmgr.getBz());
        param.put("type", chartmgr.getType());
        param.put("filed", chartmgr.getFiled());
        if(isfront!=null){
        	 param.put("username", getUserFromSession(request).getUsername());
        }
       Pagination page = chartmgrService.getChartmgrList(param, pageSize, pageNo,
				order, sort);
		model.addAttribute("page", page);
      } catch (Exception e) {
			logger.error(e);
         throw e;
		}
    if(isfront!=null)
			return "jsp/chartmgrList_f";      
		return "jsp/chartmgrList";

	}


}