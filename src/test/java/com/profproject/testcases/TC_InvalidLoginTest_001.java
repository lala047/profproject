package com.profproject.testcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.profproject.base.BaseClass;
import com.profproject.pages.HomePage;


      @Test   // please ensure @Test is present if not, it wil not execute
      
public class TC_InvalidLoginTest_001 extends BaseClass{
	
	
	public void loginInvalid() throws IOException {
HomePage homepge=new HomePage(driver);
homepge.loginToWebPage("emmaighedo@yahoo.com", "sly");
homepge.isInvalidLogin();






//USING ASSERT.assertTrue(true)) with Boolean Page Source for Assertion
boolean res=driver.getPageSource().contains("There was a problem with your login.");

if(res==true) {//res means result 
Assert.assertTrue(true);
logger.info("test case passed....");

} else { 
logger.info("test case failed....");

captureScreen(driver,"loginInvalid"); 
Assert.assertTrue(false); 





  }
  }
	}
  