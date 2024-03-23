	package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import org.techhuub.Service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.techhub.Module.AdminModule;
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AdminModule am=new AdminModule();
		am.setEmail(email);
		am.setPassword(password);
		AdminService ad=new AdminServiceImple();
		AdminModule adm=ad.isValidate(am);
		if(adm!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("ap", am);
			RequestDispatcher r=request.getRequestDispatcher("AdminDashBoard.html");
		    r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("login.html");
		    r.include(request, response);
			out.println("<center><h1>Invalid username and password....</h1></center>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
