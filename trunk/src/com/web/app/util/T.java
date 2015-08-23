package com.web.app.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
replace1("qjsc_expert");
	}
    public static void replace1(String name){
    	replace("D:/projects/qjsc/sql/qjsc_changecertapply.sql".replaceAll("qjsc_changecertapply", name),"D:/projects/qjsc/jsp/qjsc_changecertapplyEdit.htm".replaceAll("qjsc_changecertapply", name));
    	replace("D:/projects/qjsc/sql/qjsc_changecertapply.sql".replaceAll("qjsc_changecertapply", name),"D:/projects/qjsc/jsp/qjsc_changecertapplyView.htm".replaceAll("qjsc_changecertapply", name));

}
	public static void replace(String dictFilename, String filename) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					dictFilename)));
			String line = null;
			Map<String, String> m1 = new HashMap<String, String>();
			while ((line = br.readLine()) != null) {
				String c1 = line.substring(0, line.indexOf(" "));
				String c2 = line.substring(line.indexOf(" ") + 1).trim();
				m1.put(c1, c2);
			}
			
			br.close();
			File infile = new File(filename);
			String filename1=filename.replace(".html", "1.html").replace(".htm", "1.htm");
			br = new BufferedReader(new InputStreamReader(new FileInputStream(infile),"GBK"));
			
			String newfilename=infile.getName();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(filename1)), "GBK"));
			
			line = null;
			int L = "value=\"{$".length();
			int L1 = "value=\"".length();
			String voname=getVoName(infile.getName());
			while ((line = br.readLine()) != null) {
				int start = line.indexOf("value=\"{$");
				if (start != -1) {
					String tmp = line.substring(start + L);
                    String name=tmp.substring(0,tmp.indexOf("}\""));
                    String newname=m1.get(name);
                    //id="author" size="24" value="{$author}" /></td>
                    //${qjscuser.answer}
                    String s=line.substring(0,start+L1);
                    String s1=line.substring(start+L1);
                    String e=s1.substring(s1.indexOf("\""));
                    if(newname==null){
                    	System.out.println("---"+newfilename+"->"+name);
                    	newname=name;
                    }
                    line= s+"${"+voname+"."+newname+"}"+e;
                
						line=line.replaceAll(name, newname);
					 
				}else if(line.indexOf("{$")!=-1){
                    int start1=line.indexOf("{$");
					String tmp = line.substring(start1+2);
                    String name=tmp.substring(0,tmp.indexOf("}"));
                    String newname=m1.get(name);
                    //name="my_fxfwcsyy">{$my_fxfwcsyy}</textarea></td>
                    //${qjscuser.answer}
                    String s=line.substring(0,start1);//name="my_fxfwcsyy">
                    String s1=line.substring(start1+2);
                    String e=s1.substring(s1.indexOf("}")+1);//</textarea></td>
                    if(newname==null){
                    	System.out.println("---"+newfilename+"->"+name);
                    	newname=name;
                    }
                    line= s+"${"+voname+"."+newname+"}"+e;
              
                    line=line.replaceAll(name, newname);
				
				}
				bw.write(line);
				bw.write("\n");
			}
bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static String getVoName(String filename){
		//qjsc_expertEdit
		String voname=filename.indexOf("Edit")!=-1?filename.substring(0,filename.toLowerCase().indexOf("edit")):filename.substring(0,filename.toLowerCase().indexOf("view"));
		return voname.replace("_", "");
	}
}
