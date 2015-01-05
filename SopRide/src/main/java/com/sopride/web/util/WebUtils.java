package com.sopride.web.util;

import com.sopride.web.controller.UserCtrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {

	public static void forward(ServletRequest req, ServletResponse resp, String jspPage)
			throws ServletException, IOException {
		req.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsp/" + jspPage)
			.forward(req,resp);
	}

	public static UserCtrl getUserCtrl(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		return (UserCtrl) request.getSession().getAttribute(WebConstants.SESSION_USER_CTRL);
	}
}
