package com.demoaut.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demoaut.base.TestBase;
import com.demoaut.pages.FindFlightPage;
import com.demoaut.pages.HomePage;
import com.demoaut.pages.LoginPage;
import com.demoaut.pages.SelectFlightPage;

public class SelectFlightPageTest extends TestBase {
	public SelectFlightPage selectflight;
	public LoginPage loginpage;
	public FindFlightPage findflight;
	public HomePage homepage;

	@BeforeMethod
	public void setUp() throws Exception {
		initializeBrowser();
		selectflight = new SelectFlightPage();
		loginpage = new LoginPage();
		findflight = new FindFlightPage();
		homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		findflight.clickOnContinue();

	}

	@Test(priority = 1)
	public void verifySelectFlightPageTitleTest() {
		loggertest=extent.createTest("verifySelectFlightPageTitleTest");
		String title = selectflight.getSelectFlightPageTitle();
		Assert.assertEquals(title, "Select a Flight: Mercury Toursffffff");
	}

	@Test(priority = 2)
	public void selectFlight() {
		loggertest=	extent.createTest("selectFlight");
	selectflight.selectFlights(363,631);
    
	}

	
}
