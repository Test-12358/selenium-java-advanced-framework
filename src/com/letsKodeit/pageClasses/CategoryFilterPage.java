package com.letsKodeit.pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CategoryFilterPage {
	public CategoryFilterPage(WebDriver driver){
		this.driver = driver;
	}
	public WebDriver driver;
	private String Category_dropdown = "//select[@name='categories']";
	public SearchResults select(String CategoryName){
		Select Categ = new Select(driver.findElement(By.xpath(Category_dropdown)));
		Categ.selectByVisibleText(CategoryName);
		return new SearchResults(driver);
		}
	public boolean filterresults(){
		boolean result = false;
		WebElement element = driver.findElement(By.xpath("//h1[text()='Category : Selenium WebDriver']"));
        //System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains("selenium-webdriver")){
        	result = true;
        }
        return result;
	}

}
