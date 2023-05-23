package com.profproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class BlogPage {

		WebDriver driver;
			
			public BlogPage(WebDriver driver) {
				this.driver=driver;
				//PageFactory.initElements(driver, this);

			    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
			}

				
				@FindBy(xpath="//a[normalize-space()='Products']")public WebElement products;
				@FindBy(xpath="//a[@class='bookends-icon platform']")public WebElement platform;
				@FindBy(xpath="//a[normalize-space()='Heroku OpEx']")public WebElement HerokuOpEx;
				@FindBy(xpath="//h1[normalize-space()='Heroku Operational Experience']")public WebElement HerokuOpTxt;
				@FindBy(xpath="//div[@role='main']//li")public List<WebElement> links;        //links under Documentations

				@FindBy(css="body > div:nth-child(8) > header:nth-child(2) > nav:nth-child(1) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > div:nth-child(1) > div:nth-child(2) > img:nth-child(1)")public WebElement GotoSignoutbtn;
				@FindBy(xpath="//a[@class='glostick__menu__item glostick__menu__item--signout']")public WebElement Signoutbtn;
				
				
				 //Print and display all the links under Documentations, at the lower end of the page
			  //  List<WebElement> links =driver.findElements(By.xpath("")); //highlight the links in that area and copy the xpath which was this  //div[@role='main']//li[3] , so i remove the '[3]' so as to capture all f them 
			  // for (WebElement link : links) {         //Iterate over all the "links" WebElements using java for-each loop
			   // 	 System.out.println(link.getText());
			

		/**
		 * 		
		 */
				     
				
         public void gotoHerokuOpEx(){	
        	 

 			Actions actions = new Actions(driver);
					actions.moveToElement(products).moveToElement(platform).build().perform();
					HerokuOpEx.click();
					String Heroku=	HerokuOpTxt.getText();
					System.out.println("Heroku OpEx page="  + Heroku);
					Assert.assertTrue(HerokuOpTxt.isDisplayed());         //Verify Heroku OpEx page  - i.e show that the page was displayed

				     //Print and display all the links under Documentations, at the lower end of the page
					for (WebElement link : links) {  
						System.out.println(link.getText());
						
						
					}
         }
					
					public void Logout() {
					GotoSignoutbtn.click();
					Signoutbtn.click();
						
				
}
}

