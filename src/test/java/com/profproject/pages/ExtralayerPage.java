package com.profproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtralayerPage {
WebDriver driver;
	
	public ExtralayerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		
		@FindBy(xpath="//button[@type='submit']")public WebElement ignorelayer;
	
		
		public void clickIgnore() {
			ignorelayer.click();
		}

}
