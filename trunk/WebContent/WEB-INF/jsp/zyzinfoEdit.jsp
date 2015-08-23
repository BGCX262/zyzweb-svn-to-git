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
	<form class="ropt">
		<input type="button" value="返回列表" onclick="history.back();"/>
	</form>
	<div class="clear"></div>
</div>
<form method="post" action="zyzinfoSave.do" id="jvForm">
<input type="hidden" name="actiontype" value="<%=request.getParameter("actiontype") %>" />
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">

   <input type="hidden" name="zyzid" id="zyzid" value="<c:out value="${zyzinfo.zyzid}"/>"/>
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     用户姓名:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="username"  id="username" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.username}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     证件号码:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="cardid"  id="cardid" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.cardid}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     手机号码:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="phone"  id="phone" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.phone}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     归口单位:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="area"  id="area" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.area}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     性别:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="sex"  id="sex" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.sex}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     服务类别:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="servicetype"  id="servicetype" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.servicetype}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     建立时间:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="createdate"  id="createdate" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.createdate}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     积分:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="score"  id="score" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.score}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     服务时长:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="servicetimes"  id="servicetimes" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.servicetimes}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     可服务时间:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="workdate"  id="workdate" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.workdate}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     可服务时段:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="worktime"  id="worktime" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.worktime}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     工作单位:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="company"  id="company" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.company}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     专业或特长:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="professional"  id="professional" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.professional}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     密码:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="password"  id="password" maxlength="100" size="24"
 class="" value="<c:out value="${zyzinfo.password}"/>" /></td>
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