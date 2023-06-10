package com.techPanda.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DiscountCoupon {
	
     WebDriver driver;
	
	public DiscountCoupon(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT,using = "MOBILE")
	@CacheLookup
	WebElement mobile;
	
	@FindBy(how=How.XPATH,using = "(//button[@class='button btn-cart'])[3]")
	@CacheLookup
	WebElement addToCart;
	
	@FindBy(how=How.ID,using = "coupon_code")
	@CacheLookup
	WebElement discountCode;
	
	@FindBy(how=How.XPATH,using = "//button[@title='Apply']")
	@CacheLookup
	WebElement applyBtn;
	
	@FindBy(how=How.XPATH,using = "//table[@id='shopping-cart-totals-table']//tbody//tr[2]//td[2]//span")
	@CacheLookup
	WebElement dicountAmount;
	
	@FindBy(how=How.XPATH,using = "//table[@id='shopping-cart-totals-table']//tfoot//tr//td[2]//span")
	@CacheLookup
	WebElement grandTotal;
	
	
	public void clickMobile() {
		mobile.click();
	}
	
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	
	public void setCouponCode(String s) {
		discountCode.clear();
		discountCode.sendKeys(s);
	}
	
	
	public void clickApply() {
		applyBtn.click();
	}
	
	
	public String getDiscountAmt() {
		return dicountAmount.getText();
	}
	
	public String getTotalAmt() {
		return grandTotal.getText();
	}
	

}
