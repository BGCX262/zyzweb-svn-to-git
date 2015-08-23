<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>图表管理-详情</title>
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
	<div class="rpos">当前位置:  图表管理 - 详情</div>
	<form class="ropt">
		<input type="button" value="返回列表" onclick="history.back();"/>
	</form>
	<div class="clear"></div>
</div>
 
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     编号:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${chartmgr.id}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     名称:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${chartmgr.name}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     路径:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${chartmgr.url}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     备注:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${chartmgr.bz}"/>
 
     
      </td>
            </tr>   
    <tr>      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     分类:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${chartmgr.type}"/>
 
     
      </td>
               
      
		<td width="12%" class="pn-flabel pn-flabel-h">
 
     显示列:</td>
         
		<td colspan="1" width="38%" class="pn-fcontent">
 
 
 <c:out value="${chartmgr.filed}"/>
 
     
      </td>
            </tr>        
 
</table>
 
</div>
</body>
</html>