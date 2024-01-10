

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayPatientsServlet")
public class DisplayPatientsServlet extends HttpServlet {
	
	private static final String viewPatientQuery = "SELECT * FROM patients";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		try {
			
			Connection connection = DBConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(viewPatientQuery);
			
			ResultSet result = ps.executeQuery();
			pw.println("<!DOCTYPE html>");
	        pw.println("<html>");
	        pw.println("<head>");
	        pw.println("<meta charset=\"ISO-8859-1\">");
	        pw.println("<title>List of Employees</title>");
	        pw.println("<link rel='stylesheet' href='style.css'");
	        pw.println("</head>");
	        pw.println("<body>");
			pw.println("<table>");
			pw.println("<tr>");
//			pw.println("<td>ID</td>");
			pw.println("<td>Patient Name</td>");
			pw.println("<td>Age</td>");
			pw.println("<td>Gender</td>");
			pw.println("<td>Email</td>");
			pw.println("<td>Phone</td>");
			pw.println("</tr>");

			while(result.next()) {
				pw.println("<tr>");
//				pw.println("<td>"+result.getInt(1)+"</td>");
				pw.println("<td>"+result.getString(2)+"</td>");
				pw.println("<td>"+result.getString(3)+"</td>");
				pw.println("<td>"+result.getString(4)+"</td>");
				pw.println("<td>"+result.getString(5)+"</td>");
				pw.println("<td>"+result.getString(6)+"</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("</body>");
		    pw.println("<html>");
	  
	   
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("<a href='Welcome.jsp'><button>Home</button></a>");
		
		
	}

}
