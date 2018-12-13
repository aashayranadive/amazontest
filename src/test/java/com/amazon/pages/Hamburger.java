package com.amazon.pages;


import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileElement;

public class Hamburger extends BasePage 
{

	//static MobileElement ShopByCat=driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"in.amazon.mShop.android.shopping:id/gno_drawer_item\").instance(1)"));
	static MobileElement ShopByCat = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]"));
	
	public static void tapShopByCategory() throws Exception
	{
		try { if(ShopByCat.isDisplayed()) {
			ShopByCat.click();
			Log.info("Shop By Category is Tapped");
			reporting("Shop By Category Selection", "Shop By Category should be clicked",
					"Shop By Category is be clicked", "pass");
		}
		else {
			Log.info("Shop By Category is not Tapped");
			reporting("Shop By Category Selection", "Shop By Category should be clicked",
					"Shop By Category is not clicked", "fail");
			Assert.fail();
		}
		}
		catch(Exception e) {
		}

	}
}
