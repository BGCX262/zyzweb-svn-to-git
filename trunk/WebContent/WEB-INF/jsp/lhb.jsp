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
<script src="/js/jquery-1.6.4.min.js" type="text/javascript"></script>
<!-- jquery-ui 包 -->
<script src="/js/jquery-ui-1.8.11.js" type="text/javascript"></script>
<script type="text/javascript" >
	$(document).ready(function(){
		//积分排行详细dialog_div
		$( "#dialog_integral" ).dialog({
			autoOpen: false,
			modal: true,
			title: "本月个人积分排行榜TOP&nbsp;10",
			show: "blind",
			hide: "explode",
			width: 700,
			height: 380 
		});
		//打开积分排行详细dialog_div
		$( "#open_integral" ).click(function() {
			$( "#dialog_integral" ).dialog( "open" );
			return false;
		});
		
		//时长排行详细dialog_div
		$( "#dialog_time" ).dialog({
			autoOpen: false,
			modal: true,
			title: "本月个人时长排行榜TOP&nbsp;10",
			show: "blind",
			hide: "explode",
			width: 700,
			height: 380 
		});
		//打开时长排行详细dialog_div
		$( "#open_time" ).click(function() {
			$( "#dialog_time" ).dialog( "open" );
			return false;
		});
		
		 
		<c:forEach items="${list}" var="row">
		
		//时序图dialog_div
		$( "#dialog_<c:out value="${row.id}"/>" ).dialog({
			autoOpen: false,
			modal: true,
			title: "<c:out value="${row.name}"/>",
		
			width: 600,
			height: "auto" 
		});
		//打开时序图dialog_div
		$( "#open_<c:out value="${row.id}"/>" ).click(function() {
			$( "#dialog_<c:out value="${row.id}"/>" ).dialog( "open" );
			return false;
		});
		</c:forEach> 
	});
</script>
</head>

