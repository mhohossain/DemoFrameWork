package com.demoaut.base;



import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demoaut.utilities.DriverEvent;
import com.demoaut.utilities.TestUtil;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static DriverEvent driverEvent;
	public static ExtentHtmlReporter reporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest loggertest = null;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/com/demoaut/configuration/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("couldn't load properties file because: " + e.getMessage());

		}

	}

	public static void initializeBrowser() {
		String browserType = prop.getProperty("browser");
	

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./webDrivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./webDrivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		if (browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./webDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		driverEvent = new DriverEvent();
		e_driver.register(driverEvent);
	   
		driver = e_driver;
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@BeforeSuite
	public void initReprt() {
		reporter = new ExtentHtmlReporter("./reports/ExtentReprt"+TestUtil.getDate()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		

	}

	@AfterMethod
	public void parame(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {
			loggertest.log(Status.INFO, "Test name : " + result.getName());
			loggertest.log(Status.PASS, MarkupHelper
					.createLabel("the test " + result.getName() + "  is passed successfully", ExtentColor.GREEN));
          
		} else if (result.getStatus() == ITestResult.FAILURE) {
			
			loggertest.log(Status.INFO, "Test name : " + result.getName());
			loggertest.log(Status.FAIL,
					MarkupHelper.createLabel("the test " + result.getName() + "  is faild ", ExtentColor.RED));
			loggertest.log(Status.INFO, MarkupHelper.createLabel("raison of failure is : ", ExtentColor.RED));
			loggertest.log(Status.FAIL, result.getThrowable());
			loggertest.log(Status.FAIL, "the screen shot was attached at the end :");
			String pathShot = TestUtil.captureScreenShot(); 
			loggertest.addScreenCaptureFromPath(pathShot,result.getName());
			//loggertest.addScreenCaptureFromPath("./screenShot/",result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			loggertest.log(Status.INFO, "Test name : " + result.getName());
		    loggertest.log(Status.SKIP, MarkupHelper
				.createLabel("the test " + result.getName() + "  is skipped", ExtentColor.YELLOW));
		}
		 if (driver == null) {
		        return;
		    }
		    driver.quit();
		    driver = null;
		
	}

	@AfterSuite
	public void flush() {
		extent.flush();
	}

}
