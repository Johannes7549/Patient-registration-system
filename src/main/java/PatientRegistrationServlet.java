import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PatientRegistrationServlet")
public class PatientRegistrationServlet extends HttpServlet {
	private static final String addPatient = "INSERT INTO patients (name,age,gender,email,phone,password) VALUES (?,?,?,?,?,?)";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		try {
			Connection connection = DBConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(addPatient);
			
			if (name != null && gender != null && email != null && phone != null && password != null) {
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, gender);
				ps.setString(4, email);
				ps.setString(5, phone);
				ps.setString(6, password);
				
				
				int count = ps.executeUpdate();
				
				if (count == 1) {
					response.sendRedirect("login.jsp");
				}else {
					response.sendRedirect("patientRegistration.jsp");
				}
			}else {
				response.sendRedirect("patientRegistration.jsp");
			}
			
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			response.sendRedirect("patientRegistration.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("patientRegistration.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
