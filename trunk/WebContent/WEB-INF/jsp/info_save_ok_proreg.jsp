<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<head>
<title>提示信息</title>
<style type="text/css">
<!--
*{
margin:0;
padding:0;
}
body{
text-align:center;
}
td{
font-size: 16px;
line-height:150%;
}
h1{
height:20px;
line-height:20px;
font-size:12px;
text-align:center;
background-color:#f1f1f1;
color:#CC0000;
}
.box_border{
margin:50px auto;
border:1px solid #dcdcdd;
width:450px;
}
a:link {
color: #0000FF;
text-decoration: none;
}
a:visited {
text-decoration: none;
color: #003399;
}
a:hover {
text-decoration: underline;
color: #0066FF;
}
a:active {
text-decoration: none;
color: #0066FF;
}
-->
</style>
</head>
<script>

parent.window.scroll(0,0);
</script>
<body>
<div class="box_border">
<h1>提示信息</h1>
<table width="100%" cellspacing="5" cellpadding="0" bgcolor="#f5f5f5">
  <tr>
    <td align="center" bgcolor="#FFFFFF">
<br/>
信息已保存成功&nbsp;&nbsp;<a href="/qjscprojregister/qjscprojregisterList.do?isfront=0&order=desc&sort=modtime" target="_blank"><font color=red><strong>继续添加节能项目信息</strong></font></a>
<c:if test="${param['isFromWorkprogress']!=null}">
</c:if>
<br/>
<br/>
    </td>
  </tr>
</table>
</div>
</body>
</html>