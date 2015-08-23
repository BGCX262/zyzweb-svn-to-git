package com.zyz.controller;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.app.util.page.CookieUtils;
import com.web.app.util.page.Pagination;
import com.zyz.domain.Zyztbrecord;
import com.zyz.service.ZyztbrecordService;

@Controller("zyztbrecordController")
@RequestMapping("/zyztbrecord")
public class ZyztbrecordController extends BaseController{

	private static final Logger logger = Logger.getLogger(ZyztbrecordController.class);

	@Autowired
	private ZyztbrecordService zyztbrecordService;
//	@Autowired
//	private TlogerService tlogService;   


	/**
	 * 保存志愿淘宝用户购买信息信息（新增志愿淘宝用户购买信息or编辑志愿淘宝用户购买信息）
	 * @param request
	 * @param response
	 * @param zyztbrecord
	 * @return
	 */	@RequestMapping(value="/zyztbrecordSave.do")
	public String zyztbrecordSave(@RequestParam("actiontype") String actiontype,Zyztbrecord zyztbrecord,HttpServletRequest request,   
            HttpServletResponse response) throws Exception{
		try {
			if(zyztbrecord.getAmount()==null){
				zyztbrecord.setAmount(0d);
			}
			if ("edit".equals(actiontype)) {
				// 编辑
				zyztbrecordService.updateZyztbrecord(zyztbrecord);
			} 
//          else if("audit".equals(actiontype)){
//				//管理员审核
//				String isPass = request.getParameter("isPass");
//				if ("0".equals(isPass)) {
//					// 否
//					zyztbrecord.setStatus("2");//审核失败
//					zyztbrecord.setModtime(new Date());
//				} else {
//					zyztbrecord.setStatus("1");//审核通过
//					zyztbrecord.setModtime(new Date());
//				}
//				zyztbrecordService.updateZyztbrecord(zyztbrecord);
//				saveAudithis(com.web.app.util.Constants.auditType_zyztbrecord, zyztbrecord.getInfoid(), zyztbrecord.getAuditinfo(), isPass, "xx");
//				return "redirect:zyztbrecordList.do?status=0&order=desc&sort=modtime";
//			}         
         else {
//				// 新增			
//
//				zyztbrecord.setAddtime(new Date());   
        	 	zyztbrecord.setCreatedate(new Date());
        	 	if(zyztbrecord.getUnpublic()==null)
        	 		zyztbrecord.setUnpublic(0);
				zyztbrecordService.insertZyztbrecord(zyztbrecord);
//				//tlogService.insertTloger(LoggerHelper.getTloger(request, LoggerHelper.OPERATING, "新增志愿淘宝用户购买信息", "inid="+zyztbrecord.getInid()));
			}
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}
    return "info_save_ok_zyztbrecord";
     } 
     

