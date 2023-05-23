package com.profproject.base;

//if there are errors, check the import if the package name of the utilities is correct

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.profproject.utilities.ExcelReader;
import com.profproject.utilities.ReadConfig;



public class BaseClass {
	ReadConfig readconfig= new ReadConfig();  // create and object of ReadConfig Class so as to access the methods needed in the ReadConfig
	String baseURL=readconfig.getApplicationURL();
	public String username= readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static ExcelReader excel = new ExcelReader (System.getProperty("user.dir") + "\\src\\test\\java\\com\\profproject\\testdata\\LoginData.xlsx");
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")

    @BeforeClass  
	public void setup(String br) {
		
	
		
		
		//TO USE LO4J: (i)copy and paste the log4j.properties file to the project. (ii) add Apachelog4j dependency to the pom
	
		 logger=Logger.getLogger(getClass());     //(getClass()); this is the option u select
		  PropertyConfigurator.configure("log4j.properties.txt");
		 
		 
		
		
		  if(br.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver",readconfig.getChromePath()); //This is to access the chrome in Config. Properties 
	// or System.setProperty("webdriver.chrome.driver",./)+"//Drivers//chromedriver.exe"); // used in both java classes and properties file 
		//Add Chrome Options to your base class to disable pop ups by default (93.(20-23min)
		 driver = new ChromeDriver();
		 logger.info("Chrome Launched !!!");
		  
		  }else if (br.equals("firefox")){
		  System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		  driver= new FirefoxDriver();
		  
		  }else if(br.equals("ie")){
		  System.setProperty("webdriver.ie.driver",readconfig.getIEPath()); 
		  driver= new InternetExplorerDriver(); 
		 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
		 

	
	
	driver.get(baseURL);
	 driver.manage().window().maximize();
//driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();   // To accept pop up
	
	
		}
		
	
		  @AfterClass 
		  public void tearDown() { 
			  driver.quit(); 
	
			  logger.info("test execution completed !!!");
		
	}
		 
		
		  public void captureScreen(WebDriver driver, String tname) throws IOException { //tname=test case name
		  TakesScreenshot ts = (TakesScreenshot) driver; 
		  File source = ts.getScreenshotAs(OutputType.FILE); 
		  File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		  FileUtils.copyFile(source, target); System.out.println("Screenshot taken"); 
		  }
		 
		
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
		
		
}