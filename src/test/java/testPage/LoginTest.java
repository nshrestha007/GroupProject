package testPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	
	@Test
	@Parameters({"username","password"})
	public void loginTest(String username, String password) {
		driver = BrowserFactory.startBrowser();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.userlogin(username, password);
		
	}
}
