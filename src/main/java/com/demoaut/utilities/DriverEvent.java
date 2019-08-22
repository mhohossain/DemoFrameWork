package com.demoaut.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.demoaut.base.TestBase;

public class DriverEvent extends TestBase implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("TRY TO NAVIGATE TO "+url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("NAVIGATE TO "+url);
			
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("TRYING TO FIND THE ELEMENT "+by);

		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("ELEMENT FOUND :"+element.getText());
	
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("TRYING TO CLICK ON :  "+element.getText());
			
		}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("CLICKING ON :  "+element.getText());

		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("PREPARING TO SEND KEYS ON THE ELEMENT : "+element.getText());
		
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		String word ="";
		for(CharSequence st:keysToSend) {
			System.out.println(st);
			word=word+" "+st.toString();
		}
		
		System.out.println("SENDING :===>'"+word+"' ON THE ELEMENT : "+element.toString());
		
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("TRYING TO GET THE TEXT FROM THE ELEMENT :"+element.toString());
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("GETTING THE TEXT :==>'"+text+"' FROM THE ELEMENT :"+element.toString());
		
		
	}

}
