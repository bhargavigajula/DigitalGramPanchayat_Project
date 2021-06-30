package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Database;
import com.dto.Users;
@WebServlet("/RegisterForm")
public class RegisterForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Enter in register form");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String aadharNo = request.getParameter("aadharNo");
		String password = request.getParameter("password");
		
		Users user = new Users(userName,email,mobileNo,state,city,aadharNo,password);
		Database dao = new Database();
		int result = dao.register(user);
		System.out.println("Result : " + result);
		if(result > 0) {
			request.getSession().setAttribute("userNameRegister", user.getUserName());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHome.html");			
			requestDispatcher.include(request, response);
		} 
		else {
			out.println("<p><center>Registration Failed!!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.html");			
			requestDispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
