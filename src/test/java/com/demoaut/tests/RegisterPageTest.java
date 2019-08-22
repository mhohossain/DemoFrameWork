package com.demoaut.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demoaut.base.TestBase;
import com.demoaut.pages.LoginPage;
import com.demoaut.pages.RegisterPage;
import com.demoaut.utilities.TestUtil;

public class RegisterPageTest extends TestBase {
	RegisterPage registerpage;
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		registerpage = new RegisterPage();
		loginpage = new LoginPage();
		registerpage = loginpage.clickOnRegisterLink();
	}

	@Test(priority=2,dataProvider = "getdata")
	public void registerUserTest(String fname, String lname, String phoneNum, String mail, String cityname,
			String statename, String countryname, String uname, String psw, String cpsw) throws Exception {
		loggertest=extent.createTest("registerUserTest");
		registerpage.registerUser(fname, lname, phoneNum, mail, cityname, statename, countryname, uname, psw, cpsw);
	boolean conf_message=registerpage.verifyRegConfirmationMessage(fname,lname);
	Assert.assertTrue(conf_message);
	}
	@Test(priority=1)
	public void verifyRegisterPageTitleTest() {
		loggertest=extent.createTest("verifyRegisterPageTitleTest");
	  String title=	registerpage.getRegisterPageTitle();
	  Assert.assertEquals(title, "Register: Mercury Tours");
	}

	@DataProvider(name = "getdata")
	public Object[][] gettestdata() throws Exception {
		Object[][] data = TestUtil.getData("register");
		return data;
	}



}
