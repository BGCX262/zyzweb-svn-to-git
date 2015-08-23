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
	
	var o = $('.open');  //项目类型按钮
	var s = $('.show');	 //子页table框
	s.hide();
	
	o.each(function(n){
		$(this).click(function(){
			if($(this).attr('tag')){
			if($(s[n]).is(':hidden')){
				$(o[n]).html('-');
				var url = "/zyztbrecord/zyztbrecordList.do?isfront=-1&itemid="+$(this).attr('tag');
				$(s[n]).show().load(url);
				return false;
			}else{
				$(o[n]).html('+');	
				$(s[n]).hide();
			}
			}
		});   
	});
});
//$(document).ready(function(){
	
//});
</script>
<style>
	*{margin:0px auto;}
	.table-div{font-size:12px; border-top:1px solid #CCC; border-left:1px solid #CCC;}
	.table-div td{border-bottom:1px solid #CCC; border-right:1px solid #CCC;}
</style>
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

<table border="0" cellpadding="0" cellspacing="0" style="margin-top:20px;" width="1000" class="table-div">
    	<tr>
        	<td width="70" height="35" align="center">项目类型</td>
            <td width="120" align="center">项目名称</td>
            <td width="119" align="center">手机号码</td>
            <td width="62" align="center">姓名</td>
            <td width="143" align="center">身份证号码</td>
            <td width="180" align="center">工作单位</td>
            <td width="80" align="center">金额/人数</td>
            <td width="136" align="center">捐助/报名日期</td>
            <td width="90" align="center">操作</td>
        </tr>
        <c:forEach items="${page.list}" var="row">   
    	<tr>
    		<c:if test="${row.amount>0 }">
        	<td class="open" height="40" style="cursor:pointer; text-align:center;" tag="${row.itemid}">+</td>
        	</c:if>
        	<c:if test="${row.amount<=0 }">
        	<td class="open" height="40" style="cursor:pointer; text-align:center;"  ></td>
        	</c:if>
            <td align="left" colspan="7">${row.title}</td>
            <td width="90" align="center"><a href="/zyztbrecord/zyztbrecordExport.do?itemid=<c:out value='${row.itemid}'/>">导出</a></td>
        </tr>
        <tr>
        	<td colspan="9" class="show"></td>
        </tr>
        </c:forEach>
    </table>
<table width="100%" border="0" cellpadding="0" cellspacing="0"><tr><td align="center" class="pn-sp">
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