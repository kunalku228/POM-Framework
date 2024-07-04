package com.mystore.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetail;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserName;

import junit.framework.Assert;

public class TC_MyAccountPageTest extends BaseClass {
	@Test(enabled=false)
	public void verifyRegistrationAndLogin() {
	
		
		IndexPage pg =new IndexPage(driver);
		pg.clickonSignIn();
		logger.info("Clicked on SignIn button");
		
		MyAccount myAc=new MyAccount(driver);
		
		myAc.entreCreateEmailAddress("qwerty25@gmail.com");
		logger.info("Email id Created");
		myAc.clickonsublitcreate();
		logger.info("Click on Submit button");
		
		AccountCreationDetail accCreDet=new AccountCreationDetail(driver);
		accCreDet.selectTitleMrs();
		accCreDet.customerfistname("Rahul");
		accCreDet.customerlastname("Kumar");
		accCreDet.customerPasswordselect("RR@632");
		accCreDet.selectradio();
		logger.info("Enter deatail on account creation page");
		accCreDet.clickonregister();
		logger.info("click on register button.");
		
		RegisteredUserName regUser=new RegisteredUserName(driver);
		String userName =regUser.getUserName();
		
		Assert.assertEquals("Rahul Kumar",userName );
		}
	@Test
	public void verifyLogin() throws IOException {
		
		IndexPage pg =new IndexPage(driver);
		pg.clickonSignIn();
		logger.info("Clicked on SignIn button");
		
		MyAccount myAc=new MyAccount(driver);
		
		myAc.entreEmailAddress("qwerty25@gmail.com");
		logger.info("Email address entered.");
		myAc.entrePassword("RR@632");
		logger.info("Password entered");
		myAc.clicksubmit();
		logger.info("click on submit button");
		RegisteredUserName regUser=new RegisteredUserName(driver);
		String userName =regUser.getUserName();
		
		if (userName.equals("Rahul Kumar"))
		{
			logger.info("Verify user name passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Verfiy user named failed");
			Assert.assertTrue(false);
			captureScreenshot(driver,"verifyLogin");
		}
	}

}
