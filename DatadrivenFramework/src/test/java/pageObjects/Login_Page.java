package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Login_Page {
	
public static WebElement element = null;
	
	public static WebElement txtbx_UserName(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	    Log.info("Username text box found");
	 
	    return element;
	 
	    }
	 
	 public static WebElement txtbx_Password(WebDriver driver){
	 
	    element = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	    Log.info("Password text box found");
	 
	 return element;
	 
	    }
	 
	 public static WebElement btn_LogIn(WebDriver driver){
		 
		    element = driver.findElement(By.xpath("//input[@type='submit']"));
		    Log.info("Login button found");
		 
		 return element;
		 
		    }

}