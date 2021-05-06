package Day10Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMDay9.LoginPage;
import utils.HelpingFunction;

public class DataBasePara {
	WebDriver driver;

	@Test
	public void DataBaseTest() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");// to load the driver in the memory
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");

		System.out.println("Connection Successful");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from Login");
		while (rs.next()) {
			String user = rs.getString(1);
			String pass = rs.getString(2);

			System.out.println(rs.getString(1) + " ");
			System.out.println(rs.getString(2));
//PreparedStatement prep = con.prepareStatement("update Login ");
			driver.get("https://opensource-demo.orangehrmlive.com/");
			LoginPage lp = new LoginPage(driver);
			lp.doLogin(user, pass);
			try {
				Thread.sleep(3000);
				driver.findElement(By.id("welcome")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Logout")).click();
				System.out.println("Login Done");
			} catch (Exception E) {
				System.out.println("Login Failed");
			}

		}
		rs.close();
	}

	@BeforeTest
	public void beforeTest() {

		driver = HelpingFunction.startBrowser("chrome");
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}