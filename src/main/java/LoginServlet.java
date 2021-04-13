

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession(false);
		
		try {
			Connection con;
			con = DatabaseConnection.initializeDatabase();
			PreparedStatement pstmt = con.prepareStatement("select * from users where userName=? and password=?;\r\n"
					+ "");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() && session==null) {
				String role = rs.getString("role");
				int userId = rs.getInt("userId");
				session = request.getSession();
				if(role.equals("user")) {
					session.setAttribute("name", userName);
					session.setAttribute("id", userId);
					session.setAttribute("role", "user");
					response.sendRedirect("user/course-enroll");

				}
				else {
					session.setAttribute("name", userName);
					session.setAttribute("id", userId);
					session.setAttribute("role", "admin");
					response.sendRedirect("admin/dashboard");
				}
			}
			else {
				response.setContentType("text/html");  
				response.getWriter().print("Invalid User!");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		        rd.include(request, response); 
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
