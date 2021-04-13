

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

public class AddCourseServlet extends HttpServlet {
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
				Connection con;
				con = DatabaseConnection.initializeDatabase();
				Statement stmt=con.createStatement();  
				ResultSet c = stmt.executeQuery("select count(*) from `welearn`.`courses`");
				c.next();
				int courseId = c.getInt(1);
				courseId = 102+courseId;
				PreparedStatement ps = con.prepareStatement("INSERT INTO `welearn`.`courses` (`courseId`, `courseName`, `courseDescription`, `chapters`, `studentsCount`, `coursePrice`, `created_by`) VALUES (?,?,?,?,?,?,?);\r\n"
						+ "");
				response.setContentType("text/html");
				String courseName = request.getParameter("courseName");
				String chapters = request.getParameter("chapters");
				String description = request.getParameter("courseDescription");
				int price = Integer.parseInt(request.getParameter("price"));
				ps.setInt(1, courseId);
				ps.setString(2, courseName);
				ps.setString(3, description);
				ps.setString(4, chapters);
				ps.setString(5, null);
				ps.setInt(6,price);
				ps.setInt(7,(int)session.getAttribute("id"));	
				ps.executeUpdate();
				session.setAttribute("courseName", courseName);
				session.setAttribute("chapters", chapters);
				session.setAttribute("description", description);
				CourseList.list.add(new CourseDetails(courseName,chapters,description,price));
				CourseList cl = new CourseList();
				session.setAttribute("courselist", cl.getCourseList());
				response.sendRedirect("add-course-confirm");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
