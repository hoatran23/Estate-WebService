package com.estate.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	/*
	 * Package "utils" được dùng để khai báo các phương thức được sử dụng ở nhiều nơi
	 * Class được khai báo với từ khóa static được gọi là Nested class (inner class - class nằm trong class khác)
	 * 
	 * */
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";  
	private static String USER = "root";
	private static String PASS = "123456";
	
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
