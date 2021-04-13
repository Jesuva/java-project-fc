

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
				List<CourseDetails> courses = new ArrayList<CourseDetails>();
				try {
					Connection con;
					con = DatabaseConnection.initializeDatabase();
					PreparedStatement ps = con.prepareStatement("SELECT * FROM welearn.courses where isActive=1;\r\n"
							+ "");
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						while(rs.next()) {
							String name = rs.getString("courseName");
							String description = rs.getString("courseDescription");
							String chapters = rs.getString("chapters");
							int price = rs.getInt("coursePrice");
							courses.add( new CourseDetails(name,description,chapters,price));
							
						}
					}
					request.setAttribute("courseList", courses);
					RequestDispatcher rd = request.getRequestDispatcher("../user/enrollcourse.jsp");
					rd.include(request, response);
					
				}
				catch(Exception e){
					e.printStackTrace();
				}

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
