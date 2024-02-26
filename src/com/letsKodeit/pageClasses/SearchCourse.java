package com.letsKodeit.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCourse {
	public SearchCourse(WebDriver driver){
		this.driver = driver;
	}
	public WebDriver driver;
	public String search_field = "//input[@id='search']";
	public String search_icon = "//button[@type='submit']";
	public SearchResults course(String Course){
		WebElement search = driver.findElement(By.xpath(search_field));
		search.clear();
		search.sendKeys(Course);
		driver.findElement(By.xpath(search_icon)).click();
		return new SearchResults(driver);
	}

}
