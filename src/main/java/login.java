import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet{
	private static final String selectUserQuery = "SELECT * FROM patients WHERE email = ? AND password =? ";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name;
		try {
			
			Connection connection = DBConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(selectUserQuery);
			
			if (email!=null && password!=null) {
				ps.setString(1, email);
				ps.setString(2, password);
				
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("name", result.getString(2));
					name = result.getString(2);
					
					Cookie userCookie = new Cookie("user", name);
		            userCookie.setMaxAge(3600); 
		            response.addCookie(userCookie);
		         
		            
		            response.sendRedirect("Welcome.jsp");

				}
			}
			
			
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			response.sendRedirect("login.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
