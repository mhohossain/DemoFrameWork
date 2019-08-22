package com.demoaut.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demoaut.base.TestBase;
import com.demoaut.pages.FindFlightPage;
import com.demoaut.pages.HomePage;
import com.demoaut.pages.LoginPage;
import com.demoaut.pages.SelectFlightPage;
import com.demoaut.utilities.TestUtil;

public class FindFlightPageTest extends TestBase {
	public static FindFlightPage findflight;
	public static LoginPage loginpage;
	public static HomePage homepage;
	public static SelectFlightPage selectflight;

	@BeforeMethod
	public void setUp() throws Exception {
		initializeBrowser();
		homepage= new HomePage();
		findflight = new FindFlightPage();
		loginpage= new LoginPage();
		selectflight= new SelectFlightPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyFindFlightsPageTitleTest() {
	loggertest=	extent.createTest("verifyFindFlightsPageTitleTest");
	  String title=	findflight.getFindFlightsTitle();
	  Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
	}
    @Test(priority=2)
    public void verifyFlightDetailsLabelTest() {
    	loggertest=extent.createTest("verifyFlightDetailsLabelTest");
    	boolean details=findflight.verifyFlightsDetailsLabel();
    	Assert.assertTrue(details);
    }
	
	@Test(priority=3,dataProvider="getflightdata")
	public void findFlightTest(String typeFlight, String passangerCont, String deparPort, String deparMonth,
			String deparDay, String arrivPort, String returMonth, String returDay, String serviClass, String airln)
			throws Exception {
		loggertest=	extent.createTest("findFlightTest");
		findflight.findFlights(typeFlight, passangerCont, deparPort, deparMonth, deparDay, arrivPort, returMonth,
				returDay, serviClass, airln);
	String title1=selectflight.getSelectFlightPageTitle();
	Assert.assertEquals(title1,"Select a Flight: Mercury Tours");
		
	}
	
    @DataProvider(name="getflightdata")
    public Object[][] getmydata() throws Exception {
    	Object[][] data = null;
        data=TestUtil.getData("flight");
        return data;
    	
    }
    
 
    
	

}
