package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.qualitypointtech.baseclasses.Logs;

/**
 * class to capture screenshot
 */
public class Screenshot {
	WebDriver driver;
	Logs log;
	
public Screenshot(WebDriver driver) {
		this.driver=driver;
		log=new Logs(driver);
	}
	/**
	 * method  to capture screenshot
	 * @param driver
	 * @return path
	 */
	public String getScreenshot(WebDriver driver) {

		TakesScreenshot ts= (TakesScreenshot)driver;

		File source=ts.getScreenshotAs(OutputType.FILE);

		String path= System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";

		File destination=new File(path);

		try {
			FileUtils.copyFile(source,destination );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Capture Failed" + e.getMessage());
		}
		return path;
	}

}
