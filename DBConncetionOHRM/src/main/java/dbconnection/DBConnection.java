package dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String dburl = "jdbc:mysql://localhost:3306/facebook";
		String username = "root";
		String password = "geetu123";
		String query = "Select * from login";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(dburl, username, password);
		Statement stmt =con.createStatement();
		ResultSet rs =stmt.executeQuery(query);
		 while(rs.next()) {
		
		//String id = rs.getString("id");
		String email = rs.getString("email");
		String pswd= rs.getString("password");
		
		
		System.out.println(email);
		System.out.println(pswd);
		
}
		 con.close();
}
	
}
