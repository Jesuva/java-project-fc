

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			if(session.getAttribute("role").equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("../admin/addCourse.jsp");
				rd.forward(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				session.invalidate();
				out.println("<meta http-equiv='refresh' content='2;URL=../login'>");
				out.println("<h3 style='color:red;text-align:center;margin-top:15%'>Users can not view this page, Please Login using Admin Account!</h3>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			if(session!=null) {
				response.setContentType("text/html");
				String courseName = request.getParameter("courseName");
				String chapters = request.getParameter("chapters");
				String description = request.getParameter("courseDescription");
				session.setAttribute("courseName", courseName);
				session.setAttribute("chapters", chapters);
				session.setAttribute("description", description);
				response.sendRedirect("add-course-confirm");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
