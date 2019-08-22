package com.demoaut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.demoaut.base.TestBase;
import com.demoaut.utilities.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(linkText = "SIGN-ON")
	WebElement sign_on_link;

	@FindBy(linkText = "REGISTER")
	WebElement register_link;

	@FindBy(linkText = "SUPPORT")
	WebElement support_link;

	@FindBy(linkText = "CONTACT")
	WebElement contact_link;

	@FindBy(linkText = "//a[text()='Home']")
	WebElement Home_link;

	@FindBy(linkText = "//td[@colspan='2']//font//b[contains(text(),'Feb 12, 2019')]")
	WebElement date_label;

	@FindBy(name = "userName")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "login")
	WebElement sing_in_btn;
	
	@FindBy(xpath = "//img[@alt='Mercury Tours']")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}

	public HomePage login(String uname, String psw) throws Exception {
		
		userName.sendKeys(uname);
		password.sendKeys(psw);
		sing_in_btn.click();
		Thread.sleep(1000);
		return new HomePage();
	}

	public SignOnPage clickOnSignOnLink() {
		sign_on_link.click();
		return new SignOnPage();
	}

	public RegisterPage clickOnRegisterLink() {
		register_link.click();
		return new RegisterPage();
	}

	public WebElement getDateLoginPage() {
		
		WebElement date_App = driver.findElement(
				By.xpath("//td[@colspan='2']//font//b[contains(text(),'" + TestUtil.getCurrentDate() + "')]"));
		return date_App;
	}
	
	public boolean verifyLoginPageLogo() {
		
		return logo.isDisplayed();
	}

}
