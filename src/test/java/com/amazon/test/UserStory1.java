package com.amazon.test;


import org.testng.annotations.Test;

import com.amazon.pages.BasePage;
import com.amazon.pages.Category;
import com.amazon.pages.Hamburger;
import com.amazon.pages.HomePage;
import com.amazon.pages.KindlePage;


public class UserStory1 extends BasePage {
	private HomePage home;
	private Hamburger hamburger;
	private Category category;
	private KindlePage kindlePage;


	@Test
	public void ShopByCategory_Test() throws Exception
	{
		test = report.startTest("Amazon Test For Kindle Purchase");
		//try {
			//Step 1: Tap on Hamburger Button.
			home.tapHamburgerButton();
			//Step2: Select Shop by Category Option.
			hamburger.tapShopByCategory();  
			//Step3: Select Kindle Category.
			Thread.sleep(5000);
			category.tapKindleCat();
			//Step4: Select Kindle E-Reader
			//Thread.sleep(5000);
			category.selKindleEreader();
			//Step5: Choose Kindle Voyage
			kindlePage.selectKindleBasic();
		}
		//catch (Exception e) {
	
	
}

