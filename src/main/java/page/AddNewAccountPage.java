package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewAccountPage {

	WebDriver driver;
	
	public AddNewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how=How.ID,using = "account")WebElement Account;
	@FindBy(how=How.ID,using = "description")WebElement Description;
	@FindBy(how=How.ID,using = "balance")WebElement Balance;
	@FindBy(how=How.XPATH,using = "//button[@class='btn btn-primary']")WebElement submit;
	@FindBy(how = How.LINK_TEXT,using= "Transactions")WebElement transactions;
	@FindBy (how = How.LINK_TEXT, using = "View Transactions")WebElement view_transactions;

	
	public void newAccount(String account, String description, String balance) throws InterruptedException {
		Account.sendKeys(account);
		Thread.sleep(2000);
		Description.sendKeys(description);
		Thread.sleep(1000);
		Balance.sendKeys(String.valueOf(balance));
		submit.click();
		Thread.sleep(2000);
		transactions.click();
		view_transactions.click();		
	}
	
}