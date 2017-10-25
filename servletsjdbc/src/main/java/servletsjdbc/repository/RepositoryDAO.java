package servletsjdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryDAO {
	
	Connection con =  null;
	
		
	public static final String CREATE_TABLE = "create table register(fullname character varying(40) NOT NULL,email character varying(40) NOT NULL,username character varying(40) NOT NULL,password character varying(40) NOT NULL "; 	
	public static final String INSERT_REGISTER = "Insert into register values(fullname,email,username) values(?,?,?,?)";
	public static final String	SELECT_USER_INFO="select username,password from register where username = ?";
	public static final String	UPDATE_EMAIL = "Update register set email=? where username=? ";
	
	
	public void getConnection() throws ClassNotFoundException {
		
		try {
			System.out.println("postgresl staretd");
			Class.forName("org.postgresql.Driver");
			System.out.println("driver started");
			// Connection 
		con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mavenintro", "postgres", "root");	//drivermanager .get Connection always get the established link
			
		}catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}
		
		
		public boolean createRegistration() {
			
			boolean result = false;
			Statement stmt = null;
			Statement stmt2 = null;
			
		boolean isTableExisist = false;
		try {
			
			getConnection();
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			ResultSet rs = stmt2.executeQuery("SELECT EXISTS (SELECT 1 FROM pg_tables WHERE schemaname = 'public' AND tablename = 'register");
			while(rs.next()) {
				
				isTableExisist = rs.getBoolean(1);
				
			}if (!isTableExisist) {
				
				result = stmt.execute(CREATE_TABLE);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				
			stmt.close();
			}catch(SQLException e) {
			e.printStackTrace();	
				
			}
			}
			
		return result;
		}
		
		public int saveRegistrationDetails(servletsjdbc.model.Registration userInfo) {
			
			int result = 0;
		PreparedStatement ps = null;
			
			try {
				getConnection();
				ps = con.prepareStatement(INSERT_REGISTER);
				ps.setString(1, userInfo.getFullname());
				ps.setString(2, userInfo.getEmail());
				ps.setString(3, userInfo.getUsername());
				ps.setString(4, userInfo.getPassword());
				result = ps.executeUpdate();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					ps.close();
					
				}catch(SQLException SQ) {
					
					
					SQ.printStackTrace();
				}
			
			}
			
			return result;
			
		}
		
		public void UpdateEmail(String email, String LoginID) {
			
		PreparedStatement ps = null;
		try {
			getConnection();
			ps = con.prepareStatement("UPDATE_EMAIL");
			ps.setString(1, email);
			ps.setString(2, LoginID);
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				ps.close();
				
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
		}
			
			
			
		}
		
		public boolean getUserDetails(String loginID, String password) {
			
			boolean result = false;
			PreparedStatement ps = null;
		
			
			try {
				getConnection();
				ps = con.prepareStatement("SELECT_USER_INFO");
				ps.setString(1, loginID);
				ps.setString(2,password);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					String s = rs.getString("email");
					String f = rs.getString("fullname");
					System.out.println("email" + s +"full name" + f );
					
					result = true;
				}else {
					
					System.out.println("you're not in the system, please register");
					
				}
				
				
			}catch(Exception E) {
				
				E.printStackTrace();
			}finally {
				try {
					
					ps.close();
				}catch(SQLException sq) {
					
					sq.printStackTrace();
				}
			}
			
			
			
			
		return result;	
		}
		
}
