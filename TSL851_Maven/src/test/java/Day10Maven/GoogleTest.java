package Day10Maven;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;
import utils.HelpingFunction;
import utils.Keywords;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleTest {
	WebDriver driver;
	ExtentReports ex;
	ExtentTest tc1;

	@Test(description = "Title Test for Google")
	public void titleTest() throws IOException {
		ExtentTest tc1 = ex.createTest("Google Title Test");
		tc1.info("Title Test Started");
		tc1.info("Opening URL");
		driver.get("http://google.com");
		tc1.info("Comparing Expected Title with Actual Title");
		// String screenshotPath = ExtentReportsClass.getScreenshot(driver,
		// result.getName());
		// To add it in the extent report
		// logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		try {
			Assert.assertEquals(driver.getTitle(), "Google");
			tc1.pass("Google Title Test Successful");
		} catch (AssertionError A) {
			tc1.fail("Title not matching " + A.getMessage());
			tc1.addScreenCaptureFromPath(new Keywords(driver).getSnap("Screenshot\\googleTitle_"));
			Assert.fail(A.getMessage());

		}

	}

	@Test(enabled = true, dependsOnMethods = "titleTest", description = "Search Test for Google")
	public void searchTest1() throws Exception {

		WebDriverWait wt = new WebDriverWait(driver, 10);
		tc1 = ex.createTest("Google Search Test");
		tc1.info("Search Test Started");
		tc1.info("Location Search box");
		try {
			WebElement search = wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
			tc1.info("Entering Text in search box");
			search.sendKeys("MAVEN");
			tc1.info("Press Enter");
			search.sendKeys(Keys.ENTER);
			tc1.info("Comparing Expected Title with Actual Title");

			// Assert.assertEquals(driver.getTitle().contains("MAVEN"), true);
			wt.until(ExpectedConditions.titleContains("Maven"));
			tc1.pass("Google search Test Successful");
		} catch (AssertionError A) {
			tc1.fail("Title not matching " + A.getMessage());
			// tc1.addScreenCaptureFromPath(new
			// Keywords(driver).getSnap("Screenshot\\googleSearch_"));
			Assert.fail(A.getMessage());

		}

	}

	@Test(enabled = false, dependsOnMethods = "titleTest", description = "Search Test2 for Google")
	public void searchTest2() {
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement search = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name("q"));
			}
		});
		search.sendKeys("MAVEN");
		search.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle().contains("MAVEN"), true);
	}

	@BeforeClass
	public void beforeClass() {
		driver = HelpingFunction.startBrowser("chrome");
		ex = new ExtentReports();
		ex.attachReporter(new ExtentHtmlReporter("src\\test\\resources\\Reports\\Google.html"));

	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		ex.flush();

	}

}
