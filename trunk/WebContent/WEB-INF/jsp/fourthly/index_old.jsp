<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>海珠区党员自愿者信息网</title>
        <!-- 首页样式 -->
        <link rel="stylesheet" href="/style/index_css.css">
        <!-- jquery 包 -->
        <script src="/js/jquery-1.6.4.min.js" type="text/javascript"></script>
        <!-- 党员动态 “党员新闻” 和 志愿淘宝 “动态公告” 向上滚动效果 js -->
        <script src="/js/scroll.js" type="text/javascript"></script>
        <!-- 志愿淘宝 “已完成项目”、“服务项目”向左滚动效果 js -->
        <script src="/js/index.js" type="text/javascript"></script>
        <script type="text/javascript" >
			$(document).ready(function(){
				//动态公告向上滚动
				$(".helpMain").myScroll({
					speed:40, //数值越大，速度越慢
					rowHeight:78 //li的高度
				});
				
			$('#loopF').kxbdMarquee({
				direction:'left',
				eventA:'mouseenter',
				eventB:'mouseleave'
			});
			
			$('#loopB').kxbdMarquee({
				direction:'left',
				eventA:'mouseenter',
				eventB:'mouseleave'
			});
			
			$('#loopS').kxbdMarquee({
				direction:'left',
				eventA:'mouseenter',
				eventB:'mouseleave'
			});
			});
		</script>
    </head>
    
    <body> 	
        <div class="templatebg">
            <!-- 全部公益数据 -->
            <div class="data">
                <ul>
                    <li>历史善款总额：<font title="${historySum}元">${historySum}元</font></li>
                    <li>本月善款总额：<font title="${monthSum}元">${monthSum}元</font></li>
                    <li>历史爱心总人次：<font title="${peopleCount}人/次">${peopleCount}人/次</font></li>
                    <li>已实现项目总数：<font title="${doneCount}人">${doneCount}个</font></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="serve_left">
                <!-- 已结束项目 -->
                <div class="finish">
                    <div class="finish_title">
                        <b>已结束项目</b>
                        <a href="/zyztbitem/zyztbitemList_f.do?status=2" target="_parent">更多</a>
                    </div>
                    <div id="loopF" class="loopPic">   
                        <ul>    
                            <c:forEach items="${disablePage.list}" var="row">
                                <li>
                                    <div class="matter_bg">
                                        <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                            <img src="${row.image}" border="0" width="90" height="90" />
                                        </a>
                                    </div>
                                    <div class="finish_details">
                                        <h4><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">${row.title}</a></h4>
                                        <div class="content">
                                            <%-- <div>
                                                <div style="float:left;">捐款进度：</div>
                                                <div class="proceed_div">
                                                    <div class="proceed_bg" ></div>
                                                </div>
                                                (<font class="foncolor">${row.processStr}%</font>)
                                            </div> --%>
                                            <c:if test="${row.type==2 }">
                                            <div><br/>
                                                	求助金额：<font class="foncolor">${row.targetamount}元</font>
                                            </div>
                                            </c:if>
                                             <c:if test="${row.type==1 }">
                                            <div>
                                            <br/>
                                            		招募人数：<font class="foncolor">
                                            		<fmt:formatNumber value="${row.targetamount}" pattern="#"/>人</font>
                                            </div>
                                            </c:if>
                                            <div>
                                                截止日期：<font class="foncolor">${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }</font>
                                            </div>
                                        </div>
                                        <div class="finishbutt">
                                        	<c:if test="${row.type==2 }">
                                            	<img src="/images/finishbutt.png" border="0" width="90" height="31" />
                                            </c:if>
                                            <c:if test="${row.type==1 }">
                                            	<img src="/images/applyEnd.png" border="0" width="90" height="31" />
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                            </c:forEach>
                        </ul>  
                    </div>
                </div>
                <!-- 捐助项目 -->
                <div class="begin">
                    <div class="begin_title">
                        <b>捐助项目</b>
                        <a href="/zyztbitem/zyztbitemList_f.do?status=1&type=2" target="_parent">更多</a>
                    </div>
                    <div id="loopB" class="loopPic">   
                        <ul>
                            <c:forEach items="${enablePage.list}" var="row">
                            <c:if test="${row.type==2 || row.type == 3}">
                                <li>
                                    <div class="matter_bg">
                                        <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                            <img src="${row.image}" border="0" width="90" height="90" />
                                        </a>
                                    </div>
                                    <div class="finish_details">
                                        <h4 title="${row.title}"><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">${row.title}</a></h4>
                                        <div class="content">
                                            <div>
                                            	<c:if test="${row.type == 2 }">
                                                <div style="float:left;">捐款进度：</div>
                                                </c:if>
                                                <c:if test="${row.type == 3 }">
                                                <div style="float:left;">捐赠进度：</div>
                                                </c:if>
                                                <div class="proceed_div">
                                                    <div class="proceed_bg" style="width:${row.processStr}%;"></div>
                                                </div>
                                                (<font class="foncolor">${row.processStr}%</font>)
                                            </div>
                                            <div>
                                            <c:if test="${row.type == 2 }">
                                                求助金额：<font class="foncolor">${row.targetamount}元</font>
                                                </c:if>
                                                <c:if test="${row.type == 3 }">
                                                	<br/>
                                                </c:if>
                                            </div>
                                            <div>
                                                截止日期：<font class="foncolor">${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }</font>
                                            </div>
                                        </div>
                                        <div class="finishbutt">
                                            <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                            	<img src="/images/beginbutt.png" border="0" width="90" height="31" />
                                            </a>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                                </c:if>
                            </c:forEach>
                        </ul>  
                    </div>
                </div>
                <!-- 服务项目 -->
                <div class="begin">
                    <div class="begin_title">
                        <b>服务项目</b>
                        <a href="/zyztbitem/zyztbitemList_f.do?status=1&type=1" target="_parent">更多</a>
                    </div>
                    <div id="loopS" class="loopPic">   
                        <ul>
                            <c:forEach items="${enablePage.list}" var="row">
                            <c:if test="${row.type==1}">
                                <li>
                                    <div class="matter_bg">
                                        <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                            <img src="${row.image}" border="0" width="90" height="90" />
                                        </a>
                                    </div>
                                    <div class="finish_details">
                                        <h4 title="${row.title}"><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">${row.title}</a></h4>
                                        <div class="content">
                                           <div>
                                                <div style="float:left;">招募进度：</div>
                                                <div class="proceed_div">
                                                    <div class="proceed_bg" style="width:${row.processStr}%;"></div>
                                                </div>
                                                (<font class="foncolor">${row.processStr}%</font>)
                                            </div>
                                            <div>
                                                招募人数：<font class="foncolor">
                                                <fmt:formatNumber value="${row.targetamount}" pattern="#"/>人</font>
                                            </div>
                                            <div>
                                                截止日期：<font class="foncolor">${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }</font>
                                            </div>
                                        </div>
                                        <div class="finishbutt">
                                            <a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" target="_blank">
                                            	<img src="/images/applyStart.png" border="0" width="90" height="31" />
                                            </a>
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                                </c:if>
                            </c:forEach>
                        </ul>  
                    </div>
                </div>
            </div>
            <div class="serve_right">
                <!-- 动态公告 -->
                <div class="benefit">
                    <div class="benefit_title">
                        <b>项目动态</b>
                        <!-- <a href="/zyztbitem/zyztbitemList_f.do" target="_blank">更多</a> -->
                    </div>
                    <div class="helpMain">
                        <ul>
                            <c:forEach items="${recordPage.list}" var="row">
                                <li class="public_line">
                                    <dl>
                                        <dt><img src="/images/default_logo.png" /></dt>
                                        <dd>
                                            <div>
                                                <span>
                                                    <c:if test="${row.type==0 }">
                                                       		 匿名
                                                    </c:if>
                                                    <c:if test="${row.type==1 }">
                                                        ${row.username }
                                                    </c:if>
                                                </span>
                                            </div>
                                            <c:if test="${row.itemType==2}">
                                            <div>
                                                承诺捐助了${row.amount}元给<span><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid }" target="_blank">${row.itemTitle}</a></span>项目     <br/>${row.createdate.year+1900}-${row.createdate.month+1}-${row.createdate.date }
                                            </div>
                                            </c:if>
                                            <c:if test="${row.itemType==1}">
                                            <div>
                                                承诺报名参加<span><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid }" target="_blank">${row.itemTitle}</a></span>项目     <br/>${row.createdate.year+1900}-${row.createdate.month+1}-${row.createdate.date }
                                            </div>
                                            </c:if>
                                            <c:if test="${row.itemType==3}">
                                            <div>
                                                承诺捐助<span><a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid }" target="_blank">${row.itemTitle}</a></span>项目     <br/>${row.createdate.year+1900}-${row.createdate.month+1}-${row.createdate.date }
                                            </div>
                                            </c:if>
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
    </body>
</html>
