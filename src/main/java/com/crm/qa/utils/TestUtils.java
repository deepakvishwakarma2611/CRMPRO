package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.resources.Base;

public class TestUtils extends Base {

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "\\TestData\\FreeCrmTestData.xlsx";
	static Workbook wb;
	static Sheet sh;

	public TestUtils() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void switchToFrame() {

		driver.switchTo().frame("mainpanel");
	}

	public Object[][] getData(String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);

		wb = new XSSFWorkbook(fis);

		sh = wb.getSheet(sheetName);

		int rowCount = sh.getLastRowNum();

		int columnCount = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {

				data[i][j] = sh.getRow(i + 1).getCell(j).toString();

			}
		}

		return data;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
