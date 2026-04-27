package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		//1st step of JDBC
		//Loading and registering the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Dricer loaded");
			//2nd step establish the connection between java and jdbc
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud","root","vsk@2004");
			System.out.println("Con established");
			//3rd step creating the platfrom for sql queries
			Statement st = con.createStatement();
			System.out.println("Platform created");
			//4th step generate the sql queries
			String query = "Insert into Student values(0,'Vijaylaxmi','vsk@gmail.com'),"
					+ "(0,'vijju','vijju@gmail.com'),"
					+ "(0,'ananya','ananya@gmail.com')";
			int i = st.executeUpdate(query);
			System.out.println(i+" "+"rows updated");
					
					
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
