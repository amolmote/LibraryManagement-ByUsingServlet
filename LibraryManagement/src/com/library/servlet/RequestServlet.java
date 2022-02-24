package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libary.action.UserActions;
import com.libary.user.RequestBook;

/**
 * Servlet implementation class RequestServlet
 */
//@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String email=request.getParameter("email");
		String bookname=request.getParameter("bookname");
		String days=request.getParameter("noofdays");
		int noofdays=Integer.parseInt(days);
		
		RequestBook req=new RequestBook();
		
		req.setEmail(email);
		req.setBookname(bookname);
		req.setNoofdays(noofdays);
		
		int status=UserActions.reqBook(req);
		
		if(status>0) {
			out.print("<h1>Hiiiii</h1>");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book request added Successfully');");  
			   out.println("</script>");
//			   RequestDispatcher rd=request.getRequestDispatcher("ViewUserBook");
//			   rd.include(request, response);
			 response.sendRedirect("ViewUserBook");
		}
		else {
			
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book request not added');");  
			   out.println("</script>");
			   RequestDispatcher rd=request.getRequestDispatcher("ViewUserBook");
			   rd.include(request, response);
			   
		}
		
		
		
		
		
		
	}

}
