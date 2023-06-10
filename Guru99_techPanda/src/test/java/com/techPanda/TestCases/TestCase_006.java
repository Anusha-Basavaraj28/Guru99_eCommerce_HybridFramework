package com.techPanda.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.AccountCreationPage;
import com.techPanda.pageObjects.OrderPage;

public class TestCase_006 extends BaseClass{
	String orderId;
	
	@Test
	public void testCase_006() throws InterruptedException {
        accCre=new AccountCreationPage(driver);
		
		accCre.clickAddAcc();
		accCre.clickMyAcc();
		
		op=new OrderPage(driver);
		
		
		op.setEmail("IrAQJBNv@gmail.com");
		op.setPwd("abAB@123");
		op.clickLogin();
		
		op.clickWishList();
		
		op.clickAddCart();
		Thread.sleep(3000);
		op.clickProceedToCheckOut();
		Thread.sleep(3000);
		
		op.setNewAddress("New Address");
		Thread.sleep(3000);
		op.setAddress("ABC");
		Thread.sleep(3000);
		op.setCity("NEW YORK");
		Thread.sleep(3000);
		op.setState("New York");
		Thread.sleep(3000);
		op.setTelephone("1234567890");
		Thread.sleep(3000);
		op.clickContinue();
		Thread.sleep(3000);
		op.clickContinue2();
		Thread.sleep(3000);
		
		op.selectPaymentInfo();
		Thread.sleep(3000);
		op.clickContinue3();
		Thread.sleep(3000);
		op.clickPlaceOrder();
		Thread.sleep(3000);
		orderId=op.getOrderId();
		
		System.out.println(orderId);
		Assert.assertTrue(driver.getPageSource().contains("Your order has been received."));
	}

}
