package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserName {
	
	WebDriver ldriver;
	public RegisteredUserName(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[@title='View my customer account']") WebElement userName;
	@FindBy(linkText="Sign out") WebElement signOut;
	
	public String getUserName() {
		
		String text=userName.getText();
		return text;
		
		}
	public void clickonSignout() {
		signOut.click();
	}

}
