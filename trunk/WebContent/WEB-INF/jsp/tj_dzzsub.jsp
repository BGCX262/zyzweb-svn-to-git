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
		<div class="rpos">当前位置: -党组织下级统计 </div>

	<div class="clear"></div>
</div>
<form id="jvForm" action="tj_dzzsub.do" onsubmit="setValue()" method="post" style="padding-top:5px;">
    <input type="hidden" name="order" id="order" value="<c:out value="${param.order}"/>" />
    <input type="hidden" name="sort" id="sort" value="<c:out value="${param.sort}"/>" />
    <input type="hidden" name="dytype" id="dytype" value="<c:out value="${param.dytype}"/>" />
     <input type="hidden" name="charttype" id="charttype" value="" />
     <input type="hidden" name="D0107" id="D0107" value="<c:out value="${param.D0107}"/>" />
   
   
 

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
入党时间:    <input type="text" name="C0203"    id="C0203" value="<c:out value="${c02.c0203}"/>" style="width:150px"/>              
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
	<input type="button" style="font-size:12px" onclick="document.getElementById('charttype').value='';showLoad();document.getElementById('jvForm').submit();" value="查询"/>
	<hr></hr>
	<strong>图表展示：</strong>  </br>
    <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='1';document.getElementById('jvForm').submit();" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;党员人数 图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"/>
    <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='2';document.getElementById('jvForm').submit();" value="党员志愿者人数 图"/>
     <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='3';document.getElementById('jvForm').submit();" value="党员志愿者积分 图"/>
     <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='4';document.getElementById('jvForm').submit();" value="党员志愿者志愿时数 图"/></br>
     <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='5';document.getElementById('jvForm').submit();" value="党员志愿者平均积分  图"/>
     <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='6';document.getElementById('jvForm').submit();" value="党员志愿者平均志愿时数  图"/>
     <input type="button" style="font-size:12px" onclick="showLoad();document.getElementById('charttype').value='7';document.getElementById('jvForm').submit();" value="党员志愿者占党员百分比  图"/>
      </br>
      <hr></hr>
      	<strong>前台图表展示保存：</strong></br>
       标题:<input type=text id="v1" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','dyrs',$('#v1').val())" value="保存党员人数排名"/>  
                  标题:<input type=text id="v2" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','zyrs',$('#v2').val())" value="保存党员志愿者人数的排名"/> </br>
                  标题:<input type=text id="v3" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','cscore',$('#v3').val())" value="保存积分的排名&nbsp;&nbsp;&nbsp;&nbsp;"/>  
                    标题:<input type=text id="v4" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','cservicetimes',$('#v4').val())" value="保存 时数排名"/> </br>
                         标题:<input type=text id="v5" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','cscoreavg',$('#v5').val())" value="保存平均积分排名"/>  
                    标题:<input type=text id="v6" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','cservicetimesavg',$('#v6').val())" value="保存平均志愿时数排名"/> </br>
                         标题:<input type=text id="v7" />
           <input type="button" style="font-size:12px" onclick="saveData('subdzz','percent',$('#v7').val())" value="保存党员志愿者占党员百分比的排名"/> </br>                          
  <script>
  function saveData(f1,f2,name){
	  if(name==''){alert('前台显示名称不能为空!');return;};
	  var params = serializeForm('jvForm'); 
	  params='/zyzinfo/tj_dzzsub.do?'+params+'&f1='+f1+'&f2='+f2+'&charttype1=1';
	  var u2="/chartmgr/chartmgrSave.do?type=1"+'&filed='+f1+','+f2+'&name='+encodeURI(name)+"&url="+escape(params)+"&up"+new Date();
  $.ajax({ url: u2, success: function(data){
      if(data=='ok'){
    	  alert('保存成功');
      }else{
    	  alert('保存失败');
      }
    }});
  }
  
 
  </script>       
<!--
</form>

<form id="tableForm" method="post">
-->
<hr></hr>

