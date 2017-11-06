package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.core.TestNGBase;

import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.GooglePage;
import framework.core.TestNGBase;

/**
 * Unit test for simple App.
 */
public class GoogleTesting extends TestNGBase {

	String dataURL = "http://www.google.com";

	//SoftAssert softAssert = getSoftAssert();
	Boolean flag = false;

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
	
	@After
	public void teardown() {
		driver.quit();
	}
}
