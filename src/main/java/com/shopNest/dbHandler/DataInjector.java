package com.shopNest.dbHandler;

import java.sql.*;

public class DataInjector {
		public static String addCustomer(String uname,String mail,String pass, String gender,String address)  {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="system";
			String sql = "INSERT INTO customers VALUES(?,?,?,?,?)";
			String regStatus="";
			try {
				Class.forName(driver); 
				Connection con=DriverManager.getConnection(url, user, password);
				PreparedStatement ps=con.prepareStatement(sql);
							
					ps.setString(1, uname);
					ps.setString(2, mail);
					ps.setString(3, pass);
					ps.setString(4, gender);
					ps.setString(5, address);
					
					ps.executeUpdate();
					
					regStatus="success";
			}catch(Exception ex) {
				System.out.println("Problem in adding customer");
				ex.printStackTrace();
				regStatus="fail";
			}finally {
				return regStatus;
			}
		}
}