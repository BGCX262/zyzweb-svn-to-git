<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿ATM项目用户管理-详情</title>
<link href="<%=request.getContextPath()%>/res/mycms/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>
 
<script src="<%=request.getContextPath()%>/thirdparty/fckeditor/fckeditor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/js/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/js/pony.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/mycms/js/admin.js" type="text/javascript"></script>
 
</script>

</head>
<body>
<div class="body-box">
<div class="rhead">
	<div class="rpos">当前位置:  志愿ATM项目用户管理 - 详情</div>
	<form class="ropt">
		<input type="button" value="返回列表" onclick="history.back();"/>
	</form>
	<div class="clear"></div>
</div>
 
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">
    <%-- <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     inid:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.inid}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     itemid:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.itemid}"/>
 
     
      </td>
            </tr>  --%>  
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     用户名:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.username}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     类型:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:choose>
    <c:when test="${zyztbrecord.type==0}">
      <c:out value="匿名"/>
    </c:when>
    <c:when test="${zyztbrecord.type==1}">
      <c:out value="实名"/>
    </c:when>  
  </c:choose>
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     金额/人数:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 

 <c:out value="${zyztbrecord.amount}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     祝福:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.wish}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     不公开捐助金额:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
  <c:choose>
    <c:when test="${zyztbrecord.unpublic==0}">
      <c:out value="公开"/>
    </c:when>
    <c:when test="${zyztbrecord.unpublic==1}">
      <c:out value="不公开"/>
    </c:when>  
  </c:choose>
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     捐助日期:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.createdateStr}"/>
 
     
      </td>
            </tr>        
 <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     手机号码:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.phoneNo}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     查询密码:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.pwd}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     身份证号:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.idcard}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     E-mail:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.eMail}"/>
 
     
      </td>
            </tr> 
            <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     工作单位:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbrecord.workplace}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
   </td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 
     
      </td>
            </tr>
</table>
 
</div>
</body>
</html>