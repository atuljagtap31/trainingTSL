package utils;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Keywords {
	WebDriver driver;

	public Keywords(WebDriver idriver) {
		driver = idriver;
	}

	public void getURL(String url) {
		driver.get(url);
	}

	public WebElement Reuse(String locator) {
		String locatorType = locator.split(":=")[0];
		String locatorValue = locator.split(":=")[1];

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name"))
			return driver.findElement(By.name(locatorValue));
		else if (locatorType.equalsIgnoreCase("link"))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			return null;
	}

	public void click(String locator) {
		WebElement w = Reuse(locator);
		if (w != null)
			w.click();
		else
			System.out.println("Invalid Locator");

	}

	public void type(String locator, String data) {
		WebElement w = Reuse(locator);
		if (w != null)
			w.sendKeys(data);
		else
			System.out.println("Invalid Locator");
	}

	public String getSnap(String locationWithFileName) {
        String date = new Date().toString().replaceAll(":", "_").replaceAll(" ", "_");
        TakesScreenshot sp = (TakesScreenshot) driver;
        File src = sp.getScreenshotAs(OutputType.FILE);
        String path=locationWithFileName + date + ".png";
        try {
            FileHandler.copy(src, new File(path));
        } catch (Exception E) {
            System.out.println("Error with ScreenShot");
        }
        return path;
    }
	public void dropDownSelect(String locator, String data) {
		WebElement w = Reuse(locator);
		if (w != null) {
			Select from = new Select(w);
			from.selectByVisibleText(data);
		} else {
			System.out.println("Invalid Locator");
		}
	}
}
