<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	
	<style>
        .zi-div td{border-bottom:none;}
    </style>
</head>

<body>
	

<table cellpadding="0" cellspacing="0" border="0" width="1000" class="zi-div">

<c:forEach items="${page.list}" var="row">   
	<tr>
    	<td width="70" height="40" align="center">
			<c:if test="${row.itemType==1 }">服务</c:if>
 			<c:if test="${row.itemType==2 }">捐助</c:if>
 			<c:if test="${row.itemType==3 }">需求</c:if>
		</td>
        <td width="120">&nbsp;</td>
        <td width="119">${row.phoneNo}</td>
    	<td width="62">${row.username}</td>
        <td width="143">${row.idcard}</td>
        <td width="180">${row.workplace}</td>
        <td width="80">
        	  <c:if test="${row.itemType==1 || row.itemType == 3}">
			 <fmt:formatNumber value="${row.amount}" pattern="#"/>
			 </c:if>
			 <c:if test="${row.itemType==2 }">
			 ${row.amount}元
			 </c:if>
		</td>
        <td width="136">${row.createdateStr}</td>
        <td width="90" align="center" style="border-right:none;">
        <a href="/zyztbrecord/zyztbrecordEdit.do?actiontype=view&inid=<c:out value="${row.inid}"/>">详情</a>&nbsp;&nbsp;
        |<a href="/zyztbrecord/zyztbrecordRemove.do?ids=<c:out value="${row.inid}"/>" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
  