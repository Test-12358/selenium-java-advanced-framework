package com.letsKodeit.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {
	public SearchResults(WebDriver driver){
		this.driver = driver;
	}
	public WebDriver driver;
    private String courselist = "//div[@class='zen-course-list']";
    public int coursesCount(){
    	List<WebElement> courses = driver.findElements(By.xpath(courselist));
    	return courses.size();
    }
    public boolean verifySearchResult(){
    	boolean result = false;
    	if(coursesCount()>0){
    		result = true;
    	}
    	return result;
    }
}
