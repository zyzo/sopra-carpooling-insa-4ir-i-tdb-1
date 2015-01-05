package com.sopride.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class AddRideshareServlet
 */
@WebServlet("/addrideshare")
public class AddRideshareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = (UserCtrl) request.getSession().getAttribute(WebConstants.SESSION_USER_CTRL);
		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		List<WorkplaceBE> list = DAO.getAllWorkplace();
			request.setAttribute("user", userCtrl.getUser());
			request.setAttribute("list", list);
			WebUtils.forward(request, response, "addrideshare.jsp");

	}
}
