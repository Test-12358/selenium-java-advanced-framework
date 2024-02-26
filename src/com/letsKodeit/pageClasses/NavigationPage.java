package com.letsKodeit.pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {
	public NavigationPage(WebDriver driver){
		this.driver = driver;
	}
	public WebDriver driver;
	private String login_link = "//a[@href='/login']";
    private String AllCourses_URL = "https://www.letskodeit.com/courses";
    private String allcourses_tab = "//a[@href='/courses' and text()='ALL COURSES']/parent::li";
    private String mycourses_tab = "//a[@href='/mycourses' and text()='MY COURSES']/parent::li";
    private String login_img = "//img[@class='zl-navbar-rhs-img ']";
    private String logout_tab = "//a[@href='/logout']";
    public void AllCourses(){
    	driver.navigate().refresh();
    	driver.findElement(By.xpath(allcourses_tab)).click();
    }
    public void MyCourses(){
    	driver.navigate().refresh();
    	driver.findElement(By.xpath(mycourses_tab)).click();
    }

    public boolean isopen(){
    	return AllCourses_URL.equalsIgnoreCase(driver.getCurrentUrl());
    }
    public LoginPage login(){
    	driver.findElement(By.xpath(login_link)).click();
    	return new LoginPage(driver);
    }
    public boolean isloggedin(){
    	try{
    		WebElement login = driver.findElement(By.xpath(login_img));
    		return true;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    public void logout(){
    	driver.findElement(By.xpath(login_img)).click();
    	WebDriverWait wait = new WebDriverWait(driver,3);
    	WebElement logout_link = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(logout_tab))));
        logout_link.click();
    }
}
