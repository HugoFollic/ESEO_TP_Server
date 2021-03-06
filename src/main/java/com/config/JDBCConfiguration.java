package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfiguration {

	private Connection co;

	public JDBCConfiguration() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.co = DriverManager.getConnection("jdbc:mysql://localhost/maven?user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCo() {
		return co;
	}

	public void setCo(Connection co) {
		this.co = co;
	}
}