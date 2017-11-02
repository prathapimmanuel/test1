package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test; 

public class GoogleTesting{

	String dataURL = "http://www.google.com";
	Boolean flag = false;

	@Test
	public void GoogleTest() {
		 
		System.setProperty("webdriver.chrome.driver", "D:\\Data Backup\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("http://www.google.com"); 
        
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
	} 
}
