package com.techPanda.TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.CompareProductsPage;
import com.techPanda.pageObjects.HomePage;

public class TestCase_004 extends BaseClass{
	
	
	
	@Test
	public void testCase_004() throws InterruptedException {
		hp=new HomePage(driver);
		
		hp.clickMobile();
		
		Thread.sleep(3000);
		cmpPro=new CompareProductsPage(driver);
		
		
		
		cmpPro.clickSamsungAddToCpm(); // Samsung galaxy
		Thread.sleep(3000);
		cmpPro.clicIphoneAddToCpm(); //IPhone
		
		cmpPro.clickCmpButton();
		
		String mainWindowHandle = driver.getWindowHandle();  // main window handle
		System.out.println("******************************"+mainWindowHandle);
		Set<String> handles = driver.getWindowHandles();    // all window handles
		List<String>  listHandles=new ArrayList<>(handles);
		
		
		for(String s:listHandles) {
			System.out.println("(((((((((((((((((((((((((("+s);
		}
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
	    driver.switchTo().window(listHandles.get(listHandles.size()-1));
	    
	    
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		if(driver.getPageSource().contains("Compare Products")) {
			
			List<WebElement> proList=driver.findElements(By.xpath("//h2//a"));
			for(WebElement l:proList) {
				System.out.println(l.getText());
				if(l.getText().equals("SAMSUNG GALAXY")||l.getText().equals("IPHONE")) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
		}
		else {
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		
		driver.switchTo().window(mainWindowHandle); // main window
	}

}
