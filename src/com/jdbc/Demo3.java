package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo4","root","vsk@2004");
			String query = "insert into student values (0,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			//collecting the from the end user
			System.out.println("Enter username:");
			String name = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			System.out.println("enter email:");
			String email = sc.next();
			
			
			//to specify the value for place holder
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			i=ps.executeUpdate();
			System.out.println(i);
			if(i>0) {
				System.out.println("data added successfully");
			} else {
				System.out.println("unable to add");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
