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
function setValue(){
	document.getElementById('username').value=document.getElementById('A0101').value;
	var a=document.getElementById('A0104').value;
	var b="";
	if (a=='031')
    b="男";
	if (a=='032')
	    b="女";
	document.getElementById('sex').value=b;
	document.getElementById('cardid').value=document.getElementById('A0184').value;
}

</script>
</head>
<body>
<div class="body-box">
<div class="rhead">
		<div class="rpos">当前位置: -申请中党员积分排序 </div>

	<div class="clear"></div>
</div>
<form id="jvForm" action="px_sqz.do" onsubmit="setValue()" method="post" style="padding-top:5px;">
    <input type="hidden" name="order" id="order" value="<c:out value="${param.order}"/>" />
    <input type="hidden" name="sort" id="sort" value="<c:out value="${param.sort}"/>" />
    <input type="hidden" name="dytype" id="dytype" value="<c:out value="${param.dytype}"/>" />
    
   	<strong>申请人员类型：</strong>   
  <select  name="G0005" >
              <option value="">--请选择--</option>
              <c:forEach items="${g00.g00_g0005_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==g00.g0005}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
   	</br>
	<hr></hr>

 

<strong>党务系统查询条件：</strong>
</br>
姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:    <input type="text" name="A0101"  class="" id="A0101" value="<c:out value="${a01.a0101}"/>" style="width:150px"/>
   性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:               <select style="width:154px" name="A0104" >
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0104_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0104}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
   出生年龄:   <input type="text" size=6 name="nl_start" id="nl_start" value="<c:out value="${a01.nl_start}"/>" /> ~&nbsp;&nbsp;<input type="text" size=6 name="nl_end" id="nl_end" value="<c:out value="${a01.nl_end}"/>"/> 
   <input type="hidden" name="A01071"    id="A01071" value="<c:out value="${a01.a01071}"/>" />
   <input type="hidden" name="A01072"    id="A01072" value="<c:out value="${a01.a01072}"/>" />
   
   籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯:    <input type="text" name="A0111"  class="" id="A0111" value="<c:out value="${a01.a0111}"/>" style="width:150px"/>
     </br>
   民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族:               <select style="width:154px"  name="A0117" >
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0117_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0117}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
            
   单位属性:               <select style="width:154px"  name="A0171" >
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0171_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0171}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
   所属行业:         
   <select  name="A0174" style="width:154px">
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0174_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0174}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
    
   
   工作单位:    <input type="text" name="A0135"  class="" id="A0135" value="<c:out value="${a01.a0135}"/>" style="width:150px"/>
 </br>
   个人身份:      
            <select style="width:154px"  name="A0151" >
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0151_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0151}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
            <%-- <select  name="A0151" >
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0151_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0151}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select> --%>

   身份证号:    <input type="text" name="A0184"  class="" id="A0184" value="<c:out value="${a01.a0184}"/>" style="width:150px"/>
   学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:               <select style="width:154px"  name="A0801" >
              <option value="">--请选择--</option>
              <c:forEach items="${a01.a01_a0801_Dict}" var="entry">
              <option value="<c:out value="${entry.key}" />" <c:if test="${entry.key==a01.a0801}">selected </c:if> > <c:out value="${entry.value}" /></option>
              </c:forEach>
              </select>
入党申请时间:    <input type="text" name="G0004"    id="G0004" value="<c:out value="${g00.g0004}"/>" style="width:125px"/>   
</br>
入党积极分子时间:    <input type="text" name="G0009"    id="G0009" value="<c:out value="${g00.g0009}"/>" style="width:100px"/>   
发展对象时间:    <input type="text" name="G0010"    id="G0010" value="<c:out value="${g00.g0010}"/>" style="width:127px"/>   
转预备党员时间:    <input type="text" name="G0013"    id="G0013" value="<c:out value="${g00.g0013}"/>" style="width:115px"/>   
           
	<hr></hr>
	<strong>志愿者系统查询条件：</strong>
	</br>
	  <!--  用户姓名:  -->   <input type="hidden" name="username"  class="" id="username" value="<c:out value="${zyzinfo.username}"/>" style="width:150px"/>
   <!-- 证件号码: -->    <input type="hidden" name="cardid"  class="" id="cardid" value="<c:out value="${zyzinfo.cardid}"/>" style="width:150px"/>
   手机号码:    <input type="text" name="phone"  class="" id="phone" value="<c:out value="${zyzinfo.phone}"/>" style="width:150px"/>
 <!--   归口单位:  -->   <input type="hidden" name="area"  class="" id="area" value="<c:out value="${zyzinfo.area}"/>" style="width:150px"/>
  <!--  性别: -->    <input type="hidden" name="sex"  class="" id="sex" value="<c:out value="${zyzinfo.sex}"/>" style="width:150px"/>
   服务类别:    <input type="text" name="servicetype"  class="" id="servicetype" value="<c:out value="${zyzinfo.servicetype}"/>" style="width:150px"/>
   建立时间:    <input type="text" name="createdate"  class="" id="createdate" value="<c:out value="${zyzinfo.createdate}"/>" style="width:150px"/>
  </br>    
      服务时间:    <input type="text" name="workdate"  class="" id="workdate" value="<c:out value="${zyzinfo.workdate}"/>" style="width:150px"/>
   服务时段:    <input type="text" name="worktime"  class="" id="worktime" value="<c:out value="${zyzinfo.worktime}"/>" style="width:150px"/>
