package com.techPanda.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.AccountCreationPage;

public class TestCase_005 extends BaseClass{
	
	public String email;
	@Test
	public void testCase_005() {
		accCre=new AccountCreationPage(driver);
		
		accCre.clickAddAcc();
		accCre.clickMyAcc();
		accCre.clickCreateAcc();
		
		accCre.setFName("AAA");
		accCre.setLName("BBB");
		email=randomEmail()+"@gmail.com";
		System.out.println(email);
		accCre.setEmail(email);
		
		accCre.setPwd("abAB@123");
		accCre.setCinfirmPwd("abAB@123");
		accCre.clickReg();
		
		Assert.assertTrue(driver.getPageSource().contains("Thank you for registering with Main Website Store."));
		
		accCre.clickTV();
		
		accCre.clickLgLcd();
		accCre.clickaddWish();
		accCre.clickShareWL();
		accCre.setEmailAddress("anusha.basavaraj28@gmail.com");
		accCre.clickShareEmail();
		
		Assert.assertTrue(driver.getPageSource().contains("Your Wishlist has been shared."));
	}

}
