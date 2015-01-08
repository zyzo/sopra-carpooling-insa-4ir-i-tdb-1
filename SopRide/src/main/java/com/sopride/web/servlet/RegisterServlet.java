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
		UserBE user = new UserBE();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user.setEmail(request.getParameter("email"));
		user.setFirst_name(request.getParameter("first_name"));
		user.setLast_name(request.getParameter("last_name"));
		try {
			user.setPhone(Integer.parseInt(request.getParameter("phone")));
			user.setPassword(request.getParameter("password"));
			
			UserDAO.getInstance().registerUser(user);
			WebUtils.forward(request, response, "registerdone.jsp");		
			WebUtils.sendMail(email, "Inscription SoprideShare", 
					"Merci pour votre inscription sur l'application SopRideShare." 
					+"/n Votre email est : "
					+ email
					+ "/n Votre mot de passe est : "
					+ password );
		} catch (UserException e1) {
			request.setAttribute("erreur1", e1.getMessage());
			WebUtils.forward(request, response, "register.jsp");
		} catch(NumberFormatException e2){
			request.setAttribute("erreur2", ("Num�ro de t�l�phone non valide"));
			WebUtils.forward(request, response, "register.jsp");
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur", e.getMessage());
			WebUtils.forward(request, response, "register.jsp");
		}
	}

}
