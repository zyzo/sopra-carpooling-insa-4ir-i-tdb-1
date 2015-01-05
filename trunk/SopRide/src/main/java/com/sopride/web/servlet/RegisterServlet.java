package com.sopride.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.UserBE;
import com.sopride.core.exception.DaoException;
import com.sopride.core.exception.UserException;
import com.sopride.dao.UserDAO;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/inscription")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtils.forward(request, response, "register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBE user = new UserBE();
		user.setEmail(request.getParameter("email"));
		user.setFirst_name(request.getParameter("first_name"));
		user.setLast_name(request.getParameter("last_name"));
		try {
			user.setPhone(Integer.parseInt(request.getParameter("phone")));
		} catch (UserException e1) {
			request.setAttribute("erreur1", e1.getMessage());
			WebUtils.forward(request, response, "register.jsp");
		} catch(NumberFormatException e2){
			request.setAttribute("erreur2", ("Numéro de téléphone non valide"));
			WebUtils.forward(request, response, "register.jsp");
			
		}
		user.setPassword(request.getParameter("password"));
		try {
			UserDAO.getInstance().registerUser(user);
			WebUtils.forward(request, response, "registerdone.jsp");		

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur", e.getMessage());
			WebUtils.forward(request, response, "register.jsp");
		}
	}

}
