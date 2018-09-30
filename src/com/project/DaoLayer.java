package com.project;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoLayer
{
	String id,password;
	public int marks;
	public boolean flag=true;
	static DaoLayer obj=new DaoLayer();
	public static void main(String args[])
	{
		DaoLayer ob=new DaoLayer();
		ob=obj.setData("Rahul","Jaswal");
	}
	public static DaoLayer setData(String a,String b)
	{
	
		obj.id=a;
		obj.password=b;
		
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
			PreparedStatement st=con.prepareStatement("select marks from records where user_id= ? AND password= ?");
																		//Statement st=con.createStatement();
			st.setString(1,obj.id);
			st.setString(2, obj.password);
																		//st.setString(2, "hello");
																		//st.setInt(3, 234);
			ResultSet rs=st.executeQuery();
																		//ResultSet rs=st.executeQuery("select marks from records where user_id='"+id+"'");
			
			 if(!rs.isBeforeFirst())
				{
					obj.marks=-1;		//flag if user do not exist
				}
			 else
			   {
				 rs.next();
				 obj.marks=Integer.parseInt(rs.getString(1));
				 
			   }
			 con.close();
			
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
		 return obj;
	}
	public static DaoLayer setData(String a,String b,int m)
	{
		
		obj.id=a;
		obj.password=b;
		obj.marks=m;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
			System.out.println("connected");
			PreparedStatement ps=con.prepareStatement("insert into records values(?,?,?)");
			ps.setString(1, obj.id);
			ps.setString(2, obj.password);
			ps.setInt(3, obj.marks);
			
			
			PreparedStatement s=con.prepareStatement("Select * from records where user_id=?");
			s.setString(1,obj.id);
			if(s.executeQuery() == null)
			{
				obj.flag=false;
			}
			else
			{
				ps.execute();
				obj.flag=true;
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return obj;
		
		
		
	}
	 
	public static DaoLayer delData(String a,String b)
	{
		DaoLayer obj=new DaoLayer();
		obj.id=a;
		obj.password=b;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
			PreparedStatement ps=con.prepareStatement("delete from records where user_id=? AND password=?");
			ps.setString(1, obj.id);
			ps.setString(2, obj.password);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				obj.flag=true;
			}
			else
			{
				obj.flag=false;
			}
		}
		catch(Exception c)
		{
			System.out.println(c);
		}
		
		
		return obj;
		
	}
		
	
}
