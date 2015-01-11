package com.sopride.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.UserBE;
import com.sopride.core.exception.DaoException;
import com.sopride.core.exception.InscriptionException;
import com.sopride.core.exception.UserException;
import com.sopride.dao.UserDAO;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(WebConstants.PATH_REGISTER)
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

		try {

			UserBE user = new UserBE();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			user.setEmail(request.getParameter("email"));
			user.setFirst_name(request.getParameter("first_name"));
			user.setLast_name(request.getParameter("last_name"));
			user.setPhone(Integer.parseInt(request.getParameter("phone")));
			user.setPassword(request.getParameter("password"));

			UserDAO userDAO = UserDAO.getInstance() ; 

			// sans cette verification, la base de données fait planter en cas d'adresse mail deja utilisée 
			List<UserBE> listUsers = userDAO.getAllUser() ; 
			for (UserBE u : listUsers){
				if(u.getEmail().equals(email)) throw new UserException("L'adresse mail renseignée a déja été utilisée !"); 
			}
			///////////

			userDAO.registerUser(user);
			WebUtils.forward(request, response, "registerdone.jsp");		
			WebUtils.sendMailHTML(email, "Inscription SoprideShare", 
					"<h1>Merci pour votre inscription sur l'application SopRideShare. </h1>" 
							+"<h3>Votre email est : "
							+ email
							+ " </h3> <h3>Votre mot de passe est : "
							+ password 
							+"</h3>");
		} catch(NumberFormatException e2){
			throw new InscriptionException("register.jsp", "Numéro de téléphone non valide");	
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new InscriptionException("register.jsp", e.getMessage());	
		} catch (UserException e) {
			throw new InscriptionException("register.jsp", e.getMessage());	
		}
	}


}
