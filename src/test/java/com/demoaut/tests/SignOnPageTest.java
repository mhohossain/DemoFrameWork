package com.demoaut.tests;



import org.testng.Assert;
import org.testng.annotations.*;

import com.demoaut.base.TestBase;
import com.demoaut.pages.LoginPage;
import com.demoaut.pages.SignOnPage;

public class SignOnPageTest extends TestBase{
    SignOnPage signpage;
	LoginPage loginpage;
	
	
	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		signpage= new SignOnPage();
		loginpage=new LoginPage();
		signpage=loginpage.clickOnSignOnLink();
	}
	
	@Test(priority=1)
	public void verifySignOnPageTitleTest() {
		loggertest=extent.createTest("verifySignOnPageTitleTest");
	String signOn_titlepage=signpage.getSignOnPageTitle();
	Assert.assertEquals(signOn_titlepage, "Sign-on: Mercury Tours","the title of the page is incorrect");
	}
	
	@Test(priority=2)
	public void signOnTest() throws Exception {
		loggertest=extent.createTest("signOnTest");
		signpage.signOn(prop.getProperty("username"), prop.getProperty("password"));
       String title = driver.getTitle();
       Assert.assertEquals(title, "Find a Flight: Mercury Tours:","the signOn was not successful!");
	}
	
	
	
	
}
