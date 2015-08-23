package com.mycms.cms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		int i=2;
		int i1=3;
		if(i==2){
			System.out.println(i);
		}
		if(i1==3){
			System.out.println(i1);
		}else {
			System.out.println(0);
		}
		//getNewline("(`cfg_key`,`cfg_value`)"); 
//		parseFile();
//		getValuesNewline("VALUES ('fe28290e771249db81df26ef064216de',1,'admin','admin@test.com','2011-10-17 12:35:26','127.0.0.1','2011-10-17 12:39:14');");
		String v ="1";  
		float f=Float.parseFloat(v);
		long l=(long)(f/100);
		String s=String.valueOf(l);
		System.out.println(s);
	}
  private static void parseFile() throws Exception{
	  String source="C:\\Users\\ligh1\\Desktop\\cms.sql";
	  String target="C:\\Users\\ligh1\\Desktop\\cms_new.sql";
	  BufferedReader br=new BufferedReader(new FileReader(new File(source)));
	  OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(new File(target)),"UTF-8");
	  BufferedWriter bw=new BufferedWriter(osw);
	  StringBuffer sb=new StringBuffer();
	  
	  String line;
	  String nline;
	  //INSERT INTO t_config (`cfg_key`,`cfg_value`) VALUES ('email_encoding','');
	  while((line=br.readLine())!=null){
		  sb.append("\n");
		  int si=line.indexOf("(`");
		  if(si==-1){
			  sb.append(line);
			  continue;
		  }
		  int mi=line.indexOf("`)");
		  String s=line.substring(0,si);//INSERT INTO t_config 
		  String m=line.substring(si,mi+2);//(`cfg_key`,`cfg_value`)
		  String l=line.substring(mi+2);// VALUES ('email_encoding','');
		  nline=getFieldNewline(m);
		  sb.append(s+nline+l);
	  }
	  bw.write(sb.toString());
//	  System.out.println(sb);
	  br.close();
	  bw.close();
  }
  private static String getValuesNewline(String line){

		//VALUES ('fe28290e771249db81df26ef064216de',1,'admin','admin@test.com','2011-10-17 12:35:26','127.0.0.1','2011-10-17 12:39:14');

		  Pattern p = Pattern.compile("'2011[\\S|\\s]+'");
		    Matcher m = p.matcher(line);
		    StringBuffer sb=new StringBuffer();
		    sb.append("(");
		    boolean fount=false;
		    while(m.find()){
		    	if(fount)sb.append(",");
		    String f=	m.group();
		    sb.append(f.substring(1,f.lastIndexOf("'")));
		    fount=true;
		    }
		    sb.append(")");
		    System.out.println(sb);
	return sb.toString();
	  
  }
  private static String getFieldNewline(String line){
	//(`cfg_key`,`cfg_value`)

	  Pattern p = Pattern.compile("`\\w+`");
	    Matcher m = p.matcher(line);
	    StringBuffer sb=new StringBuffer();
	    sb.append("(");
	    boolean fount=false;
	    while(m.find()){
	    	if(fount)sb.append(",");
	    String f=	m.group();
	    sb.append(f.substring(1,f.lastIndexOf("`")));
	    fount=true;
	    }
	    sb.append(")");
//	    System.out.println(sb);
return sb.toString();
  }
}
