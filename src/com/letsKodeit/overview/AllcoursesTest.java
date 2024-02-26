package com.letsKodeit.overview;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.letsKodeit.Utilities.ExcelUtility;
import com.letsKodeit.base.Constants;
import com.letsKodeit.pageClasses.CategoryFilterPage;
import com.letsKodeit.pageClasses.NavigationPage;
import com.letsKodeit.pageClasses.SearchCourse;

public class AllcoursesTest extends BaseTest{
	@DataProvider(name = "verifySearchCourseData")
	public Object[][] getSearchCourseData(){
		Object[][] testData = ExcelUtility.getTestData("verify_search_course");
		return testData;
	}
	@BeforeClass
	public void setUp(){
	    navigation = login.signin(Constants.DEFAULT_EMAIL, Constants.DEFAULT_PASSWORD);
	    ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTest");
	}
	@Test(dataProvider = "verifySearchCourseData")
	public void verifySearchCourse(String courseName){
	    navigation.AllCourses();
	    Search = new SearchCourse(driver);
		results = Search.course(courseName);
		boolean resultpage = results.verifySearchResult();
		Assert.assertTrue(resultpage);
	}
	@Test
	public void filterByCategory(){
	    navigation = new NavigationPage(driver);
		navigation.AllCourses();
		category = new CategoryFilterPage(driver);
		results = category.select("Selenium WebDriver");
		boolean resultpage = results.verifySearchResult();
		Assert.assertTrue(resultpage);
		Boolean res = category.filterresults();
		Assert.assertTrue(res);
		
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
