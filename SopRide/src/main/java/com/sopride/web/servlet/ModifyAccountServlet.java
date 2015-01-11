package com.sopride.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.UserBE;
import com.sopride.core.exception.InscriptionException;
import com.sopride.core.exception.UserException;
import com.sopride.dao.UserDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class ModifyAccount
 */
@WebServlet(WebConstants.PATH_MODIFY_ACCOUNT)
public class ModifyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserCtrl userCtrl = (UserCtrl) request.getSession().getAttribute(WebConstants.SESSION_USER_CTRL);
		UserBE user = userCtrl.getUser();	
		request.setAttribute("user", user);
		WebUtils.forward(request, response, "modifyaccount.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = WebUtils.getUserCtrl(request);
		UserBE user = userCtrl.getUser();
		UserDAO DAO = UserDAO.getInstance() ; 

		user.setLast_name(request.getParameter("lastname"));
		user.setFirst_name(request.getParameter("firstname"));
		try {
			user.setPhone(Integer.parseInt(request.getParameter("phone")));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			throw new InscriptionException("modifyaccount.jsp","Numéro de téléphone non valide");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			throw new InscriptionException("modifyaccount.jsp","Numéro de téléphone non valide");		}

		try{ 
			if (!request.getParameter("prevpwd").equals("")) {
				if (user.passwordIsCorrect(request.getParameter("prevpwd"))){
					if (request.getParameter("newpwd").equals(request.getParameter("newpwdconf"))){
						user.setPassword(request.getParameter("newpwdconf"));
					}
					else {
						request.setAttribute("erreur",
								"Le nouveau mot de passe et le mot de passe de confirmation ne correspondent pas. ");
						throw new Exception() ; 
					}
				}
				else {
					request.setAttribute("erreur",
							"Le mot de passe d'origine n'est pas correct.");
					throw new Exception() ;
				}
			}
			
			DAO.updateUser(user);
			WebUtils.forward(request, response, "accountinfosModified.jsp");

		} 
		catch (Exception e) {
			request.setAttribute("user", user);
			e.printStackTrace(); 
			WebUtils.forward(request, response, "modifyaccount.jsp");
		}
	}
}

