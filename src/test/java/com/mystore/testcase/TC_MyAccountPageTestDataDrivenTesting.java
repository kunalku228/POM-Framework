package com.mystore.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetail;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserName;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {
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
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException {
		
		IndexPage pg =new IndexPage(driver);
		pg.clickonSignIn();
		logger.info("Clicked on SignIn button");
		
		MyAccount myAc=new MyAccount(driver);
		
		myAc.entreEmailAddress(userEmail);
		logger.info("Email address entered.");
		myAc.entrePassword(userPwd);
		logger.info("Password entered");
		myAc.clicksubmit();
		logger.info("click on submit button");
		RegisteredUserName regUser=new RegisteredUserName(driver);
		String userName =regUser.getUserName();
		
		if (userName.equals(expectedUsername))
		{
			logger.info("Verify user name passed");
			Assert.assertTrue(true);
			regUser.clickonSignout();
		}
		else {
			logger.info("Verfiy user named failed");
			Assert.assertTrue(false);
			captureScreenshot(driver,"verifyLogin");
		}
	}
	@DataProvider(name="LoginDataProvider")
    public String[][] LoginDataProvider(){
    	
    	String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}
    	
    }
   
