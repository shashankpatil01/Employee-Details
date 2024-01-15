package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bin.emp_bo;

public class emp_dao 
{
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/studproj";
			String user="root";
			String password="Shashank@23";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   con=DriverManager.getConnection(url,user,password);
			
		  
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	public static int signup(emp_bo em)
	{
		int status=0;
		
		try 
		{
		  Connection con= emp_dao.getConnection();
		  String query="insert into signup(name,email,phone,password)values(?,?,?,?)";
		   PreparedStatement ps= con.prepareStatement(query);
		    ps.setString(1, em.getName());
		    ps.setString(2, em.getEmail());
		    ps.setString(3, em.getPhone());
		    ps.setString(4, em.getPassword());
		    
		        status=ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	
		return status;
		
	}
	public static List<emp_bo> getAllEmployee()
	{
		List<emp_bo> list=new ArrayList<emp_bo>();
		
		try
		{
			Connection con= emp_dao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from signup");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				emp_bo em=new emp_bo();
				
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setEmail(rs.getString(3));
				em.setPhone(rs.getString(4));
				em.setPassword(rs.getString(5));
				
				list.add(em);
				
			}
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	
	return list;
}

}