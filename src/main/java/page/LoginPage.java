package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
		@FindBy(how = How.ID, using ="username" ) WebElement Username;
		@FindBy (how = How.ID, using = "password")WebElement Password;
		@FindBy (how = How.NAME,using = "login")WebElement signin;
		@FindBy (how = How.XPATH,using = "//h2[contains(text(),'Dashboard')]")WebElement Dashboard;
		public void userlogin(String username,String password) {
			Username.sendKeys(username);
			Password.sendKeys(password);
			signin.click();
		}
		public String validateTitle() {
			return driver.getTitle();
			
		}
	 
		public void validateDashBoard() {
			Dashboard.isDisplayed();
		}
}
