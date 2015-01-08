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
import com.sopride.dao.AddressDAO;
import com.sopride.dao.RideInfoDAO;
import com.sopride.dao.UserDAO;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.dao.WorkdayDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class DeleteRideshare
 */
@WebServlet(WebConstants.PATH_DELETE_RIDESHARE)
public class DeleteRideshare extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteRideshare() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = WebUtils.getUserCtrl(request);
		UserBE user = userCtrl.getUser();

		// récupération des différentes classes pour manipuler les tables de la base de données
		UserDAO userDAO = UserDAO.getInstance();
		WorkdayDAO workdayDAO = WorkdayDAO.getInstance();
		AddressDAO adressDAO = AddressDAO.getInstance();
		RideInfoDAO rideInfoDAO = RideInfoDAO.getInstance();

		try {	
			int id = Integer.parseInt(request.getParameter("id"));
			RideInfoBE rideSelected = null ;   
			List<RideInfoBE> listRideshares = user.getRide_infos() ;

			for(RideInfoBE rideshare : listRideshares){
				if (rideshare.getId() == id){
					rideSelected = rideshare ; 
				}
			}
			if (rideSelected == null) throw new Exception() ;

			user.getRide_infos().remove(rideSelected) ;
			userDAO.updateUser(user);			
			rideInfoDAO.removeRideshare(id); 
			workdayDAO.removeWorkday(rideSelected.getDays().getId_workingdays());
			adressDAO.removeAddressBE(rideSelected.getHome().getId());
			
			WebUtils.forward(request, response, "deleterideshare.jsp");
		}
		catch (Exception e) {
			WebUtils.forward(request, response, "index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
