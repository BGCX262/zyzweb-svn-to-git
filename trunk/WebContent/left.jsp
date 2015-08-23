<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
Object o=request.getSession().getAttribute(com.web.app.util.Constants.USER_INFO_SESSION);
if(o==null)
	response.sendRedirect(request.getContextPath()+ "/login.jsp");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>会员中心-广州清洁生产网</title>
<meta name="robots" content="noindex, nofollow" /> 
<meta name="googlebot" content="noindex, nofollow" /> 
<meta http-equiv="x-ua-compatible" content="ie=7" />
<!--[if IE 6]>
    <script type="text/javascript" src="js/fix_png.js"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('.btn,.hd h2,#search,.notice,#tools p strong,.hd strong a,a.btn-send, img, li, background,.member-l .menu ul li a');
    </script>
<![endif]-->
<link rel="stylesheet" href="/r/cms/www/red/css/style.css" type="text/css" />
</head>

 
<body>
	<%
	com.qjsc.web.domain.Qjscuser q=(com.qjsc.web.domain.Qjscuser)request.getSession().getAttribute(com.web.app.util.Constants.USER_INFO_SESSION);
	%>

<!-- 主体内容_Start -->
<div class="layout">
	<!-- 左栏菜单_Start -->
	<div class="left member-l">
    <c:if test="${sessionScope.userSessionInfo.status=='1'}">
    <div class="hd2"><h2>在线申报</h2></div>
    	<div class="box menu">
        	<ul>
            	<li><a title="委托清洁生产技术服务单位备案" href="#" class="on">委托清洁生产技术服务单位备案</a></li>
                <li><a title="自行组织清洁生产审核企业备案" href="#">自行组织清洁生产审核企业备案</a></li>
                <li><a title="企业开展清洁生产申报系统" href="#">清洁生产申报</a></li>
                <li><a title="技术服务单位申报系统" href="#">技术服务单位申报系统</a></li>
                <li><a title="重点能耗企业申报系统" href="#">重点能耗企业申报系统</a></li>
                <li><a title="清洁生产专家申报系统" href="#">清洁生产专家申报系统</a></li>
                <li><a title="清洁生产项目申报系统" href="#">清洁生产项目申报系统</a></li>
            </ul>
        </div>
       </c:if> 
        <div class="hd2"><h2>会员管理</h2></div>
    	<div class="box menu">
        	<ul>
            	<li><a title="查看资料" href="/qjscuser/qjscuserEdit.do?actiontype=view&userid=<c:out value="${sessionScope.userSessionInfo.userid}" />" target="iright">查看资料</a></li>
                <li><a title="修改资料" href="#">修改资料</a></li>
                <li><a title="修改密码" href="#">修改密码</a></li>
                <li><a title="退出登录" href="#">退出登录</a></li>
            </ul>
        </div>
    </div>
	<!-- 左栏菜单_End -->
    
    <div class="clear"></div>
</div>
<!-- 主体内容_End -->

</body>
</html>
