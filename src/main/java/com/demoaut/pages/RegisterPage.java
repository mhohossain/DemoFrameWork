package com.demoaut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoaut.base.TestBase;
import com.demoaut.utilities.TestUtil;

public class RegisterPage extends TestBase{

	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(id="userName")
	WebElement email;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="country")
	WebElement coutry;
	
	@FindBy(id="emailgg")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirm_password;
	
	@FindBy(name="register")
	WebElement submit_btn;
	
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getRegisterPageTitle() {
	  return driver.getTitle();
	}
	public void registerUser(String fname,String lname,String phoneNum, String mail,String cityname, String statename, String countryname,String uname, String psw, String cpsw) throws Exception {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		phone.sendKeys(phoneNum);
		email.sendKeys(mail);
		city.sendKeys(cityname);
		state.sendKeys(statename);
		TestUtil.selectDropDown(coutry, countryname);
		username.sendKeys(uname);
		password.sendKeys(psw);
		confirm_password.sendKeys(cpsw);
		submit_btn.click();
		Thread.sleep(1000);
		
	}
	public boolean verifyRegConfirmationMessage(String firstname,String lastname) {
		boolean message=driver.findElement(By.xpath("//b[text()=' Dear "+firstname+" "+lastname+",']")).isDisplayed();
		return message;
	}
}
