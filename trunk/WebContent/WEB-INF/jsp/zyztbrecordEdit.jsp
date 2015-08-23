<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿淘宝用户购买信息-编辑</title>
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
	<div class="rpos">当前位置:  志愿淘宝用户购买信息 - 编辑</div>
	<form class="ropt">
		<input type="button" value="返回列表" onclick="history.back();"/>
	</form>
	<div class="clear"></div>
</div>
<form method="post" action="zyztbrecordSave.do" id="jvForm">
<input type="hidden" name="actiontype" value="<%=request.getParameter("actiontype") %>" />
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">

   <input type="hidden" name="inid" id="inid" value="<c:out value="${zyztbrecord.inid}"/>"/>
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     用户名:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="username"  id="username" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbrecord.username}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     类型(实名,匿名):
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="type"  id="type" maxlength="100" size="24"
 class="digits" value="<c:out value="${zyztbrecord.type}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     金额:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="amount"  id="amount" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbrecord.amount}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     祝福:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="wish"  id="wish" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbrecord.wish}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     不公开捐献金额:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="unpublic"  id="unpublic" maxlength="100" size="24"
 class="digits" value="<c:out value="${zyztbrecord.unpublic}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     捐献日期:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="createdate"  id="createdate" maxlength="100" size="24"
 class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<c:out value="${zyztbrecord.createdate}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     手机号码:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="phoneNo"  id="phoneNo" maxlength="100" size="24"
 class="digits" value="<c:out value="${zyztbrecord.phoneNo}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     查询密码:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="pwd"  id="pwd" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbrecord.pwd}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     身份证号:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="idcard"  id="idcard" maxlength="100" size="24"
 class="digits" value="<c:out value="${zyztbrecord.idcard}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     E-mail:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="eMail"  id="eMail" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbrecord.eMail}"/>" /></td>
       </tr> 
       <tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     工作地址:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="workplace"  id="workplace" maxlength="254" size="50"
 class="" value="<c:out value="${zyztbrecord.workplace}"/>" /></td>
       </tr>
	<tr>
		<td colspan="2" class="pn-fbutton"><input type="submit"  
			value="提交" /> &nbsp; <input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>