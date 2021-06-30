package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Database;
import com.db.DbConnection;
import com.dto.Schemes;

/**
 * Servlet implementation class SchemesView
 */
@WebServlet("/SchemesView")
public class SchemesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SchemesView() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    Database dao = new Database();
	    List<Schemes> schemeList = dao.getSchemes();
	    
		if(schemeList != null) {
			request.setAttribute("schemeList", schemeList);
			for(Schemes x: schemeList) {
				System.out.println(x);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			out.print("<h3><center>No Schemes Uploaded</center></h3>");
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
