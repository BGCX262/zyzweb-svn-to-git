<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>网站用户表-列表</title>
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
	f.action="qjscuserRemove.do";
	f.submit();
}


$(function() {
	$("#jvForm").validate();
});

function changeOrders(s){
	var s1=s.substring(0,s.indexOf('_'));
	var s2=s.substring(s.indexOf('_')+1,s.length);
	
	document.getElementById('order').value=s2;
	document.getElementById('sort').value=s1;
}
</script>
</head>
<body>
<div class="body-box">
 <div class="rhead">
	<div class="rpos">当前位置: <c:if test="${t=='3'}">志愿者党员年龄段统计</c:if><c:if test="${t=='2'}">志愿者申请党员年龄段统计</c:if><c:if test="${t=='1'}">志愿者党员与申请党员年龄段统计</c:if> - 列表</div>

	<div class="clear"></div>
</div>  
<%-- <form id="jvForm" action="queryDzzRs.do" method="post" style="padding-top:5px;">
    <input type="hidden" name="order" id="order" value="" />
    <input type="hidden" name="sort" id="sort" value="" />
   

 
                <select  name="orders"   id="orders" onchange="changeOrders(this.options[this.options.selectedIndex].value)" >
              <option value="czyz_desc">降序</option>
              <option value="czyz_asc">升序</option>
              </select>
              <c:if test="${param['isfront1']!=null}"><input type="hidden" name="isfront1" value="<%=request.getParameter("isfront1")%>"/> </c:if> 
	<input type="submit" value="查询"/> --%>
<!--
</form>

<form id="tableForm" method="post">
-->
<!-- <hr></hr> -->

<input type="hidden" name="pageNo" value=""/>
<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead"><tr>
   	 <th>年龄段</th>
   	 <th>志愿者人数</th>
   	  <th>百分比</th>
<!--    	 <th width="40%">操作</th>	   
 -->
   	 </tr>
   	 </thead>
<tbody  class="pn-ltbody">
<c:forEach items="${page.list}" var="row">   
<tr>
 <td><c:out value="${row.nl}"/></td>
  <td><c:out value="${row.czyz}"/></td>
    <td><img src="/res/mycms/images/percent_bar.gif" width="<c:out value="${row.nlBarWidth}"/>" height="10px" border="0"/><c:out value="${row.nlPercert}"/></td>
<%--   <td><a href="/zyzinfo/queryDw.do?order=desc&sort=cscore&zzid=<c:out value="${row.d0100}"/>">统计该党组织下单位</a>&nbsp;|&nbsp;<a href="/zyzinfo/queryZyz.do?order=desc&sort=cscore&zzid=<c:out value="${row.d0100}"/>">统计该党组织下志愿者 </a></td>
 --%>
</tr>
</c:forEach>  
</tbody>
</table><%-- <table width="100%" border="0" cellpadding="0" cellspacing="0"><tr><td align="center" class="pn-sp">
	共 <c:out value="${page.totalCount}"/> 条&nbsp;
	每页<input type="text" value="<c:out value='${page.pageSize}'/>" style="width:30px" onfocus="this.select();" onblur="$.cookie('_cookie_page_size',this.value,{expires:3650});" onkeypress="if(event.keyCode==13){$(this).blur();return false;}"/>条&nbsp;
	<input type="button" value="首 页" onclick="_gotoPage('1');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" value="上一页" onclick="_gotoPage('<c:out value="${page.prePage}"/>');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" value="下一页" onclick="_gotoPage('<c:out value="${page.nextPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />
	<input type="button" value="尾 页" onclick="_gotoPage('<c:out value="${page.totalPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />&nbsp;
	当前 <c:out value="${page.pageNo}"/>/<c:out value="${page.totalPage}"/> 页 &nbsp;转到第<input type="text" id="_goPs" style="width:50px" onfocus="this.select();" onkeypress="if(event.keyCode==13){$('#_goPage').click();return false;}"/>页
	<input id="_goPage" type="button" value="转" onclick="_gotoPage($('#_goPs').val());" <c:if test="${page.totalPage==1}">  disabled="disabled"</c:if> />
</td></tr></table> --%><script type="text/javascript"> 
function _gotoPage(pageNo) {
	try{
		var tableForm = getTableForm();
		$("input[name=pageNo]").val(pageNo);
		tableForm.action="queryuserList.do";
		tableForm.onsubmit=null;
		tableForm.submit();
	} catch(e) {
		alert('_gotoPage(pageNo)方法出错');
	}
}
</script>
<!-- 
<div><input type="button" value="删除" onclick="optDelete();"/>	<form class="ropt">
<input type="hidden" id="actiontype" name="actiontype" /> 
		<input type="submit" value="添加" onclick="this.form.action='qjscuserAdd.do';document.getElementById('actiontype').value='add'"/>
</form></div> -->
</form>
</div>
</body>
</html>