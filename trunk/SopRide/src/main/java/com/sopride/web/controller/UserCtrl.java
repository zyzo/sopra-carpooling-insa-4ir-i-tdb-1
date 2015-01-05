package com.sopride.web.controller;

import com.sopride.core.beans.UserBE;
import com.sopride.dao.UserDAO;
import com.sopride.web.util.WebConstants;

import javax.servlet.http.HttpSession;

public class UserCtrl {

    HttpSession session;
    UserDAO userDAO  =UserDAO.getInstance();

    public UserCtrl(HttpSession session) {
        this.session = session;
    }

    public boolean isConnected() {
        UserBE user = getUser();
        return user != null;
    }

    /**
     * return if user is admin
     * If user is not connected, calling this method return false anyway
     * => checking if user is connected first is recommended
     */
    public boolean isAdmin() {
        UserBE user = getUser();
        if (user == null) {
            return false;
        }
        return userDAO.isAdmin(user);
    }

    public UserBE getUser() {
        return (UserBE) session.getAttribute(WebConstants.SESSION_LOGGED_IN_USER);
    }


}
