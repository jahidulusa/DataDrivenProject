package com.testExcel;

import java.util.ArrayList;

import com.excelFactory.ExcelColumn;



public class ExcelColumnValue {

	public static void main(String[] args) throws Throwable {

		String excelPath="./TestData/Login Test Cases.xlsx";
		ArrayList<String> ColumnValue= new ArrayList<String>();
		
		ColumnValue=ExcelColumn.columnValue(excelPath,2);
		System.out.println("Value::"+ColumnValue);
	}

}
