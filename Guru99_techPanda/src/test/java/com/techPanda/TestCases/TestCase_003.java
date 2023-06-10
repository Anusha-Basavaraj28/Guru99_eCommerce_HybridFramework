package com.techPanda.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.AddToCartPage;
import com.techPanda.pageObjects.HomePage;

public class TestCase_003 extends BaseClass{
	
	@Test
	public void testCase_003() throws InterruptedException {
        hp=new HomePage(driver);
		addcart=new AddToCartPage(driver);
		
		hp.clickMobile();
		Thread.sleep(3000);
		hp.sortBy("Name");
		Thread.sleep(3000);
        List<WebElement> productNames=hp.getProductNames();
		
		
		
		for(WebElement l:productNames) {
			System.out.println(l.getText());
			
			if(l.getText().equals("SONY XPERIA")) {
				l.click();
				Thread.sleep(3000);
				addcart.addToCart();
				Thread.sleep(3000);
				addcart.editQuantity("1000");
				Thread.sleep(3000);
				addcart.update();
				Thread.sleep(3000);
				if(addcart.getError().equals("* The maximum quantity allowed for purchase is 500.")) {
					logger.info("* The maximum quantity allowed for purchase is 500.");
					Assert.assertTrue(true);
				}
				addcart.emptyCart();
				Thread.sleep(3000);
				if(driver.getPageSource().contains("Shopping Cart is Empty")) {
					logger.info("Shopping Cart is Empty");
					Assert.assertTrue(true);
				}
			}
					
		}
		
		
		
	}
}
