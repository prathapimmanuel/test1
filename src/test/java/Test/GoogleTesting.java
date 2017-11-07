package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.core.EnvParameters;
import framework.core.EnvParameters.OSType;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.GooglePage;


/**
 * Unit test for simple App.
 */
public class GoogleTesting  {
	WebDriver driver;
	String dataURL = "http://www.google.com";

	//SoftAssert softAssert = getSoftAssert();
	Boolean flag = false;
	
	
@BeforeTest
private void setupChromeDriver() throws Exception {

			String ChromProp = "webdriver.chrome.driver";
			new EnvParameters();
			File targetChromedriver = null;
			if (EnvParameters.getOSname() == EnvParameters.OSType.windows) {			
				targetChromedriver = new File(EnvParameters.TEST_ROOT_DIR
						+ File.separator + "drivers" + File.separator + "chrome"
						+ File.separator + "win" + File.separator
						+ "chromedriver.exe");
			}

			else if (EnvParameters.getOSname() == OSType.mac) {
				targetChromedriver = new File(EnvParameters.TEST_ROOT_DIR
						+ File.separator + "drivers" + File.separator + "chrome"
						+ File.separator + "mac" + File.separator + "chromedriver");
			} else if (EnvParameters.getOSname() == OSType.linux) {
				targetChromedriver = new File(EnvParameters.TEST_ROOT_DIR
						+ File.separator + "drivers" + File.separator + "chrome"
						+ File.separator + "linux" + File.separator
						+ "chromedriver");
			}
			System.setProperty(ChromProp, targetChromedriver.getAbsolutePath());
			driver = new ChromeDriver();
		}
	

	@Test
	public void testOpenGoogle() {
		
		GooglePage objGooglePage = new GooglePage(driver);
		
		objGooglePage.openApplication(dataURL);
		flag = objGooglePage.getTitle().contains("Google");
		System.out.println("flag"+flag);
		//softAssert.assertTrue(flag, "search page opened");
		//softAssert.assertAll();		

	}

	//@Test
	public void testSearchGoogle() {
		GooglePage objGooglePage = new GooglePage(driver);
		objGooglePage.openApplication(dataURL);
		objGooglePage.doSearch("Test Automation");
		flag = objGooglePage.getTitle().contains("Auto mation");
		System.out.println("flag"+flag);
		//Assert.assertTrue(flag, "search succeeds");
		//softAssert.assertAll();
	}
	
	//@Test 
	public void testValidatesearch() {
		GooglePage objGooglePage = new GooglePage(driver);
		objGooglePage.openApplication(dataURL);
		objGooglePage.doSearch("Test Automation");
		flag = !objGooglePage.getResultsCount().isEmpty();
		System.out.println("flag"+flag);
		/*Assert.assertTrue(flag, "search results available");
		softAssert.assertAll();*/
		
	}
	
	@AfterMethod()
	public void postTestCase() {
		if (driver != null) {
			driver.quit();
		}
	} 
}
