package com.demoaut.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoaut.base.TestBase;
import com.demoaut.utilities.TestUtil;

public class FindFlightPage extends TestBase {

	@FindBy(xpath = "//font[contains(text(),'Details')]")
	WebElement flight_details_label;

	@FindBy(name = "passCount")
	WebElement passanger_count;

	@FindBy(name = "fromPort")
	WebElement departing_port;

	@FindBy(name = "fromMonth")
	WebElement departing_month;

	@FindBy(name = "fromDay")
	WebElement departing_day;

	@FindBy(name = "toPort")
	WebElement arriving_port;

	@FindBy(name = "toMonth")
	WebElement returning_month;

	@FindBy(name = "toDay")
	WebElement returning_day;

	@FindBy(name = "airline")
	WebElement airline;

	@FindBy(name = "findFlights")
	WebElement findFlights_btn;

	public FindFlightPage() {
		PageFactory.initElements(driver, this);
	}

	public String getFindFlightsTitle() {
		return driver.getTitle();
	}
	public void clickOnContinue() {
		findFlights_btn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public boolean verifyFlightsDetailsLabel() {
		return flight_details_label.isDisplayed();
	}

	public SelectFlightPage findFlights(String typeFlight, String passangerCont, String deparPort, String deparMonth,
			String deparDay, String arrivPort, String returMonth, String returDay, String serviClass, String airln)
			throws Exception {
		String classService =null ;
	    String typeFli=(typeFlight.toLowerCase()).replaceAll("\\s", "");
	    if(serviClass.equalsIgnoreCase("Economy class")) {
	       classService = "Coach";
	    }else if (serviClass.equalsIgnoreCase("Business class")) {
	    	 classService = "Business";
	    }else  classService = "First";
	    
	    
		driver.findElement(By.xpath("//input[@type='radio' and @value='" + typeFli + "']")).click();
		TestUtil.selectDropDown(passanger_count, passangerCont);
		TestUtil.selectDropDown(departing_port, deparPort);
		TestUtil.selectDropDown(departing_month, deparMonth);
		TestUtil.selectDropDown(departing_day, deparDay);
		TestUtil.selectDropDown(arriving_port, arrivPort);
		TestUtil.selectDropDown(returning_month, returMonth);
		TestUtil.selectDropDown(returning_day, returDay);
		driver.findElement(By.xpath("//input[@value='" + classService + "']")).click();
		TestUtil.selectDropDown(airline, airln);
		findFlights_btn.click();
		Thread.sleep(1000);
		return new SelectFlightPage();
	}

}
