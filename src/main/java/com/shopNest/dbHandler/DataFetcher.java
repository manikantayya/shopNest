package com.shopNest.dbHandler;
import java.sql.*;
public class DataFetcher {
	public static String fetchPassword(String uname)
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "system";
		String sql = "SELECT pass FROM customers WHERE uname=?";
		String dbPass="";
		try{
			//Establishing connection
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			//Executing query
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//storing fetched password into dbPass
			dbPass = rs.getString(1);
		}
		catch(Exception e){
			System.out.println("Login issue");
			e.printStackTrace();
		}
		return dbPass; 
		
	}

}
