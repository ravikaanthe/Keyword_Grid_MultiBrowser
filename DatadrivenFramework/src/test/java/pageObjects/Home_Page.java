package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Home_Page {
	
	public static WebElement element = null;
	
	public static WebElement lbl_userTitle(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[1]/section[1]/div"));
	    Log.info("user title link element found");
	 
	    return element;
	 
	    }
	 
	 public static WebElement lnk_contact(WebDriver driver){
	 
	    element = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
	    Log.info("Contact link element found");
	    
	 return element;
	 
	    }
	 
	 public static WebElement lnk_newContact(WebDriver driver){
		 
		    element = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		    Log.info("New Contact link element found");
		    
		 return element;
		 
		    }
	 
	 public static WebElement lnk_logOut(WebDriver driver){
		 
		    element = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]"));
		    Log.info("Logout link element found");
		    
		 return element;
		 
		    }
	 
}