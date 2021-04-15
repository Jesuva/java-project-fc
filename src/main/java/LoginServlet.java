

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
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
			MessageDigest sha2 = MessageDigest.getInstance("SHA-256");
			sha2.update(password.getBytes());
			BigInteger hash = new BigInteger(1,sha2.digest());
			String HashPassword = hash.toString(16);
			PreparedStatement pstmt = con.prepareStatement("select * from users where userName=? and password=?;\r\n"
					+ "");
			pstmt.setString(1, userName);
			pstmt.setString(2, HashPassword);
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
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2;URL=login'>");
				out.println("<h3 style='color:red;text-align:center;margin-top:15%'>Username and Password does not match! Please Try again with correct Credentials!</h3>");
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
