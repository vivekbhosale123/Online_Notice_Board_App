package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.Module.CategoryModule;
import org.techhuub.Service.AddCategoryService;
import org.techhuub.Service.AddCategoryServiceImple;
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title><link rel='stylesheet' href='CSS/admindashboard.css'></title>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='vv'>");
		out.println("<input type='hidden' name='cid' value='' class='controll' placeholder='Enter Your Id'/><br><br>");
		out.println("<input type='text' name='name' value='' class='controll' placeholder='Enter Your Name'/><br><br>");
		out.println("<input type='Submit' name='s' value='Add Category' class='controll'>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String name=request.getParameter("name");
			CategoryModule cm=new CategoryModule();
			cm.setName(name);
			AddCategoryService acm=new AddCategoryServiceImple();
			boolean b=acm.isAddNewCategory(cm);
			if(b)
			{
				out.println("<center><h1>Added SuccessFully....</h1></center><");
			}
			else
			{
				out.println("<center><h1>Added SuccessFully....</h1></center><");
			}
			 
		}
		else
		{
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
