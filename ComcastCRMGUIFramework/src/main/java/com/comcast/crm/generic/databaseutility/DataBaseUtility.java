package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	
	public void getDbConnection() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	}

	public void closeDbConnection() throws SQLException {
		con.close();
	}

	public ResultSet executeConSelectQuery(String query) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		return result;
	}

	public int executeNonSelectuery(String query) throws SQLException {
		int result=0;
		result = con.createStatement().executeUpdate(query);
		return result;
	}
 
}

