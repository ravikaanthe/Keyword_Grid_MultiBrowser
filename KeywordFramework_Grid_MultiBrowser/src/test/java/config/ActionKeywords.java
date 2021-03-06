package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static executionEngine.DriverScriptTest.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import executionEngine.DriverScriptTest;
import executionEngine.MobileDriverScriptTest;
import freemarker.template.Version;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utility.Log;

public class ActionKeywords {
	
	public static ExtentReports reports;
	public static ExtentTest logger;
	public static WebDriver mdriver;
	
	//Constructor to initialize the object of class ExtentReports whenever we initialize object
			public ActionKeywords(){
				//Create an object of ExtentReports class
				reports=new ExtentReports(Constants.Extent_Reports);
			}
	
//	public static void openBrowser(String object, String data){	
//		Log.info("Opening Browser");
//		try{
//			
//			//If value of the parameter is Mozilla, this will execute
//			if(data.equals("Mozilla")){
//				System.setProperty("webdriver.gecko.driver", "C:\\Selenium Automation\\Software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//				driver=new FirefoxDriver();
//				Log.info("Mozilla browser started");
//				}
//			else if(data.equals("IE")){
//				//You may need to change the code here to start IE Driver
//				driver=new InternetExplorerDriver();
//				Log.info("IE browser started");
//				}
//			else if(data.equals("Chrome")){
//				System.setProperty("webdriver.chrome.driver", "C:\\Selenium Automation\\Software\\chromedriver_win32\\chromedriver.exe");
//				driver=new ChromeDriver();
//				Log.info("Chrome browser started");
//				}
// 
//			int implicitWaitTime=(10);
//			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
//		}catch(Exception e){
//			//This is to print the logs - Method Name & Error description/stack
//			Log.info("Not able to open Browser --- " + e.getMessage());
//			//Set the value of result variable to false
//			DriverScriptTest.bResult = false;
//		}
//	}
 
	public static void navigate(String object, String data){	
		try{
		Log.info("Navigating to URL");
		DriverScriptTest.driver.manage().window().maximize();
		DriverScriptTest.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Constant Variable is used in place of URL
		//As it was declared as 'static', it can be used by referring the class name
		//Type the class name 'Constants' and press '.' dot, it will display all the members of the class Constants

		DriverScriptTest.driver.get(Constants.URL);
		logger.log(LogStatus.PASS, "Navigated to URL - "+ Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Unable to Navigate to URL - "+ Constants.URL);
			DriverScriptTest.bResult = false;
			}
	}
 
	public static void click(String object, String data){
		try{
		Log.info("Clicking on Webelement "+ object);
		DriverScriptTest.driver.findElement(By.xpath(OR.getProperty(object))).click();
		logger.log(LogStatus.PASS, "Succefully Clicked on button "+ object);
		}catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			logger.log(LogStatus.FAIL, "Unable to Click on button "+ object);
 			DriverScriptTest.bResult = false;
         	}
	}
 
