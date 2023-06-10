package com.techPanda.TestCases;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techPanda.pageObjects.AccountCreationPage;
import com.techPanda.pageObjects.OrderPage;
import com.techPanda.pageObjects.ViewOrder;

//********************************************************************************************
	/*  Verify that you will be able to save previously placed order as a pdf file 
	 * 
	 *   Note: This TestCase7a version is due to the below amended steps.
	 *  
	Test Steps:
	1. Go to http://live.techpanda.org/
	2. Click on My Account link
	3. Login in application using previously created credential 
	4. Click on 'My Orders'
	5. Click on 'View Order'
	6. *** note: After steps 4 and 5, step 6 "RECENT ORDERS" was not displayed
	   Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
	7. Click on 'Print Order' link
	8. *** note: the link was not found. 
	   Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
	9. *** unable to execute this step, due to issue with step 8 issue
	   Click on 'Save' button and save the file in some location.
	10. *** unable to execute this step, due to steps 8 and 9 issues.
	    Verify Order is saved as PDF

	*/
public class TestCase_007 extends BaseClass{
	
	@Test
	public void tsetCase_007() throws InterruptedException, AWTException {
        accCre=new AccountCreationPage(driver);
		
		accCre.clickAddAcc();
		accCre.clickMyAcc();
		op=new OrderPage(driver);
		op.setEmail("IrAQJBNv@gmail.com");
		op.setPwd("abAB@123");
		op.clickLogin();
		
		
		
		Assert.assertTrue(driver.getPageSource().contains("Recent Orders"));
		
		vp=new ViewOrder(driver);
		vp.clickViewOrder();
		Thread.sleep(3000);
		vp.clickPrintOrder();
		
		Thread.sleep(3000);
		

		/*
		 * Robot rb=new Robot(); rb.delay(2000);
		 * 
		 * // copy path to file and put in clipboard
		 * 
		 * StringSelection sc=new StringSelection("C:\\Resume\\Edit-resume-grey.docx");
		 * 
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
		 * 
		 * 
		 * //CTRL+V
		 * 
		 * rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V);
		 * 
		 * rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_V);
		 * 
		 * //ENTER rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER);
		 */
		
		
		String mainHandle=driver.getWindowHandle();
		
		Set<String> handles=	driver.getWindowHandles();
		
		List<String> handleList=new ArrayList<String>(handles);
		
		Robot rb=new Robot();
		rb.delay(2000);
		
		
		// copy path to file and put in clipboard
		
		//StringSelection sc=new StringSelection("Print Order");
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
		
		// 5 times tab
		 rb.keyPress(KeyEvent.VK_TAB); 
		 rb.keyRelease(KeyEvent.VK_TAB);
		 rb.delay(2000);
		 rb.keyPress(KeyEvent.VK_TAB); 
		 rb.keyRelease(KeyEvent.VK_TAB);
		 rb.delay(2000);
		 rb.keyPress(KeyEvent.VK_TAB); 
		 rb.keyRelease(KeyEvent.VK_TAB);
		 rb.delay(2000);
		 rb.keyPress(KeyEvent.VK_TAB); 
		 rb.keyRelease(KeyEvent.VK_TAB);
		 rb.delay(2000);
		 rb.keyPress(KeyEvent.VK_TAB); 
		 rb.keyRelease(KeyEvent.VK_TAB);
		 rb.delay(2000);
		 
		 
		 
		 
		// Enter
		rb.keyPress(KeyEvent.VK_ENTER); 
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		rb.delay(2000);
		//Page down
		rb.keyPress(KeyEvent.VK_DOWN); 
		 rb.keyRelease(KeyEvent.VK_DOWN);
		 
		// Enter
			rb.keyPress(KeyEvent.VK_ENTER); 
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			 rb.keyPress(KeyEvent.VK_TAB); 
			 rb.keyRelease(KeyEvent.VK_TAB);
			 rb.delay(2000);
			 
			 rb.keyPress(KeyEvent.VK_TAB); 
			 rb.keyRelease(KeyEvent.VK_TAB);
			 rb.delay(2000);
			 
			 rb.keyPress(KeyEvent.VK_TAB); 
			 rb.keyRelease(KeyEvent.VK_TAB);
			 rb.delay(2000);
			
		 
			 rb.keyPress(KeyEvent.VK_TAB); 
			 rb.keyRelease(KeyEvent.VK_TAB);
			 rb.delay(2000);
		
		
			 rb.keyPress(KeyEvent.VK_TAB); 
			 rb.keyRelease(KeyEvent.VK_TAB);
			 rb.delay(2000);
		
		
		
		//CTRL+V
		//rb.keyPress(KeyEvent.VK_CONTROL); rb.keyPress(KeyEvent.VK_V);
	//	rb.keyRelease(KeyEvent.VK_CONTROL); rb.keyRelease(KeyEvent.VK_V);
		//rb.delay(2000);	  
			 
		// Enter
	    rb.keyPress(KeyEvent.VK_ENTER); 
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
		// Enter
	    rb.keyPress(KeyEvent.VK_ENTER); 
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		rb.delay(2000);
	
	    driver.switchTo().window(handleList.get(handleList.size()-1));
	    Thread.sleep(3000);
	
	
	
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();	
		Thread.sleep(3000);
		
		driver.switchTo().window(mainHandle);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
