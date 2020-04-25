package testPage;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.AddNewAccountPage;
import page.ListAccountPage;
import page.LoginPage;
import page.SideNavigationPage;
import util.BrowserFactory;

public class NewAccountTest {
	WebDriver driver;
	Random rnd = new Random();
	int rndNumber = rnd.nextInt(999);
	
	@BeforeMethod
	public void startBrowser() {
		driver = BrowserFactory.startBrowser();
		}
	@Test
	public void newAccount() throws InterruptedException {
		String account = "Checking"+rndNumber;
		String description = "salary" +rndNumber;
		String balance = "5000";
		String expectedTitle = account;
		System.out.println("Expected Title: "+ account);
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.validateTitle();
		loginPage.userlogin("techfiosdemo@gmail.com", "abc123");
		loginPage.validateDashBoard();
		SideNavigationPage sidenav = PageFactory.initElements(driver, SideNavigationPage.class);
		sidenav.sideNavigation();
		sidenav.validateAccountPage();
		Thread.sleep(3000);
		AddNewAccountPage addNewAccount = PageFactory.initElements(driver, AddNewAccountPage.class);
		addNewAccount.newAccount(account, description, balance);
		//Get the list of column data from the page class
		
		ListAccountPage listAccountPage = PageFactory.initElements(driver, ListAccountPage.class);
		List<String> columnData =listAccountPage.getColumnDataFor("Account");
		
		Assert.assertTrue(isCellDataDisplayed(expectedTitle, columnData), "did not displayed!!!");
	}


	private boolean isCellDataDisplayed(String expectedTitle, List<String> columnData) {
		for(String cellData:columnData) {
			if (cellData.equalsIgnoreCase(expectedTitle)) {
				System.out.println(expectedTitle);
				System.out.println(cellData);
				return true;
			}
		
		}
		
		return false;
	
	}
	
	@AfterMethod
	public void closeEverything() {
		driver.close();
		driver.quit();
		
	}
	

}
