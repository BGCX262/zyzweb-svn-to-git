<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/style/index_css.css">
<!-- jquery-ui css 样式 -->
<link rel="stylesheet" href="/style/jquery-ui-main.css">
<!-- jquery 包 -->
<!-- jquery-ui 包 -->
</head>

<body>
   <div class="per-d_1" style="display:block;height:100%;width:100%" id="dialog_integral">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="50" height="45" align="center">&nbsp;</td>
                    <td width="130" align="center" class="fon-size">名称</td>
                    <td width="200" align="center" class="fon-size">统计值</td>
                </tr>
               <c:forEach items="${list}" end="50" var="row" varStatus="xh">   
                <tr style="background:#fffbdb;">
                    <td height="45" align="right"><em style="font-family:'HelveticaNeueLT Std Ext'; font-size:30px; font-weight:bold; color:#F33;">${xh.count}</em></td>
                     <c:forEach items="${row}" end="50" var="row1" varStatus="xh"> 
                    <td align="center"><c:out value="${row1}"/></td>
                     </c:forEach> 
                </tr>
                </c:forEach> 
                 
            </table>
		</div>
         
</body>
</html>
