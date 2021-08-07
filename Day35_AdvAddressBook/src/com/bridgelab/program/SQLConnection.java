package com.bridgelab.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
   
	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/Address_BookService";
        String user = "root";
    	String pass = "Deepak@18";
    	
    	try {
			Connection connect = DriverManager.getConnection(url,user,pass);
			System.out.println("Connection established successfully");
			return connect;
    	}catch (SQLException e) {
			System.out.println("Connection faild");
		}  
    	return null;
    }

}