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
import com.dto.Taxes;

/**
 * Servlet implementation class TaxesView
 */
@WebServlet("/TaxesView")
public class TaxesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaxesView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    Database dao = new Database();
	    List<Taxes> taxList = dao.getTaxes();
	    
		if(taxList != null) {
			request.setAttribute("taxList", taxList);
			for(Taxes x: taxList) {
				System.out.println(x);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("taxview.jsp");
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
