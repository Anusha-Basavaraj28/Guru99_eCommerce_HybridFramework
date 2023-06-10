package com.techPanda.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.DiscountCoupon;

public class TestCase_009 extends BaseClass{
	
	@Test
	public void testCase_009() throws InterruptedException {
		
		dc=new DiscountCoupon(driver);
		
		dc.clickMobile();
		dc.clickAddToCart();
		dc.setCouponCode("GURU50");
		dc.clickApply();
		
		
		Thread.sleep(3000);
		String discAmt=dc.getDiscountAmt();
		String totalAmt=dc.getTotalAmt();
		
		String iPhonePrice="$500.00";
		
		String expectedDiscAmt="-$25.00";
		
		Assert.assertEquals(discAmt, expectedDiscAmt);
		
		String expectedTotalamount="$475.00";  // 500-25
		
		Assert.assertEquals(totalAmt, expectedTotalamount);
		
		
	}
	
	

}
