package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.Module.CategoryModule;
import org.techhuub.Service.AddCategoryService;
import org.techhuub.Service.AddCategoryServiceImple;
@WebServlet("/ViewAllCategory")
public class ViewAllCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		r.include(request, response);
		AddCategoryService acs=new AddCategoryServiceImple();
		List<CategoryModule> list=acs.getAllCategories();
		out.println("<br><br>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>js</title>");
		out.println("<script type='text/javascript' src='JS/search.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='v'>");
		out.println("<table class='t'>");
		out.println("<input type='text' name='name' value='' class='con' onkeyup='searchCategory(this.value)'/>");
		out.println("<tr><th>Name</th><th>Update</th><th>Disable</th></tr>");
		for(CategoryModule cm:list)
		{
			
			out.println("<tr>");
			out.println("<td>"+cm.getName()+"</td>");
			out.println("<td><a href='Update?userid="+cm.getId()+"&name="+cm.getName()+"'>Update</a></td>");
			out.println("<td><a href='disable?userid="+cm.getId()+"'>Disable</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
