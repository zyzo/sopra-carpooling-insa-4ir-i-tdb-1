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
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class SearchForRideshare
 */
@WebServlet("/ridesharePossible")
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
		UserBE user = (UserBE) request.getSession().getAttribute(WebConstants.SESSION_LOGGED_IN_USER);
		UserDAO DAO = UserDAO.getInstance();
		List<UserBE> list = DAO.getAllUser();
		
		//int num_user = user.getRide_infos().indexOf(user);
		RideInfoBE info_user = user.getRide_infos().get(0);//.get(num_user);
		
		
		int postcode = info_user.getHome().getPostCode();
		WorkplaceBE workplace = info_user.getCar_pooling_workplace();
		
		if (user != null) {			
			List<UserBE> matches_list = new ArrayList<UserBE>();
			for(UserBE user_aux : list){
				if(user_aux != user){
				//int num_user_aux = user.getRide_infos().indexOf(user_aux);
				RideInfoBE info = user.getRide_infos().get(0);
				if((info.getHome().getPostCode() == postcode) && (info.getCar_pooling_workplace().equals(workplace))){
					matches_list.add(user_aux);
				}
				}
			}
			request.setAttribute("list", matches_list);
			if(matches_list != null){
			WebUtils.forward(request, response, "ridesharePossible.jsp");
			}
			else{
				WebUtils.forward(request, response, "rideshareNotPossible.jsp");
			}
		} /*else {		
		WebUtils.forward(request, response, "login.jsp");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
