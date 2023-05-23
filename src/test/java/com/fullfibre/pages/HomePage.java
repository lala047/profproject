package com.fullfibre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='wt-cli-accept-all-btn']")public WebElement cookies;
	@FindBy(css="div[class='elementor-element elementor-element-3ff5104 elementor-align-center elementor-widget elementor-widget-button'] a[role='button']")public WebElement clickcoverage;  
   
		
		
		public void doClickCoverage() {
			cookies.click();
			clickcoverage.click();
			
		}
}