	public static void input(String object, String data){
		try{
		//Constant Variable is used in place of UserName
		Log.info("Entering the text in " + object);
		DriverScriptTest.driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data); 
		logger.log(LogStatus.PASS, "Entered the text '" + data +"' in "+ object);
	}catch(Exception e){
		 Log.error("Not able to Enter "+ object +"--- " + e.getMessage());
		 logger.log(LogStatus.FAIL, "Not able to enter text in " + object);
		 DriverScriptTest.bResult = false;
	 	}
	}
 
 
	public static void waitFor(String object, String data) throws Exception{
		try{
		Log.info("Wait for 5 seconds");
		Thread.sleep(5000);
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScriptTest.bResult = false;
         }
	}
 
	public static void closeBrowser(String object, String data){
		try{
		Log.info("Closing the browser-- " + data);
		DriverScriptTest.driver.quit();
		logger.log(LogStatus.PASS, "Succefully closed the browser -"+ object);
		}catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 logger.log(LogStatus.FAIL, "Unable to close the browser -"+ object);
			 DriverScriptTest.bResult = false;
        }
			
	}
	
	public static String GetText(String object, String data){

		try{

			Log.info("Getting the text of '"+object+"'");
			String Text = DriverScriptTest.driver.findElement(By.xpath(OR.getProperty(object))).getText();
			logger.log(LogStatus.PASS, "Able to get the text of object-"+ object);
			return Text;
		}catch (Exception e){
			Log.error("Not able read the text --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Not able to get the text of object-"+ object);
			DriverScriptTest.bResult = false;
			return null;

		}

	}

	public static void compareGetText(String object, String data){

		try{
			Log.info("Comparing the text '" +data+ "' with '"+object+"'" );
			String acutalText = DriverScriptTest.driver.findElement(By.xpath(OR.getProperty(object))).getAttribute("innerText");
			if(acutalText.equals(data));
			logger.log(LogStatus.PASS, "Expected text '"+data+ "'is same as actual text'"+ object);
		}catch(Exception e){
			Log.error("Not able to compare the text --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Unable to compare the text "+ object);
			DriverScriptTest.bResult = false;
		}	

	}
	
	public static void mouseOver(String object, String data){

		try{
			Log.info("Moved over to '"+object+"'" );
			DriverScriptTest.driver.switchTo().frame(data);
			Actions action = new Actions(DriverScriptTest.driver);
			action.moveToElement(DriverScriptTest.driver.findElement(By.xpath(OR.getProperty(object)))).build().perform();
			logger.log(LogStatus.PASS, "Able mouse over to -"+ object);
		}catch(Exception e){
			Log.error("Not able to mouseover --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Not able mouse over to -"+ object); 
			DriverScriptTest.bResult = false;
		}	

	}
	
	public static void findTextHTMLtable(String object, String data) {
		try{
			Log.info("Searching for contact details in table '"+object+"'" );
			// find cell data using CSS Selector
			//Here we are storing the value from the cell in to the string variable
			String sCellValue = DriverScriptTest.driver.findElement(By.xpath(OR.getProperty(object))).getText();
			if (sCellValue.equals(data));
			logger.log(LogStatus.PASS, "Able to find required contact details of table-"+ object);
			
		}catch(Exception e){
			Log.error("Not able to find the contact name in database --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Not able to find required contact details of table-"+ object);
			DriverScriptTest.bResult = false;
		}	
		
	}
	
	public static void elementHighlight(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) DriverScriptTest.driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: blue; border: 3px solid blue;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}
	
	
	public static void mverifyElement(String object, String data){
		try{
			Log.info("Verifying the element '"+ object);
			mdriver.findElement(By.xpath(OR.getProperty(object))).isDisplayed();
			//elementHighlight(mdriver.findElement(By.xpath(OR.getProperty(object))));
			Thread.sleep(600);
			logger.log(LogStatus.PASS, "Webelement '"+ object+"'displayed on page");
		}catch(Exception e){
			Log.error("Unable to find Webelement --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Unable to find Webelement "+ object);
 			MobileDriverScriptTest.bResult = false;
		}
	}
	
	public static void mopenBrowser(String object, String data) throws MalformedURLException{
		//Create an object of DesiredCapabilities class and specify android platform
		DesiredCapabilities capabilities=DesiredCapabilities.android();
		
		//Set capability to execute test in Chrome Browser of mobile. MobileCapabilityType is an Interface 
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		
		//Set the capability to execute our test in android platform
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		
		//Set the Device name as well (you can give any name)
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		
		//Set the Android Version as well
		capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
		
		//Specify object of URL class and specify Appium server address
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		
		//Create object of Android Driver class and pass the url and capability that we created
		mdriver=new AndroidDriver(url, capabilities);		
		
	}
	
	public static void mnavigate(String object, String data){
		try{
			Log.info("Navigating to URL "+ "'" + Constants.MURL+"'");
			mdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Constant Variable is used in place of URL
			//As it was declared as 'static', it can be used by referring the class name
			//Type the class name 'Constants' and press '.' dot, it will display all the memebers of the class Constants
			mdriver.get(Constants.MURL);
			logger.log(LogStatus.PASS, "Navigated to URL - "+ Constants.MURL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Unable to Navigate to URL - "+ Constants.MURL);
			MobileDriverScriptTest.bResult = false;
		}
			
	}
	
	public static void mclick(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			mdriver.findElement(By.xpath(OR.getProperty(object))).click();
			logger.log(LogStatus.PASS, "Succefully Clicked on button "+ object);
		}catch(Exception e){
			Log.error("Not able to click --- " + e.getMessage());
			logger.log(LogStatus.FAIL, "Unable to Click on button "+ object);
			MobileDriverScriptTest.bResult = false;
		}
		
	}
	
	public static void minput(String object, String data){
		try{
			Log.info("Entering the text in "+ object);
			//Constant Variable is used in place of UserName
			//This is fetching the xpath of the element from the Object Repository property file
			mdriver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			mdriver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Keys.TAB);
			logger.log(LogStatus.PASS, "Entered the text in "+ object);
		}catch(Exception e){
			Log.error("Not able to Enter UserName --- " + e.getMessage());
			MobileDriverScriptTest.bResult = false;
			logger.log(LogStatus.FAIL, "Not able to enter text in "+ object);
		}
		 
	}
	
	
	
 
}