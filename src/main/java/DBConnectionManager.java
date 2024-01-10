
import java.sql.*;

public class DBConnectionManager {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/patientdb";
	private static final String userName = "root";
	private static final String password = "123456";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, userName, password);
		}catch(ClassNotFoundException e){
			throw new SQLException("Database driver not found", e);
		}
		
	}
	
}
