package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.baseclass.Library;
import com.pages.User;

public class DBconnector extends Library{

	public User getCredentialsFromDB() {//throws ClassNotFoundException,SQLException {
		{
			String dburl =prop.getProperty("dburl");//testing is the DB name 
			// String username ="root";//username of db
			//String password ="geetu123";//pwd of db
			String username =prop.getProperty("dbusername");
			String password =prop.getProperty("dbpasswort");
			//String query ="Select * from login where email='abc@gmail.com'";//login table from db
			String query = prop.getProperty("dbquery");
			Connection con= null;
			ResultSet rs = null;
			Statement stmt = null;
			User user = new User();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				con = DriverManager.getConnection(dburl, username, password);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				while(rs.next()) {

					user.setUserName(rs.getString("email"));
					user.setPassword(rs.getString("password"));

				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}

			return user;		

		}
	}}




