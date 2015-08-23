package com.web.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlowNo {
	public static String getFlowNo() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		String ctime = sd.format(new Date());
		return ctime+"000001";
	}
}
