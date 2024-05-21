package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static void main(String[] args) {

		String filePath = "./src/test/resources/Data.xlsx";

		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Customers Data");
			int rows = sheet.getLastRowNum();
			int columns = sheet.getRow(0).getLastCellNum();
			
			for(int r=0; r<rows; r++) {
				
				Row row = sheet.getRow(r);
				
				for(int c=0; c<columns; c++) {
					Cell cell = row.getCell(c);
					
					switch(cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.print((int)cell.getNumericCellValue());
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
					default:
						System.out.println("Add this cell type to list: " + cell.getCellType());
					}
					System.out.print(" | ");
				}
				System.out.println();
			}
			
			workbook.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
