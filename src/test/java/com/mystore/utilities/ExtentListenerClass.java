package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void cofigureReport() {
		ReadConfig readConfig=new ReadConfig();
		String timestamp = new SimpleDateFormat("YYYY.MM.DD.hh.mm.ss").format(new Date());
		String reportName="MyStoreTestReport-" + timestamp + ".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
		//add system environment/information info to report
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("browser", readConfig.getbrowser());
		reports.setSystemInfo("User Name", "Kunal");
		
		//configuration to change look and feel of report
		
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onStart(ITestContext Result) {
		cofigureReport();
		System.out.println("On Start method Invoked");
	}
	public void onFinish(ITestContext Result) {
		
		System.out.println("On finish method Invoked");
		reports.flush();
	}
      public void onTestFailure(ITestResult  Result) {
		
		System.out.println("Name of the test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the fail test case is: " + Result.getName(), ExtentColor.RED));
		
		String screenshotpath= System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File screenshotfile =new File(screenshotpath);
		if (screenshotfile.exists())
		{
			test.fail("Captured screenshot is below:" + test.addScreenCaptureFromPath(screenshotpath));
		}
	}
      public void onTestSkipped(ITestResult Result) {
  		
  		System.out.println("Name of the test method Skip:" + Result.getName());
  		test = reports.createTest(Result.getName());
  		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
  	}
      public void onTestStart(ITestResult Result) {
    	  System.out.println("Name of the test method stated:" + Result.getName());
      }
      
      public void onTestSuccess(ITestResult Result) {
    		
    		System.out.println("Name of the test method passed:" + Result.getName());
    		test = reports.createTest(Result.getName());
    		test.log(Status.PASS, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.GREEN));
    	}
      
     
      public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    	  
    	  
      }
}
