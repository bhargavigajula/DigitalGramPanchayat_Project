package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Database;
import com.dto.Users;

@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminHome.html");			
			requestDispatcher.forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);

			Database Dao = new Database();
			Users user = Dao.getUser(userName,password);
			System.out.println(user);
			if(user != null) {
				request.getSession().setAttribute("userName", user.getUserName());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHome.html");			
				requestDispatcher.forward(request, response);
			}
			else {
				out.println("<p1><center><b>Invalid Credentials</b></center></p1>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
				requestDispatcher.include(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}