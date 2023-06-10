package com.techPanda.TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.HomePage;

public class HomePageTestCase extends BaseClass {
	String homePageTitle;
	String PageTitle;
	List<String> sl=new ArrayList();
	List<String> ol=new ArrayList();
	List<WebElement> productNames;

	@Test
	public void homePageTestcase() throws InterruptedException {
		hp = new HomePage(driver);

		homePageTitle = driver.getTitle();
		logger.info("***********Verifying the title of homepage***********");

		Assert.assertTrue(homePageTitle.equals("Home page"));
		Thread.sleep(3000);
		hp.clickMobile();
		Thread.sleep(3000);

		PageTitle = driver.getTitle();

		Assert.assertTrue(PageTitle.equals("Mobile"));
		hp.sortBy("Name");
		Thread.sleep(3000);
		productNames = hp.getProductNames();

		for (WebElement l : productNames) {
			System.out.println(l.getText());

			sl.add(l.getText());

		}
		ol = sl;
		System.out.println("**********************" + sl);
		Collections.sort(sl);
		Assert.assertTrue(ol.equals(sl));

	}

}