<body>
        <div class="templatebg">
            <div class="ranking_left">
                <div class="per-integral">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="430" height="40" colspan="4" class="head-top">个人积分排行榜<font size=-1 color=green>[截至时间:${insertdate}]</font> </td>
                        </tr>
                        <tr>
                            <td width="50" height="45" align="center">&nbsp;</td>
                            <td width="130" align="center" class="fon-size">姓名</td>
                            <td width="200" align="center" class="fon-size">积分</td>
                            <td width="50" align="left" class="fon-size"><a href="javascript:void(0);" id="open_integral" class="detail_1">详细</a></td>
                        </tr>
                        <c:forEach items="${page.list}" end="6" var="row" varStatus="xh">  
                        
                        <tr style="background:#fffbdb;">
                            <td height="45" align="right"><em style="font-family:'HelveticaNeueLT Std Ext'; font-size:30px; font-weight:bold; color:#F33;">${xh.count}</em></td>
                            <td align="center"><c:out value="${row.username}"/></td>
                            <td align="center"><c:out value="${row.score}"/></td>
                            <td align="left">...</td>
                        </tr>
                        </c:forEach> 
                         
                        <tr style="background:#f7f7f7;">
                            <td height="45" align="right">...</td>
                            <td align="center">...</td>
                            <td align="center">...</td>
                            <td align="left">...</td>
                        </tr>
                       <%--  <tr>
                            <td height="30"><a href="javascript:void(0);"></a></td>
                            <c:forEach items="${list}" var="row">
                            <td><a href="javascript:void(0);" id="open_<c:out value="${row.id}"/>"><c:out value="${row.name}"/></a></td>
                            </c:forEach> 
                        </tr> --%>
                    </table>
                </div>
            </div>
            <div class="ranking_right">
                <div class="per-time">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="430" height="40" colspan="4" class="head-top">个人时长排行榜<font size=-1 color=green>[截至时间:${insertdate}]</font></td>
                        </tr>
                        <tr>
                            <td width="50" height="45" align="center">&nbsp;</td>
                            <td width="130" align="center" class="fon-size">姓名</td>
                            <td width="200" align="center" class="fon-size">时长</td>
                            <td width="50" align="left" class="fon-size"><a href="javascript:void(0);" id="open_time">详细</a></td>
                        </tr>
                         <c:forEach items="${page1.list}" end="6" var="row" varStatus="xh">  
                        <tr style="background:#fffbdb;">
                            <td height="45" align="right"><em style="font-family:'HelveticaNeueLT Std Ext'; font-size:30px; font-weight:bold; color:#F33;">${xh.count}</em></td>
                            <td align="center"><c:out value="${row.username}"/></td>
                            <td align="center"><c:out value="${row.servicetimes}"/></td>
                            <td align="left">...</td>
                        </tr>
                        </c:forEach> 
                         
                        <tr style="background:#f7f7f7;">
                            <td height="45" align="right">...</td>
                            <td align="center">...</td>
                            <td align="center">...</td>
                            <td align="left">...</td>
                        </tr>
                       <!--  <tr>
                            <td height="30" colspan=4><a href="javascript:void(0);"></a></td>
                            <td><a href="javascript:void(0);">柱状图</a></td>
                            <td><a href="javascript:void(0);">柱状图</a></td>
                            <td><a href="javascript:void(0);">柱状图</a></td>
                        </tr> -->
                    </table>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="templatebg">
        <table border="0" cellpadding="0" cellspacing="0">
                        <tr align=left>
                            <td height="20"> 
                            <c:forEach items="${list}" var="row">
                           <a href="javascript:void(0);" id="open_<c:out value="${row.id}"/>"><c:out value="${row.name}"/></a>
                            </c:forEach> 
                            </td>
                        </tr>
                    </table>
        </div>
    <!-- 党员龙虎榜积分dialog_div -->
        <div class="per-d_1" id="dialog_integral">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="50" height="45" align="center">&nbsp;</td>
                    <td width="130" align="center" class="fon-size">姓名</td>
                    <td width="200" align="center" class="fon-size">积分</td>
                </tr>
                <c:forEach items="${page.list}" end="50" var="row" varStatus="xh">  
                <tr style="background:#fffbdb;">
                    <td height="45" align="right"><em style="font-family:'HelveticaNeueLT Std Ext'; font-size:30px; font-weight:bold; color:#F33;">${xh.count}</em></td>
                    <td align="center"><c:out value="${row.username}"/></td>
                    <td align="center"><c:out value="${row.score}"/></td>
                </tr>
                </c:forEach> 
                 
            </table>
		</div>
        <!-- 党员龙虎榜时长dialog_div -->
        <div class="per-time" id="dialog_time">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="50" height="45" align="center">&nbsp;</td>
                    <td width="130" align="center" class="fon-size">姓名</td>
                    <td width="200" align="center" class="fon-size">时长</td>
                </tr>
                <c:forEach items="${page1.list}" end="50" var="row" varStatus="xh">  
                <tr style="background:#fffbdb;">
                    <td height="45" align="right"><em style="font-family:'HelveticaNeueLT Std Ext'; font-size:30px; font-weight:bold; color:#F33;">${xh.count}</em></td>
                    <td align="center"><c:out value="${row.username}"/></td>
                    <td align="center"><c:out value="${row.servicetimes}"/></td>
                </tr>
                </c:forEach> 
                 
            </table>
    	</div>
        <!-- 党员龙虎榜柱状图dialog_div -->
        
        <c:forEach items="${list}" var="row" varStatus="xh">
                <c:if test="${xh.count>1}">  |&nbsp;&nbsp;
                </c:if>
        <c:if test="${row.type=='0'}">  
        <div id="dialog_<c:out value="${row.id}"/>"><img src="/<c:out value="${row.url}"/>" border="0" width="477" height="360" /></div>
        </c:if>
         <c:if test="${row.type=='1'}">  
        <div id="dialog_<c:out value="${row.id}"/>"><iframe id="dialog1_<c:out value="${row.id}"/>" src="<c:out value="${row.url}"/>&charttype1=0&ud=${xh.count}" border="0" width="100%" height="360" ></iframe></div>
        </c:if>
         </c:forEach> 
</body>
</html>
