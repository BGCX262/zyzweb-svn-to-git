<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Accordion - jQuery EasyUI Demo</title>
	<link href="/res/mycms/css/admin.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="/js/jquery/jquery-easyui-1.2.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/js/jquery/jquery-easyui-1.2.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/js/jquery/jquery-easyui-1.2.1/themes/demo.css">
	<script type="text/javascript" src="/js/jquery/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery-easyui-1.2.1/jquery.easyui.min.js"></script>
</head>
<body style="padding:2px;">
<div class="body-box">

 
			
			
			
				<strong>备案步骤： 1.广州市自愿开展清洁生产企业登记表 > 2.广东省清洁生产审核备案申请表> 3.清洁生产审核工作计划表> 4.相关复印件> 5.表格下载>6.提交所有表格请求</strong>
	 
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>请在每个步骤填写完点击保存</div>
			<!-- 
	当前状态，
	审核信息，
	查看历史审核
	保存
	 -->
	</div>

<div class="easyui-tabs" data-options="fit:true,plain:true" style="height:650px;">
				<div title="1.广州市自愿开展清洁生产企业登记表" style="padding:10px;">
		<iframe  src="/qjscrecordregister/qjscrecordregisterAdd.do" id="iright" name="iright" frameborder="0"  width="100%" height="100%"></iframe>
            </div>
				<div title="2.广东省清洁生产审核备案申请表" style="padding:10px;">
		<iframe  src="/qjscuser/qjscuserEdit.do?actiontype=isFrontEdit&userid=<c:out value="${sessionScope.userSessionInfo.userid}"/>" id="iright" name="iright" frameborder="0"  width="100%" height="100%"></iframe>
</div>
				<div title="3.清洁生产审核工作计划表" style="padding:10px;">Content 3</div>
				<div title="4.相关复印件" style="padding:10px;">Content 3</div>
				<div title="5.表格下载" style="padding:10px;">Content 3</div>
				<div title="6.提交所有请求" style="padding:10px;">
			   已经确认之前的信息完成，请点击保存按钮进行提交。</br>
			   <button>保存信息</button>
				</div>
			</div>
	

</body>
</html>