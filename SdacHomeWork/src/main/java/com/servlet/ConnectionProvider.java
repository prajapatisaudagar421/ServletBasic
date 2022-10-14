package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class ConnectionProvider {
	private static Connection con;

	public static Connection getConnection() {
		try {
			if (con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return con;
	}
}
