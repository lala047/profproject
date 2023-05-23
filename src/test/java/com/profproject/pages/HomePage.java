package com.profproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
		@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")public WebElement popup;   
		@FindBy(xpath="//input[@id='email']")public WebElement username;
		@FindBy(xpath="//input[@id='password']")public WebElement password;
		@FindBy(xpath="//button[@name='commit']")public WebElement loginbtn;

		@FindBy(xpath="//div[@role='alert']")public WebElement errorMsg;
		@FindBy(xpath="//h2[@class='h3']")public WebElement logoutmsg;
		
		
		
		

   public void loginToWebPage(String usn, String pwd) {
	popup.click();
	username.sendKeys(usn);
	password.sendKeys(pwd);
	loginbtn.click();

}
	
	public void isInvalidLogin() {
		String ErrorMessage= errorMsg.getText();
		System.out.println("InvalidLogin Message:" + ErrorMessage);

		
	}
	public void Verifylogout() {        //The assertions and String messages are displayed in your console when you call these methods in Test class
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String signoutmsg=  logoutmsg.getText();    //capture logout message
		
		  System.out.println("log out Message:" + signoutmsg);
		  Assert.assertTrue(logoutmsg.isDisplayed());
		 

	}
				
	
		/*
		 * if(((Object) errorTxt).size()>0) { Assert.assertTrue(errorTxt.isDisplayed());
		 * return true; }else { return false;
		 */
	  
	

}