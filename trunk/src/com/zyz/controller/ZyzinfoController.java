package com.zyz.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.app.util.page.CookieUtils;
import com.web.app.util.page.Pagination;
import com.zyz.domain.A01;
import com.zyz.domain.C02;
import com.zyz.domain.Chartmgr;
import com.zyz.domain.D01;
import com.zyz.domain.G00;
import com.zyz.domain.TreeNode;
import com.zyz.domain.Zyzinfo;
import com.zyz.service.A01Service;
import com.zyz.service.C02Service;
import com.zyz.service.ChartmgrService;
import com.zyz.service.D01Service;
import com.zyz.service.ZyzinfoService;
import com.zyz.tools.ExcelReader;

@Controller("zyzinfoController")
@RequestMapping("/zyzinfo")
public class ZyzinfoController extends BaseController {

	private static final Logger logger = Logger
			.getLogger(ZyzinfoController.class);

	@Autowired
	private ZyzinfoService zyzinfoService;

	@Autowired
	private A01Service a01Service;

	@Autowired
	private D01Service d01Service;

	@Autowired
	private C02Service c02Service;

	@Autowired
	private ChartmgrService dhartmgrService;

	@RequestMapping(value = "/c.do")
	public String chart( HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "chart";
	}
	@RequestMapping(value = "/zyzinfoUpload.do")
	public String upload(
			String filename,
			@RequestParam(value = "uploadFile", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) throws Exception {

		try {
			String path = System.getProperty("java.io.tmpdir");
			File tempFile = new File(path, String.valueOf(System
					.currentTimeMillis()));
			file.transferTo(tempFile);
			ExcelReader readExcel = new ExcelReader(tempFile);
			readExcel.open();
			readExcel.setSheetNum(0);
			int countTmp = readExcel.getRowCount();
			for (int j = 1; j <= countTmp; j++) {
				String[] lines = readExcel.readExcelLine(j);
				if(lines.length<13){
					// 用户姓名 证件号码 手机号码 归口单位 性别 服务类别 建立时间 积分 服务时长 可服务时间 可服务时段 工作单位 专业或特长
					String error="第"+j+"行不符合要求列数(13)："+lines.length;
					model.addAttribute("error", error);
					return "info_save_error";
				}
				insertDB(lines);
			}
			return "info_save_ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	private void insertDB(String[] rows) {

		// 用户姓名 证件号码 手机号码 归口单位 性别 服务类别 建立时间 积分 服务时长 可服务时间 可服务时段 工作单位 专业或特长

		/** 用户姓名 */
		String username = rows[0];
		/** 证件号码 */
		String cardid = rows[1];
		/** 手机号码 */
		String phone = rows[2];

		if ((username == null || "".equals(username))
				|| (cardid == null || "".equals(cardid)))
			return;
        if(cardid.length()<10||!Character.isDigit(cardid.charAt(0))){
        	return;
        }
		Map<String, Object> param = new HashMap<String, Object>();
		/*
		param.put("A0184", cardid);

		List<A01> tmp = a01Service.getA01List(param);
		if (tmp.size() < 1) {
			logger.debug("--------->Cardid Not Found:" + cardid);
			if (phone != null && !"".equals(phone)) {
				param.clear();
				param.put("A0101", username);
				param.put("AT001", phone);
				tmp = a01Service.getA01List(param);
				if (tmp.size() < 1) {
					logger.debug("--------->Username and Phone Not Found:"
							+ username + "|" + phone);

				}
			}
			logger.debug("--------->Cardid:" + cardid + ",username:" + username
					+ " Not found in DW DB");
			return;
		}*/

		/** 归口单位 */
		String area = rows[3];
		/** 性别 */
		String sex = rows[4];
		/** 服务类别 */
		String servicetype = rows[5];
		/** 建立时间 */
		String createdate = rows[6];
		/** 积分 */
		String score = rows[7];
		/** 服务时长 */
		String servicetimes = rows[8];
		/** 可服务时间 */
		String workdate = rows[9];
		/** 可服务时段 */
		String worktime = rows[10];
		/** 工作单位 */
		String company = rows[11];
		/** 专业或特长 */
		String professional = rows[12];
		/** 密码 */
		String password = rows[1].substring(rows[1].length() - 6);
		Zyzinfo info = new Zyzinfo(username, cardid, phone, area, sex,
				servicetype, createdate, score, servicetimes, workdate,
				worktime, company, professional, password);

		param.put("cardid", info.getCardid());
		List<Zyzinfo> l = zyzinfoService.getZyzinfoList(param);
		if (l.size() > 0) {
			zyzinfoService.deleteZyzinfo(l.get(0).getZyzid());
		}
			zyzinfoService.insertZyzinfo(info);
	}

	/**
	 * 保存志愿者信息信息（新增志愿者信息or编辑志愿者信息）
	 * 
	 * @param request
	 * @param response
	 * @param zyzinfo
	 * @return
	 */
	@RequestMapping(value = "/zyzinfoSave.do")
	public String zyzinfoSave(@RequestParam("actiontype") String actiontype,
			Zyzinfo zyzinfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {

			if ("edit".equals(actiontype)) {
				// 编辑
				zyzinfoService.updateZyzinfo(zyzinfo);
			}

		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return "info_save_ok";
	}
	@RequestMapping(value = "/getNodes.do")
	public String getNodes(String id,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			 
			
			if(pageNo==null)pageNo=1;
			if(pageSize==null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();

			if (id==null) {
				param.put("len", 6);
				param.put("len1", 6);
			}else
			{
				param.put("len", id.length()+3);
				param.put("len1", id.length()+6);
			}

			if(id==null)id="011002";
			param.put("D0107", id+"%");
			
			List<D01>  list= d01Service.getNodes(param);
			JSONArray jarray=new JSONArray(); 
			for(D01 d:list){
				  TreeNode tnode=new TreeNode();  
	                tnode.setId(d.getD0107());  
	                tnode.setName(d.getD0101());  
	                String pid=d.getD0107().substring(0, d.getD0107().length()-3);
	                if(pid.length()==3)pid="0";
	                tnode.setpId(pid);  
	                //判断当前节点是否还有子节点  
	                if(d.getPcount()>0){  
	                    tnode.setIsParent(true);  
	                    tnode.setHasChild(true);  
	                }else{  
	                    tnode.setIsParent(false);  
	                    tnode.setHasChild(false);  
	                }
	                
	                jarray.add(tnode);
			}
			
			response.setCharacterEncoding("utf-8");  
	        PrintWriter pw = null;  
	        try {  
	            pw = response.getWriter();  
	            pw.write(jarray.toString());  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        pw.flush();  
	        pw.close();  
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	@RequestMapping(value = "/tj_dzz_tree.do")
	public String tj_dzz_tree(String root,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			boolean isRoot;
			// jquery treeview的根请求为root=source
			if (StringUtils.isBlank(root) || "source".equals(root)) {
				isRoot = true;
			} else {
				isRoot = false;
			}
			model.addAttribute("isRoot", isRoot);
			
			if(pageNo==null)pageNo=1;
			if(pageSize==null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			if (isRoot) {
				param.put("len", 6);
			}else
			{
				param.put("len", root.trim().length()+3);
			}

			List<D01>  list= d01Service.tree(param);
			model.addAttribute("list", list);
			model.addAttribute("root", root);
			return "treeTj_dzz";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	@RequestMapping(value = "/tj_dzzsub_tree.do")
	public String tj_dzzsub_tree(String root,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			boolean isRoot;
			// jquery treeview的根请求为root=source
			if (StringUtils.isBlank(root) || "source".equals(root)) {
				isRoot = true;
			} else {
				isRoot = false;
			}
			model.addAttribute("isRoot", isRoot);
			
			if(pageNo==null)pageNo=1;
			if(pageSize==null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			if (isRoot) {
				param.put("len", 6);
			}else
			{
				param.put("len", root.trim().length()+3);
			}

			List<D01>  list= d01Service.tree(param);
			model.addAttribute("list", list);
			model.addAttribute("root", root);
			return "treeTj_dzzsub";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	@RequestMapping(value = "/dzztreeDyAll.do")
	public String dzztreeDyAll(String root,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			boolean isRoot;
			// jquery treeview的根请求为root=source
			if (StringUtils.isBlank(root) || "source".equals(root)) {
				isRoot = true;
			} else {
				isRoot = false;
			}
			model.addAttribute("isRoot", isRoot);
			
			if(pageNo==null)pageNo=1;
			if(pageSize==null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			if (isRoot) {
				param.put("len", 6);
			}else
			{
				param.put("len", root.trim().length()+3);
			}

			List<D01>  list= d01Service.tree(param);
			model.addAttribute("list", list);
			model.addAttribute("root", root);
			return "treeDyAll";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	@RequestMapping(value = "/dzztreeDy.do")
	public String dzztreeDy(String root,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			boolean isRoot;
			// jquery treeview的根请求为root=source
			if (StringUtils.isBlank(root) || "source".equals(root)) {
				isRoot = true;
			} else {
				isRoot = false;
			}
			model.addAttribute("isRoot", isRoot);
			
			if(pageNo==null)pageNo=1;
			if(pageSize==null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			if (isRoot) {
				param.put("len", 6);
			}else
			{
				param.put("len", root.trim().length()+3);
			}

			List<D01>  list= d01Service.tree(param);
			model.addAttribute("list", list);
			model.addAttribute("root", root);
			return "treeDy";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	} 
	@RequestMapping(value = "/dzztreeDyNot.do")
	public String dzztreeDyNot(String root,   Integer pageNo,Integer pageSize, String order,
			String sort, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			boolean isRoot;
			// jquery treeview的根请求为root=source
			if (StringUtils.isBlank(root) || "source".equals(root)) {
				isRoot = true;
			} else {
				isRoot = false;
			}
			model.addAttribute("isRoot", isRoot);
			
			if(pageNo==null)pageNo=1;
			if(pageSize==null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			if (isRoot) {
				param.put("len", 6);
			}else
			{
				param.put("len", root.trim().length()+3);
			}

			List<D01>  list= d01Service.tree(param);
			model.addAttribute("list", list);
			model.addAttribute("root", root);
			return "treeDyNot";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	} 
	@RequestMapping(value = "/mg.do")
	public void zyzinfoMerge(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			zyzinfoService.merge();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	@RequestMapping(value = "/u.do")
	public void u(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			zyzinfoService.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	@RequestMapping(value = "/m.do")
	public void m(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String type=request.getParameter("t");
			if(type.equals("a01")){
				zyzinfoService.mergeA01();
			}else if(type.equals("c02")){
				zyzinfoService.mergeC02();
			} else if(type.equals("d01")){
				zyzinfoService.mergeD01();
			}else if(type.equals("d16")){
				zyzinfoService.mergeD16();
			}else if(type.equals("g00")){
				zyzinfoService.mergeG00();
			}else if(type.equals("uc")){
				zyzinfoService.updateCache();
			}
				 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value = "/mo.do")
	public void mo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			zyzinfoService.mergeC02();
			zyzinfoService.mergeD01();
			zyzinfoService.mergeD16();
			zyzinfoService.mergeG00();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	 

	/**
	 * 志愿者信息新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zyzinfoUploadpage.do")
	public String zyzinfoUploadpage(Model model, HttpServletRequest request)
			throws Exception {
		// model.addAttribute("zyzinfo", new Zyzinfo());
		return "zyzinfoUploadpage";

	}

	@RequestMapping(value = "/zyzinfoDwDbpage.do")
	public String zyzinfoDwDbpage(Model model, HttpServletRequest request)
			throws Exception {
		// model.addAttribute("zyzinfo", new Zyzinfo());
		return "zyzinfoDwDbpage";

	}
 
	/**
	 * 检查是否已经存在
	 * 
	 * @return
	 * @throws Exception
	 */
	/**
	 * 志愿者信息查询
	 * 
	 * @param zyzinfo
	 * @param pageNo
	 * @param order
	 * @param sort
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zyzinfoList.do")
	public String zyzinfoList(Zyzinfo zyzinfo, Integer pageNo,
			Integer pageSize, String order, String sort, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String isfront = request.getParameter("isfront");
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sorceid", zyzinfo.getZyzid());
			param.put("username", zyzinfo.getUsername());
			param.put("cardid", zyzinfo.getCardid());
			param.put("phone", zyzinfo.getPhone());
			param.put("area", zyzinfo.getArea());
			param.put("sex", zyzinfo.getSex());
			param.put("servicetype", zyzinfo.getServicetype());
			param.put("createdate", zyzinfo.getCreatedate());
			param.put("score", zyzinfo.getScore());
			param.put("servicetimes", zyzinfo.getServicetimes());
			param.put("workdate", zyzinfo.getWorkdate());
			param.put("worktime", zyzinfo.getWorktime());
			param.put("company", zyzinfo.getCompany());
			param.put("professional", zyzinfo.getProfessional());
			param.put("password", zyzinfo.getPassword());

			Pagination page = zyzinfoService.getZyzinfoList(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		if (isfront != null)
			return "zyzinfoList_f";
		return "zyzinfoList";

	}
	
	@RequestMapping(value = "/tj_dy_page.do")
	public String tj_dy_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "tj_dy";
	}
	@RequestMapping(value = "/px_dy_page.do")
	public String px_dy_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "px_dy";
	}
	@RequestMapping(value = "/px_sqz_page.do")
	public String px_sqz_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "px_sqz";
	}
	@RequestMapping(value = "/fl_dy_page.do")
	public String fl_dy_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String t=request.getParameter("t");
		if(t==null)t="";
		if("t".equals(t)){
 			model.addAttribute("t",t );
			return "flt_dy";
		}
		return "fl_dy";
	}
	@RequestMapping(value = "/fl_sqz_page.do")
	public String fl_sqz_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String t=request.getParameter("t");
		if(t==null)t="";
		if("t".equals(t)){
 			model.addAttribute("t",t );
			return "flt_sqz";
		}

		return "fl_sqz";
	}
	@RequestMapping(value = "/flt_dy_page.do")
	public String flt_dy_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "flt_dy";
	}
	@RequestMapping(value = "/flt_sqz_page.do")
	public String flt_sqz_page(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "flt_sqz";
	}

	@RequestMapping(value = "/tj_dy.do")
	public String tj_dy(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			
			setQueryMap(param,zyzinfo, a01, c02, g00,d01);
			
			Pagination page = zyzinfoService.tj_dy(param, pageSize, null,
					order, sort);
			model.addAttribute("page", page);
			if(page.getList().size()>0){
//				 DecimalFormat df=new DecimalFormat("0.000");
				 DecimalFormat df = new DecimalFormat("0.00%");
				Zyzinfo z=(Zyzinfo)page.getList().get(0);
				z.setPercent(df.format(Float.parseFloat(z.getDyrs())/Float.parseFloat(z.getRs())));
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "tj_dy";

	}

	@RequestMapping(value = "/px_dy.do")
	public String px_dy(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			
			setQueryMap(param,zyzinfo, a01, c02, g00,d01);
			
			
			if(order==null)order="desc";
			if(sort==null)sort="score";
			
			
			Pagination page = zyzinfoService.px_dy(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
			if("f".equals(request.getParameter("t"))){
				Pagination page1 = zyzinfoService.px_dy(param, pageSize, pageNo,
						"desc", "servicetimes");
				model.addAttribute("page1", page1);
				model.addAttribute("insertdate", ((Zyzinfo)page.getList().get(0)).getInsertdateStr());
			}
		 
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		if("f".equals(request.getParameter("t"))){
			Map<String, Object> param1 = new HashMap<String, Object>();
//			param1.put("", "");
			List<Chartmgr> list=			dhartmgrService.getChartmgrList(param1);
			model.addAttribute("list",list);
			return "lhb";
		}
		model.addAttribute("t", "1");
		return "px_dy";

	}
	@RequestMapping(value = "/px_sqz.do")
	public String px_sqz(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			if(order==null)order="desc";
			if(sort==null)sort="score";
			setQueryMap(param,zyzinfo, a01, c02, g00,d01);
			
			Pagination page = zyzinfoService.px_sqz(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		 
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "px_sqz";

	}

	@RequestMapping(value = "/fl_dy.do")
	public String fl_dy(Zyzinfo zyzinfo,String t, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			
			setQueryMap(param,zyzinfo, a01, c02, g00,d01);
			
			Pagination page = zyzinfoService.fl_dy(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		 
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
 		if("t".equals(t)){
 			model.addAttribute("t",t );
			return "chart_fl";
		}
		return "fl_dy";
		
	}


	@RequestMapping(value = "/fl_sqz.do")
	public String fl_sqz(Zyzinfo zyzinfo,String t, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			
			setQueryMap(param,zyzinfo, a01, c02, g00,d01);
			
			Pagination page = zyzinfoService.fl_sqz(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		 
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		if("t".equals(t)){
 			model.addAttribute("t",t );
 			rmFileNoUse(request, response);
			return "chart_fl";
		}
		model.addAttribute("t", t);
		return "fl_sqz";
		
	}
	@RequestMapping(value = "/tj_dzz.do")
	public String tj_dzz(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			
			setQueryMap(param,zyzinfo, a01, c02, g00,d01);
			if(param.get("D0107")!=null){
				param.put("D0107", param.get("D0107")+"%");
			}
			
			Pagination page = zyzinfoService.tj_dzz(param, pageSize, null,
					order, sort);
			model.addAttribute("page", page);
			if(page.getList().size()>0){
				
//				 DecimalFormat df=new DecimalFormat("0.000");
				 DecimalFormat df = new DecimalFormat("0.00%");
				Zyzinfo z=(Zyzinfo)page.getList().get(0);
				z.setCscoreavg(String.valueOf(Float.parseFloat(z.getCscore())/Float.parseFloat(z.getDyrs())));
				z.setCservicetimesavg(String.valueOf(Float.parseFloat(z.getCservicetimes())/Float.parseFloat(z.getDyrs())));
				z.setPercent(df.format(Float.parseFloat(z.getZyrs())/Float.parseFloat(z.getDyrs())));
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "tj_dzz";

	}
	@RequestMapping(value = "/tj_dzzsub.do")
	public String tj_dzzsub(Zyzinfo zyzinfo, A01 a01,C02 c02,G00 g00,D01 d01,Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();

			setQueryMap(param, zyzinfo, a01, c02, g00, d01);
			if (param.get("D0107") != null) {
				param.put("D0107", param.get("D0107") + "%");
			}
			if(request.getParameter("charttype")!=null){
				pageSize=10;	
			}

			Pagination page = zyzinfoService.tj_dzzsub(param, pageSize, null,
					order, sort);
			model.addAttribute("page", page);
		/*	if (page.getList().size() > 0) {
				for (Zyzinfo z : ((List<Zyzinfo>) page.getList())) {

					// DecimalFormat df=new DecimalFormat("0.000");
					DecimalFormat df = new DecimalFormat("0.00%");
					z.setCscoreavg(String.valueOf(Float.parseFloat(z
							.getCscore()) / Float.parseFloat(z.getDyrs())));
					z.setCservicetimesavg(String.valueOf(Float.parseFloat(z
							.getCservicetimes())
							/ Float.parseFloat(z.getDyrs())));
					z.setPercent(df.format(Float.parseFloat(z.getZyrs())
							/ Float.parseFloat(z.getDyrs())));
				}
			}*/

			model.addAttribute("t", "1");
			if (request.getParameter("charttype") != null
					&& !"".equals(request.getParameter("charttype"))) {
				rmFileNoUse(request, response);
				return "chart_dzz";
			}
			if (request.getParameter("charttype1") != null
					&& !"".equals(request.getParameter("charttype1"))) {
				// 数据库保存的url中包含前台显示的列
				String f1 = request.getParameter("f1");
				String f2 = request.getParameter("f2");
				String f3 = request.getParameter("f3");
				List<List<String>> list=new ArrayList<List<String>>();
				model.addAttribute("list", list);
				if (page.getList().size() > 0) {
					for (Zyzinfo z : ((List<Zyzinfo>) page.getList())) {
						String v1=getValue(z, f1);
						if(f1.equals("subdzz")){
							v1=zyzinfo.getD01_dzz_Dict().get(v1);
						}
						String v2=getValue(z, f2);
						List<String> l=new ArrayList<String>();
						l.add(v1);
						l.add(v2);
						list.add(l);
					}
					
				}
				return "lhb1";
			}
			return "tj_dzzsub";
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	@RequestMapping(value = "/queryDzzDy.do")
	public String queryDzzDy(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			String zzcode_like = zzcode;
			if (zzcode != null && !"".equals(zzcode.trim()))
				zzcode_like =  zzcode + "%";
			param.put("zzcode", zzcode_like);
			
			Pagination page = zyzinfoService.queryDzzDy(param, pageSize, null,
					order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "dzztj";

	}


	@RequestMapping(value = "/queryDzzDyNot.do")
	public String queryDzzDyNot(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode,String dytype, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			String zzcode_like = zzcode;
			if (zzcode != null && !"".equals(zzcode.trim()))
				zzcode_like =  zzcode + "%";
			param.put("zzcode", zzcode_like);
			param.put("dytype", dytype);
			Pagination page = zyzinfoService.queryDzzDyNot(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "2");
		return "dzztj";

	}
	
	@RequestMapping(value = "/queryDzzDyAll.do")
	public String queryDzzDyAll(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc,String zzcode, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			String zzcode_like = zzcode;
			if (zzcode != null && !"".equals(zzcode.trim()))
				zzcode_like =  zzcode + "%";
			param.put("zzcode", zzcode_like);
			
			Pagination page = zyzinfoService.queryDzzDyAll(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "dzztj";

	}
	


	@RequestMapping(value = "/queryZyzDy.do")
	public String queryZyzDy(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String username,  
			  String zzmc, String zzid, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();

			String username_like = username;
			if (username != null && !"".equals(username.trim()))
				username_like = "%" + username + "%";
			param.put("username", username_like);
 

			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			param.put("zzid", zzid);
			Pagination page = zyzinfoService.queryZyzDy(param, pageSize, null,
					order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "3");
		return "zyztj";

	}
	@RequestMapping(value = "/queryZyzDyNot.do")
	public String queryZyzDyNot(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String username,  
			  String zzmc, String zzid, String dytype,Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();

			String username_like = username;
			if (username != null && !"".equals(username.trim()))
				username_like = "%" + username + "%";
			param.put("username", username_like);
 

			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			param.put("zzid", zzid);
			param.put("dytype", dytype);
			Pagination page = zyzinfoService.queryZyzDyNot(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "2");
		return "zyztj";

	}
	
	@RequestMapping(value = "/queryZyzDyAll.do")
	public String queryZyzDyAll(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String username,  
			  String zzmc, String zzid, String dytype,Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();

			String username_like = username;
			if (username != null && !"".equals(username.trim()))
				username_like = "%" + username + "%";
			param.put("username", username_like);
 

			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			param.put("zzid", zzid);
			param.put("dytype", dytype);
			Pagination page = zyzinfoService.queryZyzDyAll(param, pageSize, pageNo,
					order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		
		return "zyztj";

	}
	
	@RequestMapping(value = "/queryDzzRsDy.do")
	public String queryDzzRsDy(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);

			Pagination page = zyzinfoService.queryDzzRsDy(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "3");
		return "dzztj_rs";

	}
	@RequestMapping(value = "/queryDzzRsDyNot.do")
	public String queryDzzRsDyNot(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc, Model model,String dytype,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);
			param.put("dytype", dytype);
			Pagination page = zyzinfoService.queryDzzRsDyNot(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "2");
		return "dzztj_rs";

	}
	
	@RequestMapping(value = "/queryDzzRsDyAll.do")
	public String queryDzzRsDyAll(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc, Model model,String dytype,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String zzmc_like = zzmc;
			if (zzmc != null && !"".equals(zzmc.trim()))
				zzmc_like = "%" + zzmc + "%";
			param.put("zzmc", zzmc_like);
			param.put("dytype", dytype);
			Pagination page = zyzinfoService.queryDzzRsDyAll(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "dzztj_rs";

	}
	
	@RequestMapping(value = "/queryZyzNlDy.do")
	public String queryZyzNlDy(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc, Model model,String dytype,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
	 
			Pagination page = zyzinfoService.queryZyzNlDy(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "3");
		return "nl_rs";

	}
	@RequestMapping(value = "/queryZyzNlDyNot.do")
	public String queryZyzNlDyNot(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc, Model model,String dytype,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
	 
			Pagination page = zyzinfoService.queryZyzNlDyNot(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "2");
		return "nl_rs";

	}
	
	@RequestMapping(value = "/queryZyzNlDyAll.do")
	public String queryZyzNlDyAll(Zyzinfo zyzinfo, Integer pageNo, Integer pageSize,
			String order, String sort, String zzmc, Model model,String dytype,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			if (pageNo == null)
				pageNo = 1;
			if (pageSize == null)
				pageSize = CookieUtils.getPageSize(request);
			Map<String, Object> param = new HashMap<String, Object>();
	 
			Pagination page = zyzinfoService.queryZyzNlDyAll(param, pageSize,
					pageNo, order, sort);
			model.addAttribute("page", page);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		model.addAttribute("t", "1");
		return "nl_rs";

	}
	
	private void setQueryMap(Map<String, Object> param,Zyzinfo zyzinfo,A01 a01,C02 c02,G00 g00,D01 d01){
		param.put("sorceid", zyzinfo.getZyzid());
		param.put("username", zyzinfo.getUsername());
		param.put("cardid", zyzinfo.getCardid());
		param.put("phone", zyzinfo.getPhone());
		param.put("area", zyzinfo.getArea());
		param.put("sex", zyzinfo.getSex());
		param.put("servicetype", zyzinfo.getServicetype());
        if(zyzinfo.getServicetype()!=null&&!"".equals(zyzinfo.getServicetype()))
        	param.put("servicetype", "%"+zyzinfo.getServicetype()+"%");
		param.put("createdate", zyzinfo.getCreatedate());
		param.put("score", zyzinfo.getScore());
		param.put("servicetimes", zyzinfo.getServicetimes());
		param.put("workdate", zyzinfo.getWorkdate());
		param.put("worktime", zyzinfo.getWorktime());
		param.put("company", zyzinfo.getCompany());
		param.put("professional", zyzinfo.getProfessional());
		param.put("password", zyzinfo.getPassword());
		param.put("flid", zyzinfo.getFlid());
		param.put("nl", zyzinfo.getNl());
		
		param.put("score1", zyzinfo.getScore1());
		param.put("score2", zyzinfo.getScore2());
		param.put("servicetimes1", zyzinfo.getServicetimes1());
		param.put("servicetimes2", zyzinfo.getServicetimes2());
		
		param.put("D0107", d01.getD0107());
		if(d01.getD0107()!=null&&!"".equals(d01.getD0107()))
		param.put("D0107Len_3", d01.getD0107().length()+3);
		
		  param.put("A0100", a01.getA0100());
	        param.put("A0102", a01.getA0102());
	        param.put("A0103", a01.getA0103());
	        param.put("A0105", a01.getA0105());
	        param.put("A0106", a01.getA0106());
	        param.put("A0108", a01.getA0108());
	        param.put("A0109", a01.getA0109());
	        param.put("A0110", a01.getA0110());
	        param.put("A0112", a01.getA0112());
	        param.put("A0113", a01.getA0113());
	        param.put("A0114", a01.getA0114());
	        param.put("A0115", a01.getA0115());
	        param.put("A0101", a01.getA0101());
	        param.put("A0116", a01.getA0116());
	        param.put("A0118", a01.getA0118());
	        param.put("A0104", a01.getA0104());
	        param.put("A0119", a01.getA0119());
	        param.put("A0120", a01.getA0120());
	        param.put("A0107", a01.getA0107());
	        param.put("A0121", a01.getA0121());
	        param.put("A0122", a01.getA0122());
	        param.put("A0123", a01.getA0123());
	        param.put("A0111", a01.getA0111());
	        if(a01.getA0111()!=null&&!"".equals(a01.getA0111()))
	        	param.put("A0111", "%"+a01.getA0111()+"%");
	        param.put("A0124", a01.getA0124());
	        param.put("A0125", a01.getA0125());
	        param.put("A0127", a01.getA0127());
	        param.put("A0131", a01.getA0131());
	        param.put("A0133", a01.getA0133());
	        param.put("A0117", a01.getA0117());
	        param.put("A0134", a01.getA0134());
	        param.put("A0136", a01.getA0136());
	        param.put("A0144", a01.getA0144());
	        param.put("A0152", a01.getA0152());
	        param.put("A0171", a01.getA0171());
	        param.put("A0174", a01.getA0174());
	        if(a01.getA0174()!=null&&!"".equals(a01.getA0174()))
	    	param.put("A0174", a01.getA0174()+"%");
	        param.put("A0175", a01.getA0175());
	        param.put("A0176", a01.getA0176());
	        param.put("A0177", a01.getA0177());
	        param.put("A0178", a01.getA0178());
	        param.put("A0181", a01.getA0181());
	        param.put("A0187", a01.getA0187());
	        param.put("A0135", a01.getA0135());
	        if(a01.getA0135()!=null&&!"".equals(a01.getA0135()))
	        	param.put("A0135", "%"+a01.getA0135()+"%");
	        param.put("A0189", a01.getA0189());
	        param.put("A01A1", a01.getA01A1());
	        param.put("A0151", a01.getA0151());
	        if(a01.getA0151()!=null&&!"".equals(a01.getA0151()))
	        	param.put("A0151", a01.getA0151()+"%");
	        param.put("A01A2", a01.getA01A2());
	        param.put("A0215", a01.getA0215());
	        param.put("A0221", a01.getA0221());
	        param.put("A0302", a01.getA0302());
	        param.put("A0802", a01.getA0802());
	        param.put("A0803", a01.getA0803());
	        param.put("A0805", a01.getA0805());
	        param.put("A0807", a01.getA0807());
	        param.put("A0184", a01.getA0184());
	        param.put("A0808", a01.getA0808());
	        param.put("A0814", a01.getA0814());
	        param.put("A0816", a01.getA0816());
	        param.put("A0901", a01.getA0901());
	        param.put("AT001", a01.getAT001());
	        param.put("D0100", a01.getD0100());
	        param.put("F_UPDATE", a01.getF_UPDATE());
	        param.put("A0801", a01.getA0801());
	        
	        param.put("nl_start", a01.getNl_start());
	        param.put("nl_end", a01.getNl_end());
	        param.put("A01071", a01.getA01071());
	        param.put("A01072", a01.getA01072());
	        
	        
	        
	        param.put("G0000", g00.getG0000());
	        param.put("G0001", g00.getG0001());
	        param.put("G0002", g00.getG0002());
	        param.put("G0003", g00.getG0003());
	        param.put("G0004", g00.getG0004());
	        
	        param.put("G00041", g00.getG00041());
	        param.put("G00042", g00.getG00042());
	        param.put("G00091", g00.getG00091());
	        param.put("G00092", g00.getG00092());
	        param.put("G00101", g00.getG00101());
	        param.put("G00102", g00.getG00102());
	        param.put("G00131", g00.getG00131());
	        param.put("G00132", g00.getG00132());
	        	        
	        
	        
	        
	        param.put("G0005", g00.getG0005());
	        param.put("G0006", g00.getG0006());
	        param.put("G0007", g00.getG0007());
	        param.put("G0008", g00.getG0008());
	        param.put("G0009", g00.getG0009());
	        param.put("G0010", g00.getG0010());
	        param.put("G0011", g00.getG0011());
	        param.put("G0012", g00.getG0012());
	        param.put("G0013", g00.getG0013());
	        param.put("G0014", g00.getG0014());
	        param.put("G0015", g00.getG0015());
	        param.put("G0016", g00.getG0016());
	        param.put("G0023", g00.getG0023());
	        
	        param.put("C0201", c02.getC0201());
	        param.put("C0202", c02.getC0202());
	        param.put("C0203", c02.getC0203());
	        
	        param.put("C02031", c02.getC02031());
	        param.put("C02032", c02.getC02032());
	        
	        param.put("C0204", c02.getC0204());
	        param.put("C0205", c02.getC0205());
	        param.put("C0206", c02.getC0206());
	        param.put("C0207", c02.getC0207());
	        param.put("C0208", c02.getC0208());
	        param.put("C0209", c02.getC0209());
	        param.put("C0211", c02.getC0211());
	        param.put("C0212", c02.getC0212());
	        param.put("C0213", c02.getC0213());
	        param.put("C0214", c02.getC0214());
	        param.put("C0215", c02.getC0215());
	        param.put("C0216", c02.getC0216());
	        param.put("C0217", c02.getC0217());
	        param.put("C0219", c02.getC0219());
	}
	
	  
	
    public static String getValue(  Object obj,String filed){
        Class<?> objClass = obj.getClass();
        try {
                String getMethodName = "get"+toFirstLetterUpperCase(filed);
                try{
                	Object value = objClass.getMethod(getMethodName).invoke(obj);
                	return value.toString();
                }catch(Exception e){
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
        
    }
    public static String toFirstLetterUpperCase(String str) {
    	if(str == null || str.length() < 2){
    		return str;
    	}
        String firstLetter = str.substring(0, 1).toUpperCase();
        return firstLetter + str.substring(1, str.length());
    }

	public void rmFileNoUse(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path=request.getRealPath("u/chart");
		File fs=new File(path);
	 File files[]=	fs.listFiles();
		List<Chartmgr> list=dhartmgrService.getChartmgrList(new HashMap<String, Object>());
		List<String> fileNames=new ArrayList<String>();
		for(Chartmgr c:list){
			if(c.getType().equals("0"))
			fileNames.add(c.getUrl().substring(c.getUrl().lastIndexOf("/")+1));
		}
		for(File f:files){
		 if(!fileNames.contains(f.getName())){
			 f.delete();
		 }
		}
	}
}