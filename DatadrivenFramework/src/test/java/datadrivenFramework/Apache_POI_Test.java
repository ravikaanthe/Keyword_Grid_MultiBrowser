package datadrivenFramework;

import utility.ExcelUtils;
import utility.Log;
import utility.Constants;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.NewContact_Action;
import appModules.SearchContacts_Action;
import appModules.SignIn_Action;
import pageObjects.Home_Page;

public class Apache_POI_Test {
	
	private static WebDriver driver = null;
	
	@BeforeMethod
	
	public void beforeMethod() throws Exception {
		
		DOMConfigurator.configure("log4j.xml");
		 
		Log.startTestCase("Selenium_Test_001");
		
		 //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
		 
		ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData, "Sheet1");
		Log.info(" Excel sheet opened");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Automation\\Software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();	
		Log.info("New driver instantiated");
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        Log.info("Web application launched");
		
	}
	
	
@Test
	public void main() throws Exception {
	
		// Provide Log4j configuration settings
	 
//		DOMConfigurator.configure("log4j.xml");
//	 
//		Log.startTestCase("Selenium_Test_001");
//		
//		 //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
//		 
//		ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData, "Sheet1");
//		Log.info(" Excel sheet opened");
//		
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Automation\\Software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//		driver = new FirefoxDriver();	
//		Log.info("New driver instantiated");
//		
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(Constants.URL);
//        Log.info("Web application launched");
        
        Thread.sleep(5000);
        SignIn_Action.Execute(driver);
        System.out.println("Login Successfully, now it is the time to add new contact buddy!!");
        NewContact_Action.Execute(driver);
        System.out.println("New Contact has been added successfully, now its time to log off buddy!!");
        SearchContacts_Action.Execute(driver);
        
//        driver.switchTo().frame("mainpanel");
//		Actions action = new Actions(driver);
//		action.moveToElement(Home_Page.lnk_contact(driver)).build().perform();
//		Log.info("Move Over action is performed on contact link");
//		
//        Home_Page.lnk_newContact(driver).click();
//        Log.info("Click action is performed on new contact link");
        
        Home_Page.lnk_logOut(driver).click();
        Log.info("Click action is performed on Log Out link");
        //This is to send the PASS value to the Excel sheet in the result column.
        
        ExcelUtils.setCellData("Pass", 1, 5);
		
}

        @AfterMethod
        
        public void afterMethod() {
       
      	    driver.quit();
       
              }        
        

}