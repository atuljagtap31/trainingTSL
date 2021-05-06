package POMDay9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	private WebDriver driver;
	public WelcomePage(WebDriver driver) {
		this.driver= driver;
	}

	public By e_user = By.name("txtUsername");
	
}
