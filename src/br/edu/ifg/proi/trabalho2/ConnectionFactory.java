package br.edu.ifg.proi.trabalho2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		
		try {
			 String url = "jdbc:mysql://localhost/trabalho01";
			 String user = "root";
			 String passw = "123456";
			 return DriverManager.getConnection(url, user, passw);
			 } catch (SQLException e) {
			 throw new RuntimeException(e);
			 }
		
	}
}
