package com.sopride.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.dao.UserDAO;
import com.sopride.web.controller.UserCtrl;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class SearchForRideshare
 */
@WebServlet(WebConstants.PATH_RIDESHARE_POSSIBLE)
public class SearchForRideshare extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForRideshare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCtrl userCtrl = (UserCtrl) request.getSession().getAttribute(WebConstants.SESSION_USER_CTRL);
		UserBE user = userCtrl.getUser();
		UserDAO DAO = UserDAO.getInstance();
		List<UserBE> list = DAO.getAllUser();
		
		
		if (user.getRide_infos().isEmpty()){
			WebUtils.forward(request, response, "rideshareNotPossible.jsp");

		}else{
		ArrayList<UserBE> matches_list_lundi[] = new ArrayList[user.getRide_infos().size()];
		ArrayList<UserBE> matches_list_mardi[] = new ArrayList[user.getRide_infos().size()];
		ArrayList<UserBE> matches_list_mercredi[] = new ArrayList[user.getRide_infos().size()];
		ArrayList<UserBE> matches_list_jeudi[] = new ArrayList[user.getRide_infos().size()];
		ArrayList<UserBE> matches_list_vendredi[] = new ArrayList[user.getRide_infos().size()];
		ArrayList<UserBE> matches_list_samedi[] = new ArrayList[user.getRide_infos().size()];
		ArrayList<UserBE> matches_list_dimanche[] = new ArrayList[user.getRide_infos().size()];
		for(int j=0; j<user.getRide_infos().size(); j++){
			matches_list_lundi[j] = new ArrayList<UserBE>();
			matches_list_mardi[j] = new ArrayList<UserBE>();
			matches_list_mercredi[j] = new ArrayList<UserBE>();
			matches_list_jeudi[j] = new ArrayList<UserBE>();
			matches_list_vendredi[j] = new ArrayList<UserBE>();
			matches_list_samedi[j] = new ArrayList<UserBE>();
			matches_list_dimanche[j] = new ArrayList<UserBE>();
		}
		
		int i = 0;
		String trajets[] = new String[user.getRide_infos().size()];
		Map<String, List<RideInfoBE>[]> rideInfoMap = new HashMap<>();
		for(RideInfoBE info_user : user.getRide_infos()){
		//RideInfoBE info_user = user.getRide_infos().get(0);
		trajets[i] = "de " + info_user.getHome().toString() + " A " + info_user.getCar_pooling_workplace().toString() + " avec " ;
		int heure_depart_matin = info_user.getMorning_hour().getHours();
		int heure_depart_soir = info_user.getNight_hour().getHours();
		int minute_depart = info_user.getMorning_hour().getMinutes();
		int minute_depart_soir = info_user.getNight_hour().getMinutes();

		int postcode = info_user.getHome().getPostCode();
		WorkplaceBE workplace = info_user.getCar_pooling_workplace();
		
			/*List<UserBE> matches_list_lundi = new ArrayList<UserBE>();
			List<UserBE> matches_list_mardi = new ArrayList<UserBE>();
			List<UserBE> matches_list_mercredi = new ArrayList<UserBE>();
			List<UserBE> matches_list_jeudi = new ArrayList<UserBE>();
			List<UserBE> matches_list_vendredi = new ArrayList<UserBE>();
			List<UserBE> matches_list_samedi = new ArrayList<UserBE>();
			List<UserBE> matches_list_dimanche = new ArrayList<UserBE>();*/
			
			for(UserBE user_aux : list){
				if(user_aux != user && (user_aux.getRide_infos().size() > 0)){
				for(RideInfoBE info : user_aux.getRide_infos()){
				//RideInfoBE info = user_aux.getRide_infos().get(0);
				if((info_user.isDriver()||info.isDriver())&&heure_depart_matin == info.getMorning_hour().getHours() || (heure_depart_matin-1==info.getMorning_hour().getHours() && minute_depart <= info.getMorning_hour().getMinutes()) || (heure_depart_matin+1==info.getMorning_hour().getHours() && minute_depart >=info.getMorning_hour().getMinutes()) && (heure_depart_soir == info.getNight_hour().getHours() || (heure_depart_soir-1==info.getNight_hour().getHours() && minute_depart_soir<=info.getNight_hour().getMinutes()) || (heure_depart_soir+1==info.getNight_hour().getHours() && minute_depart_soir>=info.getNight_hour().getMinutes()))){
	
						if((info_user.getDays().isLundi()) && info.getDays().isLundi()&&((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId()))){
							
									matches_list_lundi[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_lundi", i, user.getRide_infos().size());
														
							
						}
						if (info_user.getDays().isMardi()&& info.getDays().isMardi() && (info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId())){
	
									matches_list_mardi[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_mardi", i, user.getRide_infos().size());

						}
						if (info_user.getDays().isMercredi() && info.getDays().isMercredi() && (info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId())){
				
									matches_list_mercredi[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_mercredi", i, user.getRide_infos().size());
						}
						if (info_user.getDays().isJeudi() && info.getDays().isJeudi() && (info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId())){
									matches_list_jeudi[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_jeudi", i, user.getRide_infos().size());
					
						}
						if (info_user.getDays().isVendredi() && info.getDays().isVendredi() && (info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId())){
									matches_list_vendredi[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_vendredi", i, user.getRide_infos().size());
						}
							
						if (info_user.getDays().isSamedi() && info.getDays().isSamedi() && (info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId())){
									matches_list_samedi[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_samedi", i, user.getRide_infos().size());
						}
						if (info_user.getDays().isDimanche() && info.getDays().isDimanche() && (info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().getId()==workplace.getId())){
									matches_list_dimanche[i].add(user_aux);
									addRideInfoToMap(rideInfoMap, info, "list_dimanche", i, user.getRide_infos().size());
							}
					
					
				 
				}
				}
				}
				}
			i++;
		}	
			
			int max =  user.getRide_infos().size() - 1;
			request.setAttribute("trajets", trajets);
			request.setAttribute("nb_trajets",max);
			request.setAttribute("list_lundi", matches_list_lundi);
			request.setAttribute("list_mardi", matches_list_mardi);
			request.setAttribute("list_mercredi", matches_list_mercredi);
			request.setAttribute("list_jeudi", matches_list_jeudi);
			request.setAttribute("list_vendredi", matches_list_vendredi);
			request.setAttribute("list_samedi", matches_list_samedi);
			request.setAttribute("list_dimanche", matches_list_dimanche);
			
			request.setAttribute("rideInfoMap", rideInfoMap);
			request.setAttribute("mesTrajets", user.getRide_infos());
			
			WebUtils.forward(request, response, "ridesharePossible.jsp");
		
		}
				
	}

	@SuppressWarnings("unchecked")
	private void addRideInfoToMap(Map<String, List<RideInfoBE>[]> rideInfoMap, RideInfoBE info, String key, int correspondingRideInfo, int size) {
		List<RideInfoBE>[] rideInfoList = rideInfoMap.get(key);
		
		if (rideInfoList == null) {
			rideInfoList = new ArrayList[size];
		}
		if (rideInfoList[correspondingRideInfo] == null) {
			rideInfoList[correspondingRideInfo] = new ArrayList<RideInfoBE>();
		}
		rideInfoList[correspondingRideInfo].add(info);
		rideInfoMap.put(key, rideInfoList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
