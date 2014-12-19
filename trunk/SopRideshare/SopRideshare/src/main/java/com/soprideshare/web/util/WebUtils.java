package com.soprideshare.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {

	public static void forward(HttpServletRequest req, HttpServletResponse resp, String jspPage) 
			throws ServletException, IOException {
		req.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsp/" + jspPage)
			.forward(req,resp);
	}
}
