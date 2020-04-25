package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SideNavigationPage {

	WebDriver driver;

	public  SideNavigationPage(WebDriver driver) {
		this.driver = driver;
	} 
		@FindBy(how = How.LINK_TEXT,using = "Bank & Cash")WebElement BankCash;
		@FindBy(how = How.LINK_TEXT,using = "New Account")WebElement NewAccount;
		@FindBy (how = How.XPATH, using = "//h2[contains(text(),'Accounts')]")WebElement Accounts;
		
		public void sideNavigation() throws InterruptedException {
		BankCash.click();
		Thread.sleep(2000);
		NewAccount.click();
		}

		public void validateAccountPage() {
			Accounts.isDisplayed();
			
		}
	
	
	
}