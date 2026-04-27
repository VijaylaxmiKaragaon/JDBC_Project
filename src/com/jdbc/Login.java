package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo4","root","vsk@2004");
			String query = "select * from student where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter the email:");
			String email = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Login successful!, Welcome"+" "+rs.getString("name"));
			} else {
				System.out.println("Login failed..!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
