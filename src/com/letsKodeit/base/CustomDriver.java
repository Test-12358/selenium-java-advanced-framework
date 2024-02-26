package com.letsKodeit.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.letsKodeit.Utilities.Util;

public class CustomDriver{
	public WebDriver driver;
	public CustomDriver(){
		
	}
	public CustomDriver(WebDriver driver){
		this.driver = driver;
	}
	public String takeScreenshot(String methodName, String browserName) {
        String fileName = Util.getScreenshotName(methodName, browserName);
        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        new File(screenshotDir).mkdirs();
        String path = screenshotDir + fileName;

        try {
            File screenshot = ((TakesScreenshot)driver).
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            System.out.println("Screen Shot Was Stored at: "+ path);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}