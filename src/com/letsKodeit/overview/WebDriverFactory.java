package com.letsKodeit.overview;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.letsKodeit.base.Constants;

public class WebDriverFactory {
	public static final Logger log = LogManager.getLogger(WebDriverFactory.class.getName());
	public static final WebDriverFactory instance = new WebDriverFactory();
    private WebDriverFactory(){
    	
    }
    public static WebDriverFactory getinstance(){
    	return instance;
    }
    private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<String> threadedBrowser = new ThreadLocal<String>();
    public WebDriver getDriver(String browser){
    	WebDriver driver = null;
    	setDriver(browser);
    	threadedBrowser.set(browser);
    	if(threadedDriver.get() == null){
    	try{
    		if(browser.equalsIgnoreCase("Firefox")){
    			FirefoxOptions FFoptions = setFFOptions();
    			driver = new FirefoxDriver(FFoptions);
    			threadedDriver.set(driver);
    		}
    		if(browser.equalsIgnoreCase("Chrome")){
    			ChromeOptions chromeoptions = setChromeOptions();
    			driver = new ChromeDriver(chromeoptions);
    			threadedDriver.set(driver);
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	threadedDriver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	threadedDriver.get().manage().window().maximize();
    	}
    	return threadedDriver.get();
    }
    public String getBrowser(){
    	return threadedBrowser.get();
    }
    public void quitDriver(){
    	threadedDriver.get().quit();
    	threadedDriver.set(null);
    }
    private void setDriver(String browser){
    	String driverPath = "";
    	String os = System.getProperty("os.name").toLowerCase().substring(0,3);
    	log.info("OS name from system property :: "+ os);
    	String directory = Constants.USER_DIRECTORY+Constants.DRIVERS_DIRECTORY;
    	String driverkey = "";
    	String drivervalue = "";
    	if(browser.equalsIgnoreCase("Firefox")){
    		driverkey = "webdriver.gecko.driver";
    		drivervalue = "geckodriver";
    	}
    	else if(browser.equalsIgnoreCase("Chrome")){
    		driverkey = "webdriver.chrome.driver";
    		drivervalue = "chromedriver";
    	}
    	else
    		log.info("Browser type not supported");
    	driverPath = directory + drivervalue +(os.equals("win")? ".exe" :"");
    	log.info("Driver Binary ::"+ driverPath);
    	log.info(driverkey, driverPath);
    }
    private ChromeOptions setChromeOptions(){
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("disable-infobar");
    	return options;
    }
    private FirefoxOptions setFFOptions(){
    	FirefoxOptions options = new FirefoxOptions();
    	options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
    	return options;
    }
   
}
