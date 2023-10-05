package com.lulu.project.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuisnessLogic {
	
	void createData() throws SQLException {

		Connection connection=ConnectDBProduct.setupConnection();

		String query

        = "INSERT INTO prod ( id, name, cost, descrip  ) VALUES(?,?,?,?)";

		PreparedStatement myStmt = connection.prepareStatement(query);

	     // Set Parameters

	        myStmt.setInt(1, 888); // ready with Prepared Statement

	        myStmt.setString(2, "Socks");

	        myStmt.setInt(3, 300);

	        myStmt.setString(4, " good");

	        int success=myStmt.executeUpdate();

	        System.out.println("Added Successfully " + success);

	}

	void readData() throws SQLException{

		Connection connection=ConnectDBProduct.setupConnection();

		

		 Statement statement;

		 statement = connection.createStatement();

        ResultSet resultSet;

        resultSet = statement.executeQuery(

            "select * from prod where id>=1");

        int id;

        String name;

        int cost;

        String descr;

        while (resultSet.next()) {

            id = resultSet.getInt("id");

            name = resultSet.getString("name");

            cost=resultSet.getInt("cost");

            descr = resultSet.getString("descr");

            System.out.println("id : " + id

                               + " name : " + name +"  cost:"+ cost +" Descrip:"+ descr);

        }

	}

        void updateData() throws SQLException {

    		Connection connection = ConnectDBProduct.setupConnection();

    		String query = "update  prod set name =? where id=?";

    		PreparedStatement myStmt = connection.prepareStatement(query);

    		myStmt.setString(1,"jacket");

    		myStmt.setInt(2,333);

    		boolean success = myStmt.execute();

    		System.out.println("Updated Successfully " + success);

    	}

    	void deleteData() throws SQLException {

    		Connection connection = ConnectDBProduct.setupConnection();

    		String query = "delete from prod where id = ? ";

    		PreparedStatement myStmt = connection.prepareStatement(query);

    		myStmt.setInt(1, 222);

    		boolean success = myStmt.execute();

    		System.out.println("Deleted Successfully " + success);

     

    	}


}
