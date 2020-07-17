package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertUser(User u) {
		int status=0;
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("Insert into customer values(?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getUser(String userId , String pass) {
		User u = new User();
        try {
        	con=ConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from Customer where userId=? and password=?");
			ps.setString(1, userId);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u.setName(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
