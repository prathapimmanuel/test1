package framework.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.SkipException;





/**
 * @author
 * 
 */
public class WebUtility {

	/**
	 * Description : This Method need to be modified for Safari and other
	 * requirements 
	 * 
	 * @throws Exception
	 */

    WebDriver driver = null;

	/**
	 * Method to instantiate WebDriver based on the values set in the property file
	 * 
	 * @return WebDriver object
	 * @throws MalformedURLException 
	 */
	
	/**
	 * Create Directory for the given path
	 * 
	 * @param path (File Object)
	 * @param recreate
	 * @return true is create directory is successful, false otherwise
	 */
	public static boolean makeDirectory(File path, boolean recreate) {

		if (path.exists() && !recreate) {
			// do nothing
			return true;
		} else if (path.exists() && recreate) {
			// delete path, and recreate
			deleteDirectory(path);
			path.mkdirs();
			path.setExecutable(true);
			return true;
		} else {
			// path not exists, so create the path
			path.mkdirs();
			path.setExecutable(true);
			return true;
		}
	}

	/**
	 * Create Directory for the given path
	 *  
	 * @param path (String)
	 * @param recreate
	 * @return true is create directory is successful, false otherwise
	 */
	public static boolean makeDirectory(String path, boolean recreate) {
		return makeDirectory(new File(path), recreate);
	}

	/**
	 * Delete directory provided by the path
	 * 
	 * @param path to be deleted
	 * @return true if delete is successful, false otherwise
	 */
	public static boolean deleteDirectory(File path) {
		if (path.exists()) {
			// include a test for root directory
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return path.delete();
	}



	
}
