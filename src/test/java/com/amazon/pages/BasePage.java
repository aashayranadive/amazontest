package com.amazon.pages;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
	public static AppiumDriver<MobileElement> driver;
	public static ExtentTest test;
	public static ExtentReports report ;
	static Logger Log = Logger.getLogger(Logger.class.getName());

	@BeforeSuite
	public static AppiumDriver<MobileElement> capabilities() throws Exception
	{
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Galaxy Grand Prime");
		cap.setCapability("platformVersion", "5.1.1");
		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");		
		cap.setCapability("noReset", "true");
		try {
			driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		catch (Exception e) {
		}
		return driver;
	}

	//Capture Screenshot
	public static String getScreenshot(AppiumDriver<MobileElement> driver) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@BeforeClass
	public void startTest(){
		report = new ExtentReports(System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
		return;
	}

	@AfterClass
	public static void endTest(){
		report.endTest(test);
		report.flush();	
	}

	public static void reporting(String Description, String Expected, String Actual, String StepStatus) throws Exception {
		String screenshotPath = getScreenshot(driver);
		if(StepStatus.toLowerCase().contains("pass")) {
			test.log(LogStatus.PASS, Description,Actual);
		}
		else if (StepStatus.toLowerCase().contains("fail")) {
			test.log(LogStatus.FAIL, Description,Actual);
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
	}
	
	
	
public static void scrollDown() throws Exception {
		//The viewing size of the device
		Dimension size = driver.manage().window().getSize();
		//Starting y location set to 80% of the height (near bottom)
		int starty = (int) (size.height * 0.80);
		//Ending y location set to 20% of the height (near top)
		int endy = (int) (size.height * 0.20);
		//x position set to mid-screen horizontally
		int startx = size.width / 2;

		new TouchActions(driver).down(startx, starty)
		.move(startx, endy)
		.release()
		.build()
		.perform();
	}
}


