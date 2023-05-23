package com.profproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage {

WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//span[@class='ml2 mr1 purple']")public WebElement personalTxt;

	@FindBy(xpath="//a[@class='glostick__menu__item glostick__menu__item--signout']")public WebElement signoutbtn;

	@FindBy(xpath="//a[normalize-space()='Blogs']")public WebElement Bloglink;
	
	public void checkTxt() {
	//Assert.assertTrue(personalTxt.isDisplayed());
	
	
	}
	
	public void doSignout() {
	signoutbtn.click();
	}
	
	
	

	
	public void goToBlogs() {
	Bloglink.click();
		
	}
	
	
	
	}

