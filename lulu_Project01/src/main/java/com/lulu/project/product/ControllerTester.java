package com.lulu.project.product;

import java.sql.SQLException;

public class ControllerTester {
	
	public static void main(String[] args)throws SQLException {

	BuisnessLogic bl = new BuisnessLogic();
	bl.createData();
	bl.readData();
	bl.deleteData();
	bl.updateData();
	
	}
}
