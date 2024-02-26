package com.letsKodeit.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public LoginPage(WebDriver driver){
    	this.driver = driver;
    }
    public WebDriver driver;
    private String Email_textbox = "email";
    private String Password_textbox = "login-password";
    private String login_button = "//button[@value='Login']";
 
    public NavigationPage signin(String email, String Password){
    	WebElement email_field = driver.findElement(By.id(Email_textbox));
    	email_field.clear();
    	email_field.sendKeys(email);
    	WebElement password_field = driver.findElement(By.id(Password_textbox));
    	password_field.clear();
    	password_field.sendKeys(Password);
    	driver.findElement(By.xpath(login_button)).click();
    	return new NavigationPage(driver);
    }
}
