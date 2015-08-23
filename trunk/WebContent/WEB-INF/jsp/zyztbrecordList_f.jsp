<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿淘宝用户购买信息-列表</title>
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
function getTableForm() {
	return document.getElementById('jvForm');
}
function optDelete() {
	if(Pn.checkedCount('ids')<=0) {
		alert("请选择您要操作的数据");
		return;
	}
	if(!confirm("您确定删除吗？")) {
		return;
	}
	var f = getTableForm();
	f.action="zyztbrecordRemove.do";
	f.submit();
}


$(function() {
	$("#jvForm").validate();
});

</script>
</head>
<body>
<div class="body-box">
<div class="rhead">
	<div class="rpos">当前位置: 志愿淘宝用户购买信息 - 列表</div>

	<div class="clear"></div>
</div>
<form id="jvForm" action="zyztbrecordList.do" method="post" style="padding-top:5px;">
     

<!--
</form>

<form id="tableForm" method="post">
-->

<input type="hidden" name="pageNo" value=""/>
<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead"><tr>
	<th width="20"><input type='checkbox' onclick='Pn.checkbox("ids",this.checked)'/></th>      	 <th>用户名</th>
   	 <th>金额</th>
   	 <th>捐献日期</th>	<th width="90">操作选项</th>   </tr></thead>
<tbody  class="pn-ltbody">
<c:forEach items="${page.list}" var="row">   
<tr>
 <td><input type='checkbox' name='ids' value='<c:out value="${row.inid}"/>'/></td>
  <td><c:out value="${row.username}"/></td>
 <td><c:out value="${row.amount}"/></td>
  <td><c:out value="${row.createdateStr}"/></td>
	<td align="center">		
   <a href="zyztbrecordEdit.do?actiontype=view&inid=<c:out value="${row.inid}"/>" target="_blank" class="pn-opt">详情</a>  	
    <c:if test="${row.status =='2'}">
   |<a href="zyztbrecordEdit.do?actiontype=edit&inid=<c:out value="${row.inid}"/>" class="pn-opt">修改</a>
     </c:if>
     <c:if test="${row.status!='1'}">
   |<a href="zyztbrecordRemove.do?isfront=0&ids=<c:out value="${row.inid}"/>" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
     </c:if>
   </td>
</tr>
</c:forEach>  
</tbody>
</table><table width="100%" border="0" cellpadding="0" cellspacing="0"><tr><td align="center" class="pn-sp">
	共 <c:out value="${page.totalCount}"/> 条&nbsp;
	每页<input type="text" value="<c:out value='${page.pageSize}'/>" style="width:30px" onfocus="this.select();" onblur="$.cookie('_cookie_page_size',this.value,{expires:3650});" onkeypress="if(event.keyCode==13){$(this).blur();return false;}"/>条&nbsp;
	<input type="button" value="首 页" onclick="_gotoPage('1');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" value="上一页" onclick="_gotoPage('<c:out value="${page.prePage}"/>');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" value="下一页" onclick="_gotoPage('<c:out value="${page.nextPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />
	<input type="button" value="尾 页" onclick="_gotoPage('<c:out value="${page.totalPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />&nbsp;
	当前 <c:out value="${page.pageNo}"/>/<c:out value="${page.totalPage}"/> 页 &nbsp;转到第<input type="text" id="_goPs" style="width:50px" onfocus="this.select();" onkeypress="if(event.keyCode==13){$('#_goPage').click();return false;}"/>页
	<input id="_goPage" type="button" value="转" onclick="_gotoPage($('#_goPs').val());" <c:if test="${page.totalPage==1}">  disabled="disabled"</c:if> />
</td></tr></table><script type="text/javascript"> 
function _gotoPage(pageNo) {
	try{
		var tableForm = getTableForm();
		$("input[name=pageNo]").val(pageNo);
		tableForm.action="zyztbrecordList.do";
		tableForm.onsubmit=null;
		tableForm.submit();
	} catch(e) {
		alert('_gotoPage(pageNo)方法出错');
	}
}
</script><div> <form class="ropt">
<input type="hidden" id="actiontype" name="actiontype" /> 
		<input type="submit" value="添加" onclick="this.form.action='zyztbrecordAdd.do';document.getElementById('actiontype').value='add'"/>
</form></div>
</form>
</div>
</body>
</html>