package com.profproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.profproject.base.BaseClass;
import com.profproject.pages.ExtralayerPage;
import com.profproject.pages.HomePage;




public class TC_LoginTest_002 extends BaseClass{ 

	
	@Test
	public void LoginTest() throws IOException {
	HomePage homepge= new HomePage(driver);
	homepge.loginToWebPage(username, password);
	logger.info("Entered username and password");
	ExtralayerPage layer= new ExtralayerPage(driver);
	layer.clickIgnore();
	//LandingPage land= new LandingPage(driver);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	//land.checkTxt();

	
	/*
	 * if(homepge.isInvalidLogin()) { System.out.println("logged in Successfully!");
	 * logger.info("Login test passed"); } else { land.checkTxt();
	 * System.out.println("Invalid Log in details!"); }
	 * logger.info("Login test failed");
	 * 
	 */
	
	
	
	
	// USING ASSERT.assertTrue(true)) with Boolean Page Source for Assertion
	boolean res=driver.getPageSource().contains("Personal");
	
	if(res==true)   //res means result
	{
		Assert.assertTrue(true);
		//logger.info("test case passed....");
		
	}
	else
	{
		//logger.info("test case failed....");
		captureScreen(driver,"LoginTest");
		Assert.assertTrue(false);
	
	}
	}
}

