

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
		if(password.equals("user") && (session==null) ) {
				session = request.getSession();
				session.setAttribute("name", userName);
				session.setAttribute("role", password);
				response.sendRedirect("user/course-enroll");
		}
		else if(password.equals("admin") && (session==null)) {
			session = request.getSession();
			session.setAttribute("name", userName);
			session.setAttribute("role", password);
			response.sendRedirect("admin/dashboard");
		}
		else{
			response.setContentType("text/html");  
			response.getWriter().print("Invalid User!");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
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
