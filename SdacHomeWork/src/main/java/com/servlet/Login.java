package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("pwd");
		String remenber = request.getParameter("remember");
		
		if(remenber == null) {
			out.print("<h1>plz check term and condtion</h1>");
			RequestDispatcher dis = request.getRequestDispatcher("index.html");
			dis.include(request, response);
			
		}else {
			String query = "insert into student(name,email,address,password) values (?,?,?,?)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e7) {
				// TODO Auto-generated catch block
				e7.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
			} catch (SQLException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}
			PreparedStatement pt = null;
			try {
				pt = con.prepareStatement(query);
			} catch (SQLException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
			try {
				pt.setString(1, name);
			} catch (SQLException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			try {
				pt.setString(2, email);
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				pt.setString(3, address);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				pt.setString(4, password);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				pt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.print("<h1>");
			out.println("Name :"+name);
			out.print("<br>");
			out.println("Email :"+email);
			out.print("<br>");
			out.println("Address :"+address);
			out.print("<br>");
			out.println("Password :"+password);
			out.print("</h1>");
			out.print("<br>");
			out.print("<center>Welcome to Home Page");
			out.print("<br>");
			out.print("<a href ='home.html'>click here</a></center>");
		}
	}

}
