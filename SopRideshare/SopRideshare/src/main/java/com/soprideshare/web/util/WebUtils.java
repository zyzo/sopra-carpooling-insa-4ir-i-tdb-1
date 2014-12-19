package com.soprideshare.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String jspPage) throws ServletException, IOException {
		request.getServletContext()
			.getRequestDispatcher("/WEB-INF/" + jspPage)
			.forward(request,response);
	}
}
