package framework.core;

import java.io.File;
import org.openqa.selenium.WebDriver;





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
