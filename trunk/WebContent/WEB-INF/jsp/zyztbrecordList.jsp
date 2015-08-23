<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
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
	<div class="rpos">当前位置: 志愿ATM项目用户管理 - 列表</div>

	<div class="clear"></div>
</div>
<form id="jvForm" action="zyztbrecordList.do" method="post" style="padding-top:5px;">
项目类别:    
	<select name="itemType"  class="digits" id="itemType">
		<option value="0" >全部项目</option>
		<option value="1" <c:if test="${zyztbrecord.itemType==1}">selected="selected"</c:if> >服务项目</option>
		<option value="2" <c:if test="${zyztbrecord.itemType==2}">selected="selected"</c:if>>捐助项目</option>
		<option value="3" <c:if test="${zyztbrecord.itemType==3}">selected="selected"</c:if>>需求心愿</option>
	</select>
	项目名称:
	<input name="itemTitle"  id="itemTitle" size="24" maxlength="200"/>
	<input type="submit" value="查询"/>
<!--
</form>

<form id="tableForm" method="post">
-->
<hr></hr>

<input type="hidden" name="pageNo" value=""/>
<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead"><tr>
	<th width="20"><input type='checkbox' onclick='Pn.checkbox("ids",this.checked)'/></th>
	<th width="60">项目类型</th> 
	 <th>项目名称</th>
	 <th width="80">手机号码</th>
	<th width="80">姓名</th>
	<th width="120">身份证号码</th>
	<th>工作单位</th>
   	 <th width="35">金额/人数</th>
   	 <th width="90">捐助/报名日期</th>	<th width="140">操作选项</th>   </tr></thead>
<tbody  class="pn-ltbody">
<c:forEach items="${page.list}" var="row">   
<tr>
 <td><input type='checkbox' name='ids' value='<c:out value="${row.inid}"/>'/></td>
 <td>
 	<c:if test="${row.itemType==1 }">服务</c:if>
 	<c:if test="${row.itemType==2 }">捐助</c:if>
 	<c:if test="${row.itemType==3 }">需求</c:if>
 	</td>
  <td><c:out value="${row.itemTitle}"/></td>
  <td><c:out value="${row.phoneNo}"/></td>
  <td><c:out value="${row.username}"/></td>
  <td><c:out value="${row.idcard}"/></td>
  <td><c:out value="${row.workplace}"/></td>
 
 <td>
  <c:if test="${row.itemType==1 || row.itemType==3}">
 <fmt:formatNumber value="${row.amount}" pattern="#"/>
 </c:if>
 <c:if test="${row.itemType==2 }">
 ${row.amount}
 </c:if>
 </td>
  <td><c:out value="${row.createdateStr}"/></td>
	<td align="center">		
   <a href="zyztbrecordEdit.do?actiontype=view&inid=<c:out value="${row.inid}"/>" target="_blank" class="pn-opt">详情</a> 	
   <%-- |<a href="zyztbrecordEdit.do?actiontype=edit&inid=<c:out value="${row.inid}"/>" class="pn-opt">修改</a>  --%>
   |<a href="zyztbrecordRemove.do?ids=<c:out value="${row.inid}"/>" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
   |<a href="/zyztbrecord/zyztbrecordExport.do?itemid=<c:out value="${row.itemid}"/>" class="pn-opt">导出列表</a>
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
</script><div><input type="button" value="删除" onclick="optDelete();"/>	<form class="ropt">
<input type="hidden" id="actiontype" name="actiontype" /> 
		<!-- <input type="submit" value="添加" onclick="this.form.action='zyztbrecordAdd.do';document.getElementById('actiontype').value='add'"/> -->
</form></div>
</form>
</div>
</body>
</html>