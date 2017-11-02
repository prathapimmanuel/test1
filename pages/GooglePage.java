package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import framework.core.ReadFromExcel;

public class GooglePage {
	
//	private static String txtSearchBox = ReadFromExcel.getLocator("EditWFTPage", "txtWFTName");	
	private static String txtSearchBox = "xpath;//input[@name='q']";	
	private static String txtResultCount = "xpath;//div[@id ='resultStats']";
	private WebDriver driver;


	
	public GooglePage(final WebDriver driver) {
		this.driver = driver;	
		
	}
	
	public void openApplication(String url){
		driver.get(url);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void doSearch(String searchText){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(txtSearchBox)).sendKeys(searchText);
		driver.findElement(By.xpath(txtSearchBox)).sendKeys(Keys.ENTER);
	}
	
	public String getResultsCount(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath(txtResultCount)).getText();
	}
}
