package com.javaee.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.javaee.constant.AppConstant.*;

public class DatabaseConfig {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
