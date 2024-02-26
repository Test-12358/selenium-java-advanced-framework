package com.letsKodeit.Utilities;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.letsKodeit.base.Constants;
public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports getInstance(){
		if(extent == null){
			createInstance();
		}
		return extent;
	}
	public static synchronized ExtentReports createInstance(){
		String fileName = Util.getReportName();
		String reportsDirectory = Constants.REPORT_DIRECTORY;
		new File(reportsDirectory).mkdirs();
		String path = reportsDirectory + fileName;
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Automation Run");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		extent = new ExtentReports();
		extent.setSystemInfo("organization", "Lets Kode it");
		extent.setSystemInfo("Automation Framework", "Selenium Webdriver");
		extent.attachReporter(htmlReporter);
		return extent;
	}
}
