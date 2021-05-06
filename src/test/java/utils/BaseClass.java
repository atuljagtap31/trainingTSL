package utils;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseClass {
	public WebDriver webDriver;
	Properties prop;
	@BeforeTest
	public void beforeTest() throws Exception, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(".\\setting.property"));
		webDriver = HelpingFunction.startBrowser(prop.getProperty("browserName"));

	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(3000);
		webDriver.quit();
	}

}
