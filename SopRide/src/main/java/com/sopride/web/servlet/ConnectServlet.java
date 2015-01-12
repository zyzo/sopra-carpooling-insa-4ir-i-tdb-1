package com.sopride.web.servlet;


import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

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

@WebServlet(WebConstants.PATH_LOGIN)
public class ConnectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String VIEW = "login.jsp";

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = UserDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward(req, resp, VIEW);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("passwd");
        UserBE user = userDAO.findByEmail(email);
        if (user == null) {
            throw new LoginFailedException(VIEW, "Utilisateur non trouvé");
        }  else if (!user.passwordIsCorrect(password)) {
            throw new LoginFailedException(VIEW, "Mot de passe invalide");
        }

        req.getSession().setAttribute(WebConstants.SESSION_LOGGED_IN_USER, user);
        
        user.setNumberOfConnections(user.getNumberOfConnections()+1);
        user.setLastConnected(new Date(Calendar.getInstance().getTimeInMillis()));
        userDAO.updateUser(user);
        req.setAttribute("user", user);
        WebUtils.forward(req, resp, "index.jsp");
    }
}
