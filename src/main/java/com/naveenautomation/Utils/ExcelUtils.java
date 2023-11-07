package com.naveenautomation.Utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomation.base.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi; // provided by java IO - to read the file
	public static XSSFWorkbook wb; // all Static because we dont want to see behaviour change
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String fileName, String Sheet) throws Exception { // passing the argument so it can be
																					// used again
		// and again

		int rowCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(Sheet);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}

	public static int getCellCount(String fileName, String Sheet, int rowCount) throws Exception {
		int cellCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(Sheet);
		row = ws.getRow(rowCount);
		cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;

	}

	public static String getCellData(String fileName, String Sheet, int rowCount, int cellCount) throws Exception {

		String data;

		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(Sheet);
		row = ws.getRow(rowCount);

		cell = row.getCell(cellCount - 1);
		data = cell.getStringCellValue();
		wb.close();
		fi.close();
		return data;
	}
}
