<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="/style/index_css.css">
        <style type="text/css">
			.jp-container{width:678px; height:409px; position:relative;}
		</style>
        <link rel="stylesheet" type="text/css" href="/style/jscrollpane2.css" />
        <script src="/js/jquery-1.6.4.min.js" type="text/javascript"></script>
        <!-- the mousewheel plugin -->
		<script type="text/javascript" src="/js/jquery.mousewheel.js"></script>
        <!-- the jScrollPane script -->
        <script type="text/javascript" src="/js/jquery.jscrollpane.min.js"></script>
        <script type="text/javascript" src="/js/scroll-startstop.events.jquery.js"></script>
        <script type="text/javascript">
        	function check(){
				var phoneanId=$("#phoneanId");
				var ph = /^13[0-9]{9}|15[012356789][0-9]{8}|18[0256789][0-9]{8}|147[0-9]{8}$/;
				if(phoneanId.val()==""){
					alert("请输入手机号码");
					return false;
				}else if(!ph.test($("#phoneanId").val())){
					alert("输入的手机号码格式不正确");
					return false;
				}
				var nameId=$("#nameId");
				if(nameId.val()==""){
					alert("请输入姓名");
					return false;
				}
				var identityId=$("#identityId");
				var iden = /^[1-9]([0-9]{14}|[0-9]{17})$/;
				if(identityId.val()==""){
					alert("请输入身份证号码");
					return false;
				}else if(!iden.test($("#identityId").val())){
					alert("输入的身份证号码格式不正确");
					return false;
				}
				var emailId=$("#emailId");
				var email = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/;
				if(emailId.val()!=""){
					if(!email.test($("#emailId").val())){
						alert("输入的E-mail格式不正确");
						return false;
					}
				}
				<c:if test="${zyztbitem.type==2 || zyztbitem.type==3}">
        		var amountId=$("#amount");
				var figure = /^[1-9]\d*$/;	//数字
				if(amountId.val()!=""){
					if(!figure.test(amountId.val())){
						alert("输入的金额不正确，请输入正确的数字");
						return false;
					}else if(amountId.val() <= 0.01 || amountId.val() > ${zyztbitem.targetamount-zyztbitem.amount}){
						alert("已超出可捐助范围");
						return false;
					}else if(amountId.val() <= 0){
						alert("输入的金额不能小于0");
						return false;	
					}
				}else{
					alert("请输入输入捐助金额");
					return false;		
				}
				</c:if>

        		$('#amount').attr('disabled',false);
				return true;	
			}
        </script>
        <title>项目_正文</title>
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
                        	<!-- 项目正文内容div -->
                            <div class="details-div">
                                <div id="jp-container" class="jp-container">
                                	<!-- 标头 -->
                                    <div class="details_title">
                                        <div class="detImgL">
                                        	<p><img src="${zyztbitem.image }" /></p>
                                        </div>
                                        <div class="dettxtR">
                                            <div class="detitem">
                                            	<p class="titlePart"><b>${zyztbitem.title}</b></p>
                                                <p>发起时间：<span class="co_1">${zyztbitem.createtime.year+1900}-${zyztbitem.createtime.month+1}-${zyztbitem.createtime.date }--
                            ${zyztbitem.deadline.year+1900}-${zyztbitem.deadline.month+1}-${zyztbitem.deadline.date }</span></p>
                            					<c:if test="${zyztbitem.type==2 }">
					                            <p>求助对象: <span class="co_1">${zyztbitem.targetname}</span></p>
					                            <p>目标金额：<span class="co_2">${zyztbitem.targetamount}元</span></p>
					                            <p>已&nbsp;&nbsp;捐&nbsp;&nbsp;助：<span class="co_2">${zyztbitem.amount}元</span></p>
					                            <p>缺口金额：<span class="co_2">${zyztbitem.targetamount-zyztbitem.amount}元</span></p>
					                            </c:if>
					                            <c:if test="${zyztbitem.type==3 }">
					                            <p>求助对象: <span class="co_1">${zyztbitem.targetname}</span></p>
					                            <p>数量：<span class="co_2">${zyztbitem.targetamount}</span></p>
					                            <p></p>
					                            <p></p>
					                            </c:if>
					                            <c:if test="${zyztbitem.type==1 }">
					                            <p>服务对象: <span class="co_1">${zyztbitem.targetname}</span></p>
					                            <p>招募人数：<span class="co_2">${zyztbitem.targetamount}人</span></p>
					                            <p>已&nbsp;&nbsp;招&nbsp;&nbsp;募：<span class="co_2">${zyztbitem.amount}人</span></p>
					                            <p>缺口人数：<span class="co_2">${zyztbitem.targetamount-zyztbitem.amount}人</span></p>
					                            </c:if>
								                                                状态：
															<c:choose>
																<c:when test="${zyztbitem.status==2}">
																	<c:out value="结束" />
																</c:when>
																<c:when test="${zyztbitem.status==1}">
																	<c:out value="可用" />
																</c:when>
																<c:otherwise>
																	<c:out value="过期" />
																</c:otherwise>
															</c:choose>
                                                <p><c:if test="${zyztbitem.type == 2 }">
                                               <p>捐款进度：</p>
                                                </c:if>
                            <c:if test="${zyztbitem.type == 3 }">
                                               <p>捐赠进度：</p>
                                                </c:if></p>
                                                <div class="schedule_div">
                                                    <div class="plan">
                                                    	<div class="progress" style="width:${zyztbitem.processStr}%;"></div>
                                                    </div>
                                                	<div class="barTxt">${zyztbitem.processStr}%</div>
                                                	<div class="clear"></div>
                                                </div>
                                                <p style="margin-top:10px;">
					                				<c:if test="${zyztbitem.status == 1 }">
					                					<c:if test="${zyztbitem.type==2 || zyztbitem.type==3}">
						                              	  <a href="#my" class="donationButt"></a>
						                              	</c:if>
						                              	<c:if test="${zyztbitem.type==1}">
						                              	  <a href="#my" class="donationButt" style="background:url(../images/applyStart.png);"></a>
						                              	</c:if>
					                                </c:if>
					                                <!-- <a href="#me" class="cheerButt"></a> -->
					                            </p>
                                            </div>
                                        </div>
                                    	<div class="clear"></div>
                                    </div>
                                	<!-- 内容 -->
                                    <div class="infoItem-div">
                                        <p style="text-indent:35px;overflow:auto;">
                                        	${zyztbitem.content}
                                        </p>
                                    </div>
                                	<!-- 我要捐款div -->
				                	<c:if test="${zyztbitem.status == 1 }">
				                    <div class="donation" id="my">
				                    <c:if test="${zyztbitem.type==2}">
				                        <div class="titleBox">我要捐助</div>
				                        </c:if>
				                        <c:if test="${zyztbitem.type==1}">
				                        <div class="titleBox">我要报名</div>
				                        </c:if>
				                        <div class="donationInfo">
				                            <form action="/zyztbrecord/zyztbrecordSave.do" method="post" onsubmit="return check()">
				                            <input type="hidden" name="itemid" value="${zyztbitem.itemid}"/>
				                             <input type="hidden" name="actiontype" value="add"/>
				                             <%-- <c:if test="${zyztbitem.type==2}"> --%>
				                                <div class="radio_div">
				                                    <label> 请选择：</label>
				                                    <input class="radio_inp an" name="type"  type="radio" value="0" rel="div1" />匿名
				                                    <input class="radio_inp au" name="type" type="radio" value="1" rel="div2" checked="checked"/>实名
				                                </div>
				                                <%-- </c:if> --%>
				                                <!-- 匿名捐赠text -->
				                                <div id="div1" class="anonymity show_div">
				                                    <div class="phonean">
				                                        <label>手机号码：</label>
				                                        <input type="text" id="phoneanId" class="text_inp" name="phoneNo"/>
				                                        <span>&nbsp;<!-- 温馨提示：手机号码是匿名捐赠者用于接收捐款信息,建议填写 --></span>
				                                    </div>
				                                     <div class="phonean">
				                                        <label>我的姓名：</label>
				                                        <input type="text" id="nameId" class="text_inp" name="username"/>
				                                        <div class="clear"></div>
				                                    </div>
				                                </div>
				                                <!-- 实名捐赠text -->
				                                <div id="div2" class="autonym show_div">
				                                    <div class="identityau">
				                                        <label>身份证号码：</label>
				                                        <input type="text" id="identityId" class="text_inp" name="idcard"/>
				                                    </div>
				                                    <div class="emailau">
				                                        <label>E-Mail：</label>
				                                        <input type="text" class="text_inp" name="eMail" id="emailId"/>
				                                    </div>
				                                    <div class="phonean">
				                                        <label>工作单位：</label>
				                                        <input type="text" class="text_inp" name="workplace"/>
				                                    </div>
				                                </div>
				                                <c:if test="${zyztbitem.type==2}">
				                                <div class="radio_div">
				                                      <label>承诺捐助：</label>
				                                      <input name="rdoamount" checked="checked" type="radio" value="50" class="radio_inp rad_1" />50元
				                                      <input name="rdoamount" type="radio" value="100" class="radio_inp rad_1" />100元
				                                      <input name="rdoamount" type="radio" value="150" class="radio_inp rad_1" />150元
				                                      <input name="rdoamount" type="radio" value="200" class="radio_inp rad_1" />200元
				                                      <input name="rdoamount" type="radio" value="" class="radio_inp rad_2" />其他金额
				                                      <input type="text" value="50" class="else" name="amount" id="amount"/>&nbsp;元
				                                      <span style="color:#F00;">&nbsp;&nbsp;</span> 
				                                      <script type="text/javascript">
				                                      	$(function(){
				                                      		$('#amount').attr('disabled','disabled');
				                                      		$('.rad_1').click(function(){
				                                      			$('#amount').val($(this).val());
				                                      			$('#amount').attr('disabled','disabled');
				                                      		})
				                                      		$('.rad_2').click(function(){
				                                      			$('#amount').val('');
				                                      			$('#amount').attr('disabled',false);
				                                      		})
				                                      	})
				                                      </script>
				                                </div>
				                                </c:if>
				                                 <c:if test="${zyztbitem.type==1 || zyztbitem.type == 3}">
				                                 	<input type="hidden" value="1" class="else" name="amount" id="amount"/>
				                                 </c:if>
				                              <!--  <div class="textarea_inp">
				                                    <label>我的祝福：</label>
				                                    <textarea name="wish" style="margin: 0px; width: 525px; height: 85px;"></textarea>
				                                </div> -->
				                                <div style="margin-top:20px;">
				                                <label class="lab">&nbsp;</label>
				                                <!-- <input type="checkbox" name="unpublic" class="radiow radio1" value="1">&nbsp;不公开捐赠金额 -->
				                                </div>
				                               <!--  <div style="margin-top:20px;">
				                                    <label class="lab">&nbsp;</label>
				                                    <a href="javascript:void(0);" class="nextstep"></a>
				                                </div> -->
				                                	<input type="submit" value="" class="nextstep" style="background-position:-2px"/>
				                            </form>
				                        </div>
				                    </div>
				                    </c:if>
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
                                <img src="/images/ATM_bg.png" border="0" width="106" height="73" />
                            </div>
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
            <div id="footer">
            	<iframe src="footer.html" width="860px" height="80px" frameborder="0" scrolling="no"></iframe>
            </div>
        </div>
    </body>
</html>
 