package com.sopride.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.exception.LoginFailedException;
import com.sopride.core.beans.UserBE;
import com.sopride.dao.UserDAO;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

@WebServlet("/login")
public class ConnectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = UserDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward(req, resp, "login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("passwd");
        UserBE user = userDAO.findByEmail(email);
        if (user == null) {
            throw new LoginFailedException("Utilisateur non trouvé");
        }  else if (!user.getPassword().equals(password)) {
            throw new LoginFailedException("Mot de passe invalide");
        }

        req.getSession().setAttribute(WebConstants.SESSION_LOGGED_IN_USER, user);
        user.setNumberOfConnections(user.getNumberOfConnections()+1);
        userDAO.updateUser(user);
        
        req.setAttribute("user", user);
        WebUtils.forward(req, resp, "index.jsp");
    }
}
