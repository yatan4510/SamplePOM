package com.samplecrm.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.samplecrm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PageLoadTimeout = 25;
	public static long ImplicitWait = 25;
	public static Workbook book;
	public static Sheet sheet;

	public void switchToFrame(String name) {

		driver.switchTo().frame(name);
	}

	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\Users\\Yatan\\eclipse-workspace\\SamplePOMTest\\src\\main\\java\\com\\samplecrm\\qa\\testdata\\CRMTestData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Workbook book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}
}
