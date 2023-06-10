package com.techPanda.TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.HomePage;

public class TestCase_002 extends BaseClass{
	
	public String listPagePrice ;
	public String detailPagePrice ;
	
	
	@Test
	public void testCase_002() throws InterruptedException {
		
		hp=new HomePage(driver);
		
		
		hp.clickMobile();
		Thread.sleep(3000);
		
       
		hp.sortBy("Name");
		Thread.sleep(3000);
		List<WebElement> productNames=hp.getProductNames();
		
		
		
		for(WebElement l:productNames) {
			System.out.println(l.getText());
			
			if(l.getText().equals("SONY XPERIA")) {
				System.out.println(l.getText());
				listPagePrice=hp.getPrice();
				
				l.click();
				Thread.sleep(3000);
				
				detailPagePrice=driver.findElement(By.xpath("//span[@class='price']")).getText();
				
				
				break;
			}
					
		}
		
		System.out.println(listPagePrice);
		System.out.println(detailPagePrice);
		Assert.assertTrue(listPagePrice.equals(detailPagePrice));
		
		
	}
}
