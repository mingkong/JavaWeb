package com.web.master.component.test.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String now() {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fm.format(new Date());
	}
	
	public static String getDate() {
		return now().substring(0, 10);
	}
	
	public static String getDate(String fmt) {
		SimpleDateFormat fm = new SimpleDateFormat(fmt);
		return fm.format(new Date());
	}
	
	public static String getTime(Date date) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fm.format(date);
	}
	
	public static Date toDate(String date) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fm.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date toTime(String date) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fm.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
}
