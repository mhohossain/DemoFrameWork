package com.demoaut.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.demoaut.base.TestBase;
import com.demoaut.pages.FindFlightPage;
import com.demoaut.pages.HomePage;
import com.demoaut.pages.LoginPage;
import com.demoaut.utilities.TestUtil;

public class LoginPageTest extends TestBase{

	public LoginPage loginPage ;
	public HomePage homepage;
	
	@BeforeMethod
	public void setUp()  {
		initializeBrowser();
		loginPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void verifyLoginPageTitleTest() {
	  loggertest= extent.createTest("verifyLoginPageTitleTest");
		String LoginP_title = loginPage.getLoginPageTitle();
		Assert.assertEquals(LoginP_title, "Welcome: Mercury Tours","the title of the page is incorrect");
	}
	
	@Test(priority=2)
	public void verifyLoginPageLogoTest() {
		 loggertest=extent.createTest("verifyLoginPageLogoTest");	
	 boolean LoginP_logo = loginPage.verifyLoginPageLogo();
	 Assert.assertTrue(LoginP_logo,"the logo wasn't displayed");
	}
	@Test (priority=3)
	public void verifyLoginPageDateTest() {
		 loggertest=extent.createTest("verifyLoginPageDateTest");	
	boolean LoginP_date=loginPage.getDateLoginPage().isDisplayed();
	Assert.assertTrue(LoginP_date,"the date wasn't displayed");
	}
	@Test(priority=4)
	public void verifyLoginPageDateValueTest() {
		 loggertest=	extent.createTest("verifyLoginPageDateValueTest");	
	String date_value=loginPage.getDateLoginPage().getText();
	Assert.assertEquals(date_value, TestUtil.getCurrentDate());
	}
	@Test(priority=5)
	public void loginTest() throws Exception {
		 loggertest=	extent.createTest("loginTest");
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
         String homePageTitle=driver.getTitle();
		Assert.assertEquals(homePageTitle,"Find a Flight: Mercury Tours:" ," the login was not successful!");
	}
	

		
		
	
	
}
