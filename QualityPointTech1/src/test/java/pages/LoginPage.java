package pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverWait;
import base.Logs;
import utilities.ExcelRead;


public class LoginPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;
//	RandomStringGenerator randomEmailGenerator;
	String[][] test1=new String[1][1];
	
	By userName=By.id("username");
	By password=By.xpath("//td[text()='Log In']//following::input[2]");
	By login=By.xpath("//td[text()='Log In']//following::input[3]");
	
public LoginPage(WebDriver driver) throws TimeoutException
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}
	
//Entering username
public void enterUserName()        
	{
			test1=excel.read();
			String userName1=test1[0][1];
			
			WebElement a=driverWait.visibility(userName,20);         
			a.sendKeys(userName1);
			
			System.out.println("UserName is entered");
			log.update("******UserName is entered*****");
	}
//Entering password
public void enterPassword()        
	{
			test1=excel.read();
			String password1=test1[0][1];
			
			WebElement a=driverWait.visibility(password,20);         
			a.sendKeys(password1);
			
			System.out.println("Password is entered");
			log.update("******Password is entered*****");
	}
//Clicking on login button
public void clickOnLoginButton()        
	{
			WebElement a=driverWait.visibility(login,20);         
			a.click();
			
			System.out.println("Login is clicked");
			log.update("******Login is clicked*****");
	}
}
