package com.amazon.pages;

import org.testng.Assert;

import io.appium.java_client.MobileElement;

public class Category extends BasePage 
{
	public static void tapKindleCat() throws Exception {
		MobileElement kindleCat= driver.findElementByXPath("//android.view.View[@content-desc='Kindle E-Readers & eBooks']");
		try {
			if(kindleCat.isDisplayed()) {
				kindleCat.click();
				Log.info("Kindle Category is selected");
				reporting("Kindle Category selection", "Kindle category should be clicked",
						"Kindle category is be clicked", "pass");
			}
			else {Log.info("Kindle Category is not Tapped");
			reporting("Kindle Category Selection", "Kindle Category should be clicked",
					"Kindle Category is not clicked", "fail");
			Assert.fail();
			}
		}
		catch (Exception e) {
		}
	}

	public static void selKindleEreader() throws Exception{
		MobileElement kindleEreader = driver.findElementByXPath("//android.view.View[@content-desc='Kindle E-Readers ']");
		try{ if(kindleEreader.isDisplayed()) {
			kindleEreader.click();
			Log.info("Kindle E-Reader is selected");
			reporting("Select Kindle E-Reader", "Kindle E-Reader section should open",
					"Kindle E-Reader Section is Opened", "pass");
		}
		else {Log.info("Kindle Category is not Tapped");
		reporting("Select Kindle E-Reader", "Kindle E-Reader section should open",
				"Kindle E-Reader Section failed to Open", "fail");
		Assert.fail();
		}
		}
		catch (Exception e) {

		}
	}
}
