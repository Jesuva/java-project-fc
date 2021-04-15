

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<CourseDetails> courses = new ArrayList<CourseDetails>();
		int userId = (int)session.getAttribute("id");
		try {
			Connection con;
			con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM welearn.courses where isActive=1 and created_by="+userId+";\r\n"
					+ "");
			ResultSet rs = ps.executeQuery();
			if (rs!=null) {
				while(rs.next()) {
					String name = rs.getString("courseName");
					String description = rs.getString("courseDescription");
					String chapters = rs.getString("chapters");
					int price = rs.getInt("coursePrice");
					int courseId = rs.getInt("courseId");
					courses.add( new CourseDetails(name,description,chapters,price,courseId));
					
				}
			}
			request.setAttribute("courseList", courses);
			RequestDispatcher rd = request.getRequestDispatcher("viewCourse.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("deleteThisCourse"));
		try {
			Connection con;
			con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM `welearn`.`courses` WHERE (`courseId` = "+courseId+");");
			doGet(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
