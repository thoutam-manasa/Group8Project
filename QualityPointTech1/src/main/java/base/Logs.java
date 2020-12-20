package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Logs {
	WebDriver driver;
	Logger Log;
public Logs(WebDriver driver)
	{
		this.driver =driver;
		Log = Logger.getLogger("devpinoyLogger");
	}
//function to update a log message
public void update(String message)
	{
		Log.debug(message);
	}
}
