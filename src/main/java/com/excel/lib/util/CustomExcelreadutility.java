package com.excel.lib.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class CustomExcelreadutility {

	public static void main(String[] args) {

		getrowcount();

	}

	public static void getrowcount() {

		try {

			XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Akash Sharma\\Desktop\\selenium\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\AppiumCRMpocAI\\src\\main\\java\\com\\excel\\lib\\util\\LeadLayoutInputs.xlsx");
			XSSFSheet sheet = workbook.getSheet("LeadLayout");
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row count: " + rowcount);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}



		// using for loop

		/*
		 * int rows = sheet.getLastRowNum(); int cols =
		 * sheet.getRow(1).getLastCellNum();
		 * 
		 * for (int r = 0; r <= rows; r++) {
		 * 
		 * XSSFRow row = sheet.getRow(r);
		 * 
		 * for (int c = 0; c < cols; c++) {
		 * 
		 * XSSFCell cell = row.getCell(c); switch(cell.getCellType()) { case
		 * STRING: System.out.println(cell.getStringCellValue()); break;
		 * 
		 * } } }
		 * 
		 */
	}

}
