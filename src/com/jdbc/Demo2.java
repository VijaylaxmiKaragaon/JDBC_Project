package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1","root","vsk@2004");
			Statement st = con.createStatement();
			System.out.println("Enter the emp name:");
			String fname = sc.next();
			String query="select * from emp where fname=" + fname;
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String name = rs.getString("fname");
				String lname = rs.getString("lname");
				System.out.println(eid+" "+name+" "+lname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
