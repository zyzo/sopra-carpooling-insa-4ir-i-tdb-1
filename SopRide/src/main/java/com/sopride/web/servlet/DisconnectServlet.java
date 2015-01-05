package com.sopride.web.servlet;

import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(WebConstants.PATH_DISCONNECT)
public class DisconnectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(WebConstants.SESSION_LOGGED_IN_USER) != null) {
            req.getSession().removeAttribute(WebConstants.SESSION_LOGGED_IN_USER);
        }
        WebUtils.forward(req, resp, "index.jsp");
    }
}
