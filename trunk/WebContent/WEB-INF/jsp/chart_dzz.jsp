<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page import="java.text.*,org.jfree.chart.ChartUtilities,com.web.app.util.page.*,com.zyz.domain.*,org.jfree.chart.renderer.category.BarRenderer3D,org.jfree.chart.*,org.jfree.data.category.CategoryDataset,org.jfree.data.general.DefaultPieDataset,org.jfree.chart.title.TextTitle,java.awt.Font,org.jfree.chart.plot.title.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities,org.jfree.chart.plot.*,org.jfree.chart.labels.*,org.jfree.chart.axis.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.ChartFrame" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="<%=request.getContextPath()%>/res/common/js/jquery.js" type="text/javascript"></script>
 <script src="<%=request.getContextPath()%>/res/mycms/js/admin.js" type="text/javascript"></script>
 <html>
   <head>
    
   </head>
    
  <body>
   <%
   String p="u/chart/"+System.currentTimeMillis()+".jpg";
   String p1="u/chart/"+System.currentTimeMillis()+1+".jpg";
   int maxNum=10;//大于maxNum，则显示为其他
String path=   request.getRealPath(p);
String path1=   request.getRealPath(p1);
   String title="";
   
    DefaultPieDataset dataset = new DefaultPieDataset();
   com.web.app.util.page.Pagination page1=(com.web.app.util.page.Pagination)request.getAttribute("page");
   String charttype=request.getParameter("charttype");
   if("1".equals(charttype)){
	   title="党员人数";
   }else if("2".equals(charttype)){
	   title="党员志愿者人数";
   }else if("3".equals(charttype)){
	   title="党员志愿者积分";
   }else if("4".equals(charttype)){
	   title="党员志愿者志愿时数";
   } 
   else if("5".equals(charttype)){
	   title="党员志愿者平均积分";
   } else if("6".equals(charttype)){
	   title="党员志愿者平均志愿时数";
   } else if("7".equals(charttype)){
	   title="党员志愿者占党员百分比";
   } 
   
   double[][] data = {};
     String[] rowKeys = {};
     String[] columnKeys = {};
     
   if(page1!=null){
   java.util.List  list=page1.getList();
   if(list!=null&list.size()>0){
	   
	   int s=list.size()>maxNum?maxNum:list.size();
	   rowKeys=  new String[s];
	   data = new double[s][1];
	   columnKeys = new String[1];
	   columnKeys[0]="";
   java.util.Iterator it=list.iterator();
   int ind=0;
   double othervalues=0;
   while(it.hasNext()){
	   Zyzinfo z= (Zyzinfo)it.next();
	 String key=  z.getD01_dzz_Dict().get(z.getSubdzz());
	 String v="";
     if("1".equals(charttype)){
    	 v=z.getDyrs();
     }else if("2".equals(charttype)){
    	 v=z.getZyrs();
     }else if("3".equals(charttype)){
    	 v=z.getCscore();
     }else if("4".equals(charttype)){
    	 v=z.getCservicetimes();
     }else if("5".equals(charttype)){
    	 v=z.getCscoreavg();
     }else if("6".equals(charttype)){
    	 v=z.getCservicetimesavg();
     }else if("7".equals(charttype)){
    	 v=z.getPercent();
     }
     if(ind>maxNum-2){
		 othervalues=othervalues+ Double.parseDouble(v);
		 if(it.hasNext()){
			 continue;
		 }
	 }
     if(!(it.hasNext())&&ind>maxNum-2){
		 key="其他";
		 v=""+othervalues;
		 ind=maxNum-1;
	 }
     
     System.out.println(key+":"+v);
	 dataset.setValue(key,Double.parseDouble(v));
	 rowKeys[ind]=key;
	 data[ind][0]=Double.parseDouble(v);
	 ind++;
	 if("其他".equals(key))break;
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
     DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题          
	NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象          
	StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象          
	plot.setLabelGenerator(sp1);//设置饼图显示百分比
     
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

 	BarRenderer3D renderer = (BarRenderer3D) plot1.getRenderer(); 
    renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    renderer.setItemLabelFont(new Font("黑体",Font.BOLD,12));//12号黑体加粗
    //renderer.setItemLabelPaint(Color.black);//字体为黑色
    renderer.setItemLabelsVisible(true);

    
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
    		  u1='/chartmgr/chartmgrSave.do?type=0&url='+p1+'&name='+encodeURI(document.getElementById('v2').value);
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
 

<input type="button" style="font-size:12px" value="返回" onclick="history.back();"/></br>

<span style="font-size:12px">标题:</span><input type=text id="v1" /><button onclick="save(1)" style="font-size:12px"> 生成前台饼状图 </button></br>
<span style="font-size:12px">标题:</span><input type=text id="v2" /><button onclick="save(2)" style="font-size:12px">生成前台柱状图</button></br>
         <img src="<%=url %>" width="600" height="550">  
 </br>
      <img src="<%=url1 %>" width="600" height="550">  
  </body>
 </html>
 
 