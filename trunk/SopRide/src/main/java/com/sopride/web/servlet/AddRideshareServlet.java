package com.sopride.web.servlet;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sopride.core.beans.AddressBE;
import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkdayBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.core.exception.AbstractException;
import com.sopride.core.exception.AddRideshareException;
import com.sopride.dao.AddressDAO;
import com.sopride.dao.RideInfoDAO;
import com.sopride.dao.UserDAO;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.dao.WorkdayDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.Time24HoursValidator;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class AddRideshareServlet
 */
@WebServlet(WebConstants.PATH_ADD_RIDESHARE)
public class AddRideshareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW = "addrideshare.jsp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = WebUtils.getUserCtrl(request);
		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		List<WorkplaceBE> list = DAO.getAllWorkplace();
		request.getSession().setAttribute("user", userCtrl.getUser());
		request.getSession().setAttribute("list", list);
		WebUtils.forward(request, response, "addrideshare.jsp");

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {

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

			// création/vérification ZipCode de l'adresse de départ (maison)		 
			int postcode = Integer.parseInt(request.getParameter("HomePostcode"));
			request.getSession().setAttribute("postcode1", postcode);
			String city = request.getParameter("HomeCity");	
			request.getSession().setAttribute("city1", city);
			AddressBE home = new AddressBE() ; 
			home.setPostCode(postcode) ;
			home.setCity(city);
			home.setStreet("non renseigné");

			// détermination de l'adresse d'arrivée (lieu de travail)
			List<WorkplaceBE> list = workplaceDAO.getAllWorkplace();
			int WorkplaceID = Integer.parseInt(request.getParameter("workplace"));
			for(WorkplaceBE workplace : list){
				if(workplace.getId() == WorkplaceID) {
					rideInfo.setCar_pooling_workplace(workplace);
				}
			}

			// vérification heure départ le matin et heure de départ le soir
			Time24HoursValidator timeValidator = new Time24HoursValidator() ; 

			String timeS = request.getParameter("departFJ") ;
			if (!timeValidator.validate(timeS)) {
				throw new AddRideshareException(VIEW, "Veuillez saisir une date de la forme HH:MM") ; 
			}		
			String[] Tab = timeS.split(":");
			Time time =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
			rideInfo.setNight_hour(time);

			timeS = request.getParameter("departDJ") ;
			if (!timeValidator.validate(timeS)) {
				throw new AddRideshareException(VIEW, "Veuillez saisir une date de la forme HH:MM") ; 
			}
			Tab = timeS.split(":");
			time =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
			rideInfo.setMorning_hour(time);
			/////

			// récupération des checkboxes
			String[] selectedDays = request.getParameterValues("checkbox");
			if (selectedDays == null) {
				throw new AddRideshareException(VIEW, "Veuillez saisir au moins un jour") ; 
			}

			// insertion des infortions relatives aux checkboxes
			WorkdayBE workdayBE = new WorkdayBE(false,false,false,false,false,false, false) ; 
			boolean aDayAtLeastSelected = false ; 
			for(int i = 0 ; i < selectedDays.length ; i++) {
				switch (selectedDays[i]) {
				case "lundi":				 
					workdayBE.setLundi(true);
					aDayAtLeastSelected = true ;
					break;
				case "mardi": 
					workdayBE.setMardi(true);
					aDayAtLeastSelected = true ;
					break;
				case "mercredi":
					workdayBE.setMercredi(true);
					aDayAtLeastSelected = true ;
					break;
				case "jeudi":
					workdayBE.setJeudi(true);
					aDayAtLeastSelected = true ;
					break;
				case "vendredi":
					workdayBE.setVendredi(true);
					aDayAtLeastSelected = true ;
					break;
				case "samedi":
					workdayBE.setSamedi(true);
					aDayAtLeastSelected = true ;
					break;
				case "dimanche":
					workdayBE.setMercredi(true);
					aDayAtLeastSelected = true ;
					break;
				case "notify": 
					rideInfo.setNotify(true);
					break;	
				case "driver":
					rideInfo.setDriver(true);
					break;	
				}			
			}
			if (aDayAtLeastSelected == false) {
				throw new AddRideshareException(VIEW, "Veuillez saisir au moins un jour") ; 
			}


			// insertions  dans BDD 

			workdayDAO.registerWorkday(workdayBE);
			rideInfo.setDays(workdayBE);

			adressDAO.registerAddress(home); // enregistrement dans la BDD
			rideInfo.setHome(home); // assignation au trajet

			user.getRide_infos().add(rideInfo);
			rideInfoDAO.registerRideInfo(rideInfo);

			// redirection
			request.getSession().setAttribute("postcode1", null);	
			request.getSession().setAttribute("city1", null);
			WebUtils.forward(request, response, "accountinfosModified.jsp");
		}
		catch(NumberFormatException e){
			e.printStackTrace(); 
			throw new AddRideshareException(VIEW, "Veuillez saisir un code postal à 5 chiffres") ; 			
		}
	} 

}
