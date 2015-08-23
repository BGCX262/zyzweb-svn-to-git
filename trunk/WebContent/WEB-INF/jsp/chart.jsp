<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="org.jfree.chart.ChartUtilities,com.web.app.util.page.*,com.zyz.domain.*,org.jfree.chart.*,org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="<%=request.getContextPath()%>/res/common/js/jquery.js" type="text/javascript"></script>
 
 <html>
   <head>
    
   </head>
   
  <body>
   <%
   String p="u/chart/"+System.currentTimeMillis()+".jpg";
   String p1="u/chart/"+System.currentTimeMillis()+1+".jpg";
String path=   request.getRealPath(p);
String path1=   request.getRealPath(p1);
   String title="分类统计";
   
    DefaultPieDataset dataset = new DefaultPieDataset();
   com.web.app.util.page.Pagination page1=(com.web.app.util.page.Pagination)request.getAttribute("page");
   
   
   
   double[][] data = {};
     String[] rowKeys = {};
     String[] columnKeys = {};
     
   if(page1!=null){
   java.util.List  list=page1.getList();
   if(list!=null&list.size()>0){
	   
	   rowKeys=  new String[list.size()];
	   data = new double[list.size()][1];
	   columnKeys = new String[1];
	   columnKeys[0]="";
   java.util.Iterator it=list.iterator();
   int ind=0;
   while(it.hasNext()){
	   Zyzinfo z= (Zyzinfo)it.next();
		 String key=  z.getA01_a0117_Dict().get(z.getFlname());
		 String nl=z.getNl();
		 String cservicetimes=z.getCservicetimes();
		 if(nl!=null&&!"".equals(nl))
			 key=key+nl;
		 System.out.println(nl+":"+cservicetimes);
		 dataset.setValue(key,Double.parseDouble(cservicetimes));
		 rowKeys[ind]=key;
		 data[ind][0]=Double.parseDouble(cservicetimes);
		 ind++;
	   }
   }
   }
   
   
   
     JFreeChart chart = ChartFactory.createPieChart3D("",dataset,true,true,false);
   //设置饼状图的 主标题字体
     chart.setTitle(new TextTitle(title+"饼状图",new Font("宋体",Font.BOLD,16)));
     
     PiePlot plot = (PiePlot) chart.getPlot();
     //设置饼状图体里的的各个标签字体
     plot.setLabelFont(new Font("宋体",Font.BOLD,16));
     //设置图表下方的图例说明字体
     
	     //没有数据的时候显示的内容  
	 plot.setNoDataMessage("无数据显示");  
	 plot.setCircular(false);  
	 plot.setLabelGap(0.02D);  
	
	 plot.setIgnoreNullValues(true);//设置不显示空值  
	 plot.setIgnoreZeroValues(true);//设置不显示负值  
	 
	 ChartPanel  frame1=new ChartPanel (chart,true);  
	 chart.getTitle().setFont(new Font("宋体",Font.BOLD,16));//设置标题字体  

	 
 
     chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,16));
  	String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session);
    String url = request.getContextPath()+"/DisplayChart?filename="+fileName;
 
    
     
    
      CategoryDataset dataset1 = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data); 
     JFreeChart chart1 = ChartFactory.createBarChart3D(title+"柱状图", 
             "",
             title,	
             dataset1,
             PlotOrientation.VERTICAL,
             true,
             false,
             false);     
          
     CategoryPlot plot1 =  chart1.getCategoryPlot();
     CategoryAxis domainaxis = plot1.getDomainAxis();
 	NumberAxis numberaxis = (NumberAxis) plot1.getRangeAxis();

 	// 解决中文乱码问题
 	TextTitle texttitle = chart1.getTitle();
 	texttitle.setFont(new Font("宋体", Font.BOLD, 16));
 	domainaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 16));
 	domainaxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
 	numberaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 16));
 	numberaxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
 	chart1.getLegend().setItemFont(new Font("宋体", Font.BOLD, 16));

     String fileName1 = ServletUtilities.saveChartAsPNG(chart1,800,600,session);
     String url1 = request.getContextPath()+"/DisplayChart?filename="+fileName1;
     
     ChartUtilities.saveChartAsJPEG(new java.io.File(path),chart,800,600);
     ChartUtilities.saveChartAsJPEG(new java.io.File(path1),chart1,800,600);
 
      %>
      <script>
      var p='<%=p%>';
      var p1='<%=p1%>';
      
      function save(t){
    	  var u1;
    	  if(t==1){
    	  if(document.getElementById('v1').value==''){alert('前台显示名称不能为空!');return;};
    	  u1='/chartmgr/chartmgrSave.do?type=0&url='+p+'&name='+encodeURI(document.getElementById('v1').value);
    	  }
    	  if(t==2){
    		  if(document.getElementById('v2').value==''){alert('前台显示名称不能为空!');return;};
    		  u1='/chartmgr/chartmgrSave.do?type=0&url='+p1+'&name='+document.getElementById('v2').value;
    	  }
      $.ajax({ url: u1, success: function(data){
          if(data=='ok'){
        	  alert('保存成功');
          }else{
        	  alert('保存失败');
          }
        }});
      }

      
      </script>
 

<input type="button" value="返回" onclick="history.back();"/></br>

 前台显示名称:<input type=text id="v1" /><button onclick="save(1)">生成前台饼状图</button></br>
 前台显示名称:<input type=text id="v2" /><button onclick="save(2)">生成前台柱状图</button>
         <img src="<%=url %>" width="500" height="350">
 </br>
       <img src="<%=url1 %>" width="500" height="350">    
<iframe id='ifr1' heigth=0 weight=0 src="#"></iframe>
  </body>
 </html>
 
 