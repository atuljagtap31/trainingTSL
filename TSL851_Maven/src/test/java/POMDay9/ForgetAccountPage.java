package POMDay9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetAccountPage {
	WebDriver driver;

	public ForgetAccountPage(WebDriver driver) {
		this.driver = driver;
		// e_cancelButton = driver.findElement(By.id("btnCancel"));
	}

	public By e_userName = By.id("securityAuthentication_userName");
	public By e_resetButton = By.id("btnSearchValues");
	public By e_cancelButton = By.id("btnCancel");

	// public WebElement = e_cancelButton;
	public void SetUsername(String user) {
		driver.findElement(e_userName).sendKeys(user);
	}

	public LoginPage clickCancel() {
		driver.findElement(e_cancelButton).click();
		return new LoginPage(driver);
	}

	public void clickReset() {
		driver.findElement(e_resetButton).click();
	}

	public void doReset(String user) {
		SetUsername(user);
		clickReset();

	}
}
