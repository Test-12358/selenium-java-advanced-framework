package com.letsKodeit.overview;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.letsKodeit.base.Constants;
import com.letsKodeit.pageClasses.CategoryFilterPage;
import com.letsKodeit.pageClasses.LoginPage;
import com.letsKodeit.pageClasses.NavigationPage;
import com.letsKodeit.pageClasses.SearchCourse;
import com.letsKodeit.pageClasses.SearchResults;

public class BaseTest {
	WebDriver driver;
	String Base_URL;
	LoginPage login;
	NavigationPage navigation;
	SearchCourse Search;
	SearchResults results ;
	CategoryFilterPage category;
	@BeforeClass
	@Parameters({"browser"})
	public void commonSetUp(String browser){
		driver = WebDriverFactory.getinstance().getDriver(browser);
		Base_URL = Constants.BASE_URL;
		driver.get(Base_URL);
		driver.manage().window().maximize();
		navigation = new NavigationPage(driver);
		login = navigation.login();
	}
	@BeforeMethod
	public void methodSetup(){
		CheckPoint.clearHashMap();
	}
	@AfterClass
	public void commonTearDown(){
		WebDriverFactory.getinstance().quitDriver();
	}

}
