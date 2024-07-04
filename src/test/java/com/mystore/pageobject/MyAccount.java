package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
WebDriver ldriver;
	
	public MyAccount(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	//for account create
	@FindBy(id="email_create") WebElement createemailid;
	@FindBy(id="SubmitCreate") WebElement SubmitCreate;
	@FindBy(id="email") WebElement registedEmailid;
	//Already registered User
	@FindBy(id="passwd") WebElement registerdUserPwd;
	@FindBy(id="SubmitLogin") WebElement clickedonsignin;
	
	public void entreCreateEmailAddress(String emailAdd ) {
		createemailid.sendKeys(emailAdd);
		
	}
	
	public void clickonsublitcreate() {
		SubmitCreate.click();
		
	}
	public void entreEmailAddress(String emailAdd ) {
		registedEmailid.sendKeys(emailAdd);
		
	}
	public void entrePassword(String pwd ) {
		registerdUserPwd.sendKeys(pwd);
		
	}
	
	public void clicksubmit() {
		clickedonsignin.click();
		
	}


}
