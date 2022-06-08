package com.pccth.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * @author Staff PCC
 */
public class Tools {
	//yyyymmdd
	public static String getLocalDate() {
		Locale locale = new Locale("en", "US");
		Date date = new Date();
		SimpleDateFormat template = new SimpleDateFormat("yyyyMMdd",locale);
		return template.format(date);
	}
	
	//yyyy-mm-dd
	public static String getLocalDateSeparate() {
		Locale locale = new Locale("en", "US");
		Date date = new Date();
		SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd",locale);
		return template.format(date);
	}

	
	//yyyy-mm-dd
	public static String changeDateFormat(String date) throws ParseException {
		String oldFormat = "yyyy-MM-dd HH:mm:ss.s";
		String newFormat = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
		java.util.Date d = sdf.parse(date);
		sdf.applyPattern(newFormat);
		String newDate = sdf.format(d);
		return newDate;
		
	}
	 public static String getYearTH() {
	       String dateStr = "";
	       try {
	    	   
	           SimpleDateFormat formatter = new SimpleDateFormat("yy", Locale.getDefault());
	           formatter.setLenient(false);
	           dateStr = formatter.format(new Date());
	       } catch (Exception e) {
	           return null;
	       }
	       return dateStr;
	   }
}// End Class