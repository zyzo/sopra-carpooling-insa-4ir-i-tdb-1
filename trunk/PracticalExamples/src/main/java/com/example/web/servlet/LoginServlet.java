package com.example.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String USERNAME = "bestlanguageever";
	private static final String PASSWORD = "ocaml";
	
	/** On HTTP Get, forward to /WEB-INF/loginPage.jsp */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/login GET REQUEST");
		request.getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
	}

	/** On HTTP Post, check if username and password valid 
	  * Forward to loginSuccess.jsp if true
	  * Forward to loginFailed.jsp if not
	  */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/login POST REQUEST");
		
		// Get POST Parameter (param id = the field 'name' of the <input> tag)
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		if (USERNAME.equals(username) && PASSWORD.equals(passwd)) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/loginSuccess.jsp").forward(request, response);
		} else {
			request.getServletContext().getRequestDispatcher("/WEB-INF/loginFailed.jsp").forward(request, response);
		}
	}

}
