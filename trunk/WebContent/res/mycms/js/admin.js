Cms={};
Cms.lmenu = function(id) {
	var m = $('#' + id);
	m.addClass('lmenu');
	m.children().each(function() {
		$(this).children('a').bind('click', function() {
			$(this).parent().addClass("lmenu-focus");
			$(this).blur();
			var li = m.focusElement;
			if (li && li!=this) {
				$(li).parent().removeClass("lmenu-focus");
			}
			m.focusElement=this;
		});
	});
}



//loading
function showLoad() {
	var tipInfo="处理中.....";
  var iWidth = 120;     //弹出窗口的宽度;
  var iHeight = 0;    //弹出窗口的高度;
  var scrolltop = 0;
  var scrollleft = 0;
  var cheight = 0;
  var cwidth = 0;
  var eTip = document.createElement('div');
  eTip.setAttribute('id', 'tipDiv');
  eTip.style.position = 'absolute';
  eTip.style.display = 'none';
  eTip.style.border = 'solid 0px #D1D1D1';
   eTip.style.backgroundColor = '#F5F5DC';
  eTip.style.padding = '5px 15px';

  if(document.body.scrollTop){//这是一个js的兼容
      scrollleft=document.body.scrollLeft;
      scrolltop=document.body.scrollTop;
      cheight=document.body.clientHeight;
      cwidth=document.body.clientWidth;
  }
  else{
      scrollleft=document.documentElement.scrollLeft;
      scrolltop=document.documentElement.scrollTop;
      cheight=document.documentElement.clientHeight;
      cwidth=document.documentElement.clientWidth;
  }
  iHeight = eTip.offsetHeight;
  var v_left=(cwidth-iWidth)/2 + scrollleft; //
  var v_top=(cheight-iHeight)/2+ scrolltop-50;
  eTip.style.left = v_left + 'px';
  eTip.style.top = v_top + 'px';

  eTip.innerHTML = '<img src=\'/2.gif\'   style=\'float:left;\' />&nbsp;&nbsp;<span style=\'font-size:17px\'>' + tipInfo + '</span>';
  try {
      document.body.appendChild(eTip);
  } catch (e) { }
  $("#tipDiv").css("float", "right");
  $("#tipDiv").css("z-index", "99");
  $('#tipDiv').show();
  ShowMark();
}

function closeLoad() {
  $('#tipDiv').hide();
  HideMark();
}


//显示蒙灰层
function ShowMark() {
  var xp_mark = document.getElementById("xp_mark");
  if (xp_mark != null) {
      //设置DIV
      xp_mark.style.left = 0 + "px";
      xp_mark.style.top = 0 + "px";
      xp_mark.style.position = "absolute";
      xp_mark.style.backgroundColor = "#000";
      xp_mark.style.zIndex = "1";
      if (document.all) {
          xp_mark.style.filter = "alpha(opacity=50)";
          var Ie_ver = navigator["appVersion"].substr(22, 1);
          if (Ie_ver == 6 || Ie_ver == 5) { hideSelectBoxes(); }
      }
      else { xp_mark.style.opacity = "0.5"; }
      xp_mark.style.width = "100%";
      xp_mark.style.height = "100%";
      xp_mark.style.display = "block";
  }
  else {
      //页面添加div explainDiv,注意必须是紧跟body 内的第一个元素.否则IE6不正常.
      $("body").prepend("<div id='xp_mark' style='display:none;'></div>");
      ShowMark(); //继续回调自己
  }
}

//隐藏蒙灰层
function HideMark() {
  var xp_mark = document.getElementById("xp_mark");
  xp_mark.style.display = "none";
  var Ie_ver = navigator["appVersion"].substr(22, 1);
  if (Ie_ver == 6 || Ie_ver == 5) { showSelectBoxes(); }
}

function setValue(){
	var today=new Date(); 
	var year=today.getFullYear()-10;
	var m=today.getMonth();
	var d=today.getDate();
	
	var nl_start=document.getElementById('nl_start').value;
	var nl_end=document.getElementById('nl_end').value;
	if(nl_start!='')
	document.getElementById('A01071').value=year-nl_start+"-"+m+"-"+d;
	if(nl_end!='')
		document.getElementById('A01072').value=year-nl_end+"-"+m+"-"+d;
	
	
	
	return false;
	document.getElementById('username').value=document.getElementById('A0101').value;
	var a=document.getElementById('A0104').value;
	var b="";
	if (a=='031')
    b="男";
	if (a=='032')
	    b="女";
	document.getElementById('sex').value=b;
	document.getElementById('cardid').value=document.getElementById('A0184').value;
}
function sortSubmit(sort,order){
	document.getElementById('sort').value=sort;
	document.getElementById('order').value=order;
	showLoad();
	document.getElementById("jvForm").submit();
}



//获取指定form中的所有的<input>对象    
function getElements(formId) {    
    var form = document.getElementById(formId);    
    var elements = new Array();    
    var tagElements = form.getElementsByTagName('input');    
    for (var j = 0; j < tagElements.length; j++){  
         elements.push(tagElements[j]);  
  
    }  
    return elements;    
}   
  
//获取单个input中的【name,value】数组  
function inputSelector(element) {    
  if (element.checked)    
     return [element.name, element.value];    
}    
      
function input(element) {    
    switch (element.type.toLowerCase()) {    
      case 'submit':    
      case 'hidden':    
      case 'password':    
      case 'text':    
        return [element.name, element.value];    
      case 'checkbox':    
      case 'radio':    
        return inputSelector(element);    
    }    
    return false;    
}    
  
//组合URL  
function serializeElement(element) {    
    var method = element.tagName.toLowerCase();    
    var parameter = input(element);    
    
    if (parameter) {    
      var key = encodeURIComponent(parameter[0]);    
      if (key.length == 0) return;    
    
      if (parameter[1].constructor != Array)    
        parameter[1] = [parameter[1]];    
          
      var values = parameter[1];    
      var results = [];    
      for (var i=0; i<values.length; i++) {    
        results.push(key + '=' + encodeURIComponent(values[i]));    
      }    
      return results.join('&');    
    }    
 }    
  
//调用方法     
function serializeForm(formId) {    
    var elements = getElements(formId);    
    var queryComponents = new Array();    
    
    for (var i = 0; i < elements.length; i++) {    
      var queryComponent = serializeElement(elements[i]);    
      if (queryComponent)    
        queryComponents.push(queryComponent);    
    }    
    
    return queryComponents.join('&');  
}    
  
function getFormInfo(){  
    var params = serializeForm('login');  
    alert(params);  
}  