package com.demoaut.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoaut.base.TestBase;

public class SignOnPage extends TestBase{

	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement submit_Btn;
	
	public SignOnPage() {
		PageFactory.initElements(driver, this);
	}
	public String getSignOnPageTitle() {
		return driver.getTitle();
	}
	public HomePage signOn(String uname, String psw) throws Exception {
		username.sendKeys(uname);
		pass.sendKeys(psw);
		submit_Btn.click();
		Thread.sleep(500);
		return new HomePage();
	}
}
