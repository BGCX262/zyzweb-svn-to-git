package com.web.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;

public class TableGenHelper {
	public static void main(String args[]) {
		// updateComment("phpcms_info_23", "c:/a.txt");
		Map<String, Map<String, String>> m = parseAllInputs("C:\\code");
		for (Map<String, String> mi : m.values()) {
			System.out.println(mi);
		}
	}

	public static void updateComment(String tablename, String fileName) {
		Properties ps = System.getProperties();
		Enumeration e = ps.elements();
		// for(Hashtable o=
		// e.nextElement();e.hasMoreElements();o=e.nextElement()){
		// System.out.println(o.toString());
		// }

		Map<String, String> names = getInputNames(fileName);
		updateComment(tablename, names);
	}

	private static void updateComment(String tableName,
			Map<String, String> names) {
		try {
			Connection connection;
			Statement statement;
			ResultSet resultSet;
			ResultSetMetaData rsMetaData;
			String url = "jdbc:mysql://localhost:3306/gzcpc";
			String username = "root";
			String password = "root";
			// 加载驱动程序以连接数据库

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

			String query = "SELECT * FROM " + tableName;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			ResultSetMetaData rsrsmd = resultSet.getMetaData();
			for (int i = 1; i <= rsrsmd.getColumnCount(); ++i) {
				String name = rsrsmd.getColumnName(i);
				String type = rsrsmd.getColumnTypeName(i);
				String comment = names.get(name);
				if (comment != null) {
					String update = "ALTER TABLE " + tableName
							+ " CHANGE COLUMN " + name + " " + type
							+ " COMMENT '" + comment + "'";
					System.out.println(update);
				}

			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Map<String, Map<String, String>> parseAllInputs(String dir) {
		File dirs = new File(dir);
		Map<String, Map<String, String>> m = new HashMap<String, Map<String, String>>();
		for (File fi : dirs.listFiles()) {
			String filename = fi.getAbsolutePath();
			Map<String, String> mi = getInputNames(filename);
			if (mi.get("title") != null) {
				m.put(mi.get("title"), mi);
			}
		}
		return m;
	}

	private static Map<String, String> getInputNames(String fileName) {
		Map<String, String> names = new HashMap<String, String>();
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "gbk"));
			String line = null;

			List<String> list = new LinkedList<String>();

			while ((line = br.readLine()) != null) {
		
				if (line.indexOf("<input") != -1) {
					if(line.indexOf("\"my_yb\"")!=-1){
						int i=3;
					}
					String s1 = line.substring(line.indexOf("<input"));
					String s2 = s1.substring(0, s1.indexOf(">"));
					// <input name="my_zgxlzy" type="text" class="loginInput"
					// id="my_zgxlzy" size="24"
					String s3 = s2.substring(s2.indexOf("name=\"") + 6);
					String id = s3.substring(0, s3.indexOf("\""));
					String name = null;
					String lastLine = null;
					if (list.size() > 0) {
						boolean isbreak=false;
						for (int i = list.size()-1; i >= 0; i--) {
							try {
								lastLine = list.get(i);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if (lastLine.indexOf("class=\"loginText\"")!=-1 &&( lastLine.indexOf("F4FAF2") != -1||lastLine.indexOf("FFFFFF")!=-1)) {
								try {
									name = lastLine.substring(
											lastLine.indexOf(">") + 1,
											lastLine.indexOf("</"));
								} catch (Exception e) {
									if(lastLine.indexOf("<br />")!=-1){
									name = lastLine.substring(
											lastLine.indexOf(">") + 1,
											lastLine.indexOf("<br />"));
									names.put(id, name);
									list.clear();
									isbreak=true;
									break;
									
									}
									
									System.out.println(lastLine);
									continue;
								}
								names.put(id, name);
								list.clear();
								isbreak=true;
								break;
							}
						}
						if(!isbreak){
//							System.out.println("---------------"+line);
						}
						list.clear();
					}

				} else if (line.indexOf("<textarea") != -1) {
					String s1 = line.substring(line.indexOf("<textarea"));
					String s2 = s1.substring(0, s1.indexOf(">"));
					// <textarea rows="8" cols="74"
					// style="border: 1px solid #BCBCBB;" id="my_jsly"
					// name="my_jsly">
					String s3 = s2.substring(s2.indexOf("name=\"") + 6);
					String id = s3.substring(0, s3.indexOf("\""));
					String name = null;
					String lastLine = null;
					if (list.size() > 0) {
						boolean isbreak=false;
						for (int i = list.size() - 1; i >= 0; i--) {
							lastLine = list.get(i);
							if (lastLine.indexOf("class=\"loginText\"")!=-1 &&( lastLine.indexOf("F4FAF2") != -1||lastLine.indexOf("FFFFFF")!=-1)) {
								try {
									name = lastLine.substring(
											lastLine.indexOf(">") + 1,
											lastLine.indexOf("</"));
								} catch (Exception e) {
									if(lastLine.indexOf("<br />")!=-1){
										name = lastLine.substring(
												lastLine.indexOf(">") + 1,
												lastLine.indexOf("<br />"));
										names.put(id, name);
										list.clear();
										isbreak=true;
										break;
										}
									System.out.println(lastLine);
									continue;
								}
								names.put(id, name);
								list.clear();
								isbreak=true;
								break;
							}
						}
						list.clear();
					}
				} else {
					list.add(line);
					// lastLine = line;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return names;
	}

}
