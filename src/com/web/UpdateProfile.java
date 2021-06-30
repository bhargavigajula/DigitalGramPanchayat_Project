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
import com.dto.Schemes;
import com.dto.Users;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = (String)request.getSession().getAttribute("userName");
		String userName1 = (String)request.getSession().getAttribute("userNameRegister");
		System.out.println(userName);
		out.println("<html>");
		Database Dao = new Database();
		String s;
		if(userName != null) {
			s = userName;
		}
		else {
			s = userName1;
		}
		Users user = Dao.getProfile(s,null,null,null,null,null);
		System.out.println(user);
		if(user != null){
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
			rd.forward(request,response);
		}
		else{
			out.print("<h3><center>Record not Found</center></h3>");
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
