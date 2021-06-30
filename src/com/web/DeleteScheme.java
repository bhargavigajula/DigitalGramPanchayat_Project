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


@WebServlet("/DeleteScheme")
public class DeleteScheme extends HttpServlet {
    public DeleteScheme() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schemeName = request.getParameter("schemeName");
		String description = request.getParameter("description");
		String imageFileName = request.getParameter("imageFileName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Database dao = new Database(); 
		int x = dao.deleteScheme(schemeName,description,imageFileName);

		if(x > 0){
			RequestDispatcher rd = request.getRequestDispatcher("SchemesView");
			rd.forward(request, response);


		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
