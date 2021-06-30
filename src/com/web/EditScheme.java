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

/**
 * Servlet implementation class EditScheme
 */
@WebServlet("/EditScheme")
public class EditScheme extends HttpServlet {
    public EditScheme() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        System.out.println("edit scheme entered");
		String schemeName = request.getParameter("schemeName");
		String description = request.getParameter("description");
		Schemes scheme = new Schemes(schemeName,description);
		Database Dao = new Database();
		int result = Dao.update(scheme);

		if(result > 0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SchemesView");
			requestDispatcher.include(request, response);
		}
		else{
			out.println("<p><center>Updation Failed!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SchemesView");
			requestDispatcher.include(request, response);
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
