package com.profproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.profproject.base.BaseClass;
import com.profproject.pages.ExtralayerPage;
import com.profproject.pages.BlogPage;
import com.profproject.pages.HomePage;
import com.profproject.pages.LandingPage;



public class TC_HerokuOpExTest_004 extends BaseClass{
	
	
	
	@Test
	public void HerokuOpEx() {
	HomePage homepge= new HomePage(driver);
	homepge.loginToWebPage("emmaighedo@yahoo.com", "emmalala02%");
	ExtralayerPage layer= new ExtralayerPage(driver);
	layer.clickIgnore();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	LandingPage land= new LandingPage(driver);
	logger.info("HerokuOpExTest....");
	land.goToBlogs();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BlogPage heroku=new BlogPage(driver);
	
	heroku.gotoHerokuOpEx();
	

	//USING ASSERT.assertTrue(true)) with Boolean Page Source for Assertion
	boolean res=driver.getPageSource().contains("Log in to your account");
		
		if(res==true)   //res means result
		{
			Assert.assertTrue(true);
			//logger.info("test case passed....");
			
		}else {
		
			Assert.assertTrue(false);
			logger.info("test case failed....");
		}
		
	
	//heroku.Logout();
	//homepge.Verifylogout();
	
	}
}