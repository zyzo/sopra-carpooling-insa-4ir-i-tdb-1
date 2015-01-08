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
import com.sopride.core.exception.AbstractException;
import com.sopride.core.exception.AddRideshareException;
import com.sopride.dao.AddressDAO;
import com.sopride.dao.RideInfoDAO;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.dao.WorkdayDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.Time24HoursValidator;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class ModifyRideshare
 */
@WebServlet(WebConstants.PATH_MODIFY_RIDESHARE)
public class ModifyRideshare extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String VIEW = "modifyrideshare.jsp";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyRideshare() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = (UserCtrl) request.getSession().getAttribute(WebConstants.SESSION_USER_CTRL);
		UserBE user = userCtrl.getUser();

		WorkPlaceDAO workplaceDAO = WorkPlaceDAO.getInstance();
		List<WorkplaceBE> list = workplaceDAO.getAllWorkplace();	


		try{ 		
			int id = Integer.parseInt(request.getParameter("id"));
			RideInfoBE rideSelected = null ;   
			List<RideInfoBE> listRideshares = user.getRide_infos() ;

			for(RideInfoBE rideshare : listRideshares){
				if (rideshare.getId() == id){
					rideSelected = rideshare ; 
				}
			}
			if (rideSelected == null) throw new Exception() ; 		
			request.setAttribute("ride", rideSelected);				
			request.setAttribute("user", user);	
			request.setAttribute("list", list);
			request.setAttribute("morningH", rideSelected.getMorning_hour()) ;
			request.setAttribute("nightH", rideSelected.getNight_hour()) ; 		 
			request.setAttribute("field", rideSelected.getDays()) ; 

			WebUtils.forward(request, response, "modifyrideshare.jsp");
		}

		catch (Exception e) {
			throw new AbstractException("index.jsp", "Une erreur est survenue ! ", AbstractException.ERROR_TYPE) ; //			
		}
	} 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// récupération de l'utilisateur
			UserBE user = WebUtils.getUserCtrl(request).getUser();
			
			// récupération trajet 
			int id = Integer.parseInt(request.getParameter("id"));
			RideInfoBE rideInfo = null ;   
			List<RideInfoBE> listRideshares = user.getRide_infos() ;
			for(RideInfoBE rideshare : listRideshares){
				if (rideshare.getId() == id){
					rideInfo = rideshare ; 
				}
			}

			// récupération des différentes classes pour manipuler les tables de la base de données
			WorkPlaceDAO workplaceDAO = WorkPlaceDAO.getInstance();
			WorkdayDAO workdayDAO = WorkdayDAO.getInstance();
			AddressDAO adressDAO = AddressDAO.getInstance();
			RideInfoDAO rideInfoDAO = RideInfoDAO.getInstance();

			// création/vérification ZipCode de l'adresse de départ (maison)		 
			int postcode = Integer.parseInt(request.getParameter("HomePostcode"));
			String city = request.getParameter("HomeCity");		
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

			String s_timeM = request.getParameter("departFJ") ;
			if (!timeValidator.validate(s_timeM)) {
				throw new AddRideshareException(VIEW, "Veuillez saisir une date de la forme HH:MM") ; 
			}		
			String[] Tab = s_timeM.split(":");
			Time timeM =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
			rideInfo.setNight_hour(timeM);


			String s_timeS = request.getParameter("departDJ") ;
			if (!timeValidator.validate(s_timeS)) {
				throw new AddRideshareException(VIEW, "Veuillez saisir une date de la forme HH:MM") ; 
			}
			Tab = s_timeS.split(":");
			Time timeS =  new Time(Integer.parseInt(Tab[0]),Integer.parseInt(Tab[1]), 0) ; 
			rideInfo.setMorning_hour(timeS);
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

			if (workdayBE.toInt() != rideInfo.getDays().toInt()){
			workdayDAO.removeWorkday(rideInfo.getDays().getId_workingdays());
			workdayDAO.registerWorkday(workdayBE);
			rideInfo.setDays(workdayBE);
			}
			
			if((home.getPostCode() != rideInfo.getHome().getPostCode()) || (home.getCity() != rideInfo.getHome().getCity())){
				adressDAO.removeAddressBE(rideInfo.getHome().getId());
				adressDAO.registerAddress(home); // enregistrement dans la BDD
				rideInfo.setHome(home); // assignation au trajet				
			}
						
			// MAJ 
			rideInfoDAO.update(rideInfo);

			// redirection
			WebUtils.forward(request, response, "accountinfosModified.jsp");
		}
		catch(NumberFormatException e){
			throw new AddRideshareException(VIEW, "Veuillez saisir un code postal à 5 chiffres") ; 
		}
//		catch(Exception e){
//			throw new AbstractException("index.jsp", "Une erreur est survenue ! ", AbstractException.ERROR_TYPE) ; 
//		}
	} 

}
