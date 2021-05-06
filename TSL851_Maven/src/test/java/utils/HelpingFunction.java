package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HelpingFunction {
	public static WebDriver startBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"E:\\softwares\\Selenium_JARs\\chromedriver_win32_chrome_84\\chromedriver.exe");
//			
			System.setProperty("webdriver.chrome.driver",
					"src\\test\\resources\\Drivers\\chromedriver.exe");
			
			
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications");
			return new ChromeDriver(op);

		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"E:\\softwares\\Selenium_JARs\\geckodriver-v0.27.0-win64\\geckodriver.exe");
//			
			System.setProperty("webdriver.gecko.driver",
					"src\\test\\resources\\Drivers\\geckodriver.exe");
			
			FirefoxOptions op = new FirefoxOptions();
			op.addArguments("--disable-notifications");
			return new FirefoxDriver(op);

		} else {
			return null;
		}
	}
}
