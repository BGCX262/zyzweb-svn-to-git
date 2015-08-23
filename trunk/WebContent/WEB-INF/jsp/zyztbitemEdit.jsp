<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>志愿ATM项目信息管理-编辑</title>
<link href="<%=request.getContextPath()%>/res/mycms/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>
 
<script src="<%=request.getContextPath()%>/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/js/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/common/js/pony.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/mycms/js/admin.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/thirdparty/fckeditor/fckeditor.js" type="text/javascript"></script>
 
<script type="text/javascript"> 
$(function() {
	$("#jvForm").validate();
	$("#type").change(function(){
		if($(this).val()=="2"){
			$('#targetamountStr').html("目标金额");
			$('#targetamount').attr('readonly',false);
			$('#targetamount').val('');
			$('#targetamount').css('background-color','white');
			$('#targetnameStr').html("捐助对象");
		}else if($(this).val()=="1"){
			$('#targetamountStr').html("招募人数");
			$('#targetamount').attr('readonly',false);
			$('#targetamount').val('');
			$('#targetamount').css('background-color','white');
			$('#targetnameStr').html("服务对象");
		}else if($(this).val()=="3"){
			$('#targetamountStr').html("需求心愿");
			$('#targetamount').attr('readonly','readonly');
			$('#targetamount').val(1);
			$('#targetamount').css('background-color','lightgray');
			$('#targetnameStr').html("捐助对象");
		}
	})
});



</script>

</head>
<body>
<div class="body-box">
<div class="rhead">
	<div class="rpos">当前位置:  志愿ATM项目信息管理 - 编辑</div>
	<form class="ropt">
		<input type="button" value="返回列表" onclick="history.back();"/>
	</form>
	<div class="clear"></div>
</div>
<form method="post" enctype=”multipart/form-data” action="zyztbitemSave.do" id="jvForm" >
<input type="hidden" name="actiontype" value="<%=request.getParameter("actiontype") %>" />
<table width="100%" class="pn-ftable" cellpadding="2" cellspacing="1" 	border="0">

   <input type="hidden" name="itemid" id="itemid" value="<c:out value="${zyztbitem.itemid}"/>"/>
          <tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     项目类别:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent">
 <select name="type" id="type" >
 <option value="1"  <c:if test="${zyztbitem.type==1}">selected="selected"</c:if>>服务项目</option>
 <option value="2" <c:if test="${zyztbitem.type==2}">selected="selected"</c:if>>捐助项目</option>
 <option value="3"  <c:if test="${zyztbitem.type==3}">selected="selected"</c:if>>需求心愿</option>
 </select>
 </td>
       </tr> 
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     <font id="targetnameStr">服务对象</font>:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="targetname"  id="targetname" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbitem.targetname}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     标题:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="title"  id="title" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbitem.title}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     <font id="targetamountStr">招募人数</font>:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="targetamount"  id="targetamount" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbitem.targetamount}"/>" /></td>
       </tr>  
       <c:if test="${actiontype=='edit'}">
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     已捐款/已招募:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="amount"  id="amount" maxlength="100" size="24"
 class="" value="<c:out value="${zyztbitem.amount}"/>" /></td>
       </tr>  
       </c:if>
       
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     截止日期:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="deadline"  id="deadline" maxlength="100" size="24"
 class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<c:out value="${zyztbitem.deadlineStr}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     图片:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent">
		<table id="attachTable" border="0">
				<tr>
					<td align="center">图片地址</td>
					<td align="center">上传</td>
				</tr>
				<tr id="attachTr0">
					<input type="hidden" id="attachmentNames1" name="attachmentNames" readonly="readonly"/>
					<td align="center"><input type="text" id="attachmentPaths1" name="image" readonly="readonly" value="<c:out value="${zyztbitem.image}"/>"/></td>
					<td align="center">
						<span id="afc0"><input type="file" id="attachmentFile1" name="attachmentFile" size="12" style="width:160px"/></span>
						<input type="button" value="上传" onclick="uploadAttachment(1);"/>
						<input type="hidden" id="attachmentFilenames1" name="attachmentFilenames"/>
					</td>
				</tr>
				</table>
				<textarea id="attachTr" style="display:none">
				<tr id="attachTr{0}">
					<td align="center"><input type="text" id="attachmentNames{1}" name="attachmentNames"/></td>
					<td align="center"><input type="text" id="attachmentPaths{1}" name="ysclpath" value="<c:out value="${qjscsdpgapplyflowinfo.ysclpath}"/>"/></td>
					<td align="center">
						<span id="afc{0}"><input type="file" id="attachmentFile{1}" name="attachmentFile" size="12" style="width:160px"/></span>
						<input type="button" value="上传" onclick="uploadAttachment({1});"/>
						<input type="hidden" id="attachmentFilenames{1}" name="attachmentFilenames"/>
					</td>
				</tr>
				</textarea>
				<script type="text/javascript">
				var attachIndex = 1;
				var attachTpl = $.format($("#attachTr").val());
				function addAttachLine() {
					$('#attachTable').append(attachTpl(attachIndex++));
				}
				</script>
 		</td>
       </tr>    
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     爱心积分:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> <input type="text" name="score"  id="score" maxlength="100" size="24"
 class="digits" value="<c:out value="${zyztbitem.score}"/>" /></td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     状态:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent">
 <select name="status" id="status" >
 <option value="1"  <c:if test="${zyztbitem.status==1}">selected="selected"</c:if>>可用</option>
 <option value="2" <c:if test="${zyztbitem.status==2}">selected="selected"</c:if>>结束</option>
 <option value="-1" <c:if test="${zyztbitem.status==-1}">selected="selected"</c:if>>过期</option>
 </select>
 </td>
       </tr>   
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     内容:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> 
		<%-- <textarea rows="20" cols="60" name="content"  id="content" ><c:out value="${zyztbitem.content}"/></textarea> --%>
		
		<script type="text/javascript">
			var txt = new FCKeditor("content");
			txt.BasePath = "/thirdparty/fckeditor/";
			txt.Config["CustomConfigurationsPath"]="/thirdparty/fckeditor/myconfig.js";
			
			txt.Config["LinkBrowser"] = false ;
			txt.Config["ImageBrowser"] = false ;
			txt.Config["FlashBrowser"] = false ;
			txt.Config["MediaBrowser"] = false ;
			
			txt.Config["LinkBrowserURL"] = "/thirdparty/fckeditor/editor/filemanager/browser/default/browser.html?Connector=/fck/connector.do" ;
			txt.Config["ImageBrowserURL"] = "/thirdparty/fckeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=/fck/connector.do" ;
			txt.Config["FlashBrowserURL"] = "/thirdparty/fckeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=/fck/connector.do" ;
			txt.Config["MediaBrowserURL"] = "/thirdparty/fckeditor/editor/filemanager/browser/default/browser.html?Type=Media&Connector=/fck/connector.do" ;
			
			txt.Config["LinkUpload"] = true ;
			txt.Config["ImageUpload"] = true ;
			txt.Config["FlashUpload"] = true ;
			txt.Config["MediaUpload"] = true ;
			
			txt.Config["LinkUploadURL"] = "/manager/fck/upload.do" ;
			txt.Config["ImageUploadURL"] = "/manager/fck/upload.do?Type=Image" ;
			txt.Config["FlashUploadURL"] = "/manager/fck/upload.do?Type=Flash" ;
			txt.Config["MediaUploadURL"] = "/manager/fck/upload.do?Type=Media" ;
			
			txt.ToolbarSet="My";
			txt.Height=600;
			txt.Value='${zyztbitem.content}';
			txt.Create();
			</script>
		
       </tr>
<tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     备注:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> 
 		<textarea name="remark" id="remark" rows="20" cols="60"><c:out value="${zyztbitem.remark}"/></textarea>
 		</td>
       </tr>   
<%-- <tr>
		<td width="12%" class="pn-flabel pn-flabel-h">     置顶:
     </td>
		<td colspan="1" width="38%" class="pn-fcontent"> 
 	 <select name="top" id="top" >
 <option value="0" <c:if test="${zyztbitem.top}==0">selected="selected"</c:if>>否</option>
 <option value="1"  <c:if test="${zyztbitem.top}==1">selected="selected"</c:if>>是</option>
 </select>
 </td>
 </tr> --%>      
 
       </tr>  
	<tr>
		<td colspan="2" class="pn-fbutton"><input type="submit"  
			value="提交" /> &nbsp; <input type="reset" value="重置" /></td>
	</tr>
	<!-- 文件上传 -->
	
<script type="text/javascript">
//上传附件
function uploadAttachment(n) {
	$('#attachmentForm').submit();
	var af = $('#attachmentFile'+n);
	//检查是否选择了文件
	if(af.val()=='') {
		alert('请选择要上传的文件');
		return;
	}
	//将file移动至上传表单
	$('#attachmentContent').empty();
	$('#attachmentContent').append(af);
	/* alert($('#attachmentContent').html());
	return; */
	//复制一个file放至原处
	$('#afc'+n).append(af.clone().attr('value',''));
	//修改属性
	af.attr('id','');
	//其他表单
	$('#attachmentNum').val(n);
	$('#attachmentForm').submit();
}
</script>

  	<!-- 文件上传end -->
</table>
</form>
</div>
<form id="attachmentForm" action="/manager/content/o_upload_attachment.do" method="post" enctype="multipart/form-data" target="attachment_iframe" style="display:none;width:0px;height:0px;">
<span id="attachmentContent" ></span>
<input type="hidden" id="attachmentNum" name="attachmentNum"/>
</form>
<iframe name="attachment_iframe" frameborder="0" border="0" style="display:none;width:0px;height:0px;"></iframe><script type="text/javascript">

</body>
</html>