<%--    工作单位:    <input type="text" name="company"  class="" id="company" value="<c:out value="${zyzinfo.company}"/>" style="width:150px"/> --%>
   专业特长:    <input type="text" name="professional"  class="" id="professional" value="<c:out value="${zyzinfo.professional}"/>" style="width:150px"/>
 </br> 
  积&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分: <input type="text" size=6 name="score1" id="score1" value="<c:out value="${zyzinfo.score1}"/>" /> ~&nbsp;&nbsp;<input type="text" size=6 name="score2" id="score2" value="<c:out value="${zyzinfo.score2}"/>"/>   
   服务时长:  <input type="text" size=6 name="servicetimes1" id="servicetimes1" value="<c:out value="${zyzinfo.servicetimes1}"/>" /> ~&nbsp;&nbsp;<input type="text" size=6 name="servicetimes2" id="servicetimes2" value="<c:out value="${zyzinfo.servicetimes2}"/>"/>  
  
	</br>
	<input type="submit" onclick="showLoad()" value="查询"/>
    
<!--
</form>

<form id="tableForm" method="post">
-->
<hr></hr>

<input type="hidden" name="pageNo" value=""/>
<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead"><tr>
     <th>党员</th>
   	<th>党组织</th>
   	 <th>
   	 	    <a href="#" style="cursor:pointer" onclick="sortSubmit('score','<c:choose><c:when test="${param.order=='desc' and param.sort=='score'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
  积分
</a>
<c:if test="${param.sort=='score'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
   	 
   	 </th>
   	 <th>
   	 <a href="#" style="cursor:pointer" onclick="sortSubmit('servicetimes','<c:choose><c:when test="${param.order=='desc' and param.sort=='servicetimes'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
   服务时长
</a>
<c:if test="${param.sort=='servicetimes'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
   	</th>

   	 </tr>
   	 </thead>
<tbody  class="pn-ltbody">
<c:forEach items="${page.list}" var="row">   
<tr>
 <td><c:out value="${row.username}"/></td>
  <td><c:out value="${row.d0104}"/></td>
  <td><c:out value="${row.score}"/></td>
 <td><c:out value="${row.servicetimes}"/></td>
  

</tr>
</c:forEach>  
</tbody>
</table>

<%-- <table width="100%" border="0" cellpadding="0" cellspacing="0"><tr><td align="center" class="pn-sp">
	共 <c:out value="${page.totalCount}"/> 条&nbsp;
	每页<input type="text" value="<c:out value='${page.pageSize}'/>" style="width:30px" onfocus="this.select();" onblur="$.cookie('_cookie_page_size',this.value,{expires:3650});" onkeypress="if(event.keyCode==13){$(this).blur();return false;}"/>条&nbsp;
	<input type="button" value="首 页" onclick="_gotoPage('1');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" value="上一页" onclick="_gotoPage('<c:out value="${page.prePage}"/>');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" value="下一页" onclick="_gotoPage('<c:out value="${page.nextPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />
	<input type="button" value="尾 页" onclick="_gotoPage('<c:out value="${page.totalPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />&nbsp;
	当前 <c:out value="${page.pageNo}"/>/<c:out value="${page.totalPage}"/> 页 &nbsp;转到第<input type="text" id="_goPs" style="width:50px" onfocus="this.select();" onkeypress="if(event.keyCode==13){$('#_goPage').click();return false;}"/>页
	<input id="_goPage" type="button" value="转" onclick="_gotoPage($('#_goPs').val());" <c:if test="${page.totalPage==1}">  disabled="disabled"</c:if> />
</td></tr></table> --%>

<script type="text/javascript"> 
function _gotoPage(pageNo) {
	try{
		var tableForm = getTableForm();
		$("input[name=pageNo]").val(pageNo);
		tableForm.action="<c:if test="${t=='3'}">queryDzzDy.do</c:if><c:if test="${t=='2'}">queryDzzDyNot.do</c:if><c:if test="${t=='1'}">queryDzzDyAll.do</c:if>";
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