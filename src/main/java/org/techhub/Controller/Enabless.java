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
@WebServlet("/Enabless")
public class Enabless extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int userid=Integer.parseInt(request.getParameter("userid"));
		RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		r.include(request, response);
		AddCategoryService acs=new AddCategoryServiceImple();
		boolean b=acs.isEnable(userid);
		if(b)
		{
			List<CategoryModule> list=acs.getAllDisableCategory();
			out.println("<br><br>");
			out.println("<table class='t'>");
			out.println("<tr><th>Name</th><th>Update</th><th>Disable</th></tr>");
			for(CategoryModule cm:list)
			{
				out.println("<tr>");
				out.println("<td>"+cm.getName()+"</td>");
				out.println("<td><a href=''>Update</a></td>");
				out.println("<td><a href='disable?userid="+cm.getId()+"'>Disable</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		else
		{
			out.println("<h1>some problem here........</h1>");
		}
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
