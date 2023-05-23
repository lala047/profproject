package com.profproject.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.profproject.base.BaseClass;
import com.profproject.pages.ExtralayerPage;
import com.profproject.pages.HomePage;
import com.profproject.utilities.DataProviderClass;

public class TC_LoginDDT_003 extends BaseClass{


	@Test(dataProviderClass=DataProviderClass.class,dataProvider="dp")
	public void verifyuserLoggedIn(Hashtable<String,String> data) {
		//Create object of LoginPage
		HomePage homepge= new HomePage(driver);
		homepge.loginToWebPage(data.get("username"),data.get("password"));
		
		ExtralayerPage layer= new ExtralayerPage(driver);
		layer.clickIgnore();
		
	}
}