package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {

	static Connection con=null;
	public static Connection getCon() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(connUrl,username,pwd);
			
			}
		
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
