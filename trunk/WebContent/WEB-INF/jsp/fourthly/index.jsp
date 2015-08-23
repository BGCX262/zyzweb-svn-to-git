<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>海珠区党员志愿者信息网</title>
        <link rel="stylesheet" href="/style/index_css.css">
        <style type="text/css">
			.jp-container{width:678px; height:409px; position:relative;}
		</style>
        <link rel="stylesheet" type="text/css" href="style/jscrollpane2.css" />
        <script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>
        
        <!-- the mousewheel plugin -->
		<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
        <!-- the jScrollPane script -->
        <script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
        <script type="text/javascript" src="js/scroll-startstop.events.jquery.js"></script>
        <!-- 志愿淘宝 "已完成项目"、"服务项目"向左滚动效果 js -->
		<script src="js/index.js" type="text/javascript"></script>
        <script type="text/javascript" >
			$(document).ready(function(){				
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
    
    <body class="body">
    	<div id="main">
        	<div id="header">
            	<div class="top">
                	<!-- logo -->
            		<iframe src="header.html" width="950px" height="146px" frameborder="0" scrolling="no"></iframe>
                </div>
            </div>
            <!-- 志愿ATM-bg -->
            <div id="centre">
                <div class="frame">
                	<!-- 左 -->
                    <div class="frameLeft">
                        <div class="show-div">
                        	<div class="serve-div">
								<div id="jp-container" class="jp-container">
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
                                                                <div class="k">
                                                                    <div style="float:left;">捐款进度：</div>
                                                                    <div class="proceed_div">
                                                                        <div class="proceed_bg" style="width:${row.processStr}%;"></div>
                                                                    </div>
                                                                    (<font class="foncolor">${row.processStr}%</font>)
                                                                </div>
                                                                <div class="k">
                                                                <c:if test="${row.type == 2 }">
                                                                    求助金额：<font class="foncolor">${row.targetamount}元</font>
                                                                    </c:if>
                                                                    <c:if test="${row.type == 3 }">
                                                                        <br/>
                                                                    </c:if>
                                                                </div>
                                                                <div class="k">
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
                                                               <div class="k">
                                                                    <div style="float:left;">招募进度：</div>
                                                                    <div class="proceed_div">
                                                                        <div class="proceed_bg" style="width:${row.processStr}%;"></div>
                                                                    </div>
                                                                    (<font class="foncolor">${row.processStr}%</font>)
                                                                </div>
                                                                <div class="k">
                                                                    招募人数：<font class="foncolor">
                                                                    <fmt:formatNumber value="${row.targetamount}" pattern="#"/>人</font>
                                                                </div>
                                                                <div class="k">
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
                                <div class="clear"></div>
                            </div>
                        </div>
                        <script type="text/javascript">
							$(function() {
							
								// the element we want to apply the jScrollPane
								var $el					= $('#jp-container').jScrollPane({
									verticalGutter 	: -16
								}),
										
								// the extension functions and options 	
									extensionPlugin 	= {
										
										extPluginOpts	: {
											// speed for the fadeOut animation
											mouseLeaveFadeSpeed	: 500,
											// scrollbar fades out after hovertimeout_t milliseconds
											hovertimeout_t		: 1000,
											// if set to false, the scrollbar will be shown on mouseenter and hidden on mouseleave
											// if set to true, the same will happen, but the scrollbar will be also hidden on mouseenter after "hovertimeout_t" ms
											// also, it will be shown when we start to scroll and hidden when stopping
											useTimeout			: false,
											// the extension only applies for devices with width > deviceWidth
											deviceWidth			: 980
										},
										hovertimeout	: null, // timeout to hide the scrollbar
										isScrollbarHover: false,// true if the mouse is over the scrollbar
										elementtimeout	: null,	// avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar
										isScrolling		: false,// true if scrolling
										addHoverFunc	: function() {
											
											// run only if the window has a width bigger than deviceWidth
											if( $(window).width() <= this.extPluginOpts.deviceWidth ) return false;
											
											var instance		= this;
											
											// functions to show / hide the scrollbar
											$.fn.jspmouseenter 	= $.fn.show;
											$.fn.jspmouseleave 	= $.fn.fadeOut;
											
											// hide the jScrollPane vertical bar
											var $vBar			= this.getContentPane().siblings('.jspVerticalBar').hide();
											
											/*
											 * mouseenter / mouseleave events on the main element
											 * also scrollstart / scrollstop - @James Padolsey : http://james.padolsey.com/javascript/special-scroll-events-for-jquery/
											 */
											$el.bind('mouseenter.jsp',function() {
												
												// show the scrollbar
												$vBar.stop( true, true ).jspmouseenter();
												
												if( !instance.extPluginOpts.useTimeout ) return false;
												
												// hide the scrollbar after hovertimeout_t ms
												clearTimeout( instance.hovertimeout );
												instance.hovertimeout 	= setTimeout(function() {
													// if scrolling at the moment don't hide it
													if( !instance.isScrolling )
														$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
												}, instance.extPluginOpts.hovertimeout_t );
												
												
											}).bind('mouseleave.jsp',function() {
												
												// hide the scrollbar
												if( !instance.extPluginOpts.useTimeout )
													$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
												else {
												clearTimeout( instance.elementtimeout );
												if( !instance.isScrolling )
														$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
												}
												
											});
											
											if( this.extPluginOpts.useTimeout ) {
												
												$el.bind('scrollstart.jsp', function() {
												
													// when scrolling show the scrollbar
													clearTimeout( instance.hovertimeout );
													instance.isScrolling	= true;
													$vBar.stop( true, true ).jspmouseenter();
													
												}).bind('scrollstop.jsp', function() {
													
													// when stop scrolling hide the scrollbar (if not hovering it at the moment)
													clearTimeout( instance.hovertimeout );
													instance.isScrolling	= false;
													instance.hovertimeout 	= setTimeout(function() {
														if( !instance.isScrollbarHover )
															$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
													}, instance.extPluginOpts.hovertimeout_t );
													
												});
												
												// wrap the scrollbar
												// we need this to be able to add the mouseenter / mouseleave events to the scrollbar
												var $vBarWrapper	= $('<div/>').css({
													position	: 'absolute',
													left		: $vBar.css('left'),
													top			: $vBar.css('top'),
													right		: $vBar.css('right'),
													bottom		: $vBar.css('bottom'),
													width		: $vBar.width(),
													height		: $vBar.height()
												}).bind('mouseenter.jsp',function() {
													
													clearTimeout( instance.hovertimeout );
													clearTimeout( instance.elementtimeout );
													
													instance.isScrollbarHover	= true;
													
													// show the scrollbar after 100 ms.
													// avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar								
													instance.elementtimeout	= setTimeout(function() {
														$vBar.stop( true, true ).jspmouseenter();
													}, 100 );	
													
												}).bind('mouseleave.jsp',function() {
													
													// hide the scrollbar after hovertimeout_t
													clearTimeout( instance.hovertimeout );
													instance.isScrollbarHover	= false;
													instance.hovertimeout = setTimeout(function() {
														// if scrolling at the moment don't hide it
														if( !instance.isScrolling )
															$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
													}, instance.extPluginOpts.hovertimeout_t );
													
												});
												
												$vBar.wrap( $vBarWrapper );
											
											}
										
										}
										
									},
									
									// the jScrollPane instance
									jspapi 			= $el.data('jsp');
									
								// extend the jScollPane by merging	
								$.extend( true, jspapi, extensionPlugin );
								jspapi.addHoverFunc();
							
							});
						</script>
                    </div>
                    <!-- 右 -->
                    <div class="frameRight">
                        <div class="box-div">
                        	<!-- 志愿ATM图标 -->
                            <div class="ATM-bg">
                                <img src="/images/ATM_bg.png" border="0" width="106" height="73" />
                            </div>
                            <!-- 导航按钮 -->
                            <div class="nav">
                                <ul>
                                    <li>
                                    	<a href="/zyztbitem/zyztbitemIndex.do"><img src="/images/index_butt.png" /></a>
                                    </li>
                                    <li style="margin-left:5px;">
                                    	<a href="/zyztbrecord/zyztbrecordList.do?isfront=1"><img src="/images/donationitems_butt.png" /></a>
                                    </li>
                                    <li style="margin-left:5px;">
                                    	<a href="/zyztbrecord/zyztbrecordQueryInit.do"><img src="/images/donationselect_butt.png" /></a>
                                    </li>
                                    <div class="clear"></div>
                                </ul>
                            </div>
                            <!-- 搜索框 -->
                            <!--<div class="inquire-div">
                                <div class="inquireBG">
                                    <form>
                                        <input type="text" class="textinqu" />
                                        <input type="submit" class="subinqu" value="" />
                                        <div class="clear"></div>
                                    </form>
                                </div>
                            </div>-->
                            <!-- 数字按钮 -->
                            <div class="operation-div">
                                <ul>
                                	<c:if test="${status==0 }">
                                    	<!-- 项目列表 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do"  <c:if test="${type==0}">class="pitchon"</c:if>><img src="images/itemList.png" /></a></li>
                                        <!-- 项目服务 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?type=1"<c:if test="${type==1}">class="pitchon"</c:if>><img src="images/serveItem.png" /></a></li>
                                    </c:if>
                                    <c:if test="${status==1 }">
                                    	<!-- 项目列表 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do"  <c:if test="${type==0}">class="pitchon"</c:if>><img src="images/itemList.png" /></a></li>
                                        <!-- 项目服务 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?status=1&type=1"<c:if test="${type==1}">class="pitchon"</c:if>><img src="images/serveItem.png" /></a></li>
                                    </c:if>
                                    <c:if test="${status==2 }">
                                    	<!-- 项目列表 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do"  <c:if test="${type==0}">class="pitchon"</c:if>><img src="images/itemList.png" /></a></li>
                                        <!-- 项目服务 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?status=2&type=1"<c:if test="${type==1}">class="pitchon"</c:if>><img src="images/serveItem.png" /></a></li>
                                        
                                    </c:if>
                                    <div class="clear"></div>
                                </ul>
                                <ul>
                                	<c:if test="${status==0 }">
                                    	<!-- 捐款项目 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?type=2"<c:if test="${type==2}">class="pitchon"</c:if>><img src="images/donaItem.png" /></a></li>
                                        <!-- 需求心愿 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?type=2"<c:if test="${type==3}">class="pitchon"</c:if>><img src="images/demand.png" /></a></li>
                                    </c:if>
                                    <c:if test="${status==1 }">
										<!-- 捐款项目 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?status=1&type=2"<c:if test="${type==2}">class="pitchon"</c:if>><img src="images/donaItem.png" /></a></li>
                                        <!-- 需求心愿 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?status=1&type=3"<c:if test="${type==3}">class="pitchon"</c:if>><img src="images/demand.png" /></a></li>
                                    </c:if>
                                    <c:if test="${status==2 }">
                                        <!-- 捐款项目 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?status=2&type=2"<c:if test="${type==2}">class="pitchon"</c:if>><img src="images/donaItem.png" /></a></li>
                                        <!-- 需求心愿 -->
                                        <li><a href="/zyztbitem/zyztbitemList_f.do?status=2&type=3"<c:if test="${type==3}">class="pitchon"</c:if>><img src="images/demand.png" /></a></li>
                                    </c:if>
                                    <div class="clear"></div>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <!-- 底部 -->
            <div id="footer">
            	<iframe src="footer.html" width="860px" height="80px" frameborder="0" scrolling="no"></iframe>
            </div>
        </div>
    </body>
</html>
 