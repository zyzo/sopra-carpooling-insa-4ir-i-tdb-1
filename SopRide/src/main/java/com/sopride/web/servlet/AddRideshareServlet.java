package com.sopride.web.servlet;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.AddressBE;
import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkdayBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.dao.AddressDAO;
import com.sopride.dao.RideInfoDAO;
import com.sopride.dao.UserDAO;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.dao.WorkdayDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class AddRideshareServlet
 */
@WebServlet(WebConstants.PATH_ADD_RIDESHARE)
public class AddRideshareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = WebUtils.getUserCtrl(request);
		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		List<WorkplaceBE> list = DAO.getAllWorkplace();
		request.setAttribute("user", userCtrl.getUser());
		request.setAttribute("list", list);
		WebUtils.forward(request, response, "addrideshare.jsp");

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBE user = WebUtils.getUserCtrl(request).getUser();
		UserDAO userDAO = UserDAO.getInstance() ; 

		WorkPlaceDAO workplaceDAO = WorkPlaceDAO.getInstance();
		List<WorkplaceBE> list = workplaceDAO.getAllWorkplace();

		RideInfoDAO rideInfoDAO = RideInfoDAO.getInstance();

		RideInfoBE rideInfo = new RideInfoBE() ; 

		rideInfo.setUser(user);

		int Postcode = Integer.parseInt(request.getParameter("HomePostcode"));
		AddressBE home = new AddressBE() ; 
		home.setPostCode(Postcode) ;
		AddressDAO adressDAO = AddressDAO.getInstance();
		adressDAO.registerAddress(home);
		rideInfo.setHome(home);

		int WorkplaceID = Integer.parseInt(request.getParameter("workplace"));
		for(WorkplaceBE workplace : list){
			if(workplace.getId() == WorkplaceID) {
				rideInfo.setCar_pooling_workplace(workplace);
			}
		}

		try { 
			String timeS = request.getParameter("departFJ") ;
			String[] Tab = timeS.split(":");
			Time time =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
			rideInfo.setNight_hour(time);

			timeS = request.getParameter("departDJ") ;
			Tab = timeS.split(":");
			time =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
			rideInfo.setMorning_hour(time);


			String[] selectedDays = request.getParameterValues("checkboxDay");
			WorkdayBE workdayBE = new WorkdayBE(false,false,false,false,false,false, false) ; 
			System.out.println("affichage liste") ; 
			for(int i = 0 ; i < selectedDays.length ; i++) {
				System.out.println(selectedDays[i]) ; 
				}
			
			
			for(int i = 0 ; i < selectedDays.length ; i++) {
				switch (selectedDays[i]) {
				case "lundi":
					System.out.println("lundi détecté") ; 
					workdayBE.setLundi(true);
					break;
				case "mardi":
					System.out.println("mardi détecté") ; 
					workdayBE.setMardi(true);
					break;
				case "mercredi":
					workdayBE.setMercredi(true);
					break;
				case "jeudi":
					workdayBE.setJeudi(true);
					break;
				case "vendredi":
					workdayBE.setVendredi(true);
					break;
				case "samedi":
					workdayBE.setSamedi(true);
					break;
				case "dimanche":
					workdayBE.setMercredi(true);
					break;				
				}			
			}			
			WorkdayDAO workdayDAO = WorkdayDAO.getInstance();
			workdayDAO.registerWorkday(workdayBE);
			
			
			System.out.println("setDay") ; 
			rideInfo.setDays(workdayBE);
			
			
			rideInfo.setDriver(true);

			//String selectedDays = request.getParameterValues("checkboxDay");


			System.out.println("try register") ; 
			rideInfoDAO.registerRideInfo(rideInfo);
			System.out.println("PB") ; 
			WebUtils.forward(request, response, "accountinfosModified.jsp");

		} 

		catch(Exception e) {

			e.printStackTrace();
		}




	} 
}
