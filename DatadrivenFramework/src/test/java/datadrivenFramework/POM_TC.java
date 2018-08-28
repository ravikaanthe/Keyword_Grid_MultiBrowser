package datadrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import package page objects
import pageObjects.Home_Page;
import pageObjects.Login_Page;

public class POM_TC {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	     driver.get("http://www.store.demoqa.com");
		
		// Use page Object library now
		Login_Page.txtbx_UserName(driver).sendKeys("selframework");
		Login_Page.txtbx_Password(driver).sendKeys("klsrcm");
		Login_Page.btn_LogIn(driver).click();
		Home_Page.lnk_contact(driver).click();
		driver.quit();
		
	}

}
