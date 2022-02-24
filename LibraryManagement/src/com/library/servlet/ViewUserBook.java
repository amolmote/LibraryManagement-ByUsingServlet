package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libary.action.UserActions;
import com.libary.user.Book;

/**
 * Servlet implementation class ViewUserBook
 */
//@WebServlet("/ViewUserBook")
public class ViewUserBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
         response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		List<Book> list=UserActions.getAllBooks();
		
		HttpSession session=request.getSession(false);
		String name=(String) session.getAttribute("name");
		
		
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
		out.print("<a class=\"nav-link\" href=\"LogoutServlet\">Logout</a>");
		out.print("</li>");
		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link\" href='/'>"+name+"</a>");
		out.print("</li>");
		out.print(" </ul>");
		out.print("</div>");
		out.print("</nav>");
		out.print("<div class='container' style='margin:auto;text-align:center'>");
		out.print("<h3>***welcome***</h3>");
		out.print("<h3>"+name+"</h3>");
		out.print("</div>");
		
		
		out.print("<div class='container'>");
		out.print("<table class='table'>");
		out.print("<tr>");
		out.print("<th colespan='1'>Book Id</th>");
		out.print("<th colespan='1'> Book Name</th>");
		out.print("<th colespan='1'>Book Auther</th>");
		out.print("<th colespan='1'>Book Publisher</th>");
		out.print("<th colespan='1'>Request Book</th>");
		out.print("</tr>");
		
		for(Book e: list) {
			out.print("<tr>");
			out.print("<td colespan='1'>"+e.getBookid()+"</td>");
			out.print("<td colespan='1'>"+e.getBookname()+"</td>");
			out.print("<td colespan='1'>"+e.getAuthorname()+"</td>");
			out.print("<td colespan='1'>"+e.getPublisher()+"</td>");
			out.print("<td colespan='1'>");
			out.print("<form action='RequestServlet' method='post'>");
			out.print("<input type='hidden' name='email' value='"+name+"'/>");
			out.print("<input type='hidden' name='bookname' value='"+e.getBookname()+"'/>");
			out.print("<input  type='number' name='noofdays'/>");
			out.print("<button type='submit'><span class=\"glyphicon glyphicon-book\"></span></button>");
			//out.print("<button onclick='hiii()'>Click me</button>");
			out.print("</form>");
			out.print("</td");
			out.print("</tr>");
			
		}
		out.print("</table>");
		out.print("<div");
//		    out.println("<script type=\"text/javascript\">");
//		    out.print("function hiii(){");
//		    out.print("alert(\"I am an alert box!\");");
//		    out.print("}");
//		  
//		   out.println("</script>");
		
		out.print("</body>");
		out.print("</html>");
	}

}
