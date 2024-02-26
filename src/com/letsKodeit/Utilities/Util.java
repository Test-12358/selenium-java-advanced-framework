package com.letsKodeit.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
	public static String getReportName(){
		String localDateTime = getCurrentDateTime();
		StringBuilder name = new StringBuilder().append("AutomationReport_")
				             .append(localDateTime).append(".html");
		return name.toString();
	}
	public static String getCurrentDateTime(){
		 Calendar currentDate = Calendar.getInstance();
	        SimpleDateFormat formatter = new SimpleDateFormat(
	                "MM/dd/yyyy HH:mm:ss");
	        String date = formatter.format(currentDate.getTime()).replace("/", "_");
	        date = date.replace(":", "_");
	        System.out.println("Current Date and Time :: " + date);
	        return date;
	}
    public static String getScreenshotName(String methodName, String browserName) {
    	String localDateTime = getCurrentDateTime();
		StringBuilder name = new StringBuilder().append(browserName)
		                                        .append("_")
		                                        .append(methodName)
		                                        .append("_")
		                                        .append(localDateTime)
		                                        .append(".png");
		return name.toString();
		}
}
