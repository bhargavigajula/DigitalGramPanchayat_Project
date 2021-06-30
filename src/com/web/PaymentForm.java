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
import com.dto.Taxes;
import com.dto.Users;

/**
 * Servlet implementation class PaymentForm
 */
@WebServlet("/PaymentForm")
public class PaymentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String taxName = request.getParameter("taxName");
		String amount = request.getParameter("amount");
		
		Taxes tax = new Taxes(userName,email,mobileNo,taxName,"1000");
		Database dao = new Database();
		int result = dao.registerTax(tax);
		System.out.println("Result : " + result);
		if(result > 0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Success.html");			
			requestDispatcher.include(request, response);
		} 
		else {
			out.println("<p><center>Registration Failed!!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");			
			requestDispatcher.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
