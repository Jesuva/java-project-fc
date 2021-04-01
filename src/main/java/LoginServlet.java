

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("userPassword");
		String userName = request.getParameter("userName");		
		if(password.equals("user")) {
		
			request.setAttribute("name", userName);
			RequestDispatcher rd = request.getRequestDispatcher("enrollcourse.html");
			rd.forward(request, response);
			
		}
		else{
			response.setContentType("text/html");  
			response.getWriter().print("Invalid User!");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request, response);  
		}
		
	}

}