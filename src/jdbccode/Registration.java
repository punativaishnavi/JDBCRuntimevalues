package jdbccode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Registration
{
	public static void main(String[] args) 
	{
		
	
	String url="jdbc:mysql://localhost:3306";
	String user ="root";
	String password="punati";
	String query ="insert into vaishnavi_db.registration values(?,?,?,?)";
	try 
	{
		Connection connection =DriverManager.getConnection(url,user,password);
		System.out.println("step 1");
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter username:");
		String username = scanner.next();
		System.out.println("enter password :");
		String pwd = scanner.next();
		System.out.println("enter mobilenumber:");
		String number = scanner.next();
		System.out.println("enter mailid:");
		String mailid = scanner.next();
		System.out.println("confirm password:");
		String cpwd = scanner.next();
		
		preparedStatement.setString(1, username);
		preparedStatement.setString(3, number);
		preparedStatement.setString(4, mailid);
		
		if(pwd.equals(cpwd))
		{
			preparedStatement.setString(2,password );
			preparedStatement.executeUpdate();
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		
		
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	
}
}


