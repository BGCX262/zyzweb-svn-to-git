<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="/style/list.css">
        <title>志愿ATM公益项目列表</title>
    </head>
    
    <body>
        <div id="main">
        	<!-- 页头 -->
        	<div id="header">
            	<!-- logo -->
            	<div class="logo">logo</div>
                <!-- 导航条 -->
                <div class="nav">
                	<ul>
                    	<li class="nline"></li>
                    	<li class="navli"><a href="/index.html" >首页</a></li>
                        <li class="pline"></li>
                        <li><a href="/zyztbitem/zyztbitemList_f.do" class="npitchon">项目列表</a></li>
                        <li class="pline"></li>
                        <li class="navli"><a href="/zyztbrecord/zyztbrecordQueryInit.do">项目查询</a></li>
                        <li class="nline"></li>
                        <li class="navli"><a href="/zyztbrecord/zyztbrecordList.do?isfront=1">项目动态</a></li>
                        <li class="nline"></li>
                        <div class="clear"></div>
                    	<!--<li><a href="/zyztbitem/zyztbitemIndex.do">首页</a></li>
                        <li><a href="/zyztbitem/zyztbitemList_f.do" class="action">捐款项目</a></li>-->
                        <!-- <li><a href="projectSelect.html">捐款查询</a></li>
                        <li><a href="benefitList.html">动态公告</a></li> -->
                        <div class="clear"></div>
                    </ul>
                </div>
                
                <div class="navline"></div>
            </div>
            <!-- 中部 -->
            <div id="centre">
            	<!-- 您的位置 -->
                <div class="location">
                	您的位置：<a href="/index.html">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
                    		<span>项目列表</span>
                </div>
                <div class="mainBox">
                	<!-- 左 -->
                	<div class="proceL">
                    	<!-- 项目分类 -->
                    	<div class="proclassify">
                        	<div class="category_title">捐助项目</div>
                        	<ul class="options">
                        		<c:if test="${status==0 }">
                            	<li><a href="/zyztbitem/zyztbitemList_f.do"  <c:if test="${type==0}">class="pitchon"</c:if>>全部项目信息</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?type=1"<c:if test="${type==1}">class="pitchon"</c:if>>服务项目</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?type=2"<c:if test="${type==2}">class="pitchon"</c:if>>捐助项目</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?type=2"<c:if test="${type==3}">class="pitchon"</c:if>>需求心愿</a></li>
                                </c:if>
                                <c:if test="${status==1 }">
                            	<li><a href="/zyztbitem/zyztbitemList_f.do"  <c:if test="${type==0}">class="pitchon"</c:if>>全部项目信息</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?status=1&type=1"<c:if test="${type==1}">class="pitchon"</c:if>>服务项目</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?status=1&type=2"<c:if test="${type==2}">class="pitchon"</c:if>>捐助项目</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?status=1&type=3"<c:if test="${type==3}">class="pitchon"</c:if>>需求心愿</a></li>
                                </c:if>
                                <c:if test="${status==2 }">
                            	<li><a href="/zyztbitem/zyztbitemList_f.do"  <c:if test="${type==0}">class="pitchon"</c:if>>全部项目信息</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?status=2&type=1"<c:if test="${type==1}">class="pitchon"</c:if>>服务项目</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?status=2&type=2"<c:if test="${type==2}">class="pitchon"</c:if>>捐助项目</a></li>
                                <li><a href="/zyztbitem/zyztbitemList_f.do?status=2&type=3"<c:if test="${type==3}">class="pitchon"</c:if>>需求心愿</a></li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                    <!-- 右 -->
                    <div class="proceR">
                    	<div class="proList">
                        	<!-- 项目查找div -->
                            <div class="find">
                            	<ul>
                                	<!-- <li class="findTop">
                                    	<form>
                                            <em>求助时间</em>
                                            <input type="text" class="date_text" />&nbsp;&nbsp;-&nbsp;&nbsp;<input type="text" class="date_text" />
                                            <input type="text" class="keyword_text" />
                                            <input type="submit" value="" class="seek" />
                                        </form>
                                    </li> -->
                                    <li class="findTop mt">
                                    	<em>状态</em>
                                    	<c:if test="${type==0}">
                                        <a href="/zyztbitem/zyztbitemList_f.do" <c:if test="${status==0}">style="background-color: lightgreen"</c:if>>全部</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=1" <c:if test="${status==1}">style="background-color: lightgreen"</c:if>>进行中</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=2" <c:if test="${status==2}">style="background-color: lightgreen"</c:if>>已结项</a>
                                        </c:if>
                                        <c:if test="${type==1}">
                                        <a href="/zyztbitem/zyztbitemList_f.do?type=1" <c:if test="${status==0}">style="background-color: lightgreen"</c:if>>全部</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=1&type=1" <c:if test="${status==1}">style="background-color: lightgreen"</c:if>>进行中</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=2&type=1" <c:if test="${status==2}">style="background-color: lightgreen"</c:if>>已结项</a>
                                        </c:if>
                                        <c:if test="${type==2}">
                                        <a href="/zyztbitem/zyztbitemList_f.do?type=2" <c:if test="${status==0}">style="background-color: lightgreen"</c:if>>全部</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=1&type=2" <c:if test="${status==1}">style="background-color: lightgreen"</c:if>>进行中</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=2&type=2" <c:if test="${status==2}">style="background-color: lightgreen"</c:if>>已结项</a>
                                        </c:if>
                                        <c:if test="${type==3}">
                                        <a href="/zyztbitem/zyztbitemList_f.do?type=3" <c:if test="${status==0}">style="background-color: lightgreen"</c:if>>全部</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=1&type=3" <c:if test="${status==1}">style="background-color: lightgreen"</c:if>>进行中</a>
                                        <a href="/zyztbitem/zyztbitemList_f.do?status=2&type=3" <c:if test="${status==2}">style="background-color: lightgreen"</c:if>>已结项</a>
                                        </c:if>
                                    </li>
                                    <!-- <li class="findTop">
                                    	<span>项目查询结果</span>
                                        <span style="margin-left:395px;">
                                        	排序方式：<a href="javascript:void(0);" style="color:#666;">开始时间</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                            		<a href="javascript:void(0);" style="color:#666;">结束时间</a>
                                        </span>
                                    </li> -->
                                </ul>
                            </div>
                            <!-- 项目列表div -->
                            <div class="items">
                                	<c:forEach items="${page.list}" var="row">
                            	<div class="itemBox">
                                        <div class="itemImg">
                                        	<img src="${row.image }" width="131" height="131" />
                                        </div>
                                        <div class="recordTxt">
                                            <ul>
                                            	<li class="reco_1"><a href="zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}">${row.title }</a></li>
                                                <li>
                                                	<b>简介：</b>${row.remark }
                                                </li>
                                                <li class="reco_2">
                                                    <%-- <span>发起人：</span><span class="co_1">${row.title }</span> --%>
                                                    <span>救助对象：</span><span class="co_1">${row.targetname }</span>
                                                </li>
                                                <li class="reco_2">
                                                <c:if test="${row.type==2 }">
                                                    <span>目标金额：</span><span class="co_2">${row.targetamount }</span>元
                                                    <span style="margin-left:80px;">已捐助：</span><span class="co_2">${row.amount }</span>元
                                                    <span style="margin-left:80px;">缺口金额：</span><span class="co_2">${row.targetamount-row.amount}</span>元
                                                    </c:if>
                                                    <c:if test="${row.type==1 }">
                                                    <span>招募人数：</span><span class="co_2"><fmt:formatNumber value="${row.targetamount }" pattern="#"/></span>人
                                                    <span style="margin-left:80px;">已招募：</span><span class="co_2"><fmt:formatNumber value="${row.amount }" pattern="#"/></span>人
                                                    <span style="margin-left:80px;">缺口人数：</span><span class="co_2"><fmt:formatNumber value="${row.targetamount-row.amount}" pattern="#"/></span>人
                                                    </c:if>
                                                    <c:if test="${row.type==3 }">
                                                    	<span>需求数量：</span><span class="co_2"><fmt:formatNumber value="${row.targetamount }" pattern="#"/></span>
                                                    <span style="margin-left:80px;">已捐赠：</span><span class="co_2"><fmt:formatNumber value="${row.amount }" pattern="#"/></span>
                                                    <span style="margin-left:80px;">缺口：</span><span class="co_2"><fmt:formatNumber value="${row.targetamount-row.amount}" pattern="#"/></span>
                                                    </c:if>
                                                </li>
                                                <li class="reco_2">
                                                    <span>捐助状态：
                                                        <c:choose>
                                                            <c:when test="${row.status==2}">
                                                            	<c:out value="结束"/>
                                                            </c:when>
                                                            <c:when test="${row.status==1}">
                                                            	<c:out value="可用"/>
                                                            </c:when>  
                                                            <c:otherwise>  
                                                            	<c:out value="过期"/>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </span>
                                                </li>
                                                <li class="reco_2">
                                                	<span>爱心积分：${row.score }</span>
                                                </li>
                                                <li class="reco_2">
                                                    <span>求助时间：
                                                        <span class="co_1">
                                                        	${row.createtime.year+1900}-${row.createtime.month+1}-${row.createtime.date }~~
                                                        	${row.deadline.year+1900}-${row.deadline.month+1}-${row.deadline.date }
                                                        </span>
                                                    </span>
                                                </li>
                                                <li class="reco_2">
                                                <c:if test="${row.status==1 }">
                                                	<c:if test="${row.type==1 }">
                                                	<a href="zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" class="applyStartButt"></a>
                                                	</c:if>
                                                	<c:if test="${row.type==2 }">
                                                	<a href="zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" class="donationButt"></a>
                                                	</c:if>
                                                </c:if>
                                                <c:if test="${row.status==2 }">
                                                	<c:if test="${row.type==1 }">
                                                	<a href="zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" class="applyEndButt"></a>
                                                	</c:if>
                                                	<c:if test="${row.type==2 }">
                                                	<a href="zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}" class="finishButt"></a>
                                                	</c:if>
                                                </c:if>
                                                </li>
                                            </ul>
                                        </div>
                                    	<div class="clear"></div>
                                </div>
                                    </c:forEach>
                            </div>
                            <!-- 分页 -->
                            <!-- <div style="width:200px; height:60px; line-height:60px;">分页</div> -->
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <!-- 页脚 -->
            <div id="footer">
            	<div class="fotter_div">
                	<!-- <div>广州市发展志愿服务事业知道委员会广州市住院者行动指导中心版权所有粤ICP备11019788号</div>
                    <div>地址: 广州市越秀区人民北路875号4楼 邮编:510170 志愿时网站投稿邮箱：gz125cn@sina.com；广州青年志愿者协会邮箱：gz0529@126.com</div> -->
                </div>
            </div>
        </div>
    </body>
</html>
