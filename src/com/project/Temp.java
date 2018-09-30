package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Temp {

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
			System.out.println("connected!");
			
			Statement st=con.createStatement();
			ResultSet  rs=st.executeQuery("select * from records");
			System.out.println("executed ");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
