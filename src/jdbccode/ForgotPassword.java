
package jdbccode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ForgotPassword {
	public static void main(String[] args) 
	{
		
	
	String url="jdbc:mysql://localhost:3306";
	String user ="root";
	String password="punati";
	String query ="update vaishnavi_db.Registration set password=? where mobilenumber=? ";
	try 
	{
		Connection connection =DriverManager.getConnection(url,user,password);
		System.out.println("step 1");
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		
		Scanner scanner = new Scanner(System.in);
		
	
		System.out.println("enter password :");
		String pwd = scanner.next();
		System.out.println("enter mobilenumber:");
		String number = scanner.next();
		System.out.println("confirm new password:");
		String cpwd = scanner.next();
		
	
		preparedStatement.setString(2, number);
	
		
		if(pwd.equals(cpwd))
		{
			preparedStatement.setString(1,pwd );
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