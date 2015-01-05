package com.sopride.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.dao.UserDAO;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class RideshareManager
 */
@WebServlet("/ridesharemanager")
public class RideshareManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RideshareManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBE user = (UserBE) request.getSession().getAttribute(WebConstants.SESSION_LOGGED_IN_USER);
		
		if (user != null) {			
			List<RideInfoBE> list = user.getRide_infos() ; 
			request.setAttribute("user", user);
			request.setAttribute("list", list);
			WebUtils.forward(request, response, "manageRideshares.jsp");
		}
		else {		
		WebUtils.forward(request, response, "login.jsp");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

}