	/**
	 * 删除志愿淘宝用户购买信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyztbrecordRemove.do")
	public String zyztbrecordRemove(@RequestParam("ids") List<String> inidList,Zyztbrecord zyztbrecord,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			zyztbrecordService.deleteZyztbrecord(inidList);
			//StringBuffer sb=new StringBuffer();
			//for(String s:inidList){
			//	sb.append(s).append("|");
			//}
			//tlogService.insertTloger(LoggerHelper.getTloger(request, LoggerHelper.OPERATING, "删除志愿淘宝用户购买信息", "inid="+sb.toString()));
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}

		return zyztbrecordList(zyztbrecord, null, null,"", "", model, request, response);
	}
   

   	/**
	 * 删除志愿淘宝用户购买信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyztbrecordRemove1.do")
	public String zyztbrecordRemove1(
			String usernmae,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("username", usernmae);
			Zyztbrecord zyztbrecord= zyztbrecordService.getZyztbrecord(param);
			List<String> inidList=new ArrayList<String>();
//			inidList.add(zyztbrecord.getInid().toString());
      
			zyztbrecordService.deleteZyztbrecord(inidList);
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}

		return "delete_ok";
	}
   

	/**
	 * 志愿淘宝用户购买信息新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zyztbrecordAdd.do")
	public String zyztbrecordAdd(Model model,HttpServletRequest request) throws Exception {
      model.addAttribute("zyztbrecord", new Zyztbrecord());
		return "zyztbrecordEdit";
        
	}

	/**
	 * 志愿淘宝用户购买信息编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zyztbrecordEdit.do")
	public String zyztbrecordEdit(@RequestParam("actiontype") String actiontype,Model model, HttpServletRequest request)
			throws Exception {
      try{
		String inid = request.getParameter("inid");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("inid", inid);
		Zyztbrecord zyztbrecord = zyztbrecordService.getZyztbrecord(param);
		model.addAttribute("zyztbrecord", zyztbrecord);
		if("view".equals(actiontype)){
			return "zyztbrecordView";
		}      
      } catch (Exception e) {
			logger.error(e);
         throw e;
		}
		return "zyztbrecordEdit";
	}

	/**
	 * 检查是否已经存在
	 * 
	 * @return
	 * @throws Exception
	 */	
	/**
	 * 志愿淘宝用户购买信息查询
	 * 
	 * @param zyztbrecord
	 * @param pageNo
	 * @param order
	 * @param sort
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyztbrecordList.do")
	public String zyztbrecordList(Zyztbrecord zyztbrecord, Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
       String isfront=request.getParameter("isfront");   
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("inid", zyztbrecord.getInid());
			param.put("itemid", zyztbrecord.getItemid());
			param.put("username", zyztbrecord.getUsername());
			param.put("type", zyztbrecord.getType());
			param.put("amount", zyztbrecord.getAmount());
			param.put("wish", zyztbrecord.getWish());
			param.put("unpublic", zyztbrecord.getUnpublic());
			param.put("createdate", zyztbrecord.getCreatedate());
			if (zyztbrecord.getItemType() != null && zyztbrecord.getItemType() != 0)
				param.put("itemType", zyztbrecord.getItemType());
			param.put("itemTitle", zyztbrecord.getItemTitle());
			// if(isfront!=null){
			// param.put("username", getUserFromSession(request).getUsername());
			// }

			if (isfront != null && isfront.equals("1")) {
				model.addAttribute("page", zyztbrecordService.getZyztbrecordList(param, 100, 1, "desc", "createdate"));
				// return "zyztbrecordList_f";
				return "fourthly/benefitList";
			} else if (isfront != null && isfront.equals("2")) {
				model.addAttribute("page", zyztbrecordService.getZyztbrecordList(param, 1000, 1, "desc", "createdate"));
				// return "zyztbrecordList_f";
				return "fourthly/projectSelect";
			} else if(isfront != null && isfront.equals("-1")){
				model.addAttribute("page", zyztbrecordService.getZyztbrecordList(param, 1000, 1, "desc", "createdate"));
				// return "zyztbrecordList_f";
				return "zyztbrecordSubPage";
			}else{
				Pagination page = zyztbrecordService.getZyztbrecordList(param, pageSize, pageNo, "desc", "createdate");

				model.addAttribute("page", page);
				return "zyztbrecordList";
			}
		} catch (Exception e) {
			logger.error(e);
         throw e;
		}
    

	}
	@RequestMapping(value = "/zyztbrecordExport.do")
	public String export(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		
		String itemid = request.getParameter("itemid");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("itemid", itemid);
		List<Zyztbrecord> list = zyztbrecordService.getZyztbrecordList(param);
		StringBuffer data = new StringBuffer(); 
		String title = "项目名称,报名者姓名,电话,身份证,邮箱,工作单位,承诺捐助\n";
		data.append(title);
		for (Zyztbrecord z : list) {
			String tempStr = z.getItemTitle()+","+z.getUsername()+","+z.getPhoneNo()+"\t,"+z.getIdcard()+"\t,"+z.geteMail()+","+z.getWorkplace()+","+z.getAmount()+"\n";
			data.append(tempStr);
		}
		response.setContentType("text/csv"); 
		   response.setCharacterEncoding("gb18030"); 
		   response 
		     .setHeader("Content-Disposition", 
		       "attachment; filename=\"" 
		         + new String("项目人员.csv".getBytes("gb18030"), 
		           "iso8859-1") + "\""); 
		   PrintWriter out = response.getWriter(); 
		   out.write(data.toString()); 
		   out.flush(); 
		   out.close(); 
		return null;
	}

	@RequestMapping(value = "/zyztbrecordQueryInit.do")
	public String queryInit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "fourthly/projectSelect";
	}
}
