package com.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.Database;
import com.db.DbConnection;
import com.dto.Schemes;

/**
 * Servlet implementation class SchemeUpload
 */
@WebServlet("/SchemeUpload")
@MultipartConfig
public class SchemeUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchemeUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String schemeName = request.getParameter("schemeName");
		String description = request.getParameter("description");
		Part file = request.getPart("image");
		String imageFileName = file.getSubmittedFileName();
		String uploadPath = "C:/Users/hp/Desktop/JEE/Workspace/MiniProjectII/WebContent/image/" + imageFileName;
		try {
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();
		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		Schemes scheme = new Schemes(schemeName,description,imageFileName);
		Database dao = new Database();
		int result = dao.uploadScheme(scheme);
		if(result > 0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SchemesView");			
			requestDispatcher.include(request, response);
		} 
		else {
			out.println("<p><center>Uploading Failed!!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("upload.jsp");			
			requestDispatcher.include(request, response);
		}
	}

}
