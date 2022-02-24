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
import com.libary.user.*;

/**
 * Servlet implementation class AddBookServlet
 */
//@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String bookname=request.getParameter("bookname");
		String authorname=request.getParameter("authorname");
		String publisher=request.getParameter("publisher");
		
		Book book=new Book();
		
		book.setBookname(bookname);
		book.setAuthorname(authorname);
		book.setPublisher(publisher);
		
		int status=UserActions.addBook(book);
		
		if(status>0) {
		    	out.println("<script type=\"text/javascript\">");
			   out.println("alert('New Book Added Successful');");  
			   out.println("</script>");
			   RequestDispatcher rd=request.getRequestDispatcher("addBook.html");
			   rd.include(request, response);
		}
		else {
		    	out.println("<script type=\"text/javascript\">");
			   out.println("alert('Already Added Successful');");  
			   out.println("</script>");
			   RequestDispatcher rd=request.getRequestDispatcher("addBook.html");
			   rd.include(request, response);
		}
	}

}
