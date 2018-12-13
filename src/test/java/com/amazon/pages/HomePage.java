package com.amazon.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileElement;

public class HomePage extends BasePage{

	static MobileElement Hamburger=driver.findElement(By.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon"));

	public static void tapHamburgerButton() throws Exception{
		try { 
			if(Hamburger.isDisplayed()) {
				Hamburger.click();
				Log.info("Hamburger Icon is Tapped");
				reporting("Hamburger Icon selection", "Hamburger icon should be clicked",
						"Hamburger Icon is selected", "pass");

			}
			else {
				Log.info("Hamburger Icon is not Tapped");
				reporting("Hamburger Icon Selection", "Hamburger icon should be clicked",
						"Hamburger Icon is not selected", "fail");
				Assert.fail();
			}
		}
		catch (Exception e) {
		}
	}
}
