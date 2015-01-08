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
		
		// création d'un trajet
		RideInfoBE rideInfo = new RideInfoBE() ; 
		
		// récupération de l'utilisateur
		UserBE user = WebUtils.getUserCtrl(request).getUser();
		rideInfo.setUser(user);
		
		// récupération des différentes classes pour manipuler les tables de la base de données
		UserDAO userDAO = UserDAO.getInstance() ; 
		WorkPlaceDAO workplaceDAO = WorkPlaceDAO.getInstance();
		WorkdayDAO workdayDAO = WorkdayDAO.getInstance();
		AddressDAO adressDAO = AddressDAO.getInstance();
		RideInfoDAO rideInfoDAO = RideInfoDAO.getInstance();

		// création puis insertion de l'adresse de départ (maison)
		int postcode = Integer.parseInt(request.getParameter("HomePostcode"));
		String city = request.getParameter("HomeCity");
		AddressBE home = new AddressBE() ; 
		home.setPostCode(postcode) ;
		home.setCity(city);
		home.setStreet("non renseigné");		
		adressDAO.registerAddress(home); // enregistrement dans la BDD
		rideInfo.setHome(home); // assignation au trajet

		// insertion de l'adresse d'arrivée (lieu de travail)
		List<WorkplaceBE> list = workplaceDAO.getAllWorkplace();
		int WorkplaceID = Integer.parseInt(request.getParameter("workplace"));
		for(WorkplaceBE workplace : list){
			if(workplace.getId() == WorkplaceID) {
				rideInfo.setCar_pooling_workplace(workplace);
			}
		}

		// insertion heure départ le matin et heure de départ le soir
		String timeS = request.getParameter("departFJ") ;
		String[] Tab = timeS.split(":");
		Time time =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
		rideInfo.setNight_hour(time);

		timeS = request.getParameter("departDJ") ;
		Tab = timeS.split(":");
		time =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
		rideInfo.setMorning_hour(time);
        /////
		
		// récupération des checkboxes
		String[] selectedDays = request.getParameterValues("checkbox");
		
		// insertion des infortions relatives aux checkboxes
		WorkdayBE workdayBE = new WorkdayBE(false,false,false,false,false,false, false) ; 
		for(int i = 0 ; i < selectedDays.length ; i++) {
			switch (selectedDays[i]) {
			case "lundi":				 
				workdayBE.setLundi(true);
				break;
			case "mardi": 
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
			case "notify": 
				 rideInfo.setNotify(true);
				break;	
			case "driver":
				 rideInfo.setDriver(true);
				break;	
			}			
		}					
		workdayDAO.registerWorkday(workdayBE);
		rideInfo.setDays(workdayBE);

		// insertion du trajet dans la BDD 
		user.getRide_infos().add(rideInfo);

		rideInfoDAO.registerRideInfo(rideInfo);
		
		// redirection
		WebUtils.forward(request, response, "accountinfosModified.jsp");

	} 

	// il manque : envoi mail pour ajout de covoiturage
	// gestion des erreurs sur  : heure , zipcode, un jour au moins sélectionné
	//                                
	// ENSUITE
    // delete rideshare
	// modify rideshare
}
