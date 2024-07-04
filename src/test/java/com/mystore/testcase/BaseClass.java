package com.mystore.testcase;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getbrowser();
	
	public static WebDriver driver;
	
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "msedge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			driver=null;
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger=LogManager.getLogger("MyStoreV1");
		
		driver.get(url);
		logger.info("Url opened");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver , String testName) throws IOException {
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest=new File(System.getProperty("user.dir") + "//Screenshots//" + testName +".png");
		
		FileUtils.copyFile(src, dest);
	}

}
