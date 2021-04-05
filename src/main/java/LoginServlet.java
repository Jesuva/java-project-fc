

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

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession(false);
		try {
		if(password.equals("user")) {
			if(session==null) {
				session = request.getSession();
				session.setAttribute("name", userName);
				response.sendRedirect("course-enroll");
			}
			else if(userName.equals((String)session.getAttribute("name"))) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2;URL=course-enroll'>");
				out.println("<h3 style='color:red;text-align:center;margin-top:15%'>Welcome Back, Your session is not expired yet!<br>Last Login Time - ");
				out.println(new Date(session.getCreationTime())+"</h3>");
			}
			else {
				session.invalidate();
				session = request.getSession();
				session.setAttribute("name", userName);
				response.sendRedirect("course-enroll");
			}
			
		}
		else{
			response.setContentType("text/html");  
			response.getWriter().print("Invalid User!");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request, response);  
		}
	}
		catch(ServletException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
