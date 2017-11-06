package framework.core;

import java.io.File;



/* This included common functionalities that can be used across package like getting timestamp/latetest file from directory,Reading Excel*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.jacob.com.LibraryLoader;

import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.ITestCase;
import atu.alm.wrapper.ITestCaseRun;
import atu.alm.wrapper.enums.StatusAs;

public class FunctionalLibrary {
	
	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public void captureScreenShot(String obj, WebDriver driver)
			throws IOException {
		File screenshotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D:\\QC_ScreenShot\\" + obj
				+ "" + GetTimeStampValue() + ".png"));
	}

	public static String GetTimeStampValue() throws IOException {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		String systime = timestamp.replace(":", "");
	return systime;
	}
	
	
	public HashMap<Integer, String>  getQCStepDescription(StatusAs status,HashMap<Integer, String> statusMap,String testCaseName){
		try{
		ReadFromExcel read = new ReadFromExcel();
		FileInputStream ios = new FileInputStream(
				"d:\\Test_case Mapping Sheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(ios);
		XSSFSheet sheet = workbook.getSheetAt(1); 
		ArrayList<String> listStrings1 = new ArrayList<String>();
		ArrayList<String> listStrings2 = new ArrayList<String>();
		ArrayList<String> listStrings3 = new ArrayList<String>();
		ArrayList<String> listStrings4 = new ArrayList<String>();
		
		
		listStrings1 = read.extractExcelContentByColumnIndex(0, sheet);
		listStrings2 = read.extractExcelContentByColumnIndex(1, sheet);
		listStrings3 = read.extractExcelContentByColumnIndex(2, sheet);
		listStrings4 = read.extractExcelContentByColumnIndex(3, sheet); 
		int j=0;
		for(int i=1;i<listStrings1.size();i++){
			if(listStrings1.get(i).equalsIgnoreCase(testCaseName) && listStrings4.get(i).equalsIgnoreCase(status.getStatus())){ 
				statusMap.put(j, listStrings3.get(i));
				j++; 
			  }		
			  
		} 
		System.out.println("hmap"+statusMap);
		
		
		}catch(IOException e){
			e.printStackTrace();
		}

		return statusMap;
		
	}


}

