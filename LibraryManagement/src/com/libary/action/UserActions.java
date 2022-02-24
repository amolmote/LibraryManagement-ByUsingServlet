package com.libary.action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.libary.user.Book;
import com.libary.user.RequestBook;
import com.libary.user.User;

public class UserActions {
	
	
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/libraryproject","root","");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return con;
		
		
	}
	
	public static int register(User user) {
		int status=0;
		String query="insert into user(name,email,password) values(?,?,?)";
		System.out.println(query);
		try {
			Connection con=UserActions.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			 status=ps.executeUpdate();
			 
			con.close();
		}
		catch(Exception ex) {
			ex.getStackTrace();
		}
		
		
		return status;
		
		
	}
	
	
	public static int reqBook(RequestBook req) {
		int status=0;
		System.out.println("book name is"+req.getBookname());
		String query="insert into reqbook(email,bookname,noofdays) values(?,?,?)";
		System.out.println(query);
		try {
			Connection con=UserActions.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, req.getEmail());
			ps.setString(2, req.getBookname());
			ps.setInt(3, req.getNoofdays());
			
			
			 status=ps.executeUpdate();
			 
			con.close();
		}
		catch(Exception ex) {
			ex.getStackTrace();
		}
		
		
		return status;
		
		
	}
	
	public static ResultSet getUser(String email) {
	System.out.println(email);
		ResultSet rs=null;
		String query="select * from user where email='"+email+"'";
		System.out.println(query);
		try {
			Connection con=UserActions.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			//ps.setString(1, email);
			
			rs=ps.executeQuery();
			
			
		}
		catch(Exception exe) {
			System.out.println(exe);
		}
		
		return rs;
		
	}
	
	public static int addBook(Book book) {
		//System.out.println(book.getAuthorname());
		int status=0;
		String query="insert into book(bookname,authorname,publisher) values(?,?,?)";
		
		try {
			Connection con=UserActions.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getAuthorname());
			ps.setString(3, book.getPublisher());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}
		catch(Exception exe) {
			System.out.println(exe);
		}
		
		return status;
	}
	
	public static List<Book> getAllBooks(){
		List<Book> list=new ArrayList<Book>();
		
		String query="select * from book";
		try {
			Connection con=UserActions.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Book book=new Book();
				book.setBookid(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthorname(rs.getString(3));
				book.setPublisher(rs.getString(4));
				
				list.add(book);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	
	public static List<RequestBook> getAllRequest(){
		List<RequestBook> list=new ArrayList<RequestBook>();
		
		String query="select * from reqbook";
		try {
			Connection con=UserActions.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				RequestBook req=new RequestBook();
				req.setReqid(rs.getInt(1));
				req.setEmail(rs.getString(2));
				req.setBookname(rs.getString(3));
				req.setNoofdays(rs.getInt(4));
				
				list.add(req);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

}
