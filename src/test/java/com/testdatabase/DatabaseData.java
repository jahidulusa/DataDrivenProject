package com.testdatabase;

import com.database.Database;

public class DatabaseData {

	public static void main(String[] args) throws Throwable {
		
		String qyeries ="select * from employees";
		
		Database.getDataTableColumn(qyeries, "salary");
		Database.getDataTableColumn(qyeries, "first_name");
	}

}
