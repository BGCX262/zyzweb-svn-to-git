<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>海珠区党员自愿者信息网</title>
        <!-- 首页样式 -->
        <link rel="stylesheet" href="/style/index_css.css">
        <!-- jquery-ui css 样式 -->
        <link rel="stylesheet" href="/style/jquery-ui-main.css">
        <!-- jquery 包 -->
        <script src="/js/jquery-1.6.4.min.js" type="text/javascript"></script>
        <!-- jquery-ui 包 -->
        <script src="/js/jquery-ui-1.8.11.js" type="text/javascript"></script>
        <!-- 党员动态 的滚动新闻图片 js -->
        <script src="/js/focus.js" type="text/javascript"></script>
        <!-- 党员动态 “党员新闻” 和 志愿淘宝 “动态公告” 向上滚动效果 js -->
        <script src="/js/scroll.js" type="text/javascript"></script>
        <!-- 志愿淘宝 “已完成项目”、“服务项目”向左滚动效果 js -->
        <script src="/js/index.js" type="text/javascript"></script>
        <script type="text/javascript" >
			$(document).ready(function(){
				//选项框tabs
				var $uli = $(".layout .ul div");
				var $oli = $(".layout .ol .ol_div");
				$uli.addClass("normal");
				$oli.addClass("none_div");
				//$uli[0].className = "hover";
				$oli[0].className = "show_div";
				$uli.each(function(n){
					$(this).click(function(){
						//$uli.removeClass().addClass("normal");
						//$(this).removeClass().addClass("hover");
						$oli.removeClass().addClass("none_div");
						$($oli[n]).removeClass().addClass("show_div");
					});   
				});
				
				//党员新闻向上滚动
				$(".list_lh").myScroll({
					speed:40, //数值越大，速度越慢
					rowHeight:35 //li的高度
				});
				
				//动态公告向上滚动
				$(".helpMain").myScroll({
					speed:40, //数值越大，速度越慢
					rowHeight:60 //li的高度
				});
				
				//积分排行详细dialog_div
				$( "#dialog_integral" ).dialog({
					autoOpen: false,
					modal: true,
					title: "本月个人积分排行榜TOP&nbsp;10",
					show: "blind",
					hide: "explode",
					width: 700,
					height: 380,
					buttons : {
					"提交" : function (){
						
						},
					"关闭" : function (){
						$("#dialog_integral").dialog ("close");
					}}
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
					height: 380,
					buttons : {
					"提交" : function (){
						
						},
					"关闭" : function (){
						$("#dialog_time").dialog ("close");
					}}
				});
				//打开时长排行详细dialog_div
				$( "#open_time" ).click(function() {
					$( "#dialog_time" ).dialog( "open" );
					return false;
				});
				
				//柱形图dialog_div
				$( "#dialog_pillar" ).dialog({
					autoOpen: false,
					modal: true,
					title: "本月个人积分排行榜柱形图",
					show: "blind",
					hide: "explode",
					width: 700,
					height: 380,
					buttons : {
					"提交" : function (){
						
						},
					"关闭" : function (){
						$("#dialog_pillar").dialog ("close");
					}}
				});
				//打开柱形图dialog_div
				$( "#open_pillar" ).click(function() {
					$( "#dialog_pillar" ).dialog( "open" );
					return false;
				});
				
				//饼形图dialog_div
				$( "#dialog_pie" ).dialog({
					autoOpen: false,
					modal: true,
					title: "本月个人积分排行榜饼形图",
					show: "blind",
					hide: "explode",
					width: 700,
					height: 380,
					buttons : {
					"提交" : function (){
						
						},
					"关闭" : function (){
						$("#dialog_pie").dialog ("close");
					}}
				});
				//打开饼形图dialog_div
				$( "#open_pie" ).click(function() {
					$( "#dialog_pie" ).dialog( "open" );
					return false;
				});
				
				//时序图dialog_div
				$( "#dialog_series" ).dialog({
					autoOpen: false,
					modal: true,
					title: "本月个人积分排行榜时序图",
					show: "blind",
					hide: "explode",
					width: 700,
					height: 380,
					buttons : {
					"提交" : function (){
						
						},
					"关闭" : function (){
						$("#dialog_series").dialog ("close");
					}}
				});
				//打开时序图dialog_div
				$( "#open_series" ).click(function() {
					$( "#dialog_series" ).dialog( "open" );
					return false;
				});
				
			});
		</script>
    </head>
    
    <body>
    	 <div class="ol_div">
                    	<div class="serve-div">
                            <div class="title">志愿淘宝</div>
                            <div class="templatebg">
                            	<!-- 全部公益数据 -->
                            	<div class="data">
                                	<ul>
                                    	<li>历史善款总额：<font>${historySum}元</font></li>
                                        <li>本月善款总额：<font>${monthSum}元</font></li>
                                        <li>历史爱心总人数：<font>${peopleCount}人</font></li>
                                        <li>已实现项目总数：<font>${doneCount}个</font></li>
                                        <div class="clear"></div>
                                    </ul>
                                </div>
                            	<div class="serve_left">
                            	<!-- 已结束项目 -->
                            	<div class="finish">
                                	<div class="finish_title">
                                    	<b>已结束项目</b>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=2" target="_blank">更多</a>
                                    </div>
									<div id="loopPic" class="loopPic">   
                                        <ul>    
                                        <c:forEach items="${disablePage.list}" var="row">
                                            <li>
                                                <div class="matter_bg">
                                                    <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                                    	<img src="/images/default_logo.gif" border="0" width="90" height="90" />
                                                    </a>
                                                </div>
                                                <div class="finish_details">
                                                    <h4><a href="particular_finish.html" target="_blank">${row.title}</a></h4>
                                                    <div class="content">
                                                    	<div>
                                                            <div style="float:left;">捐款进度：</div>
                                                            <div class="proceed_div">
                                                                <div class="proceed_bg"></div>
                                                            </div>
                                                            (<font class="foncolor">${row.amount/row.targetamount}%</font>)
                                                        </div>
                                                        <div>
                                                            求助金额：<font class="foncolor">${row.targetamount}元</font>
                                                        </div>
                                                        <div>
                                                            截止日期：<font class="foncolor">${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }</font>
                                                        </div>
                                                    </div>
                                                    <div class="finishbutt">
                                                        <img src="/images/finishbutt.png" border="0" width="90" height="31" />
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </li>
                                            </c:forEach>
                                        </ul>  
                                </div>
                            	</div>
                                <!-- 捐助项目 -->
                                <%-- <div class="recommend">
                                	<div class="recommend_title">
                                    	<b>捐助项目</b>
                                        <a href="/zyztbitem/zyztbitemList_f.do" target="_blank">更多</a>
                                    </div>
									<div class="loopPic">   
                                        <ul>    
                                            <c:forEach items="${recommendPage.list}" var="row">
                                            <li>
                                                <div class="matter_bg">
                                                    <a href="particular.html" target="_blank">
                                                    	<img src="/images/default_logo.gif" border="0" width="90" height="90" />
                                                    </a>
                                                </div>
                                                <div class="finish_details">
                                                    <h4><a href="particular_finish.html" target="_blank">${row.title}</a></h4>
                                                    <div class="content">
                                                    	<div>
                                                            <div style="float:left;">捐款进度：</div>
                                                            <div class="proceed_div">
                                                                <div class="proceed_bg"></div>
                                                            </div>
                                                            (<font class="foncolor">${row.amount/row.targetamount}%</font>)
                                                        </div>
                                                        <div>
                                                            求助金额：<font class="foncolor">${row.targetamount}元</font>
                                                        </div>
                                                        <div>
                                                            截止日期：<font class="foncolor">${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }</font>
                                                        </div>
                                                    </div>
                                                    <div class="finishbutt">
                                                        <img src="/images/finishbutt.png" border="0" width="90" height="31" />
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </li>
                                            </c:forEach>
                                        </ul>  
                                	</div>
                            	</div> --%>
                                <!-- 服务项目 -->
                                <div class="begin">
                                	<div class="begin_title">
                                    	<b>捐助项目</b>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=1" target="_blank">更多</a>
                                    </div>
									<div id="loop" class="loopPic">   
                                        <ul>
                                         <c:forEach items="${enablePage.list}" var="row">
                                            <li>
                                                <div class="matter_bg">
                                                    <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                                    	<img src="/images/default_logo.gif" border="0" width="90" height="90" />
                                                    </a>
                                                </div>
                                                <div class="finish_details">
                                                    <h4><a href="particular_finish.html" target="_blank">${row.title}</a></h4>
                                                    <div class="content">
                                                    	<div>
                                                            <div style="float:left;">捐款进度：</div>
                                                            <div class="proceed_div">
                                                                <div class="proceed_bg"></div>
                                                            </div>
                                                            (<font class="foncolor">${row.amount/row.targetamount}%</font>)
                                                        </div>
                                                        <div>
                                                            求助金额：<font class="foncolor">${row.targetamount}元</font>
                                                        </div>
                                                        <div>
                                                            截止日期：<font class="foncolor">${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }</font>
                                                        </div>
                                                    </div>
                                                    <div class="finishbutt">
                                                        <img src="/images/finishbutt.png" border="0" width="90" height="31" />
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </li>
                                            </c:forEach>
                                        </ul>  
                                	</div>
                            	</div>
                                </div>
                                <div class="serve_right">
                                	<!-- 动态公告 -->
                                	<div class="benefit">
                                    	<div class="benefit_title">
                                        	<b>动态公告</b>
                                            <!-- <a href="/zyztbitem/zyztbitemList_f.do" target="_blank">更多</a> -->
                                        </div>
                                        <div class="helpMain">
                                        	<ul>
                                        	<c:forEach items="${recordPage.list}" var="row">
                                            	<li class="public_line">
                                                	<dl>
                                                    	<dt><img src="/images/default_logo.gif" /></dt>
                                                        <dd>
                                                        <div><span>
                                                        	<c:if test="${row.type==0 }">
                                                        	匿名
                                                        	</c:if>
                                                        	<c:if test="${row.type==1 }">
                                                        	${row.username }
                                                        	</c:if>
                                                        	</span></div>
                                                            <div>
                                                            	捐助了${row.amount}元给<span><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid }" target="_blank">${row.itemTitle}</a></span>项目     ${row.createdate.year+1900}-${row.createdate.month+1}-${row.createdate.date }
                                                            </div>
                                                        </dd>
                                                        <div class="clear"></div>
                                                    </dl>
                                                </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div class="clear" style="width:0px; height:0px; border:none;"></div>
    </body>
</html>
