package com.sopride.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
			
		RideInfoBE info_user = user.getRide_infos().get(0);//.get(num_user);
		
		int heure_depart_matin = info_user.getMorning_hour().getHours();
		int heure_depart_soir = info_user.getNight_hour().getHours();
		//int minute_depart = info_user.getMorning_hour().getMinutes();
		int postcode = info_user.getHome().getPostCode();
		WorkplaceBE workplace = info_user.getCar_pooling_workplace();
		
			List<UserBE> matches_list_lundi = new ArrayList<UserBE>();
			List<UserBE> matches_list_mardi = new ArrayList<UserBE>();
			List<UserBE> matches_list_mercredi = new ArrayList<UserBE>();
			List<UserBE> matches_list_jeudi = new ArrayList<UserBE>();
			List<UserBE> matches_list_vendredi = new ArrayList<UserBE>();
			List<UserBE> matches_list_samedi = new ArrayList<UserBE>();
			List<UserBE> matches_list_dimanche = new ArrayList<UserBE>();
			
			for(UserBE user_aux : list){
				if(user_aux != user){
				//int num_user_aux = user.getRide_infos().indexOf(user_aux);
				RideInfoBE info = user_aux.getRide_infos().get(0);
				if(((info.getMorning_hour().getHours() - 1)<= heure_depart_matin) && (heure_depart_matin <= info.getMorning_hour().getHours() + 1 )){
					if(((info.getNight_hour().getHours() - 1)<= heure_depart_soir) && (heure_depart_soir <= info.getNight_hour().getHours() + 1 )){
						if (info_user.getDays().isLundi()){
							if(info.getDays().isLundi()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
									matches_list_lundi.add(user_aux);
					
									
								}						
							}
						}
						if (info_user.getDays().isMardi()){
							if(info.getDays().isMardi()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
									matches_list_mardi.add(user_aux);
									
								}						
							}
						}
						if (info_user.getDays().isMercredi()){
							if(info.getDays().isMercredi()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
									matches_list_mercredi.add(user_aux);
																
								}						
							}
						}
						if (info_user.getDays().isJeudi()){
							if(info.getDays().isJeudi()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
									matches_list_jeudi.add(user_aux);
									
								}						
							}
						}
						if (info_user.getDays().isVendredi()){
							if(info.getDays().isVendredi()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
										matches_list_vendredi.add(user_aux);
									
								}						
							}
						}
							
						if (info_user.getDays().isSamedi()){
							if(info.getDays().isSamedi()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
									matches_list_samedi.add(user_aux);
								
								}						
							}
						}
						if (info_user.getDays().isDimanche()){
							if(info.getDays().isDimanche()){
								if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
										matches_list_dimanche.add(user_aux);
						
									
								}						
							}
						}
					}

				
				}
				}
				
				}
						
			request.setAttribute("list_lundi", matches_list_lundi);
			request.setAttribute("list_mardi", matches_list_mardi);
			request.setAttribute("list_mercredi", matches_list_mercredi);
			request.setAttribute("list_jeudi", matches_list_jeudi);
			request.setAttribute("list_vendredi", matches_list_vendredi);
			request.setAttribute("list_samedi", matches_list_samedi);
			request.setAttribute("list_dimanche", matches_list_dimanche);
			WebUtils.forward(request, response, "ridesharePossible.jsp");
			
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
