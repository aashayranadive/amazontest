package com.amazon.pages;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;



public class KindlePage extends BasePage {


	public static void selectKindleBasic() throws Exception{
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//scrollDown();
		//MobileElement kindleresultheader = driver.findElement(By.id("s-slick-result-header"));
		MobileElement kindleBasic = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View");

		try {
			if (kindleBasic.isDisplayed()) {
				kindleBasic.click();
				Log.info("Kindle Basic is selected");
				reporting("Select Kindle Basic", "Kindle Basic item should be selected",
						"Kindle Basic item is selected", "pass");
			}
			else {
				Log.info("Kindle Basic is selected");
				reporting("Select Kindle Basic", "Kindle Basic item should be selected",
						"Kindle Basic item is not selected", "fail");
			}
		}
		catch (Exception e) {

		}
	}

}
