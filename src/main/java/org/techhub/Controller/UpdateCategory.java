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
@WebServlet("/Update")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int userid=Integer.parseInt(request.getParameter("userid").trim());
		String name=request.getParameter("name");
		out.println("<html>");
		out.println("<head>");
		out.println("<title><link rel='stylesheet' href='CSS/admindashboard.css'></title>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='vv'>");
		out.println("<input type='hidden' name='cid1' value='"+userid+"' class='controll' placeholder='Enter Your Id'/><br><br>");
		out.println("<input type='text' name='name1' value='"+name+"' class='controll' placeholder='Enter Your Name'/><br><br>");
		out.println("<input type='Submit' name='s' value='Update Category' class='controll'>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			userid=Integer.parseInt(request.getParameter("cid1"));
			name=request.getParameter("name1");
			CategoryModule cm=new CategoryModule();
			cm.setId(userid);
			cm.setName(name);
			out.println(userid+""+name);
			AddCategoryService acm=new AddCategoryServiceImple();
			boolean b=acm.isUpdate(cm);
			out.println(cm);
			if(b)
			{
				RequestDispatcher r1=request.getRequestDispatcher("ViewAllCategory");
				r1.forward(request, response);
			}
			else
			{
				RequestDispatcher r1=request.getRequestDispatcher("UpdateCategory");
				r1.include(request, response);
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
