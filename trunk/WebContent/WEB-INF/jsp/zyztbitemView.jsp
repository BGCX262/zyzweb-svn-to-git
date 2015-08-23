<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿ATM项目信息管理-详情</title>
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
	<div class="rpos">当前位置:  志愿ATM项目信息管理 - 详情</div>
	<form class="ropt">
		<input type="button" value="导出项目记录" onclick="location.href='/zyztbrecord/zyztbrecordExport.do?itemid=${zyztbitem.itemid}';"/>
	</form>
	<div class="clear"></div>
</div>
 
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     捐助对象/服务对象:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.targetname}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     标题:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.title}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     目标金额/招募人数:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
   <c:if test="${zyztbitem.type==2 }"><c:out value="${zyztbitem.targetamount}"/>元</c:if>
 <c:if test="${zyztbitem.type==1 }"><fmt:formatNumber value="${zyztbitem.targetamount}" pattern="#"/>人</c:if>
 <c:if test="${zyztbitem.type==3 }"><fmt:formatNumber value="${zyztbitem.targetamount}" pattern="#"/></c:if>
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     截止日期:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.deadlineStr}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     创建日期:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.createtimeStr}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     已捐款/已召集:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
  <c:if test="${zyztbitem.type==2 }"><c:out value="${zyztbitem.amount}"/>元</c:if>
 <c:if test="${zyztbitem.type==1 }"><fmt:formatNumber value="${zyztbitem.amount}" pattern="#"/>人</c:if>
 <c:if test="${zyztbitem.type==3 }"><fmt:formatNumber value="${zyztbitem.amount}" pattern="#"/></c:if>
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     内容:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 ${zyztbitem.content}
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     图片:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 <img src="<c:out value="${zyztbitem.image}"/>" alt="" width="200" height="180"/>
 
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     爱心积分:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.score}"/>
 
     
      </td>
               
      
      <td width="12%" class="pn-flabel pn-flabel-h">
 
     置顶:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
  <c:choose>
    <c:when test="${zyztbitem.top==0}">
      <c:out value="否"/>
    </c:when>
    <c:when test="${zyztbitem.top==1}">
      <c:out value="是"/>
    </c:when>  
  </c:choose>
     
      </td>
      
      
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     状态:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:choose>
    <c:when test="${zyztbitem.status==2}">
      <c:out value="结束"/>
    </c:when>
    <c:when test="${zyztbitem.status==1}">
      <c:out value="可用"/>
    </c:when>  
   <c:otherwise>  
      <c:out value="过期"/>
   </c:otherwise>
  </c:choose>
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     备注:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.remark}"/>
 
     
      </td>
            </tr>   
            <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     项目类别:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:choose>
    <c:when test="${zyztbitem.type==2}">
      <c:out value="捐助项目"/>
    </c:when>
    <c:when test="${zyztbitem.type==1}">
      <c:out value="服务项目"/>
    </c:when>  
  	<c:when test="${zyztbitem.type==3}">
      <c:out value="需求心愿"/>
    </c:when> 
  </c:choose>
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     </td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
     
      </td>
            </tr>  
 
</table>
 <table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead"><tr>
	 <th width="80">手机号码</th>
	<th width="80">姓名</th>
	<th width="120">身份证号码</th>
	<th>工作单位</th>
   	 <th width="80">金额/人数</th>
   	 <th width="150">捐助/报名日期</th>
   	 </tr></thead>
<tbody  class="pn-ltbody">
<c:forEach items="${recordPage.list}" var="row">   
<tr>
  <td><c:out value="${row.phoneNo}"/></td>
  <td><c:out value="${row.username}"/></td>
  <td><c:out value="${row.idcard}"/></td>
  <td><c:out value="${row.workplace}"/></td>
 
 <td>
  <c:if test="${row.itemType==1 || row.itemType == 3}">
 <fmt:formatNumber value="${row.amount}" pattern="#"/>
 </c:if>
 <c:if test="${row.itemType==2 }">
 ${row.amount}
 </c:if>
 </td>
  <td><c:out value="${row.createdateStr}"/></td>
</tr>
</c:forEach>  
</tbody>
</table>
</div>
</body>
</html>