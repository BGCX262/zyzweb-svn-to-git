<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿者信息-编辑</title>
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
 
<script type="text/javascript"> 
$(function() {
	$("#jvForm").validate();
});

</script>

</head>
<body>
<div class="body-box">
<div class="rhead">
	<div class="rpos">当前位置:  志愿者信息 - 编辑</div>
	 
	<div class="clear"></div>
</div>
<form method="post" action="zyzinfoUpload.do" enctype="multipart/form-data" id="jvForm">
<input type="hidden" name="actiontype" value="<%=request.getParameter("actiontype") %>" />
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">
    
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     文件:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> 
<input type="file" name="uploadFile" id="uploadFile" />
</td>
       </tr>        
	<tr>
		<td colspan="2" class="pn-fbutton"> &nbsp; <input onclick="showLoad()" type="submit" value="导入" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>