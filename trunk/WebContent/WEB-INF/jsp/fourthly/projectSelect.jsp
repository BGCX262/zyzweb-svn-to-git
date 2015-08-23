<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="style/index_css.css">
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
        <title>捐款查询</title>
    </head>
    <!------------------------ 捐款查询页面 -------------------------------->
    <body class="body">
        <div id="main">
        	<!-- 头部 -->
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
                        	<!-- 捐助查询div -->
                            <div class="select-div">
                                <div id="jp-container" class="jp-container">
                                    <!-- 项目信息列表 -->
                                    <div class="selectBox">
                                        <div class="inquireBox">
                                            <div class="phoneSele">
                                                <form action="/zyztbrecord/zyztbrecordList.do?isfront=2" method="post">
                                                    <label>姓名</label><input type="text" class="selectTxt" name="username"/>
                                                    <label>手机号码</label><input type="text" class="selectTxt" name="phoneNo"/>
                                                    <label>身份证号码</label><input type="text" class="selectTxt" name="idcard"/>
                                                    <input type="submit" class="" value="查询"  />
                                                </form>
                                            </div>
                                            <div class="donationSelectList">
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td height="40" bgcolor="#F3F3F3">项目类型</td>
                                                        <td bgcolor="#F3F3F3">项目名称</td>
                                                        <td bgcolor="#F3F3F3">承诺捐助金额</td>
                                                        <td bgcolor="#F3F3F3">捐助/报名时间</td>
                                                        <td bgcolor="#F3F3F3">项目状态</td>
                                                    </tr>
                                                    <c:forEach items="${page.list}" var="row">
                                                        <tr>
                                                            <td height="35">
                                                            	<c:if test="${row.itemType==1}">
                                                                    服务项目
                                                                </c:if>
                                                                <c:if test="${row.itemType==2}">
                                                                    捐助项目
                                                                </c:if>
                                                                <c:if test="${row.itemType==3}">
                                                                    需求心愿
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                            	<a href="/zyztbitem/zyztbitemEdit.do?actiontype=view_f&itemid=${row.itemid}">${row.itemTitle }</a>
                                                            </td>
                                                            <td>
                                                            	<c:if test="${row.itemType==1}">
                                    		
                                                                </c:if>
                                                                <c:if test="${row.itemType==2}">
                                                                        ${row.amount }元
                                                                </c:if>
                                                                <c:if test="${row.itemType==3}">
                                                                        
                                                                </c:if>
                                                            </td>
                                                            <td>${row.createdate.year+1900}-${row.createdate.month+1}-${row.createdate.date }</td>
                                                            <td>
                                                            	<c:if test="${row.itemStatus==1 }">
                                                                    进行中
                                                                </c:if>
                                                                <c:if test="${row.itemStatus==2 }">
                                                                    已结束
                                                                </c:if>
                                                                <c:if test="${row.itemStatus==-1 }">
                                                                    已过期
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                            <!-- 分页 -->
                                            <!--<div style="width:200px; height:60px; line-height:60px;">分页</div>-->
                                        </div>
                                        <div class="clear"></div>
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
                            <div class="ATM-bg">
                                <img src="images/ATM_bg.png" border="0" width="106" height="73" />
                            </div>
                            <div class="nav">
                                <ul>
                                    <li>
                                    	<a href="/zyztbitem/zyztbitemIndex.do"><img src="images/index_butt.png" /></a>
                                    </li>
                                    <li style="margin-left:5px;">
                                    	<a href="/zyztbitem/zyztbitemList_f.do"><img src="images/donationitems_butt.png" /></a>
                                    </li>
                                    <li style="margin-left:5px;">
                                    	<a href="/zyztbrecord/zyztbrecordQueryInit.do"><img src="images/donationselect_butt.png" /></a>
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
