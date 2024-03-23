package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.techhub.Module.AdminModule;
import org.techhuub.Service.AdminService;
import org.techhuub.Service.AdminServiceImple;
@WebServlet("/AdminProfile")
public class AdminProfile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		AdminModule am=(AdminModule)session.getAttribute("ap");
		out.println("<html>");
		out.println("<head>");
		out.println("<title><link rel='stylesheet' href='CSS/admindashboard.css'></title>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='v'>");
		out.println("<input type='hidden' name='aid' value='"+am.getId()+"' class='control' placeholder='Enter Your Id'/><br><br>");
		out.println("<input type='text' name='name' value='"+am.getName()+"' class='control' placeholder='Enter Your Name'/><br><br>");
		out.println("<input type='email' name='email' value='"+am.getEmail()+"' class='control' placeholder='Enter Your Email'><br><br>");
		out.println("<input type='number' name='contact' value='"+am.getContact()+"' class='control' placeholder='Enter Your Contact'><br><br>");
		out.println("<input type='password' name='password' value='"+am.getPassword()+"' class='control' placeholder='Enter Your Password'><br><br>");
		out.println("<input type='Submit' name='s' value='Update Profile' class='control'>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			int id=Integer.parseInt(request.getParameter("aid"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String password=request.getParameter("password");
			am=new AdminModule();
			am.setId(id);
			am.setName(name);
			am.setEmail(email);
			am.setContact(contact);
			am.setPassword(password);
			AdminService as=new AdminServiceImple();
			boolean b=as.update(am);
			if(b)
			{
//			       r=request.getRequestDispatcher("AdminProfile");
//				   r.forward(request, response);
				   out.println("<center><h1>Updated SuccessFully....</h1></center><");
			}
			else
			{
//				   r=request.getRequestDispatcher("AdminProfile");
//				   r.include(request, response);
				   out.println("<center><h1>Not Updated....</h1></center><");
			}
		}
//		else
//		{
//		   out.println("<center><h1>Some Problem Here......</h1></center><");
//		}
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
