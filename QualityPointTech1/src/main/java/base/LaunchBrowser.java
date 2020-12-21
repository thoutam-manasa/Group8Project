package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LaunchBrowser {
	static WebDriver driver;
	//static Logs log=new Logs(driver);
	static String path1="drivers/chromedriver.exe";
	static String path2="drivers/geckodriver.exe";
	static String path3="drivers/msedgedriver.exe";
	static String path4="drivers/IEDriverServer.exe";
	

//method to launch the browser we select
	public static WebDriver Launch_Browser(String url) throws IOException
	{
	Properties configProp;
	configProp=new Properties();
	FileInputStream configPropFile=new FileInputStream("configuration.properties");
	configProp.load(configPropFile);
	
	
	 ChromeOptions chromeOptions;
     FirefoxOptions firefoxOptions;
    
     String strExecutionPlatform = System.getProperty("executionPlatform").trim().toUpperCase();
    


     switch (strExecutionPlatform) {
         case "LOCAL_CHROME":
        	 System.setProperty("webdriver.chrome.driver",path1);
     		chromeOptions=new ChromeOptions();
     		chromeOptions.addArguments("--disable-notifications");
     		driver=new ChromeDriver(chromeOptions);
     		System.out.println("Chrome browser is launched");
     		//log.update("******Chrome browser Successfully Launched******");
             break;
         case "LOCAL_FIREFOX":
        	 System.setProperty("webdriver.gecko.driver",path2);
     		firefoxOptions=new FirefoxOptions();
     		firefoxOptions.addPreference("dom.webnotifications.enabled","false");
     		driver=new FirefoxDriver(firefoxOptions);
     		System.out.println("Firefox browser is launched");
     		//log.update("******Firefox  browser Successfully Launched******");
             break;
         case "GRID_CHROME":
             DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
             chromeOptions = new ChromeOptions();
             desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
             chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
             chromeOptions.addArguments("--no-sandbox");
             driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
             break;
         case "GRID_FIREFOX":
             driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
                         break;
         
     }
	
	
	
	driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}
}
