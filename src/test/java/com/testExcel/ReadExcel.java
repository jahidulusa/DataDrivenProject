package com.testExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Throwable {

		String excelPath="./TestData/WebTable.xlsx";
		File file = new File(excelPath);
		FileInputStream fs= new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fs);
		XSSFSheet sheet= wb.getSheetAt(0);

		 DataFormatter dataFormatter = new DataFormatter();

	        // 1. You can obtain a rowIterator and columnIterator and iterate over them
	        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
	        Iterator<Row> rowIterator = sheet.rowIterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();

	            // Now let's iterate over the columns of the current row
	            Iterator<Cell> cellIterator = row.cellIterator();

	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                String cellValue = dataFormatter.formatCellValue(cell);
	                System.out.print(cellValue +  "     \t");
	            }
	            System.out.println();
	        }


}
}


