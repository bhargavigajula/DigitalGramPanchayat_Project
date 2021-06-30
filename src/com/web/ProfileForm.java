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
 * Servlet implementation class PprofileForm
 */
@WebServlet("/ProfileForm")
public class ProfileForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        System.out.println("edit profile entered");
        String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String aadharNo = request.getParameter("aadharNo");
		Users user = new Users(userName,email,mobileNo,state,city,aadharNo);
		Database Dao = new Database();
		int result = Dao.updateUser(user);

		if(result > 0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHome.html");
			requestDispatcher.include(request, response);
		}
		else{
			out.println("<p><center>Updation Failed!!</center></p>");
		}

		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
