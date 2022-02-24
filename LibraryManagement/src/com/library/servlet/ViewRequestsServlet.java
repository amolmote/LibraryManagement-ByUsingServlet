package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libary.action.UserActions;
import com.libary.user.Book;
import com.libary.user.RequestBook;

/**
 * Servlet implementation class ViewRequestsServlet
 */
//@WebServlet("/ViewRequestsServlet")
public class ViewRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		List<RequestBook> list=UserActions.getAllRequest();
		
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"ISO-8859-1\">");
		out.print("<title>LibraryManament</title>");
		out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">");
		out.print("<a class=\"navbar-brand\" href=\"#\">LibraryManagement</a>");
		out.print("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
		out.print(" <ul class=\"navbar-nav mr-auto\">");
		out.print(" <li class=\"nav-item active\">");
		out.print("<a class=\"nav-link\" href=\"reg.html\">Registration</a>");
		out.print(" </li>");
		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link\" href=\"login.html\">Login</a>");
		out.print("</li>");
		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link\" href=\"addBook.html\">Add Book</a>");
		out.print("</li>");
		out.print("</li>");
		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link\" href='ViewBookServlet'>View Book</a>");
		out.print("</li>");
		out.print(" </ul>");
		out.print("</div>");
		out.print("</nav>");
		
		out.print("<div class='container'>");
		out.print("<table class='table'>");
		out.print("<tr>");
		out.print("<th colespan='1'>Request Id</th>");
		out.print("<th colespan='1'> User Email</th>");
		out.print("<th colespan='1'>Book Name</th>");
		out.print("<th colespan='1'>For how Many Days</th>");
		out.print("<th colespan='1'>Req Accept / Decline</th>");
		out.print("</tr>");
		
		for(RequestBook e: list) {
			out.print("<tr>");
			out.print("<td colespan='1'>"+e.getReqid()+"</td>");
			out.print("<td colespan='1'>"+e.getEmail()+"</td>");
			out.print("<td colespan='1'>"+e.getBookname()+"</td>");
			out.print("<td colespan='1'>"+e.getNoofdays()+"</td>");
			out.print("<td colespan='1'>");
			out.print("<a href='AcceptServlet'>");
			out.print("<span class=\"glyphicon glyphicon-ok\"></span>");
			out.print("</a>&nbsp; &nbsp; &nbsp; &nbsp; ");
			out.print("<span>");
			out.print("<a href=\"#\">");
			out.print("<span class=\"glyphicon glyphicon-remove\"></span>");
			out.print("</a>");
			out.print("</span>");
			out.print("</td>");
			out.print("</tr>");
			
		}
		out.print("</table>");
		out.print("<div>");
		
		
		out.print("</body>");
		out.print("</html>");
	}

	
  
	 
     
   
	

}
