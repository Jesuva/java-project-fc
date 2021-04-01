

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		String courseName = request.getParameter("course");
		String courseLevel = request.getParameter("level");
		response.getWriter().append("Hi You have enrolled in the "+courseName+" ,"+courseLevel+" level course");
		RequestDispatcher rd = request.getRequestDispatcher("enrollcourse.html");
		rd.include(request,response);
		
	}

}
