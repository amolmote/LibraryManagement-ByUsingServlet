package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libary.action.UserActions;
import com.libary.user.User;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String conpassword=request.getParameter("conpassword");
		
		
			User user=new User();
			
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			
			
			int status=UserActions.register(user);
			
			if(status>0) {
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User Register Successful');");  
				   out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.forward(request, response);
				
			}
			else {
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User Register unSuccessful');");  
				   out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("reg.html");
				rd.include(request, response);
			}
			
			
		
		
		
		
		
	}

}
