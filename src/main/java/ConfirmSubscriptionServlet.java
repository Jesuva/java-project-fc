

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ConfirmSubscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String userName = (String)session.getAttribute("name");
		String course = (String)session.getAttribute("course");
		String level = (String)session.getAttribute("level");
		response.setContentType("text/html");
		out.print("<html><head><title>WeLearn</title><style type='text/css'>body{\r\n"
				+ "	background: rgb(212,212,226);\r\n"
				+ "background: linear-gradient(90deg, rgba(212,212,226,1) 47%, rgba(0,212,255,1) 97%, rgba(2,0,36,1) 100%);\r\n"
				+ "	}"
				+ "</style></head><body><h3 style='align-text:center'>Thanks For Subscribing!</h3><hr>");
		out.print("<p>Hi "+userName+"! You have Subscribed for the "+level+" level "+course+" course!</p>");
		out.print("<h2>Happy Learning!</h2>");
		out.print("<a href='/DWP/course-enroll'><button>Back to Courses</button></a>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
