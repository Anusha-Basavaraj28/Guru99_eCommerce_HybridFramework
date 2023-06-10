package com.techPanda.TestCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.techPanda.pageObjects.AccountCreationPage;
import com.techPanda.pageObjects.AddToCartPage;
import com.techPanda.pageObjects.CompareProductsPage;
import com.techPanda.pageObjects.DiscountCoupon;
import com.techPanda.pageObjects.HomePage;
import com.techPanda.pageObjects.OrderPage;
import com.techPanda.pageObjects.ViewOrder;

import net.bytebuddy.utility.RandomString;


public class BaseClass {
	
	WebDriver driver;
	HomePage hp;
	AddToCartPage addcart;
	CompareProductsPage cmpPro;
	AccountCreationPage accCre;
	OrderPage op;
	ViewOrder vp;
	DiscountCoupon dc;
	
	Logger logger;
	
	@BeforeClass
	public void setUp() {
		logger=LogManager.getLogger(this.getClass());
		
		
		logger.info("***********Launching the chrome browser***********");
		
		driver=new ChromeDriver();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
	}
	
	
	@AfterClass
     public void tearDown() {
		logger.info("***********closing the chrome browser***********");
		driver.close();
	}
	
	public String randomEmail() {
		
		
		return RandomString.make(8);
	}

}
