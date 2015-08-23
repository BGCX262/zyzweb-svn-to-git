<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>  
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="/style/particular.css">
        <!-- jquery 包 -->
        <script src="/js/jquery-1.6.4.min.js" type="text/javascript"></script>
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
        <title>志愿ATM公益项目</title>
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
                	您的位置：<a href="/">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
                    		<a href="/zyztbitem/zyztbitemList_f.do">项目列表</a>&nbsp;&nbsp;>&nbsp;&nbsp;
                            <span>${zyztbitem.title}</span>
                </div>
                <!-- 项目正文内容div -->
                <div class="details_div">
                    <div class="details_title">
                        <div class="detImgL">
                            <img src="${zyztbitem.image }" />
                        </div>
                        <div class="dettxtR">
                            <p><b>${zyztbitem.title}</b></p>
                            <p>发起时间： 
							${zyztbitem.createtime.year+1900}-${zyztbitem.createtime.month+1}-${zyztbitem.createtime.date }~
                            ${zyztbitem.deadline.year+1900}-${zyztbitem.deadline.month+1}-${zyztbitem.deadline.date }
							</p>
                            <c:if test="${zyztbitem.type==2 }">
                            <p>求助对象: ${zyztbitem.targetname}</p>
                            <p>目标金额：${zyztbitem.targetamount}元</p>
                            <p>已&nbsp;&nbsp;捐&nbsp;&nbsp;助：${zyztbitem.amount}元</p>
                            <p>缺口金额：${zyztbitem.targetamount-zyztbitem.amount}元</p>
                            </c:if>
                            <c:if test="${zyztbitem.type==3 }">
                            <p>求助对象: ${zyztbitem.targetname}</p>
                            <p>数量: <fmt:formatNumber value="${zyztbitem.targetamount}" pattern="#"/></p>
                            <p></p>
                            <p></p>
                            </c:if>
                            <c:if test="${zyztbitem.type==1 }">
                            <p>服务对象: ${zyztbitem.targetname}</p>
                            <p>招募人数：<fmt:formatNumber value="${zyztbitem.targetamount}" pattern="#"/>人</p>
                            <p>已&nbsp;&nbsp;招&nbsp;&nbsp;募：<fmt:formatNumber value="${zyztbitem.amount}" pattern="#"/>人</p>
                            <p>缺口人数：<fmt:formatNumber value="${zyztbitem.targetamount-zyztbitem.amount}" pattern="#"/>人</p>
                            </c:if>
                            <p>状态：
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
						</p>
						
						<c:if test="${zyztbitem.type==2||zyztbitem.type==3 }">
								<c:if test="${zyztbitem.type == 2 }">
                                               <p>捐款进度：</p>
                                                </c:if>
                            <c:if test="${zyztbitem.type == 3 }">
                                               <p>捐赠进度：</p>
                                                </c:if>
                            
                            <div class="schedule_div">
                                <div class="plan">
                                    <div class="progress" style="width:${zyztbitem.processStr}%;"></div>
                                </div>
                                <div class="barTxt">${zyztbitem.processStr}%</div>
                            </div>
                            </c:if>
                            
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
                        <div class="clear"></div>
                    </div>
                    <div class="infoItem">
                    	<p>${zyztbitem.content}</p>
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
                                <div style="margin-top:20px;">
                                <label class="lab">&nbsp;</label>
                                <!-- <input type="checkbox" id="checkId" name="donationAgreement" value="1" checked="checked">&nbsp;我已阅读 <a href="javascript:void(0);"><<捐赠协议>></a> -->  
                                </div>
                               <!--  <div style="margin-top:20px;">
                                    <label class="lab">&nbsp;</label>
                                    <a href="javascript:void(0);" class="nextstep"></a>
                                </div> -->
                                <input type="submit" value="" class="submitbutt"/>
                            </form>
                        </div>
                    </div>
                    </c:if>
                	<!-- 加油打气div -->
                    <!-- <div class="comentBox" id="me">
                        <div class="titleBox">加油打气</div>
                        <div class="comentMain">
                            <ul>
                                <li>
                                    <div class="comentUser">
                                        <img src="images/userHead.png" width="50" height="50">
                                    </div>
                                    <div class="comentText">
                                        <span class="spanName">dashabin003@163.com</span>
                                        <span class="spanTime">2014-05-04 03:27:10</span>
                                        <p class="spanTxt">加油！！！</p>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="comentUser">
                                        <img src="images/userHead.png" width="50" height="50">
                                    </div>
                                    <div class="comentText">
                                        <span class="spanName">一个骗子的真话</span>
                                        <span class="spanTime">2014-04-23 11:15:39</span>
                                        <p class="spanTxt">曾几何时 天天说 日日谈 趁年轻的时候 每天为自己省下10元盒饭钱 参与低收费高保障的产 却往往被误认为是骗子 傻帽 我身体棒棒的 买那东西不吉利 是在诅咒我吗 结果 一个个血的教训 古语云 长贫难顾 也许 你身边有很多很多热心人士捐助 但 你能保证他们每天都在您身边吗 何况 还有千千万万的弱势群体在等候着 昂贵的医疗费用 君不见 医院一间比一间辉煌 一家比一家设备先进 众所周知 机器不用是会生锈的 相必 您懂了吧 医疗费贵不药品 而是我们的心 又到和谐时间了 希望有一天您能想起 我以上的肺腑之言 而不会因此而后悔</p>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                            </ul>
                            分页div
                            <div></div>
                        </div>
                        发表祝福	            
                        <div class="titleBox">发表祝福</div>
                        <form>
                            <div class="comentWrite">
                                <div class="wishUser">
                                    <label>用户名</label>
                                    <input type="text" class="usertext" />
                                </div>
                                <div class="wishWrite">
                                    <textarea class="writeCon"></textarea>
                                </div>
                                <div class="wishCaptcha">
                                    <input type="text" class="captchatext" />
                                    <img src="images/verify.jpg" />
                                    <span style="line-height:25px;">看不清点我</span>
                                    <div class="clear"></div>
                                </div>
                                <div class="wishSubmit">
                                    <a href="javascript:void(0);" class="submitbutt"></a>
                                </div>
                            </div>
                        </form>
                    </div> -->
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
