<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿淘宝商品信息-列表</title>
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
	f.action="zyztbitemRemove.do";
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
	<div class="rpos">当前位置: 志愿ATM项目信息管理- 列表</div>

	<div class="clear"></div>
</div>
<form id="jvForm" action="zyztbitemList.do" method="post" style="padding-top:5px;">

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
	<th>捐助对象</th>
   	 <th>标题</th>
   	 <th width="120" >目标金额/招募人数</th>
   	 <th>状态</th>	<th width="90">操作选项</th>   </tr></thead>
<tbody  class="pn-ltbody">
<c:forEach items="${page.list}" var="row">   
<tr>
 <td><input type='checkbox' name='ids' value='<c:out value="${row.itemid}"/>'/></td>
  <td>
  <c:if test="${row.type==1 }">服务</c:if>
 	<c:if test="${row.type==2 }">捐助</c:if>
 	<c:if test="${row.type==3 }">需求</c:if>
  </td>
  <td><c:out value="${row.targetname}"/></td>
 <td><c:out value="${row.title}"/></td>
 <td >
 <c:if test="${row.type==2 }"><c:out value="${row.targetamount}"/>元</c:if>
 <c:if test="${row.type==1 }"><fmt:formatNumber value="${row.targetamount}" pattern="#"/>人</c:if>
 <c:if test="${row.type==3 }">/</c:if>
 </td>
 <td>
 <c:if test="row.status==0">
 
 
 </c:if>
 <c:choose>
    <c:when test="${row.status==2}">
      <c:out value="结束"/>
    </c:when>
    <c:when test="${row.status==1}">
      <c:out value="可用"/>
    </c:when>  
   <c:otherwise>  
      <c:out value="过期"/>
   </c:otherwise>
  </c:choose>
 </td>
	<td align="center" width="170">		
   <a href="zyztbitemEdit.do?actiontype=view&itemid=<c:out value="${row.itemid}"/>" target="_blank" class="pn-opt">详情</a> 	
   |<a href="zyztbitemEdit.do?actiontype=edit&itemid=<c:out value="${row.itemid}"/>" class="pn-opt">修改</a> 
   |<a href="zyztbitemRemove.do?ids=<c:out value="${row.itemid}"/>" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
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
		tableForm.action="zyztbitemList.do";
		tableForm.onsubmit=null;
		tableForm.submit();
	} catch(e) {
		alert('_gotoPage(pageNo)方法出错');
	}
}
</script><div><input type="button" value="删除" onclick="optDelete();"/>	<form class="ropt">
<input type="hidden" id="actiontype" name="actiontype" /> 
		<input type="submit" value="添加" onclick="this.form.action='zyztbitemAdd.do';document.getElementById('actiontype').value='add'"/>
</form></div>
</form>
</div>
</body>
</html>