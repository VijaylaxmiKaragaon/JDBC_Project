package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stud","root","vsk@2004");
			Statement st = con.createStatement();
			String query = "SELECT * FROM STUDENT";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				System.out.println(id+" "+name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
