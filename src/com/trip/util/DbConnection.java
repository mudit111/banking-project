package com.trip.util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class DbConnection {

	public static Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager
				.getConnection("jdbc:sqlserver://localhost:1433;databaseName=trip;username=sa;password=sunlife_1234");
		return connection;
	}
}
