package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetail {

	WebDriver ldriver;
	public AccountCreationDetail(WebDriver rdriver) {
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="id_gender1") WebElement Title;
	@FindBy(id="customer_firstname") WebElement FName;
	@FindBy(id="customer_lastname") WebElement LName;
	@FindBy(id="passwd") WebElement Password;
	@FindBy(id="newsletter") WebElement RadioButton;
	@FindBy(id="submitAccount") WebElement register;


	public void selectTitleMrs() {
		Title.click();
	}
	public void customerfistname(String fname) {
		FName.sendKeys(fname);
	}
	public void customerlastname(String lname) {
		LName.sendKeys(lname);
	}
	public void customerPasswordselect(String pwd) {
		Password.sendKeys(pwd);
	}
	public void selectradio() {
		RadioButton.click();

	}
	public void clickonregister() {
		register.click();
	}

}