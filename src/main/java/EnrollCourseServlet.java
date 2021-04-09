

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			if (session.getAttribute("role").equals("user")) {
				RequestDispatcher rd = request.getRequestDispatcher("../user/enrollcourse.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				session.invalidate();
				out.println("<meta http-equiv='refresh' content='2;URL=../login'>");
				out.println("<h3 style='color:red;text-align:center;margin-top:15%'>Admin can not view this page, Please Login using User Account!</h3>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			if(session!=null) {
				response.setContentType("text/html");  
				String courseName = request.getParameter("course");
				String courseLevel = request.getParameter("level");
				session.setAttribute("course", courseName);
				session.setAttribute("level", courseLevel);
				response.sendRedirect("confirm-submission");
			}
			else {
				doGet(request,response);
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
