

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
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
		
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String name = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			String email = request.getParameter("userEmail");
			boolean nameExists = false;
			boolean mailExists = false;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			BigInteger hash = new BigInteger(1,md.digest());
			String HashWord = hash.toString(16);
				Connection con;
				con = DatabaseConnection.initializeDatabase();
				Statement stmt = con.createStatement();
				ResultSet nameCheck = stmt.executeQuery("select * from users where userName='"+name+"';\r\n"
						+ "");
				if (nameCheck.next()) {
					nameExists =true;
				}
				ResultSet mailCheck = stmt.executeQuery("select * from users where email='"+email+"';\r\n"
						+ "");
				if(mailCheck.next()) {
					 mailExists = true;
				}
				if(nameExists) {
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('The username already Exists! Try again with some other name!');");
						out.println("</script>");
						RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");  
				        rd.include(request, response); 
					
				}
				else if(mailExists) {
					response.setContentType("text/html");  
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('The Email already Exists! Please try again with some other Email!');");
					out.println("</script>");
					RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");  
			        rd.include(request, response); 
				}
				else {
					try {
						PreparedStatement pstmt = con.prepareStatement("INSERT INTO `welearn`.`users` (`userName`, `password`, `email`) VALUES (?,?,?);\r\n"
								+ "");
						pstmt.setString(1, name);
						pstmt.setString(2, HashWord);
						pstmt.setString(3, email);
						pstmt.executeUpdate();
						session.setAttribute("name", name);
						session.setAttribute("role", "user");
						response.sendRedirect("user/course-enroll");
					}
					catch(Exception e) {
						con.close();
						e.printStackTrace();
					}
				}
				
				
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