<input type="hidden" name="pageNo" value=""/>
<table class="pn-ltable" style="" width="100%" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead"><tr>
     <th>  党组织</th>
      <th>
   	 
   	 <a href="#" style="cursor:pointer" onclick="sortSubmit('dyrs','<c:choose><c:when test="${param.order=='desc'  and param.sort=='dyrs'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
党员人数
</a>
<c:if test="${param.sort=='dyrs'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
 
   	 </th>
   	 <th>
   	 
   	 <a href="#" style="cursor:pointer" onclick="sortSubmit('zyrs','<c:choose><c:when test="${param.order=='desc'  and param.sort=='zyrs'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
党员志愿者人数
</a>
<c:if test="${param.sort=='zyrs'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
 
   	 </th>
   	 <th>
   	 <a href="#" style="cursor:pointer" onclick="sortSubmit('cscore','<c:choose><c:when test="${param.order=='desc'  and param.sort=='cscore'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
党员志愿者积分
</a>
<c:if test="${param.sort=='cscore'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
 
   	
   	 </th>
   	 <th>
 <a href="#" style="cursor:pointer" onclick="sortSubmit('cservicetimes','<c:choose><c:when test="${param.order=='desc'  and param.sort=='cservicetimes'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
 党员志愿者志愿时数
</a>
<c:if test="${param.sort=='cservicetimes'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
   	 </th>
   	 
   	 <th>
   	 <a href="#" style="cursor:pointer" onclick="sortSubmit('cscoreavg','<c:choose><c:when test="${param.order=='desc' and param.sort=='cscoreavg'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
  党员志愿者平均积分
</a>
<c:if test="${param.sort=='cscoreavg'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
   	</th>
     <th>
   <a href="#" style="cursor:pointer" onclick="sortSubmit('cservicetimesavg','<c:choose><c:when test="${param.order=='desc'  and param.sort=='cservicetimesavg'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
  党员志愿者平均志愿时数
</a>
<c:if test="${param.sort=='cservicetimesavg'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
     </th>
     <th>
   <a href="#" style="cursor:pointer" onclick="sortSubmit('percent','<c:choose><c:when test="${param.order=='desc'  and param.sort=='percent'}">asc</c:when><c:otherwise>desc</c:otherwise></c:choose>')">
  党员志愿者占党员百分比
</a>
<c:if test="${param.sort=='percent'}"> <IMG style="cursor:pointer" border=0 alt=^ align=absMiddle src="/images/<c:choose><c:when test="${param.order=='desc'}">down.gif</c:when><c:otherwise>up.gif</c:otherwise> </c:choose>"></c:if>
     
     </th>
   	 </tr>
   	 </thead>
<tbody  class="pn-ltbody">
<c:forEach items="${page.list}" var="row">   
<tr>
 <td><c:out value="${row.d01_dzz_Dict[row.subdzz]}"/></td>
 <td><c:out value="${row.dyrs}"/></td>
 <td><c:out value="${row.zyrs}"/></td>
 <td><c:out value="${row.cscore}"/></td>
  <td><c:out value="${row.cservicetimes}"/></td>
   <td><c:out value="${row.cscoreavg}"/></td>
    <td><c:out value="${row.cservicetimesavg}"/></td>
     <td><c:out value="${row.percent}"/></td>

</tr>
</c:forEach>  
</tbody>
</table>

<%-- <table width="100%" border="0" cellpadding="0" cellspacing="0"><tr><td align="center" class="pn-sp">
	共 <c:out value="${page.totalCount}"/> 条&nbsp;
	每页<input type="text" value="<c:out value='${page.pageSize}'/>" style="width:30px" onfocus="this.select();" onblur="$.cookie('_cookie_page_size',this.value,{expires:3650});" onkeypress="if(event.keyCode==13){$(this).blur();return false;}"/>条&nbsp;
	<input type="button" style="font-size:12px" value="首 页" onclick="_gotoPage('1');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" style="font-size:12px" value="上一页" onclick="_gotoPage('<c:out value="${page.prePage}"/>');" <c:if test="${page.firstPage}">disabled="disabled" </c:if> />
	<input type="button" style="font-size:12px" value="下一页" onclick="_gotoPage('<c:out value="${page.nextPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />
	<input type="button" style="font-size:12px" value="尾 页" onclick="_gotoPage('<c:out value="${page.totalPage}"/>');" <c:if test="${page.lastPage}">disabled="disabled" </c:if> />&nbsp;
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
<div><input type="button" style="font-size:12px" value="删除" onclick="optDelete();"/>	<form class="ropt">
<input type="hidden" id="actiontype" name="actiontype" /> 
		<input type="submit" value="添加" onclick="this.form.action='qjscuserAdd.do';document.getElementById('actiontype').value='add'"/>
</form></div> -->
</form>
</div>
</body>
</html>