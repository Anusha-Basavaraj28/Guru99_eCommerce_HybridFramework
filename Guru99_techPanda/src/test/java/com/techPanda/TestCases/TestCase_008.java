package com.techPanda.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.AccountCreationPage;
import com.techPanda.pageObjects.OrderPage;

public class TestCase_008 extends BaseClass {
	
	String orderId;
	
	@Test
	public void testCase_008() throws InterruptedException {
		
accCre=new AccountCreationPage(driver);
		
		accCre.clickAddAcc();
		accCre.clickMyAcc();
		op=new OrderPage(driver);
		op.setEmail("IrAQJBNv@gmail.com");
		op.setPwd("abAB@123");
		op.clickLogin();
		
		Assert.assertTrue(driver.getPageSource().contains("Recent Orders"));
		
		op.clickREOrder();
		Thread.sleep(3000);
		op.setQTY();
		Thread.sleep(3000);
		op.clickUpdateBtn();
		
		
		String price=op.getPrice();
		String price2=price.substring(1);
		System.out.println(price2);
		double p=Double.parseDouble(price2);
		System.out.println(p);
		
		double up=p*10;
		
		String updatedPrice=Double.toString(up);
		System.out.println(updatedPrice);
		
		String totalPrice=op.getTotalPrice();
		String totalPrice2=totalPrice.substring(1);
		System.out.println(totalPrice2);
		
		String totalPrice3=totalPrice2.replace(",", "");
		System.out.println(totalPrice3);
		
		
		
		float tp=Float.parseFloat(totalPrice3);
		System.out.println(tp);
		String tp2=Double.toString(tp);
		System.out.println(tp2);
		
		
		
		
		Assert.assertTrue(updatedPrice.equals(tp2));
		
		
		op.clickProceedToCheckOut();
		
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
