package com.web.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormator {
public static String formatDate(Date d){
//	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date="";
	try {
		date=sd.format(d);
	} catch (Exception e) {
	}
	return date;
}
public static String formatDate1(Date d){
//	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	String date="";
	try {
		date=sd.format(d);
	} catch (Exception e) {
	}
	return date;
}
public static String formatDateTime(Date d){
	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date="";
	try {
		date=sd.format(d);
	} catch (Exception e) {
	}
	return date;
}

public static void main(String args[]){
	System.out.println(DateFormator.formatDate(new Date()));
}
}
