<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿淘宝--详情</title>
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
	<div class="rpos">当前位置:  志愿淘宝商品信息 - 详情</div>
	<form class="ropt">
		<input type="button" value="返回列表" onclick="history.back();"/>
	</form>
	<div class="clear"></div>
</div>
 
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     捐献对象:</td>
         
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
 
     目标金额:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.targetamount}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     截止日期:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.deadline}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     创建日期:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.createtime}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     已捐款:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.amount}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     内容:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.content}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     图片:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.image}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     爱心积分:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.score}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     类别:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.type}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     状态:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.status}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     备注:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.remark}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     置顶:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${zyztbitem.top}"/>
 
     
      </td>
                   <td width="12%" class="pn-flabel pn-flabel-h"></td>
		<td colspan="1" width="38%" class="pn-fcontent"></td>
</tr>    
 
</table>
 <form action="" method="post">
 	<input type="radio" name="type" value="0"/>实名
 	<input type="radio" name="type" value="1"/>匿名
 	<br/>
 	捐献金额:<input type="text" name="amount" />
 </form>
</div>
</body>
</html>