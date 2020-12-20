package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {
	WebDriver driver;
	WebElement webElement;
	Logs log;
//constructor for driver
public DriverWait(WebDriver driver)
	{
		this.driver=driver;
		log =new Logs(driver);
	}
//webdriverwait for element to be clickable
public WebElement clickable(By locator,int timeout)
	{
	try 
	{
		WebDriverWait wt=new WebDriverWait(driver,timeout);
		webElement=wt.until(ExpectedConditions.elementToBeClickable(locator));
	}
	catch(WebDriverException e)
	{
		e.printStackTrace();
		log.update("Exception in WaitForElement method");
	}
	catch(IncompatibleClassChangeError e)
	{
		e.printStackTrace();
		log.update("Exception in incompatile class change error method");
	}
		return webElement;
	}
//webdriverwait for text to be visible 
public WebElement visibility(By locator,int timeout) 
	{
	try 
	{
		WebDriverWait wt=new WebDriverWait(driver,timeout);
		webElement=wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	catch(WebDriverException e)
	{
		e.printStackTrace();
		log.update("Exception in WaitForElement method");
	}
	catch(IncompatibleClassChangeError e)
	{
		e.printStackTrace();
		log.update("Exception in incompatile class change error method");
	}
		return webElement;
	}
}
