package com.bridgelab.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		Main services = new Main();
		services.readAddressBookData();
		services.updateAddressBookData("Deepak", "703871");
		services.readAddressBookData();
	}

	private void updateAddressBookData(String name, String phoneNumber) throws SQLException {
		Connection conn = SQLConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement("UPDATE AddressBook SET phoneNumber = ? WHERE firstName = ?");
		statement.setString(1, phoneNumber);
		statement.setString(2, name);
		statement.executeUpdate();
        System.out.println("updated successfully");
        
        conn.close();
	}

	private void readAddressBookData() throws SQLException {
		Connection conn = SQLConnection.getConnection();
		String sql = "SELECT * FROM AddressBook";
		Statement query = conn.createStatement();
		ResultSet resultSet = query.executeQuery(sql);
		ResultSetMetaData rsmd = resultSet.getMetaData();
	    int columnsNumber = rsmd.getColumnCount();
		while(resultSet.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
	            if (i > 1) System.out.print(" | ");
	            System.out.print(resultSet.getString(i));
	        }
	        System.out.println("");
		}
		conn.close();	
	}
}
