package com.ty.secreatepassword.helper;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnectionObject {

		private static String url = "jdbc:mysql://localhost:3306";
		private static String username = "root";
		private static String password = "root";

		static {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public static Connection getConnection() {

			Connection connection = null;

			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;

		}

	}


