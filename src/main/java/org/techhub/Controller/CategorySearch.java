package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.Module.CategoryModule;
import org.techhuub.Service.AddCategoryService;
import org.techhuub.Service.AddCategoryServiceImple;
@WebServlet("/CategorySearch")
public class CategorySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("catName");
		AddCategoryService acs=new AddCategoryServiceImple();
		List<CategoryModule> list=acs.getAllCategoriesByName(name);
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
