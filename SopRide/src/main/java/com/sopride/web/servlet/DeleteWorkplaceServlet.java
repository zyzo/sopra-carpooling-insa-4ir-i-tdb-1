package com.sopride.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Array;

import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.dao.RideInfoDAO;
import com.sopride.dao.UserDAO;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class DeleteWorkplaceServlet
 */
@WebServlet(WebConstants.PATH_DELETE_WORKPLACE)
public class DeleteWorkplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteWorkplaceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		RideInfoDAO rDAO = RideInfoDAO.getInstance();
		UserDAO uDAO = UserDAO.getInstance();
		List<RideInfoBE> list = rDAO.getAllRideInfoBE();
		List<UserBE> listu= uDAO.getAllUser();

		int id = Integer.parseInt(request.getParameter("id"));

		for (RideInfoBE ri : list){
			if(ri.getCar_pooling_workplace().getId() == id){
				System.out.println("1 " +ri);
				for(UserBE user : listu){
					System.out.println(user);
					List<RideInfoBE> listr = new ArrayList<RideInfoBE>();
					listr.addAll(user.getRide_infos());
					for(RideInfoBE rid : listr){
						if(rid.getId()==ri.getId()){
							System.out.println("2 " + user.getRide_infos());
							user.getRide_infos().remove(rid);
							System.out.println("3 " + user.getRide_infos());
						}

					}
				}
				
				rDAO.removeRideshare(ri.getId());
				for(UserBE user : listu){
					uDAO.updateUser(user);
				}
			}
		}
		
		DAO.removeWorkPlace(id);
		WebUtils.forward(request, response, "deleteworkplace.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
