package rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;






/*AMOS PROJECT

PROJECT DEMO: https://id.heroku.com/login
Note: Create an account for yourself
emmaighedo@yahoo.com
Pw: emmalala02%
1. Attempt Login to your account and perform negative testcases
2.Verify user login credentials as required
3. Repeat 1 and 2 with valid login  details
4, Navigate to Blogs page
5. Mouse hover products through Heroku Platform and selecet Heroku OpEx
6. Verify Heroku OpEx page  - i.e show that the page was displayed (create element locator of the displayed page)
7. Print and display all the links under Documentations, at the lower end of the page
8. Logout and verify successful logout

Notes:
-Ensure all test results are verified
-Report failure with screenshot
-Execute test with Junit- ExcelData driven not required (Optional)
-Execute test with TestNG Excel Data Driven
-Execute test with  TestNG XML File
-Execute test using ANT 
-Get login data from external file like excel sheet
-Execute in Chrome and also in Firefox browser (use if statement to select browser)
-Execute the concept of Page Object Model and Page Factory Framework 
*/

public class Mousehover {

	

	public static WebDriver driver;
	
	public static void main (String[] args) {
		
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://id.heroku.com/login");
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();   // To accept pop up
     driver.findElement(By.xpath("//input[@id='email']")).sendKeys("emmaighedo@yahoo.com");
     driver.findElement(By.xpath("//input[@id='password']")).sendKeys("emmalala02%");
     driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
     driver.findElement(By.xpath("//button[@type='submit']")).click(); 
     String title= driver.findElement(By.cssSelector(".ml2.mr1.purple")).getText();
     System.out.println(title);
     //driver.findElement(By.xpath("//a[normalize-space()='Blogs']")).click();
     
    // WebElement products=driver.findElement(By.xpath("//a[normalize-space()='Products']"));//HandSign on 'products'
   //  Actions actions= new Actions(driver);       // create and object of Actions class
   //  actions.moveToElement(products).build().perform();        //hand sign activated on 'products'
   //  WebElement platform= driver.findElement(By.xpath("//a[@class='bookends-icon platform']"));   // it moves and hovers around 'platform'
   //  actions.moveToElement(platform).build().perform(); //hand sign activated on 'platform'
   //  driver.findElement(By.xpath("//a[normalize-space()='Heroku OpEx']")).click();    //hand sign clicks on 'Heroku OpEx'
    // String titles= driver.findElement(By.xpath("//h1[normalize-space()='Heroku Operational Experience']")).getText();  //capturing the page 
    // System.out.println(titles);
     
    // boolean res=driver.getPageSource().contains("Heroku Operational Experience");
		
	//	if(res==true) {  //res means result
		//	System.out.println("passed");
			
			if (driver.getTitle().equals("Heroku")) {
				System.out.println("passed");
		
		
			//Assert.assertTrue(true);
			//logger.info("test case passed....");
			
		}else {
			//logger.info("test case failed....");
			//captureScreen(driver,"addNewCustomer");
			//Assert.assertTrue(false);
		System.out.println("failed");
		
     
     
     //Print and display all the links under Documentations, at the lower end of the page
    List<WebElement> links =driver.findElements(By.xpath("//div[@role='main']//li")); //highlight the links in that area and copy the xpath which was this  //div[@role='main']//li[3] , so i remove the '[3]' so as to capture all of them 
   for (WebElement link : links) {         //Iterate over all the "links" WebElements using java for-each loop
    	 System.out.println(link.getText());
                 
    	 
         //Print the total no of links under Documentations, at the lower end of the page
    	    // List<WebElement> links =driver.findElements(By.xpath("//div[@role='main']//li")); //highlight the links in that area and copy the xpath which was this  //div[@role='main']//li[3] , so i remove the '[3]' so as to capture all of them 
    	   //  System.out.println("Total no of links " + links.size());
    	     
                 
                 
     //Print and display all the links on the Heroku OpEX page  
     //List<WebElement> links = driver.findElements(By.tagName("a"));
    // for (WebElement link : links) {
              //   System.out.println(link.getText());
     

     //Print the total no of links on the Heroku OpEX page  
    // List<WebElement>links= driver.findElements(By.tagName("a"));
  //   System.out.println("Total no of links " + links.size());
     
 

    
  // driver.quit();
   }
		}
	}
}
