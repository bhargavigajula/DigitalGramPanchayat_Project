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
 * Servlet implementation class UpdateSchemes
 */
@WebServlet("/UpdateSchemes")
public class UpdateSchemes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSchemes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String schemeName = request.getParameter("schemeName");
		String description = request.getParameter("description");
		String imageFileName = request.getParameter("imageFileName");
		out.println("<html>");
		Database Dao = new Database();
		Schemes scheme = Dao.getSchemeDetails(schemeName,description,imageFileName);
		System.out.println(scheme);
		if(scheme != null){
			request.setAttribute("scheme",scheme);
			RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
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
