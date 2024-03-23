package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddNotices")
public class AddNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		r.include(request, response);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>notices</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='frm' action='' method='post' class='vb'>");
		out.println("<table class='vb1'>");
		out.println("<input type='text' name='name' value='' class='control2' placeholder='enter the name'>");
		out.println("<input type='number' name='package' value='' class='control2' placeholder='enter the package'><br><br>");
		out.println("<input type='date' name='sdate' value='' class='control2' placeholder='enter starting date'>");
		out.println("<input type='date' name='edate' value='' class='control2' placeholder='enter ending date'><br><br>");
		out.println("<select class='control3'><option>notice 1</option><option>notice 2</option><option>notice 3</option></select>");
		out.println("<select class='control3'><option>notice 1</option><option>notice 2</option><option>notice 3</option></select><br><br>");
		out.println("<input type='button' name='s' value='Add Notice' class='control2'>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
