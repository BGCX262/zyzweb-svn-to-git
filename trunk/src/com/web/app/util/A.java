package com.web.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		d("D:\\projects\\qjsc\\dict\\sfzdqy.txt", "zdnh", "是否重点耗能企业");
//		e1();
		e2a();
	}
	public static void e2(){
		String dir="E:\\www.gzcpc.org_5ks21r5f825fsm9j\\www.gzcpc.org_5ks21r5f825fsm9j\\data\\cache\\";
		File f=new File(dir);
		Map<String, String> m=e2a();
		for(File fi:f.listFiles()){
			if(fi.getName().startsWith("categorys_")){
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(
							new FileInputStream(fi), "gbk"));
					String line = null;
					String channelid = null;
					String catid = null;
					String catname = null;
					
					while ((line = br.readLine()) != null) {
						if(line.indexOf("'channelid'")!=-1){
							//'channelid' => '149',
							String tmp= line.substring(line.indexOf("=>"));
							channelid=tmp.substring(tmp.indexOf("'")+1,tmp.lastIndexOf("'"));
						} else if(line.indexOf("'catid'")!=-1){
							//'catid' => '149',
							String tmp= line.substring(line.indexOf("=>"));
							catid=tmp.substring(tmp.indexOf("'")+1,tmp.lastIndexOf("'"));
						} else if(line.indexOf("'catname'")!=-1){
							//'catid' => '149',
							String tmp= line.substring(line.indexOf("=>"));
							catname=tmp.substring(tmp.indexOf("'")+1,tmp.lastIndexOf("'"));
							if(catname.endsWith("年"))
								catname=catname.substring(0,catname.indexOf("年"));
							if(m.get(channelid)!=null)
							System.out.println("insert into tmp2 values('"+channelid+"','"+catid+"','"+catname+"','"+m.get(channelid)+"');");

						} 
					}
					br.close();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private  static Map<String, String> e2a(){
		Map<String, String> m=new HashMap<String,String>();
			try {

					BufferedReader br = new BufferedReader(new InputStreamReader(
							new FileInputStream("c:/a"), "gbk"));
					String line = null;
					String name = null;
					while ((line = br.readLine()) != null) {
						String t[]=line.split(" ");
						String id=t[1].substring(t[1].lastIndexOf("_")+1);
						String table=t[2].trim();
						m.put(id, table);
						//update qjsc_record_attach_yy set year=(select catname from tmp2 where tmp2.catid=qjsc_record_attach_yy.`year` and tmp2.tablename='qjsc_record_attach_yy');
                         
						System.out.println("update "+table+" set year=(select catname from tmp2 where tmp2.catid="+table+".`year` and tmp2.tablename='"+table+"') where EXISTS (select 1 from  tmp2 where tmp2.catid="+table+".`year` and tmp2.tablename='"+table+"');");
						
					}
					br.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					return m;
	}
	public static void e1() {
		File f=new File("c:\\abc");
		StringBuilder sb = new StringBuilder();
		for(File fi:f.listFiles()){
			StringBuilder s1=e(fi);
			sb.append(s1);
		}
		System.out.println(sb.toString());
	}
	public static StringBuilder e(File file) {
		StringBuilder sb = new StringBuilder();
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "gbk"));
			String line = null;
			String id = null;
			String name = null;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("areaid") != -1) {
					String tmp = line.substring(line.indexOf("=>") + 2);
					id = tmp.substring(tmp.indexOf("'")+1, tmp.lastIndexOf("'"));
				} else if (line.indexOf("areaname") != -1) {
					String tmp = line.substring(line.indexOf("=>") + 2);
					name = tmp.substring(tmp.indexOf("'")+1, tmp.lastIndexOf("'"));
					if(id!=null){
						sb.append("insert into tmp values('").append(id).append("','").append(name).append("');").append("\n");
						id=null;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

	public static void d(String file, String type, String typedesc) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "gbk"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				if (line.indexOf("<select") != -1) {
					// String tmp=line.substring(line.indexOf("name='")+6);
					// type=tmp.substring(0,tmp.indexOf("'"));
					sb.append(
							"insert into t_dictionarytype(type,name) values('")
							.append(type).append("','").append(typedesc)
							.append("');");
				} else if (line.indexOf("<option") != -1) {
					sb.append("\n");
					String tmp = line.substring(line.indexOf("value=\"") + 7);// '
					String name = tmp.substring(0, tmp.indexOf("\""));// '
					sb.append("insert into t_dictionay(id,type,name) values('")
							.append(name).append("','").append(type)
							.append("','").append(name).append("');");
				}
			}
			br.close();
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void c(String password) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

			System.out.println("Digest(in hex format):: " + sb.toString());

			// convert the byte to hex format method 2
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			System.out.println("Digest(in hex format):: "
					+ hexString.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void b() {
		try {
			String srcDirPath = "D:\\projects\\qjsc\\ab";
			// 转为UTF-8编码格式源码路径
			String utf8DirPath = "D:\\projects\\qjsc\\ab1";

			// 获取所有java文件
			File d = new File(srcDirPath);
			File f[] = d.listFiles();

			for (File javaGbkFile : f) {
				// UTF8格式文件路径
				String utf8FilePath = utf8DirPath
						+ javaGbkFile.getAbsolutePath().substring(
								srcDirPath.length());
				// 使用GBK读取数据，然后用UTF-8写入数据
				FileUtils.writeLines(new File(utf8FilePath), "UTF-8",
						FileUtils.readLines(javaGbkFile, "GBK"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void a() {
		File d = new File("D:\\projects\\qjsc\\ab");
		File f[] = d.listFiles();
		for (File fi : f) {
			String name = fi.getAbsolutePath();
			String newname = name.replaceAll("1\\.", "\\.").replaceAll("_", "")
					.replaceAll("htm", "jsp");
			fi.renameTo(new File(newname));
		}

	}
}
