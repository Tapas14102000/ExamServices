package project;
import java.sql.*;
public class ConnectionProvider {
public static Connection getconn() throws Exception
{
Class.forName("com.mysql.jdbc.Driver");   //error expected ClassNotFoundException
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qems","root","Tapas2055@");  //error expected SQLException
/*
 * DriverManager is a class in java.sql package.
 * 	static Connection getConnection(String url)throws SQLException
 * 	static Connection getConnection(String url,String Username,String Password)throws SQLException
 * 	static Connection getConnection(String url,Properties pp)throws SQLException
 * 	
 */
return con;
}
}
