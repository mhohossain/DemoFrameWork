package com.demoaut.pages;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoaut.base.TestBase;

public class SelectFlightPage extends TestBase{

	
	@FindBy(name="reserveFlights")
	WebElement resert_flight_btn;
	
	
	public SelectFlightPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSelectFlightPageTitle() {
		return driver.getTitle();
	}

	
	
	public void selectFlights(int departNum, int returnNum) {
//		Scanner depart_scanner , return_scanner;
//		depart_scanner= new Scanner(System.in);
	//	System.out.println("please enter the departFlight number in the console: ");
	//	String DepartFlightNum =depart_scanner.nextLine();		
		driver.findElement(By.xpath("//input[contains(@value,'$"+departNum+"')]")).click();
//		return_scanner= new Scanner(System.in);
//		System.out.println("please enter the departFlight number in the console: ");
//		String returnFlightNum =return_scanner.nextLine();	
		driver.findElement(By.xpath("//input[contains(@value,'$"+returnNum+"')]")).click();
		resert_flight_btn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
}
