package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libary.action.UserActions;
import com.libary.user.User;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
	  
		
		ResultSet rs=UserActions.getUser(email);
		
		try {
			if(rs.next()) {
				if(rs.getString(3).equals(email) && rs.getString(4).equals(password)) {
					out.println("<script type=\"text/javascript\">");
					   out.println("alert(' User Login Successful');");  
					   out.println("</script>");
					   HttpSession session=request.getSession();
						session.setAttribute("name", email);
						response.sendRedirect("ViewUserBook");
					
				}
				
				else {
					   out.println("<script type=\"text/javascript\">");
					   out.println("alert('User or password incorrect');");  
					   out.println("</script>");
					   RequestDispatcher rd=request.getRequestDispatcher("login.html");
					   rd.include(request, response);
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		if(email.equals("admin@gmail.com") && password.equals("admin")) {
			HttpSession session=request.getSession();
			session.setAttribute("username", "admin");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert(' Admin Login Successful');");  
			   out.println("</script>");
			   RequestDispatcher rd=request.getRequestDispatcher("addBook.html");
			   rd.forward(request, response);
		}
		
			
		
		
		
		
		
		
	}

}
