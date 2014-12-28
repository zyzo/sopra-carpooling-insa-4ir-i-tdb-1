package com.sopride.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.WorkplaceBE;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class AddWorkplaceServlet
 */
@WebServlet("/addworkplace")
public class AddWorkplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorkplaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtils.forward(request, response, "addworkplace.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Postcode = Integer.parseInt(request.getParameter("postcode"));
		String City = request.getParameter("city");
		String Street = request.getParameter("street");
		
		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		
		WorkplaceBE workplace = new WorkplaceBE();	
		workplace.setCity(City);
		workplace.setPostCode(Postcode);
		workplace.setStreet(Street);
		
		DAO.registerWorkplace(workplace);
		
		WebUtils.forward(request, response, "workplaceadded.jsp");
	}

}
