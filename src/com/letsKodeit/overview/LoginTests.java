package com.letsKodeit.overview;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.letsKodeit.base.Constants;


public class LoginTests extends BaseTest{
	
	@Test
	public void testlogin(){
		 navigation = login.signin(Constants.DEFAULT_EMAIL, Constants.DEFAULT_PASSWORD);
		 boolean result = navigation.isloggedin();
		 CheckPoint.markFinal("test-01", result, "login verification");
		 //Assert.assertTrue(result);
	}
	@AfterMethod
	public void afterMethod(){
		if(navigation.isloggedin()){
			navigation.logout();
		    navigation.login();
		}
	}
		
}
