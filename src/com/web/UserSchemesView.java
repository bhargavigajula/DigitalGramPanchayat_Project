package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Database;
import com.dto.Schemes;

/**
 * Servlet implementation class UserSchemesView
 */
@WebServlet("/UserSchemesView")
public class UserSchemesView extends HttpServlet {
    public UserSchemesView() {
        
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
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserView.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			out.print("<h3><center>No Schemes Uploaded</center></h3>");
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
