package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListAccountPage {

	WebDriver driver;
	
	//Every page must have a constructor to invite the driver
		public ListAccountPage(WebDriver driver) {
		this.driver = driver;
	}
		//method to return string to the test class
		public List<String> getColumnDataFor(String columnHeader) {
		//empty string variable created haven't stored anything yet
		List<String> columnData = new ArrayList<String>();;
		//index for column header(account)
		int index = getColumnHeaderIndexFor(columnHeader);
		//injecting index
		String xpath = "//table[@class='table table-bordered sys_table']/tbody/tr/td["+index+"]";
		//List of WebElement(will convert into List of String)
		List<WebElement> columnDataElements = driver.findElements(By.xpath(xpath));
		for(int i = 0; i <columnDataElements.size(); i++) {
			columnData.add(columnDataElements.get(i).getText());
		}
		
		return columnData ;
	
	}
	
		private int getColumnHeaderIndexFor(String columnHeader) {
		String xpath = "//table[@class='table table-bordered sys_table']/tbody/tr[1]/child::th";
		//Created web element list
		List<WebElement> columnHeaderElements = driver.findElements(By.xpath(xpath));
		System.out.println(columnHeaderElements.get(1).getText());
		int index = 1;
		
		for(WebElement element :columnHeaderElements) {//1st round element.get1
			if(element.getText().equalsIgnoreCase(columnHeader)) {
				return index;
			}
			index++;
		}
		return 0;
		
	}
		

}