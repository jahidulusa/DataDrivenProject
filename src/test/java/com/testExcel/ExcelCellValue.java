package com.testExcel;

import com.excelFactory.CellValue;

public class ExcelCellValue {

	public static void main(String[] args) throws Throwable {
		String excelPath = "./TestData/Login Test Cases.xlsx";
		String value = CellValue.getData(0, 2, 1, excelPath);
		System.out.println(value);
	}

}
