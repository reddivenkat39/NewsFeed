package mangi.PostMe.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataSourceBean {

	
	private String url ="jdbc:mysql://localhost:3306/discussionpostdb";
	private String uname = "root";
	private String pswd ="password";
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(url + " "+uname+ " "+pswd);
		Connection con = DriverManager.getConnection(url,uname, pswd);
		System.out.println(con);
		return con;
	}
	
}
