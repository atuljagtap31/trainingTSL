package POMDay9;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;

public class POMRunner extends BaseClass {
	ForgetAccountPage forget;
	LoginPage login;
	WelcomePage welcome;

	@Test(description = "Checking Forget Account")
	public void forgetTest() {
		webDriver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		login = new LoginPage(webDriver);
		forget = login.clickForget();
		Assert.assertEquals(webDriver.findElement(forget.e_resetButton).isDisplayed(), true);
	}

	@Test(dependsOnMethods = "forgetTest", description = "Checking cancel Button")
	public void cancelButtonTest() throws Exception {
		login = forget.clickCancel();
		Assert.assertEquals(webDriver.findElement(login.e_userName).isDisplayed(), true);
	}

	@Test(dependsOnMethods = "cancelButtonTest", description = "Checking Login")
	public void doLogin() throws Exception {
		welcome = login.doLogin("admin", "admin123");
		try {
			Assert.assertEquals(webDriver.findElement(welcome.e_user).isDisplayed(), true);
		} catch (NoSuchElementException N) {
			Assert.fail("Unable to do Login Process with given Credentials");
		}
	}
}
