package com.sopride.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.UserBE;
import com.sopride.dao.UserDAO;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/forgetPassword")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	WebUtils.forward(request, response, "forgetPassword.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		UserDAO DAO = UserDAO.getInstance();
		System.out.println(email);
		UserBE User = DAO.findByEmail(email);
		WebUtils.sendMail(email, "Mot de passe oublié", "Voici votre mail : " + email + "\n mot de passe : " + User.getPassword());;
		WebUtils.forward(request, response,"mailSent.jsp" );
		
	}

}
