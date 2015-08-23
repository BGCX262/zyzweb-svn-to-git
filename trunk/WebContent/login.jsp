<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/top_header.jspx" flush="true" />

<body>
<!-- 顶部_Start -->
	<jsp:include page="/top_search.jspx" flush="true" />
</div>
<!-- 顶部_End -->

<!-- 导航菜单_Start --> 
	<jsp:include page="/top_menu.jspx" flush="true" />
<!-- 导航菜单_End -->


 
<!-- 文章内容_Start -->
<div class="layout">
	<div class="left">
    <div class="hd2"><h2>通知公告</h2></div>


        <!-- 通知公告_Start -->
<jsp:include page="/notice.jspx" flush="true" />
        <!-- 通知公告_End -->
        
    	 
    </div>
    <div class="right">
 
 <!-- 当前位置_Start -->
<DIV class="hd site">您当前的位置： <A href="#">会员中心</A> &gt; 会员登录</DIV><!-- 当前位置_End -->
<DIV id=article-box class=box>
<H2>会员登录</H2>
<DIV class="table-div div-login">
<FORM onsubmit="return checkform();" method=post name=loginform id=loginform action=/member/login.php>
<TABLE class=t border=0 cellSpacing=0 cellPadding=0 width=400 align=center>
<TBODY>
<TR>
<TD height=44 width=80 align=center>用户名</TD>
<TD align=left><INPUT id=username class="input w200" name=username size=24></TD>
<TD width=100 align=center><A href="/qjscuser/reg_shengming.do" target=_blank>注册新用户</A></TD></TR>
<TR>
<TD height=44 align=center>密&nbsp;&nbsp;码</TD>
<TD align=left><INPUT id=passwd class="input w200" name=passwd   size=24 type=password></TD>
<TD align=center><!-- <A href="/member/getpassword.php" target=_blank>忘记密码?</A> --></TD></TR>
<TR>
<TD height=44 align=center>验证码</TD>
<TD align=left><INPUT id=checkCode class="input w75" name=checkCode size=10> &nbsp;
<IMG height="20" onclick="this.src='/CaptchaImg?time='+Math.random()" width="90" src="<%=request.getContextPath() %>/CaptchaImg">
</TD>
<TD align=center>&nbsp;</TD></TR>
<TR>
<TD height=59 align=center>&nbsp;</TD>
<TD align=left><INPUT id=forward name=forward value=/member/ type=hidden> <INPUT id=dosubmit class=login-btn name=dosubmit value=登录 type=button onclick="userLogin1()"></TD>
<TD align=center>&nbsp;</TD></TR></TBODY></TABLE></FORM></DIV></DIV>
 
 
    </div>
    <div class="clear"></div>
</div>
<!-- 文章内容_End -->
 
 
<!-- 底部_Start -->
<jsp:include page="buttom.jspx" flush="true" />
<!-- 底部_End -->
<script type="text/javascript"> 
function userLogin1(){
    
	$.post("/qjscuser/logincheck.do",$("#loginform").serializeArray(),function(data){
        if(data.message=='ok')
        document.location='/qjscuser/render.do'
        else
       {
      alert(data.message)  
	//	$.messager.alert('提示',data.message,'info');
       }
	});
}
 
</script>
</body>
</html>
