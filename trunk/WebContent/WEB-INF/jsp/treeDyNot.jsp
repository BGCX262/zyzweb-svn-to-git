 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <c:choose>
 <c:when test="${isRoot}">  
[{
	"text": "<a href='/zyzinfo/queryDzzDyNot.do?order=desc&sort=cscore' target='rightFrame1'>党组织机构树</a>",
	"classes": "folder"
	<c:if  test="${!empty list}">,
	"expanded": true,
	"children": [
	<c:forEach items="${list}" var="row" varStatus="status">  
		{
		"text": "<a href='/zyzinfo/queryDzzDyNot.do?order=desc&sort=cscore&zzcode=${row.d0107}' target='rightFrame1'>${row.d0101}</a>",
		"classes": "<c:choose><c:when test="${row.hasChild}">folder</c:when><c:otherwise>file</c:otherwise></c:choose>",
		"id": "<c:out value="${row.d0107}"/>",
		"hasChildren": <c:choose><c:when test="${row.hasChild}">true</c:when><c:otherwise>false</c:otherwise></c:choose>
		}<c:if test="${!status.last}">,</c:if>
	</c:forEach>  
	]
	 </c:if>
}]
</c:when>

   <c:otherwise>
	[
	<c:forEach items="${list}" var="row" varStatus="status">  
		{
		"text": "<a href='/zyzinfo/queryDzzDyNot.do?order=desc&sort=cscore&zzcode=${row.d0107}' target='rightFrame1'>${row.d0101}</a>",
		"classes": "<c:choose><c:when test="${row.hasChild}">folder</c:when><c:otherwise>file</c:otherwise></c:choose>",
		"id": "<c:out value="${row.d0107}"/>",
		"hasChildren": <c:choose><c:when test="${row.hasChild}">true</c:when><c:otherwise>false</c:otherwise></c:choose>
		}<c:if test="${!status.last}">,</c:if>
	</c:forEach>  
	]
</c:otherwise>  
</c:choose>
