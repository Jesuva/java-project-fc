

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String name = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String confirmPassword = request.getParameter("confirmPassword");
			String role = request.getParameter("role");
			if(password.equals(confirmPassword)) {
				Connection con;
				con = DatabaseConnection.initializeDatabase();
				Statement stmt=con.createStatement();  
				ResultSet c = stmt.executeQuery("select count(*) from `welearn`.`users`");
				c.next();
				int count = c.getInt(1);
				count = 1001+count;
				try {
					PreparedStatement pstmt = con.prepareStatement("INSERT INTO `welearn`.`users` (`userId`, `userName`, `password`, `role`) VALUES (?,?,?,?);\r\n"
							+ "");
					pstmt.setInt(1, count);
					pstmt.setString(2, name);
					pstmt.setString(3, password);
					pstmt.setString(4, role);
					pstmt.executeUpdate();
					session.setAttribute("name", name);
					session.setAttribute("role", role);
					if(role.equals("user")) {
						response.sendRedirect("user/course-enroll");
					}
					else {
						response.sendRedirect("admin/dashboard");
					}
				}
				catch(Exception e) {
					con.close();
					e.printStackTrace();
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
