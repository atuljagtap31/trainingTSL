package Day10Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.HelpingFunction;

public class Database {
	@Test
	public void f() throws Exception {
		ResultSet rs= null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
		// Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/selenium99", "mpremchand99",
	            //    "mpremchand99");
		rs = con.createStatement().executeQuery("select * from Login");
		System.out.println(rs);
		}
		catch(Exception E) {
			System.out.println(E.getMessage());
		}
		System.out.println("test!!!!");
		if (rs.next()== true) {
			String username = rs.getString(1);
			System.out.println(username);
			System.out.println("test2");
			}
//			WebDriver driver = HelpingFunction.startBrowser("chrome");
//			LoginPage lp = new LoginPage(driver);
//			lp.doLogin(user, pass);
//			try {
//				Thread.sleep(2000);
//				driver.findElement(By.id("welcome")).click();
//				Thread.sleep(2000);
//				driver.findElement(By.linkText("Logout")).click();
//				
//			}

	//	}

	}
}
